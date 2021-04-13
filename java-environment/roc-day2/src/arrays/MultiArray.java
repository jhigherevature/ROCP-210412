package arrays;

public class MultiArray {
	public static void main(String[] args) {
		
		//an array of int that holds an array of int
			
		int [][] numTable = new int[3][5];//array of three arrays, with each array having a size of 5
				//Array 1
					numTable[0][0] = 1;
					numTable[0][1] = 2;
					numTable[0][2] = 3;
					numTable[0][3] = 4;
					numTable[0][4] = 5;
					
				//Array 2	
					numTable[1][0] = 6;
					numTable[1][1] = 7;
					numTable[1][2] = 8;
					numTable[1][3] = 9;
					numTable[1][4] = 10;
					
				//Array 3	
					numTable[2][0] = 11;
					numTable[2][1] = 12;
					numTable[2][2] = 13;
					numTable[2][3] = 14;
					numTable[2][4] = 15;
					
					System.out.println(numTable[0][3]);
					System.out.println(numTable[2][2]);
	}

}
