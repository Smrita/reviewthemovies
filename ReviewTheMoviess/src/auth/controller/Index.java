package auth.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class Index extends HttpServlet
{
      public void doGet(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException
      {
//    	  
//    	  if(request.getAttribute("logout")!=null)
//    	  {
//    		  HttpSession session=request.getSession(false);
//    		  session.invalidate();
//    	  }
    	  RequestDispatcher dispatcher=request.getRequestDispatcher("pages/index.jsp");
    	  dispatcher.forward(request, response);
    	  
      }
}
