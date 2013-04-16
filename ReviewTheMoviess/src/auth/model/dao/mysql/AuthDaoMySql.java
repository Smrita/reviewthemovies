package auth.model.dao.mysql;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;

import auth.model.dto.User;
import common.dao.BaseDao;

public class AuthDaoMySql extends BaseDao 
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
    
    public User signUp(String firstName,String lastName,String email,String password,String country) throws Exception
    {
    	

    	connectToDb();
    	  	
    	System.out.println("from signup 3");
//    	if(checkUser(email,password)==null)
//   	    {
    	 
    		query="insert into user(firstname,lastname,email,password,country) values (?,?,?,?,?)";
    	    	try
    	    	{
    	    		preparedStatement=connection.prepareStatement(query);
    	    	    preparedStatement.setString(1,firstName);
    	    	    preparedStatement.setString(2,lastName);
    	    	    preparedStatement.setString(3,email);
    	    	    preparedStatement.setString(4,password);
    	    	    preparedStatement.setString(5,country);   
    	    	}
    	    	catch(Exception e)
    	    	{
    	    		System.out.println("couldnot insert from AuthDa0MySQL");
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
			user.setId(resultSet.getInt("id"));
			user.setFirstName(resultSet.getString("firstname"));
			user.setLastName(resultSet.getString("lastname"));
			user.setEmail(resultSet.getString("email"));
			user.setPassword(resultSet.getString("password"));
			user.setCountry(resultSet.getString("country"));
			
		}
    	
    }
    
    private void checkUser(String email,String password) throws SQLException, ClassNotFoundException
    {
    	query="SELECT * FROM user where email=? AND password=?";
    	preparedStatement = connection.prepareStatement(query);
		preparedStatement.setString(1, email);
		preparedStatement.setString(2, password);
		resultSet=preparedStatement.executeQuery();
		setUserAttributes(resultSet);
    	
    }
    
    
    public static void main(String[] args) throws ClassNotFoundException, SQLException 
    {
    	AuthDaoMySql ms=new AuthDaoMySql();
    	String firstName="Smritaa";
    	String lastName="Pokharel";
    	String email="smriita@gmail.com";
    	String password="abc123";
    	String country="Nepal";
    	try {
//		User user=ms.signUp(firstName, lastName, email, password, country);
   		User user=ms.login(email, password);
   		System.out.println(user.getCountry());
			
		} catch (Exception e) {
			System.out.println("couldnot insert from main");
			e.printStackTrace();
		}
    }
   
}
