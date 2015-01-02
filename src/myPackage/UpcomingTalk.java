package myPackage;

public class UpcomingTalk {
	
	private String topictitle;
	private String topicsummary;
	private String date;
	private String location;

	
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
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	
	public UpcomingTalk(){
		
	}
	
	public UpcomingTalk(String topictitle, String topicsummary, String date, String location){
		this.topictitle=topictitle;
		this.topicsummary=topicsummary;
		this.date=date;
		this.location=location;
	}
	

}
