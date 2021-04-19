package excercises;

public class OddNumberExceptions extends Exception {
	public  OddNumberExceptions() {
		super("This ain't odd so it doesn't work");
	}
	public static void main(String[] args) {
			try {
				System.out.println(addEven(4,5));
			} catch (OddNumberExceptions e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}
	
	public static int addEven(int a, int b) throws OddNumberExceptions {
		if(a%2 == 1) { 
			throw new OddNumberExceptions();
		}
		if(b%2 == 1) {
			throw new OddNumberExceptions();
		}
		return a+b;
	}
	
}
