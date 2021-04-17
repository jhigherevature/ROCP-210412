package methods_with_parameters;

public class ExerciseOne {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		ExerciseOne e = new ExerciseOne();
		float[] array = e.square(2,4,6,8);
		
		for(int i = 0; i < array.length; i++)
		{
			System.out.println(array[i]);
		}
	}
	
	public float[] square(int num1, int num2, int num3, int num4)
	{
		float[] floatArray = new float[4];
		
		num1 = num1 * num1;
		num2 = num2 * num2;
		num3 = num3 * num3;
		num4 = num4 * num4;
		
		floatArray[0] = num1;
		floatArray[1] = num2;
		floatArray[2] = num3;
		floatArray[3] = num4;
		return floatArray;
	}
}