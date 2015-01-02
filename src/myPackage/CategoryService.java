package myPackage;

import java.io.*;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CategoryService {
	
	public void saveToDatabase(Category category,  Statement stmt) 
			throws IOException, SQLException{
		
		stmt.executeUpdate ("INSERT INTO Categories (topictitle, category)  " +
				"VALUES ('" + category.getTopictitle() + "', '" + category.getCategory() +  "')");			
	}
	
	public void editAndSaveToDatabase(Collection<Category> categories, String topictitle, Statement stmt) 
			throws IOException, SQLException{
		
		stmt.executeUpdate ("DELETE FROM Categories WHERE topictitle='" + topictitle + "'");
		
		for (Category category : categories) {
			stmt.executeUpdate ("INSERT INTO Categories (topictitle, category)  " +
					"VALUES ('" + category.getTopictitle() + "', '" + category.getCategory() + "')");

	    }
	}

		public List<Category> getFromDatabase(Statement stmt) 
				throws IOException, SQLException{

			List<Category> categorylist = new ArrayList<Category>();
			
			
			String query = "SELECT topictitle, category FROM Categories";
			ResultSet rs = stmt.executeQuery (query);
			while (rs.next()) {
				
				Category categorybean = new Category();

				categorybean.setTopictitle(rs.getString ("topictitle"));
				categorybean.setCategory(rs.getString ("category"));
				categorylist.add(categorybean);
			}
			return categorylist;
		}
		
		
		public List<Category> getCategoryFromDatabase(Statement stmt, String topictitle) 
				throws IOException, SQLException{

			List<Category> categorylist = new ArrayList<Category>();

			String query = "SELECT topictitle, category FROM Categories WHERE topictitle ='" + topictitle +"'";

			ResultSet rs = stmt.executeQuery (query);
			
			while(rs.next()){
			
				Category categorybean = new Category();

				categorybean.setTopictitle(rs.getString ("topictitle"));
				categorybean.setCategory(rs.getString ("category"));
		
				categorylist.add(categorybean);
			}
			return categorylist;
		}		
		
		public List<Topic> getTopicFromDatabase(Statement stmt, String category) 
				throws IOException, SQLException{
			
			System.out.println("in getTopicFromDatabase");
			System.out.println("category: " + category);

			List<Topic> topiclist = new ArrayList<Topic>();
			List<Category> categorylist = new ArrayList<Category>();

			String query1 = "SELECT topictitle, category FROM Categories WHERE category ='" + category +"'";

			ResultSet rs = stmt.executeQuery (query1);
			int count = 0;
			
			while(rs.next()){
				System.out.println("in while loop " + count++);
			
				Category categorybean = new Category();

				categorybean.setTopictitle(rs.getString ("topictitle"));
				categorybean.setCategory(rs.getString ("category"));
				System.out.println(categorybean.getCategory());
				System.out.println(categorybean.getTopictitle());
				System.out.println("******************");
		
				categorylist.add(categorybean);
			}
			
			String temptitle;
			int i=0;
			for(Category cat: categorylist){
				temptitle=cat.getTopictitle();
				System.out.println("i= " + i);
				System.out.println(cat + "  " + temptitle);
			    String query2 = "SELECT username, password, firstname, lastname, topictitle, topicsummary, topicpicture FROM Topics WHERE topictitle ='" + temptitle +"'";
			    rs = stmt.executeQuery (query2);
			    if(rs.next()){
			    Topic topicbean = new Topic();
			    topicbean.setPassword(rs.getString("password"));
			    topicbean.setUsername(rs.getString("username"));
				topicbean.setFirstname(rs.getString ("firstname"));
				topicbean.setLastname(rs.getString ("lastname"));
			    topicbean.setTopictitle(rs.getString("topictitle"));
			    topicbean.setTopicsummary(rs.getString("topicsummary"));
				topicbean.setTopicpicture(rs.getString ("topicpicture"));
			    
			    topiclist.add(topicbean);
			    }
			}
			return topiclist;
		}		
				
}


