package basics;

public class Casting {
	


	public static void main(String[] args) {
		int num=65;
		double decimal=num;
		double decimal2=65.78;
		int num2=(int) decimal2;
		
		System.out.println(num2);
		
		char c=(char) num;
		System.out.println(c);
		
		
		//when converting between data types the binary values are truncated
		//which can lead to strange representation
		byte b=(byte) 255;
		System.out.println(b);

	}

}
