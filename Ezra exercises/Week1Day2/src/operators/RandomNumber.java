package operators;

public class RandomNumber {
	
	public static void main(String[] args) {
		randomNumber();
	}
	public static int randomNumber() {
		double d = Math.random();
		d=d*50;
		System.out.println((int)d);
		return (int)d;
	}

}

//Create a method that returns a random number between 1 and 50, inclusively. This method should be called `randomNumber()`, it should be have a `public` access modifier and return an `int` datatype. It should not declare any parameters or exceptions. 

//You'll need to use the Math class to generate a random number. It has a method called **random** that will return a value greater than or equal to 0.0 and less than 1.0. An example of its usage is below:

//`double d = Math.random();`