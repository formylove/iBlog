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
import javax.servlet.http.HttpSession;

import main.src.common.Log;
import main.src.common.WebUtils;
import main.src.multithread.CheckINThread;
import main.src.service.UserService;


public class UserDetectFilter implements Filter{

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void doFilter(ServletRequest req, ServletResponse res,	FilterChain filterChain) throws IOException, ServletException {
		HttpServletRequest request=(HttpServletRequest)req;
		HttpSession session = request.getSession();
		String url=request.getRequestURI().toLowerCase();
		if(!(url.indexOf(".action")>=0 || url.indexOf(".js")>=0 || url.indexOf(".css")>=0 || url.indexOf(".png")>=0 || url.indexOf(".jpg")>=0)){
		if(session.getAttribute("notFirst") == null || WebUtils.neededRecord(request)){
			CheckINThread cit = new CheckINThread(request);
			cit.start();
		}
			request.setAttribute("user", UserService.getcurLoginUser((HttpServletRequest)req));
		System.out.println("###########user-agent###########"+request.getHeader("user-agent"));
		}
		filterChain.doFilter(req, res);
	
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		// TODO Auto-generated method stub
		
	}

}
