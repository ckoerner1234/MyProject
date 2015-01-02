package myPackage;


//SWE632 Carolyn Koerner



import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

import org.apache.commons.lang3.StringUtils;
import org.apache.struts2.interceptor.SessionAware;
import org.apache.struts2.interceptor.validation.SkipValidation;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

import java.sql.*;


public class ProcessFacultyFormDataAction extends ActionSupport implements ModelDriven, SessionAware{

	private static final long serialVersionUID = 1L;
	private String firstname;
	private String lastname;
	private String streetaddress1;
	private String streetaddress2;
	private String city;
	private String state;
	private String zipcode;
	private String phone;
	private String email;
	private String username;
	private String password;
	private String bio;
	private String topictitle;
	private String topicsummary;
	private String topicpicture;
	private String chosenSpeaker;
	
	Map m;
	DBConnection dbconnection;

	private Speaker speaker;
	private Topic topic;
	private ListOfSpeakersBean listbean;
	
	private List<String> listOfTopics;
	private Collection<Topic> collectionOfTopics;
	private Collection<Topic> collectionOfTopicsSpeaker;
	private String[] categories;
	private Collection<Category> collectionOfCategories;

	private int numberofspeakers;
	private List<String> listOfSpeakers;
	private Collection<Speaker> collectionOfSpeakers;
	private ArrayList<String> listOfWholeNames;
	
	private Statement stmt;

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
	public String getStreetaddress1() {
		return streetaddress1;
	}
	public void setStreetaddress1(String streetaddress1) {
		this.streetaddress1 = streetaddress1;
	}
	public String getStreetaddress2() {
		return streetaddress2;
	}
	public void setStreetaddress2(String streetaddress2) {
		this.streetaddress2 = streetaddress2;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getZipcode() {
		return zipcode;
	}
	public void setZipcode(String zipcode) {
		this.zipcode = zipcode;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
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
	public String[] getCategories() {
		return categories;
	}
	public void setCategories(String[] categories) {
		this.categories = categories;
	}
	public String getBio() {
		return bio;
	}
	public void setBio(String bio) {
		this.bio = bio;
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
	public Speaker getSpeaker() {
		return speaker;
	}
	public Topic getTopic() {
		return topic;
	}
	public void setTopic(Topic topic) {
		this.topic = topic;
	}
	public void setSpeaker(Speaker speaker) {
		this.speaker = speaker;
	}
	public ListOfSpeakersBean getListbean() {
		return listbean;
	}
	public void setListbean(ListOfSpeakersBean listbean) {
		this.listbean = listbean;
	}
	public int getNumberofspeakers() {
		return numberofspeakers;
	}
	public void setNumberofspeakers(int numberofspeakers) {
		this.numberofspeakers = numberofspeakers;
	}
	public List<String> getListOfSpeakers() {
		return listOfSpeakers;
	}
	public void setListOfSpeakers(List<String> listOfSpeakers) {
		this.listOfSpeakers = listOfSpeakers;
	}
	
	public Collection<Speaker> getCollectionOfSpeakers(){
		return collectionOfSpeakers;
	}
	public void setCollectionOfSpeakers(Collection<Speaker> collectionOfSpeakers){
		this.collectionOfSpeakers = collectionOfSpeakers;
	}
	
	public List<String> getListOfTopics() {
		return listOfTopics;
	}
	public void setListOfTopics(List<String> listOfTopics) {
		this.listOfTopics = listOfTopics;
	}
	public Collection<Topic> getCollectionOfTopicsSpeaker() {
		return collectionOfTopicsSpeaker;
	}
	public void setCollectionOfTopicsSpeaker(
			Collection<Topic> collectionOfTopicsSpeaker) {
		this.collectionOfTopicsSpeaker = collectionOfTopicsSpeaker;
	}
	public Collection<Topic> getCollectionOfTopics() {
		return collectionOfTopics;
	}
	public void setCollectionOfTopics(Collection<Topic> collectionOfTopics) {
		this.collectionOfTopics = collectionOfTopics;
	}
	

	public Collection<Category> getCollectionOfCategories() {
		return collectionOfCategories;
	}
	public void setCollectionOfCategories(Collection<Category> collectionOfCategories) {
		this.collectionOfCategories = collectionOfCategories;
	}
	public ArrayList<String> getListOfWholeNames() {
		return listOfWholeNames;
	}
	public void setListOfWholeNames(ArrayList<String> listOfWholeNames) {
		this.listOfWholeNames = listOfWholeNames;
	}
	public String getChosenSpeaker() {
		return chosenSpeaker;
	}
	public void setChosenSpeaker(String chosenSpeaker) {
		this.chosenSpeaker = chosenSpeaker;
	}
	
	public String execute() throws IOException, SQLException{
		
		System.out.println("in execute ProcessFacultyFormData");
		
		m.put("session_username", username);
		m.put("session_password", password);
		m.put("session_firstname", firstname);
		m.put("session_lastname", lastname);
		
		
		Statement stmt  = dbconnection.connectToDatabase();
		
		SpeakerService speakerserv = new SpeakerService();
		TopicService topicserv = new TopicService();
		CategoryService categoryserv = new CategoryService();
		Category cat;
		collectionOfCategories = new ArrayList<Category>();

		speaker = new Speaker(firstname, lastname, streetaddress1,
				streetaddress2, city, state, zipcode, phone, email, username, password, bio);
		
		
		String tp;  
		tp = "/home/bitnami/SWE632/pictures/" + topicpicture;
		//File f = new File(topicpicture);
		File f = new File(tp);
		if(f.exists() && !f.isDirectory()) {
			System.out.println("Picture exists");
		}else{		
			System.out.println("Picture does not exist.   Get a random one.");
		       //File folder = new File("../standalone/deployments/MyProject.war");
		       File folder = new File("/home/bitnami/SWE632/pictures");
		       System.out.println("folder = " + folder);
		        File[] listOfFiles = folder.listFiles();
		        String[] listOfPictures = new String[200];
		        int index=0;
		        int partsoffilename;
		    for (File file : listOfFiles)
		    {
		        if (file.isFile())
		        {
		            String[] filename = file.getName().split("\\.(?=[^\\.]+$)"); //split filename from it's extension
		            partsoffilename=filename.length;
		            if(partsoffilename == 2){
		            	if(filename[1].equalsIgnoreCase("jpg")){
		            		//matching defined filename
		            		System.out.println("File exist: "+filename[0]+"."+filename[1]); // match occures.Apply any condition what you need
		            		listOfPictures[index] = filename[0]+"."+filename[1];
		            		System.out.println("index="+ index);
		            		index++;
		            	}
		            }
		        }
		     }
		    System.out.println("number of pictures: " + index);
		    int total = index-1;
		    Random rand = new Random();

		    // nextInt is normally exclusive of the top value,
		    // so add 1 to make it inclusive
		    System.out.println(total);
		    int randomNum = rand.nextInt(total + 1);

			topicpicture = listOfPictures[randomNum];
		    System.out.println("randomly chosen picture: " + topicpicture);
		}
	    System.out.println("picture: " + topicpicture);
		
		topic = new Topic(username, password, firstname, lastname, topictitle, topicsummary, topicpicture);
		if(categories != null){
			for(int i=0; i<categories.length; i++){
				cat = new Category(topictitle, categories[i]);
				categoryserv.saveToDatabase(cat, stmt);
				collectionOfCategories.add(cat);
			}
		}

		speakerserv.saveToDatabase(speaker, stmt);
		topicserv.saveToDatabase(topic, stmt);
		
		Map<String,Speaker> speakermap = speakerserv.getFromDatabase(stmt);
		List<Topic> topiclist = topicserv.getFromDatabase(stmt);


		listOfSpeakers = new ArrayList<String>();
		ArrayList<String> keys = new ArrayList(speakermap.keySet());
		String[] usernames = new String[50];
		for (int i = 0; i < keys.size(); i++) {
			usernames[i] = (String)keys.get(i); 
			listOfSpeakers.add(usernames[i]);
		}

		numberofspeakers = keys.size();
		listbean = new ListOfSpeakersBean(usernames, numberofspeakers);
		
				
		
		List<Speaker> list = new ArrayList<Speaker>(speakermap.values());			
		collectionOfSpeakers = speakermap.values();	
		collectionOfTopics = topiclist;
		collectionOfTopicsSpeaker = topicserv.getTopicFromDatabase(stmt, username);
		//added this
		collectionOfTopics = collectionOfTopicsSpeaker;


		return "success";  
	}
	
	@SkipValidation
	public String listTalks() {
		
		
		return "success";
	}
	
	@SkipValidation
	public String findAPerson()  throws IOException{
		
		try{
			Statement stmt  = dbconnection.connectToDatabase();
			SpeakerService speakerserv = new SpeakerService();
			Map<String,Speaker> speakermap = speakerserv.getFromDatabase(stmt); 
			List<Speaker> list = new ArrayList<Speaker>(speakermap.values());			
			collectionOfSpeakers = speakermap.values();			
			return "success";
		} catch (SQLException e) {
			System.out.println("Cannot connect the database!");
			return "error";
		} 

	}
	
	@SkipValidation
	public String listSpeakers()  throws IOException{
		
		try{
			Statement stmt  = dbconnection.connectToDatabase();
			SpeakerService speakerserv = new SpeakerService();
			Map<String,Speaker> speakermap = speakerserv.getFromDatabase(stmt); 
			System.out.println("Got Speakers from database!");
			List<Speaker> list = new ArrayList<Speaker>(speakermap.values());
			collectionOfSpeakers = speakermap.values();			
			return "success";
		} catch (SQLException e) {
			System.out.println("Cannot connect the database!");
			return "error";
		} 
					
	}

	@SkipValidation
	public String listWholeNamesOfSpeakers()  throws IOException{
				
		try{
			Statement stmt  = dbconnection.connectToDatabase();
			SpeakerService speakerserv = new SpeakerService();
			Map<String, String> mapOfWholeNames = new HashMap<String,String>();
			mapOfWholeNames = speakerserv.getWholeNamesFromDatabase(stmt); 
			listOfWholeNames = new ArrayList<String>(mapOfWholeNames.values());
			System.out.println("Got Speakers from database!");
			return "success";
		} catch (SQLException e) {
			System.out.println("Cannot connect the database!");
			return "error";
		} 
					
	}	
	
	
	
	public void validate(){
		System.out.println("in validate");
		if(StringUtils.isEmpty(getFirstname())){
			System.out.println("first name is blank");
			addFieldError("firstname","First Name cannot be blank");
		}
		if(StringUtils.isEmpty(getLastname())){
			addFieldError("lastname","Last Name cannot be blank");
			System.out.println("last name is blank");
		}
		if(StringUtils.isEmpty(getUsername())){
			System.out.println("user name is blank");
			addFieldError("username","Username cannot be blank");
		}
		if(StringUtils.isEmpty(getStreetaddress1())){
			addFieldError("streetaddress1","Street Address cannot be blank");
		}
		if(StringUtils.isEmpty(getCity())){
			addFieldError("city","City cannot be blank");
		}
		if(StringUtils.isEmpty(getState())){
			addFieldError("state","State cannot be blank");
		}
		if(StringUtils.isEmpty(getZipcode())){
			addFieldError("zipcode","Zip Code cannot be blank");
		}
		if(StringUtils.isEmpty(getPhone())){
			addFieldError("phone","Phone cannot be blank");
		}
		if(StringUtils.isEmpty(getEmail())){
			addFieldError("email","Email cannot be blank");
		}
		 String emailString = getEmail();
		   int atpos = emailString.indexOf("@");
		   int dotpos = emailString.lastIndexOf(".");
		   if (atpos < 1 || dotpos < atpos+2 || dotpos+2 >= emailString.length())
		   {      
				System.out.println("not a valid email **************");
		      addFieldError("email","Not a valid email");
		   }
		   if(getCategories() == null){
			   addFieldError("checkbox","Please check at least one category");
		   }
		   firstname = getFirstname();
		   lastname = getLastname();
		   streetaddress1 = getStreetaddress1();
		   streetaddress2 = getStreetaddress2();
		   city = getCity();
		   state = getState();
		   zipcode = getZipcode();
		   phone = getPhone();
		   email = getEmail();
		   username = getUsername();
		   password = getPassword();
		   bio = getBio();
		   topictitle = getTopictitle();
		   topicsummary = getTopicsummary();
		   topicpicture = getTopicpicture();
		   
	}


	@Override
	public Object getModel() {
		System.out.println("in getModel");
		speaker = getSpeaker();
		return speaker;
	}
	
	public void setSession(Map m)
    {
        this.m=m;
    }
 

}

