package operators;

public class GetPi {
	
	public static void main(String[] args) {
		GetPi pi = new GetPi();
		System.out.println(pi.getPi());
		

	}
	public double getPi() {
		double d = Math.PI;
		return d;
	}
}
