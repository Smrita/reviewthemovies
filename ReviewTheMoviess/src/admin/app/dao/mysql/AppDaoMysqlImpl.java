package admin.app.dao.mysql;

import admin.app.dao.AppDao;
import admin.app.dto.Genre;
import admin.app.dto.Movie;
import admin.app.dto.Person;

public class AppDaoMysqlImpl implements AppDao{
	@Override
	public void addMovie(Movie movie, Person[] director, Person[] writer,
			Person[] star, Genre[] genre) throws Exception {
		// TODO Auto-generated method stub
		new MovieDaoMysql().addMovie(movie, director, writer , star, genre);
	}

}
