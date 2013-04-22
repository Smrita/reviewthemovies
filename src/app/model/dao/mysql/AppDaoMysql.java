package app.model.dao.mysql;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import app.model.Dto.Actor;
import app.model.Dto.Director;
import app.model.Dto.Movies;
import app.model.Dto.Writer;

import common.dao.BaseDao;


public class AppDaoMysql extends BaseDao{

	private int _actorId;

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
			movies.set_releaseDate(resultSet.getString(2));
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
			
			List<Actor>actor=new ArrayList<Actor>();
			List<Director>director=new ArrayList<Director>();
			List<Writer>writer=new ArrayList<Writer>();
			
			while(rsActors.next()){
				Actor tempActor=new Actor();
				tempActor=getMovieActors(rsActors.getInt(1));
				actor.add(tempActor);
				movies.setActor(actor);
			}
			while(rsDirectors.next()){
				Director tempDirector=new Director();
				tempDirector=getMovieDirectors(rsDirectors.getInt(1));
				director.add(tempDirector);
				movies.setDirector(director);
			}
			
			while(rsWriters.next()){
				Writer tempWriter=new Writer();
				tempWriter=getMovieWriters(rsWriters.getInt(1));
				writer.add(tempWriter);
				movies.setWriter(writer);
			}
		
			movieList.add(movies);
		}
		return movieList;
	}
    
	
	public Actor getMovieActors(int actorId) throws SQLException, ClassNotFoundException{
		connectToDb();
		Actor actor=new Actor();
		String queryActors="SELECT first_name,middle_name,last_name from actors where actor_id=?";
		PreparedStatement stmt=connection.prepareStatement(queryActors);
		stmt.setInt(1,actorId);
		ResultSet actors=stmt.executeQuery();
		while(actors.next()){
			actor.set_actorId(actors.getInt(1));
			actor.set_firstName(actors.getString(2));
			actor.set_middleName(actors.getString(3));
			actor.set_lastName(actors.getString(4));
			
		}
		return actor;
	
	}
	
	public Director getMovieDirectors(int directorId) throws SQLException, ClassNotFoundException{
		connectToDb();
		Director director=new Director();
		String queryDirectors="SELECT first_name,middle_name,last_name from directors where director_id=?";
		PreparedStatement stmt=connection.prepareStatement(queryDirectors);
		stmt.setInt(1,directorId);
		ResultSet directors=stmt.executeQuery();
		while(directors.next()){
			director.set_directorId(directors.getInt(1));
			director.set_firstName(directors.getString(2));
			director.set_middleName(directors.getString(3));
			director.set_lastName(directors.getString(4));
		}
		return director;
	
	}
	
	public Writer getMovieWriters(int writerId) throws SQLException, ClassNotFoundException{
		connectToDb();
		Writer writer=new Writer();
		String queryWriters="SELECT first_name,middle_name,last_name from writers where writer_id=?";
		PreparedStatement stmt=connection.prepareStatement(queryWriters);
		stmt.setInt(1,writerId);
		ResultSet writers=stmt.executeQuery();
		while(writers.next()){
			writer.set_writerId(writers.getInt(1));
			writer.set_firstName(writers.getString(2));
			writer.set_middleName(writers.getString(3));
			writer.set_lastName(writers.getString(4));
		}
		return writer;
	
	}



}
