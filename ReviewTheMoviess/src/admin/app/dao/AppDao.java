package admin.app.dao;

import admin.app.dto.Genre;
import admin.app.dto.Movie;
import admin.app.dto.Person;

public interface AppDao {
	
	public void addMovie(Movie movie , Person[] director , Person[] writer, Person[] star, Genre[] genre) throws Exception;

}
