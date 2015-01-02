package myPackage;

import java.io.File;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Set;

public class TopicService {
	
	public void saveToDatabase(Topic topic,  Statement stmt) 
			throws IOException, SQLException{

		System.out.println("INSERT INTO Topics (username, password, firstname, lastname, topictitle, topicsummary, topicpicture)  " +
				"VALUES ('" + topic.username + "', '" + topic.password + "', '" + 
				topic.firstname + "', '" + topic.lastname + "', '" +
				topic.topictitle + "', '" + topic.topicsummary + "', '" + topic.topicpicture + "')");
		
		stmt.executeUpdate ("INSERT INTO Topics (username, password, firstname, lastname, topictitle, topicsummary, topicpicture)  " +
				"VALUES ('" + topic.username + "', '" + topic.password + "', '" + 
				topic.firstname + "', '" + topic.lastname + "', '" +
				topic.topictitle + "', '" + topic.topicsummary + "', '" + topic.topicpicture +  "')");
	}
	
	public void editAndSaveToDatabase(Collection<Topic> topics, String username, Statement stmt) 
			throws IOException, SQLException{
		
		stmt.executeUpdate ("DELETE FROM Topics WHERE username='" + username + "'");
		
		String tp;  
		for (Topic topic : topics) {
			tp = "/home/bitnami/SWE632/pictures/" + topic.topicpicture;
			File f = new File(tp);
			if(f.exists() && !f.isDirectory()) {
				System.out.println("Picture exists");
			}else{		
				System.out.println("Picture does not exist.   Get a random one.");
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

				topic.topicpicture = listOfPictures[randomNum];
			    System.out.println("randomly chosen picture: " + topic.topicpicture);
			}
			
			
		    System.out.println("picture: " + topic.topicpicture);
			
			
			System.out.println("first name last name " + topic.firstname + "  " + topic.lastname);
			stmt.executeUpdate ("INSERT INTO Topics (username, password, firstname, lastname, topictitle, topicsummary, topicpicture)  " +
					"VALUES ('" + topic.username + "', '" + topic.password + "', '" + 
					topic.firstname + "', '" + topic.lastname + "', '" +
					topic.topictitle + "', '" + topic.topicsummary + "', '" + topic.topicpicture +  "')");

	    }
	
		
	}
	
	
/*	
	public Map<String,Topic> getFromDatabase(Statement stmt) 
			throws IOException, SQLException{

		Map<String,Topic> topicmap = new HashMap<String,Topic>();
		
		
		String query = "SELECT username, password, topictitle, topicsummary FROM Topics";
		ResultSet rs = stmt.executeQuery (query);
		while (rs.next()) {
			
			Topic topicbean = new Topic();

			topicbean.setUsername(rs.getString ("username"));
			topicbean.setPassword(rs.getString ("password"));
			topicbean.setTopictitle(rs.getString ("topictitle"));
			topicbean.setTopicsummary(rs.getString ("topicsummary"));
			

			topicmap.put(rs.getString ("username"), topicbean);
		}
		return topicmap;
	}
	
	public Map<String,Topic> getTopicFromDatabase(Statement stmt, String username) 
			throws IOException, SQLException{

		Map<String,Topic> topicmap = new HashMap<String,Topic>();

		String query = "SELECT username, password, topictitle, topicsummary FROM Topics WHERE username ='" + username +"'";

		ResultSet rs = stmt.executeQuery (query);
		
		if(rs.next()){
		
			Topic topicbean = new Topic();

			topicbean.setUsername(rs.getString ("username"));
			topicbean.setPassword(rs.getString ("password"));
			topicbean.setTopictitle(rs.getString ("topictitle"));
			topicbean.setTopicsummary(rs.getString ("topicsummary"));

			topicmap.put(rs.getString ("username"), topicbean);
		}
		return topicmap;
	}
*/	
	
	public List<Topic> getFromDatabase(Statement stmt) 
			throws IOException, SQLException{

		List<Topic> topiclist = new ArrayList<Topic>();
		
		
		String query = "SELECT username, password, firstname, lastname, topictitle, topicsummary, topicpicture FROM Topics";
		ResultSet rs = stmt.executeQuery (query);
		while (rs.next()) {
			
			Topic topicbean = new Topic();

			topicbean.setUsername(rs.getString ("username"));
			topicbean.setPassword(rs.getString ("password"));
			topicbean.setFirstname(rs.getString ("firstname"));
			topicbean.setLastname(rs.getString ("lastname"));
			topicbean.setTopictitle(rs.getString ("topictitle"));
			topicbean.setTopicsummary(rs.getString ("topicsummary"));
			topicbean.setTopicpicture(rs.getString ("topicpicture"));
/*			
			System.out.println("1111111111111111111111111");
			System.out.println("in getFromDatabase in TopicService");
			System.out.println("username = " + topicbean.username);
			System.out.println("topictitle = " + topicbean.topictitle);
			System.out.println("topicsummary = " + topicbean.topicsummary);
			System.out.println("*************************");
*/
			topiclist.add(topicbean);
		}
		return topiclist;
	}	
	
	public String getTopicSummaryFromDatabase(Statement stmt, String topictitle) 
			throws IOException, SQLException{

		String query = "SELECT topicsummary FROM Topics WHERE topictitle ='" + topictitle +"'";

		ResultSet rs = stmt.executeQuery (query);
		while(rs.next()){
			return rs.getString("topicsummary");
		}
		return "no summary";
	}
	
	public String getUsernameFromDatabase(Statement stmt, String topictitle) 
			throws IOException, SQLException{

		String query = "SELECT username FROM Topics WHERE topictitle ='" + topictitle +"'";

		ResultSet rs = stmt.executeQuery (query);
		while(rs.next()){
			return rs.getString("username");
		}
		return "no username";
	}	
	
	public List<Topic> getTopicFromDatabase(Statement stmt, String username) 
			throws IOException, SQLException{

		List<Topic> topiclist = new ArrayList<Topic>();

		String query = "SELECT username, password, firstname, lastname, topictitle, topicsummary, topicpicture FROM Topics WHERE username ='" + username +"'";

		ResultSet rs = stmt.executeQuery (query);
		
		while(rs.next()){
		
			Topic topicbean = new Topic();

			topicbean.setUsername(rs.getString ("username"));
			topicbean.setPassword(rs.getString ("password"));
			topicbean.setFirstname(rs.getString ("firstname"));
			topicbean.setLastname(rs.getString ("lastname"));
			topicbean.setTopictitle(rs.getString ("topictitle"));
			topicbean.setTopicsummary(rs.getString ("topicsummary"));
			topicbean.setTopicpicture(rs.getString ("topicpicture"));
/*
			System.out.println("22222222222222222222222222");
			System.out.println("in getTopicFromDatabase in TopicService");
			System.out.println("username = " + topicbean.username);
			System.out.println("topictitle = " + topicbean.topictitle);
			System.out.println("topicsummary = " + topicbean.topicsummary);
			System.out.println("*************************");
*/			
			topiclist.add(topicbean);
		}
		return topiclist;
	}
	
	public List<Topic> searchDatabase(Statement stmt, String mysearchstring) 
			throws IOException, SQLException{
		
		List<Topic> topiclist = new ArrayList<Topic>();
		String query = "SELECT username, password, firstname, lastname, topictitle, topicsummary, topicpicture FROM Topics WHERE topicsummary like '" + mysearchstring +"'";

		ResultSet rs = stmt.executeQuery (query);
		
		while(rs.next()){
		
			Topic topicbean = new Topic();

			topicbean.setUsername(rs.getString ("username"));
			topicbean.setPassword(rs.getString ("password"));
			topicbean.setFirstname(rs.getString ("firstname"));
			topicbean.setLastname(rs.getString ("lastname"));
			topicbean.setTopictitle(rs.getString ("topictitle"));
			topicbean.setTopicsummary(rs.getString ("topicsummary"));
			topicbean.setTopicpicture(rs.getString ("topicpicture"));
			
			topiclist.add(topicbean);
		}		
		
		return topiclist;
	}
	
	
	public void deleteFromDatabase(Map<String,Topic> deleted_topic_map,Statement stmt) throws SQLException{
		System.out.println("in deleteFromDatabase()");
		Set<String> list_of_titles = deleted_topic_map.keySet();
		for(String title : list_of_titles){
			String query = "DELETE FROM Topics WHERE topictitle ='" + title +"'";
			stmt.execute(query);
			System.out.println("deleted Topic : " + deleted_topic_map.get(title).topictitle);
		}
		
	}

	

}
