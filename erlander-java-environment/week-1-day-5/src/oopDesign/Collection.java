package oopDesign;

public class Collection extends Book{
	private int numStories;
	private String[] storyTitles;
	
	public Collection(String bookText, String name, String author, int numStories, String[] storyTitles) {
		super(bookText, name, author);
		this.setNumStories(numStories);
		this.setStoryTitles(storyTitles);
	}

	public int getNumStories() {
		return numStories;
	}

	public void setNumStories(int numStories) {
		this.numStories = numStories;
	}

	public String[] getStoryTitles() {
		return storyTitles;
	}

	public void setStoryTitles(String[] storyTitles) {
		this.storyTitles = storyTitles;
	}

}
