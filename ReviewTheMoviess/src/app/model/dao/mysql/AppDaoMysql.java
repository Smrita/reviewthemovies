package app.model.dao.mysql;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.ArrayList;

import app.model.Dto.Movies;

import common.dao.BaseDao;


public class AppDaoMysql extends BaseDao{

	public List<Movies> getMovieInfo() throws ClassNotFoundException, SQLException{
		query="SELECT * from movies";
		String actorName,directorQuery,directorName,writerQuery,writerName;
		List<Movies> movieList=new ArrayList<Movies>();
		
		connectToDb();
		
		preparedStatement=connection.prepareStatement(query);
		resultSet=preparedStatement.executeQuery();
		query="Select actor_id from movie_actors where movie_id=?";
		directorQuery="SELECT director_id from movie_directors where movie_id=?";
		writerQuery="SELECT writer_id from movie_writers where movie_id=?";
		while(resultSet.next()){
			Movies movies=new Movies();
			movies.set_movieId(resultSet.getInt(1));
			movies.set_releaseDate(resultSet.getDate(2));
			movies.set_pgRating(resultSet.getString(3));
			movies.set_length(resultSet.getString(4));
			movies.set_summary(resultSet.getString(5));
			movies.set_imageLink(resultSet.getString(6));
			movies.set_downloadLink(resultSet.getString(7));
			preparedStatement=connection.prepareStatement(query);
			preparedStatement.setInt(1,movies.get_movieId());
			ResultSet rsActors=preparedStatement.executeQuery();
			preparedStatement =connection.prepareStatement(directorQuery);
			preparedStatement.setInt(1,movies.get_movieId());
			ResultSet rsDirectors=preparedStatement.executeQuery();
			preparedStatement =connection.prepareStatement(writerQuery);
			preparedStatement.setInt(1,movies.get_movieId());
			ResultSet rsWriters=preparedStatement.executeQuery();
			
			List<String>actor=new ArrayList<String>();
			List<String>director=new ArrayList<String>();
			List<String>writer=new ArrayList<String>();
			
			while(rsActors.next()){
				
				actorName=getMovieActors(rsActors.getInt(1));
				actor.add(actorName);
				movies.set_stars(actor);
			}
			while(rsDirectors.next()){
				directorName=getMovieDirectors(rsDirectors.getInt(1));
				director.add(directorName);
				movies.set_directors(director);
			}
			
			while(rsWriters.next()){
				writerName=getMovieWriters(rsWriters.getInt(1));
				writer.add(writerName);
				movies.set_writers(writer);
			}
			
			movieList.add(movies);
		}
		return movieList;
	}
    
	
	public String getMovieActors(int actorId) throws SQLException, ClassNotFoundException{
		connectToDb();
		String actorName=null;
		String queryActors="SELECT first_name,middle_name,last_name from actors where actor_id=?";
		PreparedStatement stmt=connection.prepareStatement(queryActors);
		stmt.setInt(1,actorId);
		ResultSet actors=stmt.executeQuery();
		while(actors.next()){
			actorName=actors.getString(1)+actors.getString(2)+actors.getString(3);
		}
		return actorName;
	
	}
	
	public String getMovieDirectors(int directorId) throws SQLException, ClassNotFoundException{
		connectToDb();
		String directorName=null;
		String queryDirectors="SELECT first_name,middle_name,last_name from directors where director_id=?";
		PreparedStatement stmt=connection.prepareStatement(queryDirectors);
		stmt.setInt(1,directorId);
		ResultSet directors=stmt.executeQuery();
		while(directors.next()){
			directorName=directors.getString(1)+directors.getString(2)+directors.getString(3);
		}
		return directorName;
	
	}
	
	public String getMovieWriters(int writerId) throws SQLException, ClassNotFoundException{
		connectToDb();
		String writerName=null;
		String queryWriters="SELECT first_name,middle_name,last_name from writers where writer_id=?";
		PreparedStatement stmt=connection.prepareStatement(queryWriters);
		stmt.setInt(1,writerId);
		ResultSet writers=stmt.executeQuery();
		while(writers.next()){
			writerName=writers.getString(1)+writers.getString(2)+writers.getString(3);
		}
		return writerName;
	
	}



}
