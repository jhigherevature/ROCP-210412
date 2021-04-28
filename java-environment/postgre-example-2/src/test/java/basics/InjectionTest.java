package basics;

import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import testing.ConstructorInjection;
import testing.FieldInjection;
import testing.InjectionClass;
import testing.SetterInjection;

public class InjectionTest {
	/*
	 * the @InjectMocks allows mockito to utilize Mocked objects
	 * within the objects that are annotated with InjectMocks
	 * 
	 * When you have interconnections between different classes
	 * InjectMocks and Mocked data allow you to create the
	 * dummy data and method stubs that are used within your
	 * unit tests
	 * 
	 * When we use the @InjectMocks annotation, Mockito can
	 * provide the injection using the class's constructor, 
	 * the setter or the field (if no setter/constructor is 
	 * provided)
	 */
	@InjectMocks
	ConstructorInjection conInject;
	
	@InjectMocks
	SetterInjection setInject;
	
	@InjectMocks
	FieldInjection fieldInject;
	
	/*
	 * The @Mock annotation allows us to create dummy objects
	 * (mocks) which Mockito can provide method stubs for, and
	 * control the information that is being returned from
	 * our mocked object, when input is received. Effectively
	 * it allows us to control the input/output of supplementary
	 * objects to our main objects we are testing...
	 */
	@Mock
	InjectionClass injection;
	
	@Before
	public void setUp() {
		MockitoAnnotations.openMocks(this);
	}
	
	@Test
	public void constructorTest () {
		Mockito.when(injection.checkValue(10)).thenReturn(true);		
		assertTrue(conInject.performAction(10));
	}
	
	@Test
	public void setterTest () {
		Mockito.when(injection.checkValue(10)).thenReturn(true);		
		assertTrue(setInject.performAction(10));
	}
	
	@Test
	public void fieldTest () {
		Mockito.when(injection.checkValue(10)).thenReturn(true);		
		assertTrue(fieldInject.performAction(10));
	}
}
