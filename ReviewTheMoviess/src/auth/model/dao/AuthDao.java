package auth.model.dao;

import auth.model.dto.User;

public interface AuthDao 
{

	User login(String username, String password) throws Exception;
	User signUp(String firstName,String middleName,String lastName,String email,String password,String country) throws Exception;
    void injectCookies(String email,String cookie) throws Exception;
    void removeCookie(String email) throws Exception;
    User getUserFromCookie(String cookieValue) throws Exception;
}
