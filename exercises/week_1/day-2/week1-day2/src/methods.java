
public class methods {
/*
 * # Exercise 1
Create a method that returns a random number
between 1 and 50, inclusively. 
This method should be called `randomNumber()`, 
it should be have a `public` access modifier 
and return an `int` datatype. 
It should not declare any parameters or 
exceptions. 

You'll need to use the Math class 
to generate a random number. It has a 
method called **random** that will return a 
value greater than or equal to 0.0 
and less than 1.0. An example of its 
usage is below:

`double d = Math.random();`
 */
	public static int  randomNumber() {
		 int randomNumber = (int)(Math.random()*50);
		return randomNumber;
		
	}
/*
 * # Bonus 1

Create a class called "Parrot" which has a String field called 
"name". Initialize this name property to any String value.

Create a method within this parrot class called 
"Talk" which prints the name property of the object 
followed by " wants a cracker!".
 */
		
	public static void main(String[] args) {
		 System.out.println(randomNumber());
		 
		 // Bonus 1 
		 Parrot p = new Parrot();
		 System.out.println(p.talk);
		 }
	

}
