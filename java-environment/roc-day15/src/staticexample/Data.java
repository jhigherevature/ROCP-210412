package staticexample;

public class Data {
	public static String word = "Hi There!";
	
	public static Data singletonData = new Data();
	
	public void myMethod() {
		word = "";
	}
}
