package methods_with_parameters;

public class Exercise1 {
	
	public static float[] square(float[] numbers) {
		
		float[] squares = new float[numbers.length];
		
		for (int i = 0; i < numbers.length; i++) {
			
			squares[i] = numbers[i] * numbers[i];
		}
		
		return squares;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		float[] numbers = {6, 9, 12, 15};
		
		for (float number : square(numbers)) {
			
		System.out.println(number);
		
		}

	}
	
}
