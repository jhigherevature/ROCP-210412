package testexample;

public class TestingClass {
	
	private Data d;
	
	public int performWork(int value) {
		int sum = 0;
		
		
		if (d.checkisOdd(value)) {
			sum = 15;
		} else {
			sum = 2000;
		}
		
		return sum; 
	}
}
