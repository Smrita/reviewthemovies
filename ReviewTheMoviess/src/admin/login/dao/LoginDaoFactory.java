package admin.login.dao;

import admin.login.dao.mysql.LoginDaoMysqlImpl;

public class LoginDaoFactory {
	
	public static LoginDao getLoginDao()
	{
		return new LoginDaoMysqlImpl();
	}

}
