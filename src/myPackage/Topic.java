package myPackage;

public class Topic {
	
	 String username;
	 String password;
	 String firstname;
	 String lastname;
	 String topictitle;
	 String topicsummary;
	 String topicpicture;
	 
	 public Topic(){
		 
	 }
	
	public Topic (String username, String password, String firstname, String lastname, 
			String topictitle, String topicsummary, String topicpicture){
		this.username=username;
		this.password=password;
		this.firstname=firstname;
		this.lastname=lastname;
		this.topictitle=topictitle;
		this.topicsummary=topicsummary;
		this.topicpicture=topicpicture;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getTopictitle() {
		return topictitle;
	}

	public void setTopictitle(String topictitle) {
		this.topictitle = topictitle;
	}

	public String getTopicsummary() {
		return topicsummary;
	}

	public void setTopicsummary(String topicsummary) {
		this.topicsummary = topicsummary;
	}

	public String getTopicpicture() {
		return topicpicture;
	}

	public void setTopicpicture(String topicpicture) {
		this.topicpicture = topicpicture;
	}
	
	

}
