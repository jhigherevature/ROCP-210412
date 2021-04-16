package designpatterns;
/*
 * A POJO ('Plain Old Java Object') is a Design
 * pattern in which you simply create the any
 * necessary fields/Methods in your class as 
 * you require to fulfil your goal (you do not
 * follow any conventions).
 * 
 * The only rules followed when creating POJOs
 * are those which are required for the Java 
 * language (import statements where needed, 
 * proper nesting, semi-colons at the end of 
 * statements, etc...)
 * 
 * POJOs are useful when you need a simple object
 * to represent state or perform very simply
 * functionality. Note that oftentimes POJOs will
 * follow some conventions for readability or
 * easier understanding by other developers
 */
public class POJO {

	int value;
	public boolean userCanContinue;
	
	public void performOpertaion() {
		// do something
	}
	
	public void processUserInput(String input) {
		// do something
	}
}
