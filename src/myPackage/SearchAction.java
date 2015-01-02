package myPackage;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;

import com.opensymphony.xwork2.ActionSupport;

import org.apache.commons.lang3.StringUtils;
import org.apache.struts2.interceptor.SessionAware;
import org.apache.struts2.interceptor.validation.SkipValidation;


public class SearchAction extends ActionSupport implements SessionAware{
	private static final long serialVersionUID = 1L;
	
	private String mysearchstring;
	private String selectedTopic;
	private String selectedTalk;
	private String topicsummary;
	
	private Speaker speaker;
	private Topic topic;
	private Collection<Topic> topiclist;

	Map m;
	DBConnection dbconnection;
	

	
	public Collection<Topic> getTopiclist() {
		return topiclist;
	}

	public void setTopiclist(Collection<Topic> topiclist) {
		this.topiclist = topiclist;
	}

	public String getMysearchstring() {
		return mysearchstring;
	}

	public void setMysearchstring(String mysearchstring) {
		this.mysearchstring = mysearchstring;
	}

	public String getSelectedTopic() {
		return selectedTopic;
	}

	public void setSelectedTopic(String selectedTopic) {
		this.selectedTopic = selectedTopic;
	}

	public String getSelectedTalk() {
		return selectedTalk;
	}

	public void setSelectedTalk(String selectedTalk) {
		this.selectedTalk = selectedTalk;
	}

	public Speaker getSpeaker() {
		return speaker;
	}

	public void setSpeaker(Speaker speaker) {
		this.speaker = speaker;
	}

	public String getTopicsummary() {
		return topicsummary;
	}

	public void setTopicsummary(String topicsummary) {
		this.topicsummary = topicsummary;
	}

	public Topic getTopic() {
		return topic;
	}

	public void setTopic(Topic topic) {
		this.topic = topic;
	}

	public String execute() throws IOException, SQLException{
		System.out.println("mysearchstring: " + mysearchstring);
		System.out.println("selectedTopic: " + selectedTopic);
		System.out.println("selectedTalk: " + selectedTalk);
		
		SpeakerService speakerserv = new SpeakerService();
		TopicService topicserv = new TopicService();
		
		Statement stmt  = dbconnection.connectToDatabase();
		
		topicsummary = topicserv.getTopicSummaryFromDatabase(stmt, selectedTalk);
		String username = topicserv.getUsernameFromDatabase(stmt, selectedTalk);
		
		speaker = speakerserv.getSpeakerFromDatabase(stmt, username);
		
	 return "success";
	}
	
	public String registerSpeaker() throws SQLException{
		return "success";
	}
	
	@SkipValidation
	public String searchForKeyword() throws IOException, SQLException{
		String username = (String) getSession().get("session_username");

		
		System.out.println("keyword is: " + mysearchstring);
		System.out.println("selectedTopic is:" + selectedTopic);
		TopicService topicserv = new TopicService();
		
		String tempsearchstring = mysearchstring.trim();
		tempsearchstring="%" + tempsearchstring + "%";
		
		Statement stmt  = dbconnection.connectToDatabase();
		List<Topic> topiclist = topicserv.searchDatabase(stmt, tempsearchstring);
		this.topiclist = topiclist;
		
		System.out.println("number: " + topiclist.size());
		
		for(Topic t: topiclist){
			System.out.println("topictitle = " + t.topictitle);
		}

		
		if(username == null) return "success";
		if(username != null && !username.isEmpty()) return "speaker_success";
		return "admin_success";
	}
	
	@SkipValidation
	public String searchForTopic() throws IOException, SQLException{
		String username = (String) getSession().get("session_username");
		System.out.println("In searchForTopic()");
		System.out.println("keyword is: " + mysearchstring);
		System.out.println("selectedTopic is:" + selectedTopic);
		CategoryService categoryserv = new CategoryService();
				
		Statement stmt  = dbconnection.connectToDatabase();
		List<Topic> topiclist = categoryserv.getTopicFromDatabase(stmt, selectedTopic);
		this.topiclist = topiclist;
		
		System.out.println("number: " + topiclist.size());
		
		for(Topic t: topiclist){
			System.out.println("topictitle = " + t.topictitle);
			System.out.println("firstname = " + t.firstname);
			System.out.println("lastname = " + t.lastname);
			System.out.println("picture = " + t.topicpicture);
		}

		if(username == null) return "success";
		if(username != null && !username.isEmpty()) return "speaker_success";
		return "admin_success";
		
	}
	
	public void validate(){
		System.out.println("in validate");
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
