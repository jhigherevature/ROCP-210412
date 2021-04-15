package accessmodstwo;

import accessmodsone.AccessModifiers;

public class PackTwoSimulator {
	public static void main(String[] args) {
		AccessModifiers am = new AccessModifiers();
		System.out.println("Public Level:" + am.pub);
		
		/*
		 *  error
		 *  we cannot access protected fields outside
		 *  of the package they are declared, unless
		 *  we are a child of that class
		 */
//		System.out.println("Protected Level:" + am.pro);
		
		/*  error
		 *  we cannot access default/package-private
		 *  fields outside of the package they are 
		 *  declared
		 */
//		System.out.println("Default Level:" + am.def);
		
		/*  error
		 *  we cannot access private fields
		 *  outside of the class they are declared
		 */
//		System.out.println("Private Level:" + am.priv);
	}
}
