package forLoop;

public class ForLoopOne {
	public static void main(String[] args) {
		
		byte[] arr = new byte[10];
		byte num = 2;
		for (int i = 0; i< 10; i++) {
		
			arr[i] = num;
			num += 2;
			System.out.println(arr[i]);
		}
		
	}
}
