package main.src.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import main.src.common.StrUtils;
import main.src.common.WebUtils;
import main.src.multithread.CheckINThread;
import main.src.service.UserService;
@WebFilter(urlPatterns = {"/*"}, asyncSupported = true, 
filterName = "userFilter", displayName = "userFilter", 
initParams = {@WebInitParam(name = "exdluceParams", value = "ajax,.action,.js,.swf,.gif,.css,.png,.jpg,.ico,.icon")} 
)
public class UserDetectFilter implements Filter{
    private FilterConfig config;
	@Override
	public void doFilter(ServletRequest req, ServletResponse res,	FilterChain filterChain) throws IOException, ServletException {
		HttpServletRequest request=(HttpServletRequest)req;
		HttpSession session = request.getSession();
		String url=request.getRequestURI().toLowerCase();
		
		if(!StrUtils.contains(url, config.getInitParameter("exdluceParams").split(","))){
			
		if((session.getAttribute("notFirst") == null || WebUtils.neededRecord(request)) && url.indexOf("ajax")<0 ){
			CheckINThread cit = new CheckINThread(request);
			cit.start();
		}
			request.setAttribute("logined_user", UserService.getcurLoginUser((HttpServletRequest)req));
			System.out.println("###########user-agent###########"+request.getHeader("user-agent"));
		}
		
		System.out.println("########### detectFilter ###########"+request.getRequestURI());
		filterChain.doFilter(req, res);
	
	}
	
	@Override
	public void init(FilterConfig config) throws ServletException {
		this.config = config;
	}
	@Override
	public void destroy() {
		System.out.println("###########detectFilter  destroy ###########");
	}
  	}
