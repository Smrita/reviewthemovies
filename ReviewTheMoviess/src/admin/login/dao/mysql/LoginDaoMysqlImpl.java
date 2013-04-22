package admin.login.dao.mysql;

import admin.login.dao.LoginDao;
import admin.login.dto.Admin;

public class LoginDaoMysqlImpl implements LoginDao {

	@Override
	public Admin login(String adminName, String adminPassword) throws Exception {
		// TODO Auto-generated method stub
		return new LoginDaoMysql().login(adminName, adminPassword);
	}

}
