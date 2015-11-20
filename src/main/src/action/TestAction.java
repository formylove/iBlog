package main.src.action;

import java.util.Properties;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.StrutsStatics;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;
import org.springframework.core.io.Resource;
import org.springframework.web.context.support.ServletContextResource;
import org.springframework.web.context.support.XmlWebApplicationContext;

import com.opensymphony.xwork2.ActionContext;

import main.src.common.IPParser;
import main.src.common.Log;
import main.src.common.MsgConstants;
import main.src.entity.Note;
import main.src.entity.User;
import main.src.service.NoteService;
import main.src.service.UserService;
import test.entity.Address;
import test.service.TestService;
import test.service.impl.TestServiceImpl;
public class TestAction {
	User user;
	int id;
	Properties nations;
	String msg;
	@javax.annotation.Resource(name = "testService")
	TestServiceImpl testService;
	public String h2(){
		AbstractApplicationContext ctx = new FileSystemXmlApplicationContext(
				new String[]{"C:/Users/Administrator/git/iBlog/WebContent/WEB-INF/applicationContext.xml"
						,"C:/Users/Administrator/git/iBlog/WebContent/WEB-INF/daoContext.xml"
				});
		NoteService ns = ctx.getBean("noteService",NoteService.class);
		Note n = ns.get(3);
		Log.print("根据主键加载持久化实体", n.getAuthor());

		return "test";
	}
	public String test(){
		HttpServletRequest request=ServletActionContext.getRequest();
		HttpSession session = request.getSession();
		session.invalidate();
		HttpServletResponse res = (HttpServletResponse) ActionContext.getContext().get(StrutsStatics.HTTP_RESPONSE);
		if(id!=0){
			Cookie c = new Cookie("night_user_id",String.valueOf(id));
			c.setMaxAge(3600);
			res.addCookie(c);
		}else{
			UserService.logout();
		}
		if(user!=null)
			System.out.println(user.getNick_name());
		return "test";
	}
	public String testSpring(){
		HttpServletRequest request=ServletActionContext.getRequest();
		Resource rs = new ServletContextResource(request.getServletContext(), "data/QQWry.Dat");
		Log.print("ServletContextResource", rs.getFilename());
		Log.print("ServletContextResource-exists", rs.exists());
		msg = "ServletContextResource-exists" + rs.getFilename() + " " + rs.exists();
		return "test";
	}
	public String testResource(){
		HttpServletRequest request=ServletActionContext.getRequest();
		IPParser i = new IPParser(request);
		try {
			Log.print("country", i.getCountry());
			Log.print("local", i.getLocal());
			ServletContextResource rs = new ServletContextResource(request.getServletContext(), "data/qqwry.dat");
			msg = rs.getPath();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "test";
	}
	
	public String testXmlWeb(){
		XmlWebApplicationContext ctx = new XmlWebApplicationContext(); 
		ctx.setConfigLocation("/WEB-INF/applicationContext.xml");
		ctx.setServletContext(ServletActionContext.getServletContext());
		ctx.refresh();
		Address addr = ctx.getBean("test", Address.class);
		msg = addr.getDetail();
		return "test";
	}
	public String annotation(){
		testService.test();
		return "test";
	}
	public String cache(){
		nations = MsgConstants.ISO31661ALPHA3;
		msg = MsgConstants.AUTHORITY.getProperty("10");
		return "test";
	}
	public String aop(){
		XmlWebApplicationContext ctx = new XmlWebApplicationContext();
		ctx.setConfigLocations("/WEB-INF/applicationContext.xml");
		ctx.setServletContext(ServletActionContext.getServletContext());
		ctx.refresh();
		NoteService ns = ctx.getBean("noteService",NoteService.class);
		ns.get(0);
		return "test";
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public Properties getNations() {
		return nations;
	}
	public void setNations(Properties nations) {
		this.nations = nations;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public TestService getTestService() {
		return testService;
	}
	public void setTestService(TestServiceImpl testService) {
		this.testService = testService;
	}
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	
	
}
