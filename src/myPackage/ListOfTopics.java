package myPackage;

public class ListOfTopics {
	
	private String username;
	private String[] listoftopictitles;
	private String[] listoftopicsummaries;
	private int numberoftopics;
	
	
	public ListOfTopics(String username, String[] listoftopictitles_in, 
			String[] listoftopicsummaries_in, int numberoftopics){
		this.listoftopictitles = new String[50];
		int number = listoftopictitles_in.length;
		for (int i=0;i<number; i++){
		   this.listoftopictitles[i] = listoftopictitles_in[i];
		}
		this.listoftopicsummaries = new String[50];
		for (int i=0;i<numberoftopics; i++){
		   this.listoftopicsummaries[i] = listoftopicsummaries_in[i];
		}
		
		this.username = username;
		this.setNumberoftopics(numberoftopics);
		
	}

	
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String[] getListoftopictitles() {
		return listoftopictitles;
	}
	public void setListoftopictitles(String[] listoftopictitles) {
		this.listoftopictitles = listoftopictitles;
	}
	public String[] getListoftopicsummaries() {
		return listoftopicsummaries;
	}
	public void setListoftopicsummaries(String[] listoftopicsummaries) {
		this.listoftopicsummaries = listoftopicsummaries;
	}
	public int getNumberoftopics() {
		return numberoftopics;
	}
	public void setNumberoftopics(int numberoftopics) {
		this.numberoftopics = numberoftopics;
	}

}
