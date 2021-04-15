package do_while;

public class ExerciseOne {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int i = 1;
		
		do
		{
			if(i % 2 != 0)
			{
				System.out.println(i);
			}
			i++;
		}
		while(i < 50);
	}
}