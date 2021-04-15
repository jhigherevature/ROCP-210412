package operators;

public class GetPi {
	
	public static void main(String[] args) {
//		get rid of this to make it static and final
//		GetPi pi = new GetPi();
//		System.out.println(pi.getPi());
		System.out.println(getPi());
//		sample attempt to use
		System.out.println(5*getPi());

	}
	public static final double getPi() {
		double d = Math.PI;
		return d;
	}
}
