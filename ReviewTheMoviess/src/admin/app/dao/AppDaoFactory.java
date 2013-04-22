package admin.app.dao;

import admin.app.dao.mysql.AppDaoMysqlImpl;

public class AppDaoFactory {

	public static AppDao getAppDao()
	{
		return new AppDaoMysqlImpl();
	}
}
