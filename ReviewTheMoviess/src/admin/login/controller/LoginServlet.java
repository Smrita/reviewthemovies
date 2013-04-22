package admin.login.controller;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import admin.login.dao.LoginDao;
import admin.login.dao.LoginDaoFactory;
import admin.login.dto.Admin;

/**
 * Servlet implementation class Login
 */
@WebServlet("/adminLogin")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public LoginServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

		RequestDispatcher rd = getServletContext().getRequestDispatcher(
				"/admin/pages/login.jsp");
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		LoginDao dao = null;
		Admin admin = null;
		
		String adminName = new String();
		String adminPassword = new String();
	
		try{
			
			adminName = request.getParameter("adname");
			adminPassword = request.getParameter("adpassword");

			dao = LoginDaoFactory.getLoginDao();
			admin = dao.login(adminName, adminPassword);
			
			if(admin.getIsValid())
			{
				response.sendRedirect("adminHome");
				
			}
			else{

				request.setAttribute("check", "Sorry, invalid username and password");
				RequestDispatcher login = request.getRequestDispatcher("/admin/pages/login.jsp");
				login.include(request, response);
			}
			
		}catch(Exception e)
		{
			e.printStackTrace();
			response.sendRedirect("adminLogin");
		}
	}

}
