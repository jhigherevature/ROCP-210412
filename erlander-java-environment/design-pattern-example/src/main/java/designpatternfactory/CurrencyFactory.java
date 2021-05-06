package designpatternfactory;

public class CurrencyFactory {
	
	public static Currency createCurrency (String country) {
		switch (country.toLowerCase().intern()) {
		case "usa":
			return new USDollar();
		case "italy":
			return new Euro();
		case "france":
			return new Euro();
		default:
			return new Bitcoin();
		}
	}

}
