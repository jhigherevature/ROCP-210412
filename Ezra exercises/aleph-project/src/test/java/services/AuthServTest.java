//package services;
//
//import static org.junit.Assert.assertEquals;
//
//import org.junit.Before;
//import org.junit.Test;
//import org.mockito.InjectMocks;
//import org.mockito.Mock;
//import org.mockito.Mockito;
//import org.mockito.MockitoAnnotations;
//
//import dataaccessobject.DonorDAO;
//import dataaccessobject.EmployeeDAO;
//import dataaccessobject.UserpassDAO;
//import model.Donor;
//import model.Employee;
//import model.Userpass;
//
//public class AuthServTest {
//	
//	@InjectMocks
//	private AuthenticationService serv;
//	
//	@InjectMocks
//	public GetUNandPW getup;
//
//
//	@Mock
//	private UserpassDAO udao;
//	
//	@Mock
//	private EmployeeDAO edao;
//
//	@Mock
//	private static DonorDAO ddao;
//
//	@Mock
//	private Userpass userpass;
//
//	@Mock
//	private Employee emp;
//	
//	@Mock
//	Donor donor;
//
//	public void setUp() {
//		MockitoAnnotations.openMocks(this);
//		userpass = new Userpass(100, "test", "pass", "emp");
//		emp = new Employee(99, "adam", "smith", "CEO", 100);
//		donor = new Donor(2000, 91134, "mr", "Johnson", "Johnson", "4123 Lineway dr.", "Atlanta", "GA", 90740, "123-456-7890", "Johnson@johnson.com", "123-12-1234", "asflkjaoefinna osadfoaef", "stuff", true, true, 20);
//		String[] str = new String[] {
//	}
//	
//	@Test
//	public void authTest() {
//		Mockito.when(udao.selectLoginByUserAndPass(str)).thenReturn(userpass);
//		Mockito.when(edao.selectEmployeeByLoginId(userpass.getId_userpass())).thenReturn(emp);
//		Mockito.when(getup.getUNandPW()).thenReturn(str);
//		Employee e = serv.authenticateEmployee(str[]);
//		assertEquals([]);
//	}
//}
