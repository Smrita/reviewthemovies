package auth.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.HttpCookie;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import auth.model.dao.AuthDao;
import auth.model.dao.AuthDaoFactory;
import auth.model.dao.mysql.AuthDaoMySql;
import auth.model.dto.User;

public class Login extends HttpServlet
{

	protected AuthDao dao;
	protected User user;
	protected String email;
	protected String password;
	protected Boolean rememberMe=false;
	protected HttpSession session;
	protected HttpCookie cookie;
	private static final int DAYS_IN_A_MONTH=30;
	private static final int SECONDS_IN_A_MIN=60;
	private static final int MINUTES_IN_AN_HOUR=60;
	private static final int HOURS_IN_A_DAY=24;
	
	
	
	public void doGet(HttpServletRequest request,HttpServletResponse response) throws IOException, ServletException
	{
	  
	
  	  RequestDispatcher dispatcher=request.getRequestDispatcher("pages/auth/login.jsp");
  	  dispatcher.forward(request, response);
	
	}
	
	public void doPost(HttpServletRequest request,HttpServletResponse response) throws IOException, ServletException
	{
		
		try {
			dao=AuthDaoFactory.getAuthDao();
		} catch (Exception e1) {
			
			e1.printStackTrace();
		}
		user=new User();
		email=request.getParameter("email");
		password=request.getParameter("password");
	
		String userEmail = null;
		
	
		
		
		
		try 
		{
		    System.out.println("email is "+email);	
			user=dao.login(email, password);
			userEmail=user.getEmail();
			System.out.println("userName is"+userEmail);
			
			
		} catch (Exception e) {
			System.out.println("couldnot login from login servlet");
			e.printStackTrace();
		}
		
		if(userEmail!=null)
		{
			if(request.getParameter("rememberMe")!=null)
			{
				String rememberme=request.getParameter("rememberMe");
				if(rememberme.matches("true"))
				{
//					rememberMe=true;
					Cookie cookie=new Cookie("rememberMe",email);
					cookie.setMaxAge(DAYS_IN_A_MONTH* HOURS_IN_A_DAY*MINUTES_IN_AN_HOUR*SECONDS_IN_A_MIN);
					cookie.setPath(request.getContextPath());
					cookie.setHttpOnly(true);
					response.addCookie(cookie);
					
						try {
							dao.injectCookies(email,cookie.getValue());
						} catch (Exception e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					
					
				}
			}

			
			session=request.getSession(true);
			session.setAttribute("user", user);
//			RequestDispatcher dispatcher=request.getRequestDispatcher("home");
//		    dispatcher.forward(request, response);
			
			response.sendRedirect("home");
			
		}
		else
		{
			response.sendRedirect("login");
		}
		
	
	}
	
	
}
