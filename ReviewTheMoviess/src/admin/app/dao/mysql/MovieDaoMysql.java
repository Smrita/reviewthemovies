package admin.app.dao.mysql;

import java.sql.Date;
import java.sql.Statement;

import admin.app.dto.Genre;
import admin.app.dto.Movie;
import admin.app.dto.Person;
import admin.common.BaseDao;

public class MovieDaoMysql extends BaseDao {

	public void addMovie(Movie movie, Person[] director, Person[] writer,
			Person[] star, Genre[] genre) throws Exception {
		try {
			connect();
			connection.setAutoCommit(false);
			
			query = "insert into movie values(?,?,?,?,?,?,?,?)";
			preparedStatement = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
			preparedStatement.setString(1, "");
			preparedStatement.setString(2, movie.getMovieName());
			preparedStatement.setString(3, movie.getReleasedDate());
			preparedStatement.setString(4, movie.getPgRating());
			preparedStatement.setString(5, movie.getDuration());
			preparedStatement.setString(6, movie.getSummary());
			preparedStatement.setString(7, movie.getImageLink());
			preparedStatement.setString(8, movie.getDownloadLink());
			int movie_id = preparedStatement.executeUpdate();

			
			query = "insert into directors values(?,?,?,?)";
		    preparedStatement = connection.prepareStatement(query,Statement.RETURN_GENERATED_KEYS);
			preparedStatement.setString(1, "");
			preparedStatement.setString(2, director[0].getFirstName());
			preparedStatement.setString(3, director[0].getMiddleName());
			preparedStatement.setString(4, director[0].getLastName());
			int director_id = preparedStatement.executeUpdate();

			
			query = "insert into writers values(?,?,?,?)";
			preparedStatement = connection.prepareStatement(query ,Statement.RETURN_GENERATED_KEYS);
			preparedStatement.setString(1, "");
			preparedStatement.setString(2, writer[0].getFirstName());
			preparedStatement.setString(3, writer[0].getMiddleName());
			preparedStatement.setString(4, writer[0].getLastName());
			int writer_id = preparedStatement.executeUpdate();

			
			
			query = "insert into stars values(?,?,?,?)";
			preparedStatement = connection.prepareStatement(query , Statement.RETURN_GENERATED_KEYS);
			preparedStatement.setString(1, "");
			preparedStatement.setString(2, star[0].getFirstName());
			preparedStatement.setString(3, star[0].getMiddleName());
			preparedStatement.setString(4, star[0].getLastName());
			int star_id = preparedStatement.executeUpdate();

			
			query = "insert into genres values(?,?,?,?)";
			preparedStatement = connection.prepareStatement(query , Statement.RETURN_GENERATED_KEYS);
			preparedStatement.setString(1, "");
			preparedStatement.setString(2, genre[0].getTitle());
			int genre_id = preparedStatement.executeUpdate();
			
			
			query = "insert into movies_directors values(?,?)";
			preparedStatement = connection.prepareStatement(query);			
			preparedStatement.setInt(1, movie_id);
			preparedStatement.setInt(2, director_id);
			preparedStatement.executeUpdate();
			
			
			query = "insert into movies_writers values(?,?)";
			preparedStatement = connection.prepareStatement(query);			
			preparedStatement.setInt(1, movie_id);
			preparedStatement.setInt(2, writer_id);
			preparedStatement.executeUpdate();
			
			
			query = "insert into movies_stars values(?,?)";
			preparedStatement = connection.prepareStatement(query);			
			preparedStatement.setInt(1, movie_id);
			preparedStatement.setInt(2, star_id);
			preparedStatement.executeUpdate();
			
			
			query = "insert into movies_genres values(?,?)";
			preparedStatement = connection.prepareStatement(query);			
			preparedStatement.setInt(1, movie_id);
			preparedStatement.setInt(2, genre_id);
			preparedStatement.executeUpdate();
			
			connection.commit();

		} catch (Exception e) {
			connection.rollback();
			
			e.printStackTrace();
			throw e;

		} finally {
           close();
		}

	}

}
