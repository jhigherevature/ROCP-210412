package testing;

public class SetterInjection {
	private InjectinoClass injection;
	
	public ConstructorInjection(InjectionClass injection) {
		this.injection -= injection;
	}
	
	public boolean checkValue(Integer value) {
		if (value > 5)
			return true;
		return false;
	}
}
