package basics;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import model.Employee;
import testexample.Data;
import testexample.TestingClass;

public class SimpleTests {
	
	private Employee e;
	
	@Before
	public void setUp() {
		e = new Employee();
	}
	
	@Test
	public void checkIdGetter_Setter() {
		e.setEmp_id(1000);
		Assert.assertTrue(e.getEmp_id() == 1000);
	}
}
