package auth.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class Home extends HttpServlet
{
	
	public void doGet(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException
	{
		HttpSession session =request.getSession(true);
		
		if(session!=null&&session.getAttribute("user")!=null)
		{
			RequestDispatcher dispatcher=request.getRequestDispatcher("pages/home.jsp");
			dispatcher.forward(request, response);
		}
		else
		{
			response.sendRedirect("welcome");
		}
		
		
		
	}
	
}