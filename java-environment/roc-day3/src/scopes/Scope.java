package scopes;

public class Scope {
	public String instanceScope = "This string exists in Instance Scope"; 
	public static int staticScope = 8;
	
	public static void main(String[] args) {
		Scope scopeObj = new Scope();
		System.out.println(scopeObj.instanceScope);
		
		System.out.println(scopeObj.staticScope);
		System.out.println(Scope.staticScope);
		
		
		
		scopeObj.method();
	}
	
	public void createObjectAndDoMethod() {
		if (true) {
			Scope scp = new Scope();
			scp.instanceScope = "Instance";
			scp.method();
		}
	}

	public void method() {
		/*
		 * the 'list' of available Variable names
		 * is shared at a class level, and a method
		 * level. 
		 * 
		 * variales within a method cannot share the 
		 * same name, even if they exist in a block
		 * within the method. 
		 */
		String methodScope = "This is the method scope string";
		String instanceScope = "This is the methods Instance Scope";
		System.out.println(methodScope);
		System.out.println(instanceScope);
		
		int i = 0;
		for ( ; i < 10; i++) {
			System.out.println(i);
		}
		
//		System.out.println(i); // int i no longer exists
	}
}
