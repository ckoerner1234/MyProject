package myPackage;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LoginInfoService {


	public Speaker getUserFromDatabase(Statement stmt, String username, String password) 
				throws IOException, SQLException{

		Speaker sbean = new Speaker();

		String query = "SELECT firstname, lastname, address1, address2, " +
				"city, state, zipcode, phone, email, username, password, bio FROM SpeakerInfo WHERE username ='" + username +"' AND password ='" + password + "'";                
		
		
		ResultSet rs = stmt.executeQuery (query);
		
		if(rs.next()){
		

			sbean.setFirstname(rs.getString ("firstname"));
			sbean.setLastname(rs.getString ("lastname"));
			sbean.setStreetaddress1(rs.getString ("address1"));
			sbean.setStreetaddress2(rs.getString ("address2"));			
			sbean.setCity(rs.getString ("city"));
			sbean.setState(rs.getString ("state"));
			sbean.setZipcode(rs.getString ("zipcode"));
			sbean.setPhone(rs.getString ("phone"));			
			sbean.setEmail(rs.getString ("email"));
			sbean.setUsername(rs.getString ("username"));
			sbean.setPassword(rs.getString ("password"));
			sbean.setBio(rs.getString ("bio"));
			return sbean;

		}
		else return null;
	}

	public List<Topic> getTopicFromDatabase(Statement stmt, String username, String password) 
			throws IOException, SQLException{

	List<Topic> topiclist = new ArrayList<Topic>();

	String query = "SELECT username, password, topictitle, topicsummary FROM Topics WHERE username ='" + username +"' AND password ='" + password + "'";                
	
	
	ResultSet rs = stmt.executeQuery (query);
	
	while(rs.next()){
	
		Topic topicbean = new Topic();

		topicbean.setUsername(rs.getString ("username"));
		topicbean.setPassword(rs.getString ("password"));
		topicbean.setTopictitle(rs.getString ("topictitle"));
		topicbean.setTopicsummary(rs.getString ("topicsummary"));
		topiclist.add(topicbean);

	}
	return topiclist;
}
	
	public List<Topic> getTopicFromDatabase(Statement stmt, String username) 
			throws IOException, SQLException{

		List<Topic> topiclist = new ArrayList<Topic>();

		String query = "SELECT username, password, topictitle, topicsummary FROM Topics WHERE username ='" + username +"'";

		ResultSet rs = stmt.executeQuery (query);
		
		while(rs.next()){
		
			Topic topicbean = new Topic();

			topicbean.setUsername(rs.getString ("username"));
			topicbean.setPassword(rs.getString ("password"));
			topicbean.setTopictitle(rs.getString ("topictitle"));
			topicbean.setTopicsummary(rs.getString ("topicsummary"));
			topiclist.add(topicbean);

		}
		return topiclist;
	}


	
}
