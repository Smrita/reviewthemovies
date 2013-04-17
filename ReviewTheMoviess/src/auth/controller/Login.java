package auth.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.HttpCookie;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
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
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		user=new User();
		email=request.getParameter("email");
		password=request.getParameter("password");
		
		String rememberme=request.getParameter("rememberMe");
//		int id = -1;
		String userEmail = null;
		
//		if(rememberme.matches("true"))
//		{
//			rememberMe=true;
//		}
		
		
		
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
			
			System.out.println("session set email"+userEmail);
			session=request.getSession(true);
			session.setAttribute("user", user);
			
			RequestDispatcher dispatcher=request.getRequestDispatcher("home");
		    dispatcher.forward(request, response);
			
		}
		else
		{
			response.sendRedirect("login");
		}
		
	
	}
	
	
}
