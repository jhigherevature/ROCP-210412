package designpatternfactory;

public class Bitcoin implements Currency{

	@Override
	public String getCurrencySymbol() {
		return "BTC";
	}
}
