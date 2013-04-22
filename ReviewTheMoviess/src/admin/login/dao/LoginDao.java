package admin.login.dao;

import admin.login.dto.Admin;

public interface LoginDao {

	public Admin login(String adminName , String adminPassword) throws Exception;
}
