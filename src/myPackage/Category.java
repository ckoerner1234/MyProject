package myPackage;

public class Category {
	
	private String topictitle;
	private String category;
	
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public String getTopictitle() {
		return topictitle;
	}
	public void setTopictitle(String topictitle) {
		this.topictitle = topictitle;
	}
	
	public Category(){
		
	}
	
	public Category(String topictitle, String category){
		this.topictitle=topictitle;
		this.category=category;
	}

}
