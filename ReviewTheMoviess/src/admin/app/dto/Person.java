package admin.app.dto;

public class Person {
	
	private String firstName;
	private String lastName;
	private String middleName;
	
	public void setFirstName(String fName)
	{
		this.firstName = fName;
	}
	public String getFirstName()
	{
		return firstName;
	}
	public void setLastName(String lName)
	{
		this.lastName=lName;
	}
	public String getLastName()
	{
		return lastName;
	}
	public void setMiddleName(String mName)
	{
		this.middleName=mName;
	}
	public String getMiddleName()
	{
		return middleName;
	}
}
