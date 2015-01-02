package myPackage;



import org.apache.commons.lang3.StringUtils;
import org.apache.struts2.interceptor.SessionAware;
import org.apache.struts2.interceptor.validation.SkipValidation;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class CheckLoginAction extends ActionSupport  implements ModelDriven, SessionAware{
	
	private static final long serialVersionUID = 1L;
	private String username;
	private String password;
	
	private LoginInfo logininfo;
	
	private Statement stmt;
	private Speaker speaker;
	
	private Collection<UpcomingTalk> upcomingtalks;
	
	private ArrayList<String> listOfWholeNames;
	private ArrayList<String> listOfUsernames;
	private ArrayList<Speaker> listOfSpeakers;

	
	Map m;
	DBConnection dbconnection;

	private Collection<Topic> collectionOfTopics;

	
	public LoginInfo getLogininfo() {
		return logininfo;
	}
	public void setLogininfo(LoginInfo logininfo) {
		this.logininfo = logininfo;
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
	
	public ArrayList<Speaker> getListOfSpeakers() {
		return listOfSpeakers;
	}
	public void setListOfSpeakers(ArrayList<Speaker> listOfSpeakers) {
		this.listOfSpeakers = listOfSpeakers;
	}
	public Collection<UpcomingTalk> getUpcomingtalks() {
		return upcomingtalks;
	}
	public void setUpcomingtalks(Collection<UpcomingTalk> upcomingtalks) {
		this.upcomingtalks = upcomingtalks;
	}
	
	public ArrayList<String> getListOfWholeNames() {
		return listOfWholeNames;
	}

	public void setListOfWholeNames(ArrayList<String> listOfWholeNames) {
		this.listOfWholeNames = listOfWholeNames;
	}

	
	
	public ArrayList<String> getListOfUsernames() {
		return listOfUsernames;
	}
	public void setListOfUsernames(ArrayList<String> listOfUsernames) {
		this.listOfUsernames = listOfUsernames;
	}
	public String whoIsLoggedIn(){
		String username = (String) m.get("session_username");
		System.out.println("in whoIsLoggedIn " + username);
		if(username == null) return "customer";
		if(username.toLowerCase().equals("admin")) return "admin";
		return "speaker";
	}
	
	public String getUpcomingTalks()  throws IOException, SQLException{
		
		Statement stmt  = dbconnection.connectToDatabase();
		
		UpcomingTalkService upcomingserv = new UpcomingTalkService();
		upcomingtalks =  upcomingserv.getFromDatabase(stmt);
		
		System.out.println("in getUpcomingTalks ");
		System.out.println(upcomingtalks.iterator().next().getTopictitle());
		
		String username = (String) m.get("session_username");
		if(username == null) return "customer";
		if(username.toLowerCase().equals("admin")) return "admin";
		return "speaker";

	}
	
	public String logout(){
		m.put("session_username", null);
		m.put("session_password", null);
		return "success";
	}
	
	public String cancel(){
		System.out.println("in cancel CheckLoginAction");
		return "success";
	}
	
	public String execute() throws IOException, SQLException{
		System.out.println("in execute 6879694856845");
		
		String address;		
		Statement stmt  = dbconnection.connectToDatabase();
		
		LoginInfoService loginserv = new LoginInfoService();
		TopicService topicserv = new TopicService();
		speaker = loginserv.getUserFromDatabase(stmt, username, password);

		
		//topic = loginserv.getTopicFromDatabase(stmt, username, password);
		List<Topic> topiclist = topicserv.getTopicFromDatabase(stmt, username);
		List<Topic> topiclist2 = topicserv.getFromDatabase(stmt);
		setCollectionOfTopics(topiclist);

	
		if(speaker != null){
			m.put("session_username", username);
			m.put("session_password", password);
			String firstname = speaker.getFirstname();
			String lastname = speaker.getLastname();
			m.put("session_firstname", firstname);
			m.put("session_lastname", lastname);
			
			address = "success";
		} else {
			m.put("session_username", null);
			address = "nouserlikethat";
		}
		if(username.toLowerCase().equals("admin") && password.toLowerCase().equals("admin")){ 	
			m.put("session_username", username);
			m.put("session_password", password);
			
			SpeakerService speakerserv = new SpeakerService();
			
			Map<String, String> mapOfWholeNames = new HashMap<String,String>();
			listOfSpeakers = new ArrayList<Speaker>();
			Map<String,Speaker> list_of_speakers = speakerserv.getFromDatabase(stmt);

			for(Speaker s: list_of_speakers.values()){
				listOfSpeakers.add(s);
			}


		    mapOfWholeNames = speakerserv.getWholeNamesFromDatabase(stmt); 
		    listOfWholeNames = new ArrayList<String>(mapOfWholeNames.values());
		    listOfUsernames = new ArrayList<String>(mapOfWholeNames.keySet());
		    System.out.println("Got Speakers from database!");
			
			
			address="adminLogin";}
        return address;
	}


	@Override
	public Object getModel() {
		System.out.println("in getModel");
		logininfo = getLogininfo();
		return logininfo;
	}
	
	@Override
	public void setSession(Map m)
    {
        this.m=m;
    }


}
