package reflections;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.lang.reflect.Parameter;

public class ReflectionsSimulator {

	public static void main(String[] args) throws NoSuchMethodException, SecurityException {
		Class<Frankenstein> frankClass = Frankenstein.class;
		
		System.out.println(frankClass.getName());
		
		System.out.println("Constructors: ");
		Constructor<Frankenstein> [] frankConstructors = (Constructor<Frankenstein>[])frankClass.getConstructors();
		for (Constructor<Frankenstein> c : frankConstructors) {
			System.out.println("\t" + c);
		}
		
		Constructor<Frankenstein> paramConstructor = frankClass.getDeclaredConstructor(int.class, String.class, double.class);
		System.out.println("\tParamConstructor: " + paramConstructor);
		
		System.out.println("Declared Methods: ");
		/*
		 * Declared methods will return a list of every single method in
		 * the class (including private, protected, etc...)
		 */
		Method[] declareMethods = frankClass.getDeclaredMethods();
		for (Method dm : declareMethods) {
			System.out.println("\t" + dm);
		}
		
		System.out.println("Visible Methods: ");
		/*
		 * Called getMethods() method on our class will only retrieve
		 * those that are visible
		 */
		Method[] visibleMethods = frankClass.getMethods();
		for (Method vm : visibleMethods) {
			System.out.println("\t" + vm);
		}
		
		System.out.println("Declared Fields: ");
		Field[] decFields = frankClass.getDeclaredFields();
		for (Field df : decFields) {
			System.out.println("\t" + df);
		}
		
		System.out.println("Visible Fields: ");
		Field[] visFields = frankClass.getFields();
		for (Field vf : visFields) {
			System.out.println("\t" + vf);
		}
		
		System.out.println("Field Modifiers: ");
		for (Field f : decFields) {
			int mod = f.getModifiers();
			System.out.println("\t" + f);
			System.out.println("\t\t" + mod);
			System.out.println("\t\tPublic: " + Modifier.isPublic(mod));
			System.out.println("\t\tPrivate: " + Modifier.isPrivate(mod));
		}
		
		System.out.println("MODIFIERS: ");
		System.out.println("Public: " + Modifier.PUBLIC);				// 0000 0000 0001
		System.out.println("Private: " + Modifier.PRIVATE);				// 0000 0000 0010
		System.out.println("Protected: " + Modifier.PROTECTED);			// 0000 0000 0100
		System.out.println("Static: " + Modifier.STATIC);				// 0000 0000 1000
		System.out.println("Final: " + Modifier.FINAL);					// 0000 0001 0000
		System.out.println("Synchronized: " + Modifier.SYNCHRONIZED);	// 0000 0010 0000
		System.out.println("Volatile: " + Modifier.VOLATILE);			// 0000 0100 0000
		System.out.println("Transiet: " + Modifier.TRANSIENT);			// 0000 1000 0000
		System.out.println("Native: " + Modifier.NATIVE);				// 0001 0000 0000
		System.out.println("Interface: " + Modifier.INTERFACE);			// 0010 0000 0000
		System.out.println("Abstract: " + Modifier.ABSTRACT);			// 0100 0000 0000
		System.out.println("Strict: " + Modifier.STRICT);				// 1000 0000 0000
		
		System.out.println("Parameters for Declared Methods: ");
		for (Method dm : declareMethods) {
			System.out.println("\t" + dm);
			Parameter[] dmParams = dm.getParameters();
			for (Parameter p : dmParams) {
				System.out.println("\t\t" + p);
			}
		}
	}
}
