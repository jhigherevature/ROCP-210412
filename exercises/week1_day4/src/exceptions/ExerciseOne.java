package exceptions;

public class ExerciseOne {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		ExerciseOne e = new ExerciseOne();
		try {
			e.addEven(3,2);
		} catch (OddNumberException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}
	
	public void addEven(int num1, int num2) throws OddNumberException
	{
		if(num1 % 2 != 0 || num2 % 2 != 0)
		{
			throw new OddNumberException();
		}
	}
}