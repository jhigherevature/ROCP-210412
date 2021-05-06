package designpatternfactory;

public class Euro implements Currency{

	@Override
	public String getCurrencySymbol() {
		return "EUR";
	}
}
