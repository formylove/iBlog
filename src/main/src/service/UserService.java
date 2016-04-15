package main.src.service;

import javax.servlet.http.HttpServletRequest;

import main.src.entity.User;
import main.src.service.base.BaseService;

public interface UserService extends BaseService<User>{

	User getcurLoginUser(HttpServletRequest request);

	boolean hasRegistered(String email);

	String loginDetect(String email, String password);

	boolean hasUsed(String nick_name);

	String registerDetect(String nick_name, String email, String password, String psw_conf, String rule);

	User valiAndLogin(String email, String password, String remember);

	boolean login(User user, String remember);
	
	User login(String email, String remember);
	
	User validate(String email, String remember);

	int getDurationForRegister(String token);

	boolean logout();
	
	User getUserByMail(String email);

	User getUserByToken(String token);
	
	void activate(String token);

	boolean isExpired(String token);
	
	public String valiName(String nick_name);
}
