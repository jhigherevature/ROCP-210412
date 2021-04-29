package testing;

public class SetterInjection {
	private InjectionClass injection;
	
	public boolean performAction(int value) {
		return injection.checkValue(value);
	}
	
	public void setInjection(InjectionClass injection) {
		this.injection = injection;
	}
}
