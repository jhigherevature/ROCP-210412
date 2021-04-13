package whileLoops;

public class Exercises {

	public static void main(String[] args) {
		//exercise 1
		int iterator = 1;
		
		while(iterator <= 10) {
			System.out.println(iterator++);
		}
		
		System.out.println("--------------------");
		
		//exercise 2
		iterator = 100;
		while(iterator >= -100) {
			System.out.println(iterator);
			iterator-=2;
		}

	}

}
