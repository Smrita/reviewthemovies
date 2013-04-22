package auth.model.dao.mysql;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;

import auth.model.dao.AuthDao;
import auth.model.dto.User;
import common.dao.BaseDao;

public class AuthDaoMySql extends BaseDao implements AuthDao
{
	User user=null;
	
    public User login(String email,String password) throws Exception
    {

    	connectToDb();
    
    	try
    	{
   		
    		user=new User();
     		checkUser(email,password);
     		setUserAttributes(resultSet);
        
    		
    	}
    	
    	catch(Exception e)
    	{
    		e.printStackTrace();
    	}
    	
    	finally
    	{
    		disconnectFromDb();
    	}
    	
    	return user;
    }
    
    public User signUp(String email,String password,String firstName,String middleName,String lastName,String country) throws Exception
    {
    	

    	connectToDb();
    	  	
    	System.out.println("from signup 3");
//    	if(checkUser(email,password)==null)
//   	    {
    	 
    		query="insert into users(email,password,firstname,middlename,lastname,country) values (?,?,?,?,?,?)";
    	    	try
    	    	{
    	    		preparedStatement=connection.prepareStatement(query);
    	    	    preparedStatement.setString(1,email);
    	    	    preparedStatement.setString(2,password);
    	    	    preparedStatement.setString(3,firstName);
    	    	    preparedStatement.setString(4,middleName);
    	    	    preparedStatement.setString(5,lastName);
  	    	        preparedStatement.setString(6,country);
    	    	    preparedStatement.executeUpdate();
   	    	    user=new User(firstName,middleName,lastName,email,password,country);
    	    	    
    	    	}
    	    	catch(Exception e)
    	    	{
    	    		System.out.println("couldnot insert from AuthDa0MySQL");
    	    		e.printStackTrace();
    	    		
    	    	}
    	    	
    	    	finally
    	    	{
    	    		System.out.println("from signup finally");
    	    		disconnectFromDb();
    	    		
    	    	}
   	    	
//   	    }
   	    
    	
    	return user;
    }
    
    private void setUserAttributes(ResultSet resultSet) throws SQLException
    {
    	while(resultSet.next())
		{
			user=new User();
		
			user.setFirstName(resultSet.getString("firstname"));
			user.setLastName(resultSet.getString("lastname"));
			user.setEmail(resultSet.getString("email"));
			user.setPassword(resultSet.getString("password"));
			user.setCountry(resultSet.getString("country"));
			
		}
    	
    }
    
    private void checkUser(String email,String password) throws SQLException, ClassNotFoundException
    {
    	query="SELECT * FROM users where email=? AND password=?";
    	preparedStatement = connection.prepareStatement(query);
		preparedStatement.setString(1, email);
		preparedStatement.setString(2, password);
		resultSet=preparedStatement.executeQuery();
		setUserAttributes(resultSet);
    	
    }
    
    public void injectCookies(String email,String cookieName) throws Exception
    {
    	query="update users set cookie=? where email=?";
    	try
    	{
    		connectToDb();
    		preparedStatement=connection.prepareStatement(query);
    		preparedStatement.setString(1,cookieName);
    		preparedStatement.setString(2,email);
    		preparedStatement.executeUpdate();
    		
       }
    	catch(Exception e)
    	{
    		System.out.println("couldnot update database i.e. set cookie in user table");
    		e.printStackTrace();
    	}
    }
    
    public void removeCookie(String email) throws SQLException
    {
    	query="update users set cookie=? where email=?";
    	
    	try
    	{
    		connectToDb();
    		preparedStatement=connection.prepareStatement(query);
    		preparedStatement.setString(1,"");
    		preparedStatement.setString(2,email);
    		preparedStatement.executeUpdate();
       }
    	catch(Exception e)
    	{
    		System.out.println("couldnot update database i.e. destroy cookie in user table");
    		e.printStackTrace();
    	}
    	
    	finally
    	{
    		disconnectFromDb();
    	}
    }
    
    public User getUserFromCookie(String cookieValue) throws SQLException
    {
    	query="select * from users where cookie=?";
    	user=null;
    	try
    	{
    		
    		connectToDb();
    		preparedStatement=connection.prepareStatement(query);
    		preparedStatement.setString(1, cookieValue);
    		resultSet=preparedStatement.executeQuery();
    		setUserAttributes(resultSet);
    	}
    	catch(Exception e)
    	{
    		System.out.println("couldnot get user from cookie");
    		e.printStackTrace();
    	}
    	finally
    	{
    		disconnectFromDb();
    	}
    	
    	return user;
    	
    }
    
    
    public static void main(String[] args) throws ClassNotFoundException, SQLException 
    {
    	AuthDaoMySql ms=new AuthDaoMySql();
    	String firstName="Srija";
    	String middleName="";
    	String lastName="Pokharel";
    	String email="smriita@gmail.com";
    	String password="abc";
    	String country="Nepal";
    	try {
		User user=ms.signUp(firstName, middleName,lastName, email, password, country);
//   		User user=ms.login(email, password);
//   		System.out.println(user.getCountry());
//			ms.injectCookies("smriita@gmail.com", "xyz");
    		
//    		User user=ms.getUserFromCookie("jkjj");
  		System.out.println(user.getCountry());
    		
		} catch (Exception e) {
			System.out.println("couldnot insert from main");
			e.printStackTrace();
		}
    }

//	@Override
//	public void removeCookie(String email) throws Exception {
//		// TODO Auto-generated method stub
//		
//	}

	
}
