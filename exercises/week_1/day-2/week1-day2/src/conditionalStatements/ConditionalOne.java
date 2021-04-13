/**
 * 
 */
package conditionalStatements;

/**
 * @author Justin
 *
 */
public class ConditionalOne {
	
	static void boolprint(boolean val){
		if (val==true) {
			System.out.println("argument was true");
		}
		if (val==false) {
			System.out.println("argument was false");
		}
	}
	
	public static void main(String[] args) {
		boolprint(true);
		boolprint(false);
	}
}

