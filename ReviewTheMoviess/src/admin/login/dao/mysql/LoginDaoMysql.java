package admin.login.dao.mysql;


import admin.common.BaseDao;
import admin.login.dto.Admin;

public class LoginDaoMysql extends BaseDao{
	
	public Admin login(String adminName , String adminPassword) throws Exception
	{
		Admin admin=null;

		query="Select * from admin where admin_name=? and admin_password=?";
		try{
            connect();
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setString(1, adminName);
			preparedStatement.setString(2, adminPassword);
			resultSet= preparedStatement.executeQuery();
         
	        admin = new Admin();
			while(resultSet.next())
			{
				
				admin.setAdminName(resultSet.getString("admin_name"));
				admin.setAdminName(resultSet.getString("admin_password"));
				admin.setIsValid(true);
			}
		}catch(Exception e){
			e.printStackTrace();
			throw e;
		}finally{
			close();
		}
		
		
		return admin;
	}

}
