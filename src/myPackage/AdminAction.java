package myPackage;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class AdminAction extends ActionSupport  implements SessionAware{

	private ArrayList<String> listOfWholeNames;
	private ArrayList<String> listOfUsernames;
	private Map<String, String> mapOfWholeNames;

	private String chosenSpeaker;
	
	
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
	private String comment;
	
	private String topictitle;
	private String topicsummary;
	private String topicpicture;

	private Speaker speaker;
	private List<Topic> listOfTopics;
	private Collection<Topic> collectionOfTopics;
	private Collection<Topic> collectionOfTopicsSpeaker;
	private ArrayList<Speaker> listOfSpeakers;
	private ArrayList<String> listOfComments;
	private ArrayList<String> listOfUpcomingTalks;
	//private ArrayList<String> listOfPublish;
	private ArrayList<String> listOfDeletedComments;
	private ArrayList<String> listOfDeletedUpcomingTalks;
	private Map<Integer,Boolean> list_of_deleted_talks;
	private Collection<UpcomingTalk> upcomingtalks;
	private String[] categories;
	private Collection<Category> collectionOfCategories;

	Map m;
	DBConnection dbconnection;

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

	public ArrayList<String> getListOfComments() {
		return listOfComments;
	}

	public void setListOfComments(ArrayList<String> listOfComments) {
		this.listOfComments = listOfComments;
	}

	public ArrayList<String> getListOfUpcomingTalks() {
		return listOfUpcomingTalks;
	}

	public void setListOfUpcomingTalks(ArrayList<String> listOfUpcomingTalks) {
		this.listOfUpcomingTalks = listOfUpcomingTalks;
	}

	public ArrayList<String> getListOfDeletedComments() {
		return listOfDeletedComments;
	}

	public void setListOfDeletedComments(ArrayList<String> listOfDeletedComments) {
		this.listOfDeletedComments = listOfDeletedComments;
	}
	public ArrayList<String> getListOfDeletedUpcomingTalks() {
		return listOfDeletedUpcomingTalks;
	}

	public void setListOfDeletedUpcomingTalks(
			ArrayList<String> listOfDeletedUpcomingTalks) {
		this.listOfDeletedUpcomingTalks = listOfDeletedUpcomingTalks;
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

	public Collection<UpcomingTalk> getUpcomingtalks() {
		return upcomingtalks;
	}

	public void setUpcomingtalks(Collection<UpcomingTalk> upcomingtalks) {
		this.upcomingtalks = upcomingtalks;
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

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public Speaker getSpeaker() {
		return speaker;
	}

	public void setSpeaker(Speaker speaker) {
		this.speaker = speaker;
	}

	public List<Topic> getListOfTopics() {
		return listOfTopics;
	}

	public void setListOfTopics(List<Topic> listOfTopics) {
		this.listOfTopics = listOfTopics;
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

	public ArrayList<Speaker> getListOfSpeakers() {
		return listOfSpeakers;
	}

	public void setListOfSpeakers(ArrayList<Speaker> listOfSpeakers) {
		this.listOfSpeakers = listOfSpeakers;
	}

	public Map<Integer, Boolean> getList_of_deleted_talks() {
		return list_of_deleted_talks;
	}

	public void setList_of_deleted_talks(Map<Integer, Boolean> list_of_deleted_talks) {
		this.list_of_deleted_talks = list_of_deleted_talks;
	}

	public Map<String, String> getMapOfWholeNames() {
		return mapOfWholeNames;
	}

	public void setMapOfWholeNames(Map<String, String> mapOfWholeNames) {
		this.mapOfWholeNames = mapOfWholeNames;
	}

	public String getChosenSpeaker() {
		return chosenSpeaker;
	}

	public void setChosenSpeaker(String chosenSpeaker) {
		this.chosenSpeaker = chosenSpeaker;
	}

	public AdminAction(){
	   
   }

	public AdminAction(ArrayList<String> listOfWholeNames) {
		super();
		this.listOfWholeNames = listOfWholeNames;
	}	

	public String execute() throws SQLException, IOException{
		
		System.out.println("in execute");
		
		String address;	
		Statement stmt  = dbconnection.connectToDatabase();
		SpeakerService speakerserv = new SpeakerService();
		Map<String,Speaker> list_of_speakers = speakerserv.getFromDatabase(stmt);

		for(Speaker s: list_of_speakers.values()){
			listOfSpeakers.add(s);
		}
		
		
		Map<String, String> mapOfWholeNames = new HashMap<String,String>();

	    mapOfWholeNames = speakerserv.getWholeNamesFromDatabase(stmt); 
	    listOfWholeNames = new ArrayList<String>(mapOfWholeNames.values());
	    listOfUsernames = new ArrayList<String>(mapOfWholeNames.keySet());
	    int number = listOfUsernames.size();
	    for(int i=0; i<number; i++){
	    	System.out.println(listOfUsernames.get(i));
	    }
	    System.out.println("Got Speakers from database!");
		
		return "success";
	}
	
	public String justGoToAddATalk(){
		return "success";
	}
	
	public String adminlogin() throws  SQLException, IOException{
				
		Statement stmt  = dbconnection.connectToDatabase();

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
	    
	    return "success";
		
	}	
	
	public String processFeedback() throws  SQLException, IOException{
		

		Statement stmt  = dbconnection.connectToDatabase();
		String publish = "false";
		stmt.executeUpdate ("INSERT INTO Feedback (publish, comment)  " + 
		"VALUES ('" + publish + "', '" + comment +  "')");		

	    return "success";
		
	}
	
	public String viewFeedback() throws  SQLException, IOException{
		
		Statement stmt  = dbconnection.connectToDatabase();
		listOfComments = new ArrayList<String>();
		//listOfPublish = new ArrayList<String>();
		
				
		String query = "SELECT publish, comment FROM Feedback";
		ResultSet rs = stmt.executeQuery (query);
		while (rs.next()) {		
			listOfComments.add(rs.getString("comment"));
			//listOfPublish.add(rs.getString("publish"));
		}		
	    
	    return "success";
		
	}
	
	
	public String deleteSpeaker() throws SQLException, IOException{
		System.out.println(" ******************* in deleteSpeaker *********************");
		username = (String) getSession().get("session_admin_chosen_speaker");
		Statement stmt  = dbconnection.connectToDatabase();

		SpeakerService speakerserv = new SpeakerService();
		System.out.println("username = " + username);
		speakerserv.deleteFromDatabase(stmt, username);
		
		listOfSpeakers = new ArrayList<Speaker>();
		Map<String, String> mapOfWholeNames = new HashMap<String,String>();
		Map<String,Speaker> list_of_speakers = speakerserv.getFromDatabase(stmt);

		for(Speaker s: list_of_speakers.values()){
			listOfSpeakers.add(s);
		}

	    mapOfWholeNames = speakerserv.getWholeNamesFromDatabase(stmt); 
	    listOfWholeNames = new ArrayList<String>(mapOfWholeNames.values());
	    listOfUsernames = new ArrayList<String>(mapOfWholeNames.keySet());

		
		
		return "success";
	}
	
	public String getAllUpcomingTalks() throws SQLException, IOException{

		Statement stmt  = dbconnection.connectToDatabase();
		listOfUpcomingTalks = new ArrayList<String>();
		
		UpcomingTalkService upcomingserv = new UpcomingTalkService();
		upcomingtalks =  upcomingserv.getFromDatabase(stmt);
		for(UpcomingTalk u : upcomingtalks){
			System.out.println(u.getTopictitle());
			listOfUpcomingTalks.add(u.getTopictitle());
		}
		
		System.out.println("at end of getAllUpcomingTalks");
		
		return "success";
	}
	
	
	public String editUpcomingTalks() throws SQLException, IOException{
		Statement stmt  = dbconnection.connectToDatabase();
	
		UpcomingTalkService upcomingserv = new UpcomingTalkService();
	
		return "success";
	}	
	
	public String editFeedback() throws  SQLException, IOException{
		
		System.out.println(" ************  in editFeedback");
		
		int number=listOfComments.size();
		for (int i=0; i<number; i++) {
			System.out.println(listOfComments.get(i));
			System.out.println(listOfDeletedComments.get(i));
		}
	
		Statement stmt  = dbconnection.connectToDatabase();

		String publish = "true";
		String query = "DELETE FROM Feedback";
		String del = "false";
		stmt.execute(query);
		int index=0;
		for (String comment : listOfComments) {
			//publish = listOfPublish.get(index);
			del = listOfDeletedComments.get(index);
			System.out.println("comment: " + comment + " deleted ?  " + del);
			if(del.equals("false")) {
				stmt.executeUpdate ("INSERT INTO Feedback (publish, comment)  " +
					"VALUES ('" + publish + "', '" + comment +  "')");
				System.out.println("keeping " + comment);
				System.out.println(" ");
				}
			index++;
	    }
		
		listOfComments = new ArrayList<String>();
		query = "SELECT publish, comment FROM Feedback";
		ResultSet rs = stmt.executeQuery (query);
		while (rs.next()) {		
			listOfComments.add(rs.getString("comment"));
			//listOfPublish.add(rs.getString("publish"));
		}		

	    return "success";
		
	}
	
	
	public String processEdits() throws SQLException, IOException{
		
		Statement stmt  = dbconnection.connectToDatabase();				
		SpeakerService speakerserv = new SpeakerService();
		TopicService topicserv = new TopicService();
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

		speaker = new Speaker(firstname, lastname, streetaddress1,
				streetaddress2, city, state, zipcode, phone, email, username, password, bio);
		
		System.out.println("in AdminAction processEdits");
		System.out.println("firstname: " + firstname);
		System.out.println("lastname: " + lastname);
		System.out.println("username: " + username);
		System.out.println("bio: " + bio);

		

		speakerserv.editAndSaveToDatabase(speaker, username, stmt);
		topicserv.editAndSaveToDatabase(collectionOfTopics, username, stmt);
		//topicserv.editAndSaveToDatabase(collectionOfTopicsSpeaker, username, stmt);
		
		delete(stmt);

		
		List<Topic> topiclist = topicserv.getFromDatabase(stmt);		
				
		collectionOfTopics = topiclist;
		collectionOfTopicsSpeaker = topicserv.getTopicFromDatabase(stmt, username);
		//added this
		collectionOfTopics = collectionOfTopicsSpeaker;
		
		return "success";
	}
	
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
	
	public String searchForSpeaker() throws SQLException, IOException{
		System.out.println("chosen speaker: " + chosenSpeaker);
		username=chosenSpeaker;
		
		m.put("session_admin_chosen_speaker", username);
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
	
	public void setSession(Map m)
    {
        this.m=m;
    }
	
	public Map getSession()
    {
        return m;
    }


 
}
