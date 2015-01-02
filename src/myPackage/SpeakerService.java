package myPackage;

//  SWE645 Carolyn Koerner

import java.io.*;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import com.sun.xml.internal.bind.v2.schemagen.xmlschema.List;

public class SpeakerService {

	public void saveToDatabase(Speaker speaker,  Statement stmt) 
			throws IOException, SQLException{

		//String query = "CREATE TABLE IF NOT EXISTS SpeakerInfo (firstname VARCHAR(20), lastname VARCHAR(20), 
		// address1 VARCHAR(20), address2 VARCHAR(20), city VARCHAR(20), state VARCHAR(20), zipcode VARCHAR(20), 
		// phone VARCHAR(20), email VARCHAR(20), username VARCHAR(20), password VARCHAR(20), bio VARCHAR(1000),
		// topicsummary VARCHAR(1000), PRIMARY KEY(username));";

		//stmt.execute (query);
		
/*		
		String query =  "INSERT INTO SpeakerInfo (firstname, lastname, address1, address2, city, state, zipcode, phone, email, username, password, bio, topicsummary)  " +
				"VALUES (" + speaker.firstname + ", " + speaker.lastname + ", " + 
				speaker.streetaddress1 + ", " + speaker.streetaddress2 + ", " +
				speaker.city + ", " + speaker.state + ", " + speaker.zipcode + ", " + speaker.phone + ", " +
				speaker.email +  ", " + speaker.username + ", " + speaker.password + ", " +
				speaker.bio  + ", " + speaker.topicsummary  +  ")";

		stmt.executeUpdate ("INSERT INTO SpeakerInfo (firstname, lastname, address1, address2, city, state, zipcode, phone, email, username, password, bio, topicsummary)  " +
				"VALUES ('" + speaker.firstname + "', '" + speaker.lastname + "', '" + 
				speaker.streetaddress1 + "', '" + speaker.streetaddress2 + "', '" +
				speaker.city + "', '" + speaker.state + "', '" + speaker.zipcode + "', '" + speaker.phone + "', '" +
				speaker.email + "', '" + speaker.username + "', '" + speaker.password + "', '" + 
				speaker.bio + "', '" + speaker.topicsummary +   "')");
*/
		
		
		stmt.executeUpdate ("INSERT INTO SpeakerInfo (firstname, lastname, address1, address2, city, state, zipcode, phone, email, username, password, bio)  " +
				"VALUES ('" + speaker.firstname + "', '" + speaker.lastname + "', '" + 
				speaker.streetaddress1 + "', '" + speaker.streetaddress2 + "', '" +
				speaker.city + "', '" + speaker.state + "', '" + speaker.zipcode + "', '" + speaker.phone + "', '" +
				speaker.email + "', '" + speaker.username + "', '" + speaker.password + "', '" + 
				speaker.bio  +   "')");		
		
	}
	
	public void editAndSaveToDatabase(Speaker speaker,  String username, Statement stmt) 
			throws IOException, SQLException{
		
				
		stmt.executeUpdate ("DELETE FROM SpeakerInfo WHERE username='" + username + "'");	
		
		stmt.executeUpdate ("INSERT INTO SpeakerInfo (firstname, lastname, address1, address2, city, state, zipcode, phone, email, username, password, bio)  " +
				"VALUES ('" + speaker.firstname + "', '" + speaker.lastname + "', '" + 
				speaker.streetaddress1 + "', '" + speaker.streetaddress2 + "', '" +
				speaker.city + "', '" + speaker.state + "', '" + speaker.zipcode + "', '" + speaker.phone + "', '" +
				speaker.email + "', '" + speaker.username + "', '" + speaker.password + "', '" + 
				speaker.bio  +   "')");		
		
	}
	
	public void deleteFromDatabase(Statement stmt, String username) throws SQLException{
		System.out.println(" in deleteFromDatabase username = " + username);
		String query = "DELETE FROM SpeakerInfo WHERE username ='" + username + "'";
		stmt.executeUpdate(query);
		query = "DELETE FROM Topics where username = '" + username + "'";
		stmt.executeUpdate(query);
	}


	public Map<String,Speaker> getFromDatabase(Statement stmt) 
			throws IOException, SQLException{

		Map<String,Speaker> speakermap = new HashMap<String,Speaker>();
/*
		String query = "SELECT firstname, lastname, address1, address2, " +
				"city, state, zipcode, phone, email, username, password, bio, topicsummary FROM SpeakerInfo";

*/
		
		
		String query = "SELECT firstname, lastname, address1, address2, " +
				"city, state, zipcode, phone, email, username, password, bio FROM SpeakerInfo";
		ResultSet rs = stmt.executeQuery (query);
		while (rs.next()) {
			
			Speaker sbean = new Speaker();

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
			

			speakermap.put(rs.getString ("username"), sbean);
		}
		return speakermap;
	}

	public Map<String, String> getWholeNamesFromDatabase(Statement stmt) 
			throws IOException, SQLException{

		Map<String, String> listOfWholeNames = new HashMap<String,String> ();
		String wholeName;
		
		String query = "SELECT firstname, lastname, address1, address2, " +
				"city, state, zipcode, phone, email, username, password, bio FROM SpeakerInfo";
		ResultSet rs = stmt.executeQuery (query);
		while (rs.next()) {
			
			wholeName = rs.getString("firstname") + rs.getString("lastname");
			listOfWholeNames.put(rs.getString("username"), wholeName);			

		}
		return listOfWholeNames;
	}


	
	public Speaker getSpeakerFromDatabase(Statement stmt, String username) 
			throws IOException, SQLException{

		Speaker sbean = new Speaker();

		String query = "SELECT firstname, lastname, address1, address2, " +
				"city, state, zipcode, phone, email, username, password, bio FROM SpeakerInfo WHERE username ='" + username +"'";

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

		}
		return sbean;
	}

}
