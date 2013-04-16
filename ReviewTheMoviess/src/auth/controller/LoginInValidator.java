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

import auth.model.dao.mysql.AuthDaoMySql;
import auth.model.dto.User;

public class LoginInValidator extends HttpServlet
{

	protected AuthDaoMySql dao;
	protected User user;
	protected String email;
	protected String password;
	protected Boolean rememberMe=false;
	protected HttpSession session;
	protected HttpCookie cookie;
	
	public void doPost(HttpServletRequest request,HttpServletResponse response) throws IOException, ServletException
	{
		
		dao=new AuthDaoMySql();
		user=new User();
		email=request.getParameter("email");
		password=request.getParameter("password");
		String rememberme=request.getParameter("rememberMe");
		int id = -1;
		
//		if(rememberme.matches("true"))
//		{
//			rememberMe=true;
//		}
		
		
		
		try 
		{
			user=dao.login(email, password);
			id=user.getId();
			
			
			
		} catch (Exception e) {
			System.out.println("couldnot login from login servlet");
			e.printStackTrace();
		}
		
		if(id>0)
		{
			
			session=request.getSession(true);
			session.setAttribute("user", user);
			
			RequestDispatcher dispatcher=request.getRequestDispatcher("pages/home.jsp");
		dispatcher.forward(request, response);
			
		}
		else
		{
			response.sendRedirect("pages/index.jsp");
		}
		
		/*response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		out.println("hello");*/
	}
}
