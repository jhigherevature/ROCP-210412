package methods;

public class ExerciseOne {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		ExerciseOne e = new ExerciseOne();
		System.out.println(e.randomNumber());
	}
	
	public int randomNumber()
	{
		int num;
		num = (int)(1 + Math.random() * 50);
		
		return num;
	}
}