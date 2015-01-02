package myPackage;
//SWE632 Carolyn Koerner


import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.*;
import javax.servlet.http.*;

import org.apache.commons.lang3.StringUtils;
import org.apache.struts2.interceptor.SessionAware;
import org.apache.struts2.interceptor.validation.SkipValidation;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.opensymphony.xwork2.Preparable;

import java.sql.*;



public class ProcessEditFormDataAction extends ActionSupport 
	implements ModelDriven<Collection<Topic>>, Preparable, SessionAware{
	
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

	private Speaker speaker;
	private List<Topic> listOfTopics;
	private Collection<Topic> collectionOfTopics;
	private Collection<Topic> collectionOfTopicsSpeaker;
	private Map<Integer,Boolean> list_of_deleted_talks;
	
	private String[] categories;
	private Collection<Category> collectionOfCategories;


	private Statement stmt;
	
	Map m;
	DBConnection dbconnection;

	
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
	public String getBio() {
		return bio;
	}
	public void setBio(String bio) {
		this.bio = bio;
	}
	public Speaker getSpeaker() {
		return speaker;
	}
	public void setSpeaker(Speaker speaker) {
		this.speaker = speaker;
	}
	
	public Collection<Topic> getCollectionOfTopics() {
		return collectionOfTopics;
	}
	public void setCollectionOfTopics(Collection<Topic> collectionOfTopics) {
		this.collectionOfTopics = collectionOfTopics;
	}
	
	public Collection<Topic> getCollectionOfTopicsSpeaker() {
		return collectionOfTopicsSpeaker;
	}
	public void setCollectionOfTopicsSpeaker(
			Collection<Topic> collectionOfTopicsSpeaker) {
		this.collectionOfTopicsSpeaker = collectionOfTopicsSpeaker;
	}
	public Map<Integer, Boolean> getList_of_deleted_talks() {
		return list_of_deleted_talks;
	}
	public void setList_of_deleted_talks(Map<Integer, Boolean> list_of_deleted_talks) {
		this.list_of_deleted_talks = list_of_deleted_talks;
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
	
	public List<Topic> getListOfTopics() {
		return listOfTopics;
	}
	public void setListOfTopics(List<Topic> listOfTopics) {
		this.listOfTopics = listOfTopics;
	}
	public String[] getCategories() {
		return categories;
	}
	public void setCategories(String[] categories) {
		this.categories = categories;
	}
	public Collection<Category> getCollectionOfCategories() {
		return collectionOfCategories;
	}
	public void setCollectionOfCategories(
			Collection<Category> collectionOfCategories) {
		this.collectionOfCategories = collectionOfCategories;
	}	
	
		
	public String execute() throws IOException, SQLException{
		
		m.put("session_username", username);
		m.put("session_password", password);
		m.put("session_firstname", firstname);
		m.put("session_lastname", lastname);

		Statement stmt  = dbconnection.connectToDatabase();
		System.out.println("in execute ProcessEditFormDataAction");
				
		SpeakerService speakerserv = new SpeakerService();
		TopicService topicserv = new TopicService();

		speaker = new Speaker(firstname, lastname, streetaddress1,
				streetaddress2, city, state, zipcode, phone, email, username, password, bio);

		speakerserv.editAndSaveToDatabase(speaker, username, stmt);
		topicserv.editAndSaveToDatabase(collectionOfTopics, username, stmt);
		
		delete(stmt);

		
		List<Topic> topiclist = topicserv.getFromDatabase(stmt);		
				
		collectionOfTopics = topiclist;
		collectionOfTopicsSpeaker = topicserv.getTopicFromDatabase(stmt, username);
		
		//added this
		collectionOfTopics = collectionOfTopicsSpeaker;		

		return "success";  
	}
	
	@SkipValidation
	public String addATalk() throws IOException, SQLException{		
		
		Statement stmt  = dbconnection.connectToDatabase();	
		System.out.println("in processEditFormDataAction addATalk");
		System.out.println("username: " + username);
		
		SpeakerService speakerserv = new SpeakerService();
		speaker = speakerserv.getSpeakerFromDatabase(stmt,  username) ;
		
		
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
		
		
		TopicService topicserv = new TopicService();
		Topic topic = new Topic(username, password, firstname, lastname, topictitle, topicsummary, topicpicture);
		topicserv.saveToDatabase(topic, stmt);
		CategoryService categoryserv = new CategoryService();
		Category cat;
		collectionOfCategories = new ArrayList<Category>();
		if(categories == null){ 
			categories = new String[1];
		    categories[0]="None";	
		}
		
		for(int i=0; i<categories.length; i++){
			cat = new Category(topictitle, categories[i]);
			categoryserv.saveToDatabase(cat, stmt);
			collectionOfCategories.add(cat);
		}
		
		List<Topic> topiclist = topicserv.getTopicFromDatabase(stmt, username);		
		
		collectionOfTopics = topiclist;
		collectionOfTopicsSpeaker = topicserv.getTopicFromDatabase(stmt, username);
		
		//added this
		collectionOfTopics = collectionOfTopicsSpeaker;

		
		return "success";  


	}

	@SkipValidation
	public String addATalkAdmin() throws IOException, SQLException{
		
		
		Statement stmt  = dbconnection.connectToDatabase();		
		System.out.println("in processEditFormDataAction addATalk");
		System.out.println("username: " + username);
	
		SpeakerService speakerserv = new SpeakerService();
		speaker = speakerserv.getSpeakerFromDatabase(stmt,  username) ;
		password = speaker.getPassword();
		firstname = speaker.getFirstname();
		lastname = speaker.getLastname();
		
		
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

		TopicService topicserv = new TopicService();
		Topic topic = new Topic(username, 
				password, 
				firstname, 
				lastname, 
				topictitle, 
				topicsummary, 
				topicpicture);
		topicserv.saveToDatabase(topic, stmt);
		CategoryService categoryserv = new CategoryService();
		Category cat;
		collectionOfCategories = new ArrayList<Category>();
		
		if(categories != null){
		for(int i=0; i<categories.length; i++){
			cat = new Category(topictitle, categories[i]);
			categoryserv.saveToDatabase(cat, stmt);
			collectionOfCategories.add(cat);
		}
		}
		
		List<Topic> topiclist = topicserv.getTopicFromDatabase(stmt, username);		
		
		collectionOfTopics = topiclist;
		collectionOfTopicsSpeaker = topicserv.getTopicFromDatabase(stmt, username);
		
		//added this
		collectionOfTopics = collectionOfTopicsSpeaker;

		
		return "success";  


	}
	
	
	@SkipValidation
	private void delete(Statement stmt) throws IOException, SQLException{
		
		System.out.println("in delete");
		
		Map<String,Topic> deleted_topic_map = new HashMap<String,Topic>();
		List<Integer> keys = new ArrayList<Integer>(list_of_deleted_talks.keySet());
		System.out.println("number of keys:  " + keys.size());
		for(int i=0; i<keys.size(); i++){
			System.out.println(list_of_deleted_talks.get(i));
		}
		boolean temp;
		Topic temp_topic;
		List<Topic> kept_topics = new ArrayList<Topic>();
		
		Map<Integer,Topic> topicmap = new HashMap<Integer,Topic>();
		Integer i = 0;
		for (Topic topic : collectionOfTopics) {
		//for (Topic topic : collectionOfTopicsSpeaker) {
			topicmap.put(i, topic);
			i=i+1;
		}

		for (Integer key: keys) {
		    temp = list_of_deleted_talks.get(key);			
		    System.out.println(key + ": " + temp);
		    if(temp == true) {
			    temp_topic = topicmap.get(key);
			    System.out.println("deleted topic : " + temp_topic.topictitle);
		    	deleted_topic_map.put(temp_topic.topictitle, temp_topic);
		    }
		    if(temp == false){
		    	temp_topic = topicmap.get(key);
		    	kept_topics.add(temp_topic);
		    }
		}
		
		TopicService topicserv = new TopicService();
		int number = deleted_topic_map.size();
		if(number > 0) topicserv.deleteFromDatabase(deleted_topic_map, stmt);
		collectionOfTopics = topicserv.getFromDatabase(stmt);		
		collectionOfTopicsSpeaker = topicserv.getTopicFromDatabase(stmt, username);
		
	}
	
	@SkipValidation
	public String findAPerson() throws IOException, SQLException{
		
		
		username = (String) getSession().get("session_username");
		if(username.equals(null)) return "notloggedin";
		
		Statement stmt  = dbconnection.connectToDatabase(); 
		SpeakerService speakerserv = new SpeakerService();
		TopicService topicserv = new TopicService();

		listOfTopics =  topicserv.getTopicFromDatabase(stmt, username);
		speaker = speakerserv.getSpeakerFromDatabase(stmt,  username) ;
		collectionOfTopics = listOfTopics;
		collectionOfTopicsSpeaker = topicserv.getTopicFromDatabase(stmt, username);
		
		//added this
		collectionOfTopics = collectionOfTopicsSpeaker;
		
		return "success";
		
	}
	
	public String goToAddATalk(){
		return "success";
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
	public Collection<Topic> getModel() {
		System.out.println("in getModel");
		
		return collectionOfTopics;
	}
	
	public void  prepare() {
	    collectionOfTopics = new ArrayList<Topic>();
		collectionOfTopicsSpeaker = new ArrayList<Topic>();
	    //listOfTopics.add(new Topic());
	}
	
	public void setSession(Map m)
    {
        this.m=m;
    }
	public Map getSession()
    {
        return m;
    }



}


