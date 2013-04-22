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

public class EntryValidator implements Filter
{

	boolean loggedIn=false;
	boolean cookieFlag=false;
	String email;
	@Override
	public void destroy()
	{
		
	}

	@Override
	public void doFilter(ServletRequest req, ServletResponse res,FilterChain chain) throws IOException, ServletException
   {
        System.out.println("============login filter here===============");
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
					System.out.println("cookie found found found!");
					cookieFlag=true;
					email=c.getValue();
					System.out.println("from entry validator cookie value"+email);
				   
				}
			}

		}
		if(session!=null&&session.getAttribute("user")!=null)
		{
			loggedIn=true;
//			response.sendRedirect("home");
		}
		
			
		if(cookieFlag)
		{
			user=null;
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
							
								session=request.getSession(true);
								session.setAttribute("user", user);
								loggedIn=true;
							}
//							break;
							}
						catch (Exception e)
						{
							e.printStackTrace();
						}
				    
				  
				}
//			}
//		}
           
//			chain.doFilter(req, res);
//		}
		
		if(loggedIn)
		{
			System.out.println("inside loggedIn from entry invalidator");
			response.sendRedirect("home");
		}
		
		else
		{
			chain.doFilter(req, res);
		}
		

		}
	

	@Override
	public void init(FilterConfig arg0) throws ServletException 
	{
		
		
		
		
	}

}
