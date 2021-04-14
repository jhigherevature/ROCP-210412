public class LinearSearch {

 

	public static void main(String[] args) {

	   //create some dummy data for our method
	
	   char[] letters = { 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r',
	
		's', 't', 'u', 'v', 'w', 'x', 'y', 'z' };
	
	   //call your methods here
	LinearSearch ls = new LinearSearch();
	ls.findIndex('0', letters);
	 System.out.println(ls.findIndex('A', letters));
	 
	 //Exercise one 
	 System.out.println(ls.findLetterBackwards('z', letters));

	 
	 //Exercise 2
	 System.out.println(ls.findLetterFromMiddle('p', letters));
 	}

//create your first method here
	public static int findIndex(char target, char[] data) {
		if(data == null) {return -1;}
		int result = -1;
		for(int i = 0; i <data.length; i++){
			char temp = data[i];
			if (temp == target){
				return i; //return the current index
			}
		
		}
		
		
		return result;
	}
	
	//Exercise one 
	public static int findLetterBackwards(char target, char[] data) {
		if(data == null) {return -1;}
		int result = -1;
		for(int i = data.length-1; i >=0 ; i--){
			char temp = data[i];
			if (temp == target){
				return i; //return the current index
			}
		
		}
		
		
		return result;
	}
	
	
	public static int findLetterFromMiddle(char target, char[] data) {
		if(data == null) {return -1;}
		int result = -1;
		char[] data1 = new char[data.length/2];
		char[] data2 = new char[data.length - (data.length/2)];
		
		for (int i = 0; i < data1.length; i++) {
			data1[i]=data[i];
		}
		
		for (int i = data2.length-1; i >= data2.length-1; i--) {
			data1[i]=data[i];
		}
		
		int result1 = findIndex(target, data1);
		int result2 = findIndex(target, data2);
		if(result1 >-1) {
			return result1;}
		 if (result2 >-1) {
			return result2+data1.length;
		}

		
		return result;
	}
	
	
	

}