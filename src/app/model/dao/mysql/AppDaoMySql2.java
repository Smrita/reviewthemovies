package app.model.dao.mysql;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import app.model.Dto.Movies;

import common.dao.BaseDao;

public class AppDaoMySql2 extends BaseDao{

	Movies movies=null;
	public ArrayList<Movies> getMovieInfo() throws Exception{
		
		ArrayList<Movies> movieInfo=new ArrayList<Movies>();
		ArrayList<String> actorName;
		ArrayList<Integer> actorId=new ArrayList<Integer>();
		ResultSet rs1;
		ResultSet rs;
		String summary=null;
		int id;
		query="SELECT * from movies";
		connectToDb();
		rs=statement.executeQuery(query);
		
		query="Select actor_id from movie_actors where movie_id=?";
		preparedStatement=connection.prepareStatement(query);
		
		while(rs.next()){
			Movies movies =new Movies();	
			
			actorName=new ArrayList<String>();
			movies.set_movieId(rs.getInt(1));
			preparedStatement.setInt(1, movies.get_movieId());
			rs1=preparedStatement.executeQuery();
			
			while(rs1.next())
			{
				
				id=rs1.getInt("director_id");
				System.out.println(rs1.getInt(1));
				String actorname=retrieveActorName(id);
				actorName.add(actorname);
				System.out.println(actorname);
			}
			movies.set_stars(actorName);
			movies.set_releaseDate(rs.getDate(2));
			movies.set_pgRating(rs.getString(3));
			movies.set_length(rs.getString(4));
			movies.set_summary(rs.getString(5));
			movies.set_imageLink(rs.getString(6));
			movies.set_downloadLink(rs.getString(7));
			movieInfo.add(movies);
		}
		return movieInfo;
	}
	
	public String retrieveActorName(int actorId) throws SQLException, ClassNotFoundException
	{
		String firstName = null;
		String middleName = null;
		String lastName = null;
		String actorName=null;
		
		connectToDb();
		query="select first_name,middle_name,last_name from actors where actor_id=?";
		preparedStatement=connection.prepareStatement(query);
		preparedStatement.setInt(1, actorId);
		System.out.println(actorId);
		resultSet=preparedStatement.executeQuery();
		while(resultSet.next())
		{
			firstName=resultSet.getString(1);
			middleName=resultSet.getString(2);
			lastName=resultSet.getString(3);
		}
		if(middleName!=null||middleName!=" ")
		actorName=firstName+" "+middleName+" "+lastName;
		
		else
			actorName=firstName+" "+lastName;	
		
		return actorName;
	}
	
	
//public static void main(String [] args) throws SQLException, ClassNotFoundException{
//	AppDaoMySql appdao=new AppDaoMySql();
//	String actorname=appdao.retrieveActorName(2);
//	System.out.println(actorname);
//	
//	
//}
}
