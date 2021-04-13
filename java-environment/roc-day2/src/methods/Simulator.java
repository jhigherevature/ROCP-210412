package methods;

class House {
	public String color = "Green";
	public static int numOfDoors = 2;
	public static void doorbell() {//we can use this method without Creating a House object
		System.out.println("Ding Dong, Someone is at the door");
	}
}
public class Simulator {
	//Methods
	//AccessModifier(required)
		/* static can be applied to variables and methods within a class
		 * static means the method can be invoked without creating an object from the class it is in
		 * */
	//Return Type(required)
	/* void means the method has no return type
	 * */
	
	//Method Name(required)
	
	//Method Syntax
	//AccessModifier NonAccessModifier DataType MethodNme(Parameters)throws declaration{
			//Method Body
	//}
	//Return type must match the DataType of the method
	
	//add method with a int DataType/Return Type so it must return a int
	public static int add(int a, int b) {
		int sum = a + b;
		/*Return keyword
		 * allows you to use the method as you would an expression by using the value immediately to the left of the keyword
		 * stops the functionality within your method at that line
		 * */
		return sum;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(add(10, 25));
		House.numOfDoors = 5;
		//System.out.println(House.color);//Cannot do this
		System.out.println(House.numOfDoors);
		House myHouse = new House();
		System.out.println("House Object " + myHouse.numOfDoors);
		House.doorbell();//doorbell() method being used without creating an House object

	}

}
