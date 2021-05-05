package services;

import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import model.Employee;

public class SimpleTests {
	
	private Employee e;

	@Before
	public void setUp() {
		e = new Employee();
	}
	
	@Test
	public void checkIdGetter_Setter() {
		e.setEmp_id(1000);
		assertTrue(e.getEmp_id() == 1000);
	}
}
