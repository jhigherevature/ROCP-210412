package lecture;

public class Casting {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//UPCAST: Converting from smaller to larger data type this will be done implicitly
		//Move num(int) into a bigger container decimal(double)
		int num = 65;
		double decimal = num;
		
		//DOWNCAST: Converting from larger data type to a smaller data type
		//Cannot move decimal_2 into a smaller container without casting
		//double decimal_2 = 65.0;
		//int num_2 = decimal_2;

		//Cannot move decimal_2 into a smaller container without casting
				double decimal_2 = 65.0;
				int num_2 = (int)decimal_2;
				
				char letter = (char)num;
				System.out.println(letter);
				
				byte b = (byte)255;
				System.out.println(b);
	}

}
