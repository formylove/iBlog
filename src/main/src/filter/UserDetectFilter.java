package main.src.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.web.context.support.WebApplicationContextUtils;

import main.src.common.StrUtils;
import main.src.common.WebUtils;
import main.src.multithread.CheckINThread;
import main.src.service.UserService;
import main.src.service.impl.UserServiceImpl;
@WebFilter(urlPatterns = {"/*"}, asyncSupported = true, 
filterName = "userFilter", displayName = "userFilter", 
initParams = {@WebInitParam(name = "exdluceParams", value = "ajax,.action,.js,.swf,.gif,.css,.png,.jpg,.ico,.icon")} 
)
public class UserDetectFilter implements Filter,ApplicationContextAware{
    private FilterConfig config;
    private UserService userService;
    ApplicationContext ctx;
	@Override
	public void doFilter(ServletRequest req, ServletResponse res,	FilterChain filterChain) throws IOException, ServletException {
		HttpServletRequest request=(HttpServletRequest)req;
		HttpSession session = request.getSession();
		String url=request.getRequestURI().toLowerCase();
		
		if(!StrUtils.contains(url, config.getInitParameter("exdluceParams").split(","))){
			
//		if((session.getAttribute("notFirst") == null || WebUtils.neededRecord(request))){
//			CheckINThread cit = new CheckINThread(request,ctx);
//			cit.start();
//		}
			request.setAttribute("logined_user", userService.getcurLoginUser((HttpServletRequest)req));
		}
		filterChain.doFilter(req, res);
	}
	
	@Override
	public void init(FilterConfig config) throws ServletException {
		this.config = config;
		ServletContext context = config.getServletContext();  
        ctx = WebApplicationContextUtils.getWebApplicationContext(context);  
        userService = (UserService) ctx.getBean("userService");  
	}
	@Override
	public void destroy() {
		System.out.println("###########detectFilter  destroy ###########");
	}

	@Override
	public void setApplicationContext(ApplicationContext ctx) throws BeansException {
		userService = ctx.getBean("userService",UserServiceImpl.class);
		this.ctx = ctx;
	}
  	}
