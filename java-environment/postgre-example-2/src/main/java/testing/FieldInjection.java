package testing;

public class FieldInjection {
	private InjectionClass injection;
	
	public boolean performAction(int value) {
		return injection.checkValue(value);
	}
}
