package main.src.filter;

import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import main.src.common.Log;
import main.src.service.UserService;


public class UserDetectFilter implements Filter{

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void doFilter(ServletRequest req, ServletResponse res,	FilterChain filterChain) throws IOException, ServletException {
		HttpServletRequest request=(HttpServletRequest)req;
		System.out.println("###########userDetect###########"+request.getRequestURI());
		if(UserService.isLogined((HttpServletRequest)req)){
			request.setAttribute("loginStatus", true);
			request.setAttribute("user", UserService.getcurLoginUser((HttpServletRequest)req));
		}else{
			request.setAttribute("loginStatus", false);
		}
		filterChain.doFilter(req, res);
	
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		// TODO Auto-generated method stub
		
	}

}
