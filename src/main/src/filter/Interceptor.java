package main.src.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

import main.src.common.Log;

public class Interceptor implements Filter{

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void doFilter(ServletRequest req, ServletResponse res,	FilterChain filterChain) throws IOException, ServletException {
		@SuppressWarnings("unused")
		HttpServletRequest request=(HttpServletRequest)req;	
		String url = (String)request.getRequestURL().toString();
		if(!(url.indexOf(".js")>=0 || url.indexOf(".css")>=0 || url.indexOf(".png")>=0)){
		Log.print("interceptor£º"+url);}
		filterChain.doFilter(req, res);
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		// TODO Auto-generated method stub
		
	}

}
