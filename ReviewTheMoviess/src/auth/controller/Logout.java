package auth.controller;

import java.io.IOException;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import auth.model.dao.AuthDao;
import auth.model.dao.AuthDaoFactory;
import auth.model.dto.User;

public class Logout extends HttpServlet 
{

	AuthDao dao;
	String email;
	Cookie[] cookies;
	Cookie cookie;
	public void doGet(HttpServletRequest request,HttpServletResponse response) throws IOException
	{
		HttpSession session=request.getSession(false);
        System.out.println(request.getContextPath());
		try
		{
			if(session!=null&&session.getAttribute("user")!=null)
			{
				session.invalidate();
			}
			
			dao=AuthDaoFactory.getAuthDao();
		    cookies=request.getCookies();
		    if(cookies!=null)
			   {
		    	
		    	for(Cookie c:cookies)
			     {
				   System.out.println("destroying cookies;");
				   if(c.getName().matches("rememberMe"))
				   {   System.out.println("insde remember me from logout");
					   System.out.println(c.getName());
					   System.out.println(c.getValue());
//					   dao.removeCookie(c.getValue());
					   c=new Cookie("rememberMe" ,null);
					   c.setPath(request.getContextPath());
					   c.setHttpOnly(true);
					   c.setMaxAge(0);
					   
					   response.addCookie(c);
					   
					  
					   System.out.println("cookies destroyed");
					   break;
				   }
			   }
			   }
			   
			   
			   System.out.println("session invalidated");

			   response.sendRedirect("login");
		}
		catch (Exception e1) 
		{
			System.out.println("couldnot destroy cookies from logout");
			e1.printStackTrace();
		}
		
		 
	}
}
