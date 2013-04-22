package admin.login.dto;

public class Admin {

	private String adminName=null;
	private String adminPassword=null;
	private boolean isValid = false;
	
	public void setAdminName(String adName)
	{
		this.adminName = adName;
	}
	public void setAdminPassword(String adPass)
	{
		this.adminPassword = adPass;
	}
	public String getAdminName()
	{
		return adminName;
	}
	public String getAdminPassword()
	{
		return adminPassword;
	}
	public void setIsValid(boolean adValid)
	{
		this.isValid=adValid;
	}
	public boolean getIsValid()
	{
		return isValid;
	}
}
