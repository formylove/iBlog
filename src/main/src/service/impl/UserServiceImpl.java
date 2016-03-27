package main.src.service.impl;

import javax.annotation.Resource;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;
import org.apache.struts2.StrutsStatics;
import org.hibernate.criterion.Restrictions;
import org.hibernate.type.StandardBasicTypes;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.opensymphony.xwork2.ActionContext;

import main.src.common.StrUtils;
import main.src.common.WebUtils;
import main.src.dao.UserDao;
import main.src.entity.User;
import main.src.service.UserService;
@Service("userService")
@Transactional
public class UserServiceImpl implements UserService {
	private final int Max_Age = 7*24*60*60;
	@Resource(name = "userDaoHibernate4")
	private UserDao userDao;
	
	public UserServiceImpl() {
	}

	public int save(User user) {
		return userDao.save(user);
	}

	@Override
	public void persist(User user) {
		userDao.persist(user);
	}
	
	@Override
	public void delete(int id) {
		User n = get(id); 
		delete(n);
	}

	@Override
	public void delete(User user) {
		userDao.delete(user);
	}
	@Override
	public void update(User user) {
		userDao.update(user);
	}
	@Override
	public User remove(int id) {
		User user = get(id);
		if(null != user){
			user.setDel_flag(true);
			userDao.update(user);
		}
		return user;
	}

	@Override
	public User get(int id) {
		return userDao.get(id);
	}

	@Override
	public void recover(int id) {
		User user = get(id);
		if(null != user){
			user.setDel_flag(false);
			userDao.update(user);
		}
	}

	public UserDao getUserDao() {
		return userDao;
	}

	public void setUserDao(UserDao userdao) {
		this.userDao = userdao;
	}
	@Override
	 public boolean hasRegistered(String email){
		User user = getUserByMail(email);
		
		return (user != null);
	}
	@Override
	 public boolean hasUsed(String nick_name){
		String hql = "from User where nick_name = :nick_name and del_flag <> 1";
		User user = (User)userDao.getSession().createQuery(hql)
				.setString("nick_name", nick_name)
				.setMaxResults(1)
				.uniqueResult();
		
		return (user != null);
	}
	@Override
	 public String loginDetect(String email,String password){
		email = email.trim();
		String message = null;
		if(!StrUtils.valiEmail(email)){
			return "邮箱格式错误";
		}
		if(!StrUtils.simpleChar(password)){
			return "密码错误";
		}
		if(getUserByMail(email) == null){
			return "邮箱未注册";
		}
		User user = getUserByMail(email);
		if(!user.isEmail_val_flag()){
			return "邮箱未激活";
		}
		if(password == null || !password.equals(user.getPassword())){
			return "密码错误";
		}
		return null;
	}
	@Override
	 public String registerDetect(String nick_name,String email,String password,String psw_conf,String rule){
		email = email.trim();
		if(!StrUtils.valiName(nick_name)){
			return "昵称必须只包含英文中文数字以及下划线";
		}
		if(!StrUtils.valiEmail(email)){
			return "邮箱格式错误";
		}
		if(getUserByMail(email) != null){
			return "邮箱已注册";
		}
		if(!StrUtils.simpleChar(password)){
			return "密码只能包含数字及字母";
		}
		if(StrUtils.isEmpty(password) || password.length()<8 || password.length()>16){
			return "密码长度必须在8到16位之间";
		}
		if(!password.equals(psw_conf)){
			return "两次输入密码不同";
		}
		if(StringUtils.isEmpty(rule)){
			return "请先阅读并同意夜网使用协议";
		}
		return null;
	}
	@Override
	 public User valiAndLogin(String email,String password,String remember){
		User user = (User)userDao.getSession()
				.createCriteria(User.class)
				.add(Restrictions.eq("email", email))
				.add(Restrictions.eq("del_flag", 0))
				.setMaxResults(1).uniqueResult();
		if(user.getPassword().equals(password)){
			login(user,remember);
			return user;
		}else{
			return null;
		}
	}
	@Override
	 public boolean login(User user,String remember){
		if(remember == null){
			ActionContext.getContext().getSession().put("logined_user", user);
		}else{
			HttpServletResponse res = (HttpServletResponse) ActionContext.getContext().get(StrutsStatics.HTTP_RESPONSE);
			Cookie c = new Cookie("night_user_id",String.valueOf(user.getId()));
			c.setMaxAge(Max_Age);
			res.addCookie(c);
		}
		return true;
	}
	 public User login(String email,String remember){
		User user = getUserByMail(email);
		login(user, remember);
		return user;
	}
	 @Override
	 public User getUserByMail(String email){
		 email = email.trim();
		 String hql = "from User where token = :email and del_flag <> 1";
		 User user = (User)userDao.getSession().createQuery(hql)
			.setString("email", email)
			.setMaxResults(1)
			.uniqueResult();
		return user;
	}
	 @Override
	 public User getUserByToken(String token){
		 token = token.trim();
		 String hql = "from User where token = :token and del_flag <> 1";
		 User user = (User)userDao.getSession().createQuery(hql)
				 .setString("token", token)
				 .setMaxResults(1)
				 .uniqueResult();
		return user;
	}
	 @Override
	 public boolean isExpired(String token){
		token = token.trim();
		if(getDurationForRegister(token)>=24){//等于24已经超了
			return false;
		}else{
			return false;
		}
	}
	 @Override
	 public int getDurationForRegister(String token){
		token = token.trim();
		String sql = "SELECT TIMESTAMPDIFF(HOUR,register_date,NOW()) duration FROM User WHERE token = :token";
		int duration = (int)userDao.getSession().createSQLQuery(sql)
				.addScalar("duration", StandardBasicTypes.INTEGER)
				.setString("token", token)
				.setMaxResults(1)
				.uniqueResult();
		return duration;
	}
	 @Override
	 public boolean logout(){
			ActionContext.getContext().getSession().put("logined_user", null);
			HttpServletResponse res = (HttpServletResponse) ActionContext.getContext().get(StrutsStatics.HTTP_RESPONSE);
			Cookie c = new Cookie("night_user_id","");
			c.setMaxAge(0);
			res.addCookie(c);
		return true;
	}
	@Override
	 public User getcurLoginUser(HttpServletRequest request){
		User user = null;
		if(request!=null){
			user = (User)request.getSession().getAttribute("logined_user");
		}else{
			user = (User)ActionContext.getContext().getSession().get("logined_user");
		}
		if(user !=null){
			return user;
		}
		String user_id = WebUtils.getCookie("night_user_id",request);
		if(user_id != null){
			return get(Integer.parseInt(user_id));
		}
			return null;
	}

	@Override
	public User validate(String email, String remember) {
		return null;
	}

	@Override
	public void activate(String token) {
		token = token.trim();
		String hql = "update User set email_val_flag = 1 where token = :token ";
		userDao.getSession().createQuery("").setString("token", token).executeUpdate();
	}

}
