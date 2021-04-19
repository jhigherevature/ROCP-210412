package accessmodsone;

public class AccessModifiers {

	public String pub = "Public Access";
	protected String pro = "Protected Access";
	String def = "Default or Package-Private Access";
	private String priv = "Private Access";
	
	public static void main(String[] args) {
		AccessModifiers am = new AccessModifiers();
		System.out.println("Public Level:" + am.pub);
		System.out.println("Protected Level:" + am.pro);
		System.out.println("Default Level:" + am.def);
		System.out.println("Private Level:" + am.priv);
	}
}
