package designpatternfactory;

public class USDollar implements Currency{
	
	
	@Override
	public String getCurrencySymbol() {
		return "USD";
	}
}
