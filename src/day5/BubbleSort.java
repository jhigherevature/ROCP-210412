package day5;

public class BubbleSort {

	public static void main(String[] args) {

		int[] items = { 1, 0, 5, 6, 3, 2, 3, 7, 9, 8, 4 };
		
		for(int i = 0; i < items.length; i++) {
			for(int k = 0; k < i; k++) {
				if(items[i] < items[k]) {
					int temp = items[k];
					items[k] = items[i];
					items[i] = temp;
				}
			}
		}
		
		for(int i = 0; i < items.length; i++) {
			System.out.print(items[i] + ", ");
		}
	}
}
