package auth.model.dao;

import auth.model.dao.mysql.AuthDaoMySql;

public class AuthDaoFactory 
{
  public static AuthDao getAuthDao() throws Exception
  {
	return new AuthDaoMySql();  
  }
}
