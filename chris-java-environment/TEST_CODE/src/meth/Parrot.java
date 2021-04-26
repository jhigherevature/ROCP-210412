package meth;

public class Parrot {
	
	String name = "Polly";
	
 public void Talk() {
	 
	 System.out.println(name + " wants a cracker!");
 }
 public static void main(String[] args) {
	 
	 Parrot a = new Parrot();
	 
	 a.Talk();
	 
 }

}
