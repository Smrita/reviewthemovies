package auth.model.dto;

public class User
{
	
     private String userName;
     private String country;
     private String password;
     private String firstName;
     private String lastName;
     private String middleName;
 	private String email;
     public String getMiddleName() {
		return middleName;
	}

	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}


     
	 
public User()
{
}

public User(String firstName,String middleName,String lastName,String email,String password,String country)
{
	setFirstName(firstName);
	setMiddleName(middleName);
	setLastName(lastName);
	setEmail(email);
	setCountry(country);
	setPassword(password);
}
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}
	
	public String getCountry()
	{
		return country;
	}
	
	public void setCountry(String country)
	{
		this.country = country;
	}
	
	public String getPassword()
	{
		return password;
	}
	
	public void setPassword(String password) 
	{
		this.password = password;
	}
	
	public String getFirstName()
	{
		return firstName;
	}
	
	public void setFirstName(String firstName)
	{
		this.firstName = firstName;
	}
	
	public String getLastName() 
	{
		return lastName;
	}
	
	public void setLastName(String lastName)
	{
		this.lastName = lastName;
	}
     
     
     
     
}
