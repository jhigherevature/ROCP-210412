package accessmodsone;

public class PackageOneSimulator {
	public static void main(String[] args) {
		AccessModifiers am = new AccessModifiers();
		System.out.println("Public Level:" + am.pub);
		System.out.println("Protected Level:" + am.pro);
		System.out.println("Default Level:" + am.def);
		
		/*
		 *  error - we cannot access private fields
		 *  outside of the class they are declared
		 */
//		System.out.println("Private Level:" + am.priv);
	}
}
