package scopes;

public class Simulator {
	public static void main(String[] args) {
		Scope scp = new Scope();
		System.out.println(scp.instanceScope);
		scp.method();
	}
}
