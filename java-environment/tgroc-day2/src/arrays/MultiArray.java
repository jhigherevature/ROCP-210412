package arrays;

public class MultiArray {
	
	public static void main(String[] args) {
		int[][]numTable = new int[3][3];
		numTable[0][0] = 1;
		numTable[0][1] = 2;
		numTable[0][2] = 3;
		
		numTable[1][0] = 4;
		numTable[1][1] = 5;
		numTable[1][2] = 6;
		
		numTable[2][0] = 7;
		numTable[2][1] = 8;
		numTable[2][2] = 9;
		
		int[][] numbTable_2 = new int[][] { {1,2,3}, {4,5,6}, {7,8,9}};
		
		// this works, never do this!
		int[][] numTableComplex[][]; //creates a 4 dimensional array
	}

}
