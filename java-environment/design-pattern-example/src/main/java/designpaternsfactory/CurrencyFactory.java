package designpaternsfactory;

/*
 * The currency factory will provide the appropriate
 * object based on our input (this can be user input or
 * input from a developer who is using a library we establish)
 */
public class CurrencyFactory {
	public static Currency createCurrency(String country) {
		switch (country.toLowerCase().intern()) {
		case "usa":
			return new USDollar();
		case "italy":
			return new Euro();
		case "france":
			return new Euro();
		default:
			return new BitCoin();
		}
	}
}
