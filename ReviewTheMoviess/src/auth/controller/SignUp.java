package auth.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import auth.model.dao.AuthDao;
import auth.model.dao.AuthDaoFactory;
import auth.model.dto.User;

public class SignUp extends HttpServlet
{
	protected AuthDao dao;
	protected User user;
	protected String email;
	protected String password;
	protected String firstName;
	protected String middleName;
	protected String lastName;
	protected String country;
	
	public void doGet(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException
	{
	           	RequestDispatcher dispatcher=request.getRequestDispatcher("pages/auth/signup.jsp");
	           	dispatcher.forward(request, response);
	}
	
	public void doPost(HttpServletRequest request,HttpServletResponse response) throws IOException
	{
		
		email=request.getParameter("email");
		password=request.getParameter("password");
		firstName=request.getParameter("firstName");
		middleName=request.getParameter("middleName");
		lastName=request.getParameter("lastName");
		country=request.getParameter("country");
		try
		{
			dao=AuthDaoFactory.getAuthDao();
			dao.signUp(email, password,firstName, middleName, lastName,  country);
		    response.sendRedirect("pages/auth/Confirmation.jsp");
		}
		
		catch(Exception e)
		{
		   System.out.println("coulnot insert ");
		   request.setAttribute("signUpError","coulnot signup.Please try again");
		   response.sendRedirect("signup");
		   System.out.println();
		   e.printStackTrace();
		}
		
		
	}
	
}
