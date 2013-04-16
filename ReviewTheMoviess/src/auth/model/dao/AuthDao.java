package auth.model.dao;

import auth.model.dto.User;

public interface AuthDao 
{

	User login(String username, String password) throws Exception;
	User signup(String firstname,String lastname, String username, String password) throws Exception;
}
