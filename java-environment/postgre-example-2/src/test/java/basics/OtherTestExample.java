package basics;

import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import testexample.Data;
import testexample.TestingClass;

public class OtherTestExample {

	@InjectMocks
	private TestingClass tc;
	
	@Mock
	private Data d;
	
	@Before
	public void setUp() {
		MockitoAnnotations.openMocks(this);
	}
	
	@Test
	public void testPerformMethod_01() {
		Mockito.when(d.checkisOdd(10)).thenReturn(false);
		assertTrue(tc.performWork(10) == 2000);
	}
}
