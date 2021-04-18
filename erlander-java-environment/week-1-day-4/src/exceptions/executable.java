package exceptions;

public class executable {

	public static void main(String[] args) {
		try {
			System.out.print(addEven(2, 9));
		} catch(OddNumberException e) {
			e.printStackTrace();
		} catch(Exception e) {
			e.printStackTrace();
		}
		

	}
	
	public static int addEven(int a, int b) throws OddNumberException {
		if(a % 2 != 0 || b % 2 != 0) {
			throw new OddNumberException("Input is odd");
		}
		
		return a + b;
	}

}
