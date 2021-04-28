package testing;

public class ConstructorInjection {
	private InjectionClass injection;
	
	public ConstructorInjection(InjectionClass injection) {
		this.injection = injection;
	}
	
	public boolean performAction(int value) {
		
	}
}
