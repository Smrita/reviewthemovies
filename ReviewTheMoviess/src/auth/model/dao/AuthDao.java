package auth.model.dao;

import auth.model.dto.User;

public interface AuthDao 
{

	User login(String username, String password) throws Exception;
	User signUp(String firstName,String lastName,String email,String password,String country) throws Exception;
}
