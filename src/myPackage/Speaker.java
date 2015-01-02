package myPackage;

public class Speaker {
	
	String firstname;
	String lastname;
	String streetaddress1;
	String streetaddress2;
	String city;
	String state;
	String zipcode;
	String phone;
	String email;
	String username;
	String password;
	String bio;

	public Speaker() {

	}

	public Speaker(String firstname, String lastname, String address1, String address2, String city, 
			String state, String zipcode, String phone, String email, String username, String password,
			String bio) {
		this.firstname = firstname;
		this.lastname = lastname;
		this.streetaddress1 = address1;
		this.streetaddress2 = address2;
		this.city = city;
		this.state = state;
		this.zipcode = zipcode;
		this.phone = phone;
		this.email = email;
		this.username = username;
		this.password = password;
		this.bio = bio;
	}

	public String getFirstname(){
		return firstname;
	}

	public void setFirstname(String x){
		this.firstname = x;
	}

	public String getLastname(){
		return lastname;
	}

	public void setLastname(String x){
		this.lastname = x;
	}

    public String getStreetaddress1(){
    	return streetaddress1;
    }
    
    public void setStreetaddress1(String x){
    	this.streetaddress1 = x;
    }
    
    public String getStreetAddress2(){
    	return streetaddress2;
    }
    
    public void setStreetaddress2(String x){
    	this.streetaddress2 = x;
    }
    
    public String getCity(){
    	return city;
    }
    
    public void setCity(String x){
    	this.city = x;
    }
    
    public String getState(){
    	return state;
    }
    
    public void setState(String x){
    	this.state = x;
    }
    
    public String getZipcode(){
    	return zipcode;
    }
    
    public void setZipcode(String x){
    	this.zipcode = x;
    }
    
    public String getEmail(){
    	return email;
    }
    
    public void setEmail(String x){
    	this.email = x;
    }
    
    
    public String getPhone(){
    	return phone;
    }
    
    public void setPhone(String x){
    	this.phone = x;
    }
    
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getBio() {
		return bio;
	}

	public void setBio(String bio) {
		this.bio = bio;
	}


}
