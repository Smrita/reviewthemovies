package common.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import auth.model.dao.AuthDao;
import auth.model.dao.AuthDaoFactory;
import auth.model.dto.User;

public class SessionFilter implements Filter
{
	boolean loggedIn=false;
	boolean cookieFlag=false;
	String email;

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void doFilter(ServletRequest req, ServletResponse res,
			FilterChain chain) throws IOException, ServletException
   {
		System.out.println("============session filter here=========");
		User user;
	    Cookie cookie;
	    AuthDao dao;
		HttpServletRequest request=(HttpServletRequest)req;
		HttpServletResponse response=(HttpServletResponse)res;
		HttpSession session=request.getSession(false);
	    String url = request.getServletPath();
	    String cookieValue;
	
	    Cookie[] cookies=request.getCookies();
	
	    if(cookies!=null)
	    {
	    	for(Cookie c:cookies)
	    	{
	    		if(c.getName().matches("rememberMe"))
				{
//				   System.out.println("cookie foud found found!");
				   cookieFlag=true;
				   email=c.getValue();
				   
				}
	    	}
	    }
		
	    
		if(session!=null&&session.getAttribute("user")!=null)
		{
			loggedIn=true;
//			response.sendRedirect("home");
		}
		else if(cookieFlag)
		{
			user=null;
//			if(request.getCookies()!=null)
//			{
			System.out.println("inside cookies set filter");
//			 Cookie[] cookies=request.getCookies();
			
//				for(Cookie c:cookies)
//				{
//					if(c.getName().matches("rememberMe"))
//					{
						System.out.println("inside remember me cookies");
						try {
//							user=new User();
//							cookieValue=c.getValue();
							dao=AuthDaoFactory.getAuthDao();
							System.out.println("");
							user=dao.getUserFromCookie(email);
							System.out.println("user country from entry filter"+user.getCountry());
							if(user!=null)
							{
								System.out.println("inside session set");
								session=request.getSession(true);
								session.setAttribute("user", user);
								System.out.println("session is set");
								loggedIn=true;
							}
//							break;
							}
						catch (Exception e)
						{
							e.printStackTrace();
						}
				    
				  
				}
		
		if(!loggedIn)
		{
			response.sendRedirect("login");
		}
		else
		{
			chain.doFilter(req, res);
		}
		


//		if(session.getAttribute("user")==null)
//		{
//			System.out.println("session filter");
//			System.out.println(" not set");
//			response.sendRedirect("login");
//		}
//		else
//		{
//
//			System.out.println("from session filter set");
//			chain.doFilter(req, res);
//		}
//		
		

		
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException 
	{
		
		
		
		
	}

}
