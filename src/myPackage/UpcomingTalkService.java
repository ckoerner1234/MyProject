package myPackage;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class UpcomingTalkService {
	
	public List<UpcomingTalk> getFromDatabase(Statement stmt) 
			throws IOException, SQLException{

		List<UpcomingTalk> talklist = new ArrayList<UpcomingTalk>();
		
		
		String query = "SELECT * FROM UpcomingTalks";
		ResultSet rs = stmt.executeQuery (query);
		while (rs.next()) {
			
			UpcomingTalk talkbean = new UpcomingTalk();

			talkbean.setTopictitle(rs.getString ("topictitle"));
			talkbean.setTopicsummary(rs.getString ("topicsummary"));
			talkbean.setDate(rs.getString ("date"));
			talkbean.setLocation(rs.getString ("location"));
			
			System.out.println(talkbean.getTopictitle());
			System.out.println(talkbean.getTopicsummary());
			System.out.println(talkbean.getDate());
			System.out.println(talkbean.getLocation());

			talklist.add(talkbean);
		}
		return talklist;
	}	
	
	public void saveToDatabase(Statement stmt, UpcomingTalk upcomingtalk) throws SQLException{
		stmt.executeUpdate ("INSERT INTO UpcomingTalks (topictitle, topicsummary, date, location)  " +
				"VALUES ('" + upcomingtalk.getTopictitle() + "', '" + upcomingtalk.getTopicsummary() + "', '" + 
				upcomingtalk.getDate() + "', '" + upcomingtalk.getLocation() + "')");		
		
	}
	
	public void deleteFromDatabase(Statement stmt) throws SQLException{
		String query = "DELETE FROM UpcomingTalks";
		stmt.executeUpdate(query);
	}

}
