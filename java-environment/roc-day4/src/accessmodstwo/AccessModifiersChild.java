package accessmodstwo;

import accessmodsone.AccessModifiers;

public class AccessModifiersChild extends AccessModifiers {
	public static void main(String[] args) {
		AccessModifiers am = new AccessModifiers();
		System.out.println("Public Level:" + am.pub);
		/*
		 *  error
		 *  NOTE: We do not access protected fields 
		 *  from the parent directly...We can only
		 *  access the protected field within the child
		 *  class object
		 */
//		System.out.println("Protected Level:" + am.pro);
		
		AccessModifiersChild amc = new AccessModifiersChild();
		System.out.println("Protected Level:" + amc.pro);
		
		/*
		 * Protected fields are a way to pass a field 
		 * to a child, which then acts similar to a
		 * private field, for that child (other children
		 * and other classes cannot access the protected
		 * field directly, only the child, within the
		 * child class can access the data
		 */
	}
}
