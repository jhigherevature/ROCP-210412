package testing;

import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;

// a static import gives ability to import JUST a static method in a class, as if wrote that method in the importing class. saves some memory because only adding method and not entire class.
//  static keyword added		name of static method
//		|							|
import static org.junit.Assert.assertTrue;

public class MathOpsTest {

	/*
	 * JUnit Test File is a Java class which leverages different JUnit annotations and methods.
	 */
	private MathOps ops;
	
	@BeforeClass
	public static void setUpBeforeClass() {
		System.out.println("before class method");
	}
	@Before
	public void setUp() {
		System.out.println("set up ran");
		ops = new MathOps();

	}

	@After
	public void tearDown() {
		System.out.println("tear down ran");

}
	@Test
	public void testAdd_01 () {
		System.out.println("addint test 1");
		int result = ops.add(1, 2);
		assertTrue(result == 3);	
	}
	
	@Test
	public void testAdd_02 () {
		int result = ops.add(5, 5);
		assertTrue(result == 10);	
	}
	
	@Ignore
	@Test
	public void test_1() {
		System.out.println("test 1 ran");
}
	@Ignore
	@Test
	public void test_2() {
		System.out.println("test 2 ran");
}
	}