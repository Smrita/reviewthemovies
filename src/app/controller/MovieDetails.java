package app.controller;

import java.util.List;
import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import app.model.Dto.Movies;
import app.model.dao.mysql.AppDaoMysql;


@WebServlet("/MovieDetails")
public class MovieDetails extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		AppDaoMysql app=new AppDaoMysql();
		List<Movies> movieList=new ArrayList<Movies>();
		try{
			
		movieList= app.getMovieInfo();
		}
		catch(Exception e){
			e.printStackTrace();
		}
		
		request.setAttribute("movieList",movieList);
		RequestDispatcher rs=request.getRequestDispatcher("pages/app/show.jsp");
		rs.forward(request,response);
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
