package oopDesign;

import java.util.Map;

public class Magazine extends Book{
	private int numArticles;
	private Map<String, String> articles; 
	
	public Magazine(String bookText, String name, int numArticles, Map<String, String> articles) {
		super(bookText, name, "various");
		this.setNumArticles(numArticles);
		this.setArticles(articles);
	}

	public int getNumArticles() {
		return numArticles;
	}

	public void setNumArticles(int numArticles) {
		this.numArticles = numArticles;
	}

	public Map<String, String> getArticles() {
		return articles;
	}

	public void setArticles(Map<String, String> articles) {
		this.articles = articles;
	}

}
