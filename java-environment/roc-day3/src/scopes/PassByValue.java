package scopes;

public class PassByValue {
	static int x = 10;
	
	public static void main(String[] args) {
//		System.out.println(modify(x));
//		System.out.println(x);
//		
//		x = modify(x);
//		System.out.println(x);
		
		Data data_1 = new Data();
		System.out.println(data_1.number);
		modify(data_1);
		System.out.println(data_1.number);
		
		Dog fido = new Dog("Fido", "Bull Dog");
		
	}

	/*
	 *  The method name below is a bit of a misnomer
	 *  
	 *  When we use primitive variables, we do not
	 *  actually refer to the variable at all, and the
	 *  variables value is retained unless we directly
	 *  manipulate it.
	 */
	public static int modify(int a) {
		a = a+5;
		return a;
	}
	
	public static Data modify(Data d) {
		Data temp = new Data();
		temp.number = d.number;
		temp.number = 15;
		return temp;
	}
	
	public static Dog modify(Dog d) {
		// This creates a new object to preserve the 
		// original
		Dog temp = new Dog(d.name, d.breed);
		
		temp.name = "Scooby";
		temp.breed = "Great Dane";
		return temp;
	}
}
