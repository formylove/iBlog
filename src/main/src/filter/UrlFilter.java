package main.src.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import main.src.common.Log;


public class UrlFilter implements Filter{

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void doFilter(ServletRequest req, ServletResponse res,	FilterChain filterChain) throws IOException, ServletException {
		HttpServletRequest request=(HttpServletRequest)req;
		String url=request.getRequestURI();
	Log.print(url);
		if(url.indexOf("diary/")>=0)
		{
//			Log.print("in");
		String diaryId=	url.substring(url.length()-4);
		HttpServletResponse response=(HttpServletResponse) res;
		response.sendRedirect("../action/diaryAction.action?method:loadDiary&id="+diaryId);
		}else if(url.indexOf("hidddd", 0)>=0){
			Log.print("in");
			req.getRequestDispatcher("/pages/jsp/hi.html").forward(req, res);
		}else{
			filterChain.doFilter(req, res);
			
			
		}
//		Log.print("out");
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		// TODO Auto-generated method stub
		
	}

}
