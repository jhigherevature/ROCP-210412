package exceptions;

public class OddNumberException extends Exception {//needs to extend exceptions

	public OddNumberException(String warning){//this is a constructor, used to instantiate the class
		
		super(warning);//this lets us write a custom message when the exception is called
		
	}
	
	public OddNumberException() {}//this allows us to call the exception with no message
	
}
