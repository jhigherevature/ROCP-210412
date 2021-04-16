package operators;

public class simulator {
	public static void main(String[] args) {
		
//		execute conditional statment ex1
		ConditionalStatements.bool(false);
		
//		execute RandomNumber ex2
		RandomNumber.randomNumber();
		
		Parrot Polly = new Parrot();
		Polly.talk("Rando");
		System.out.println(Polly.talk("Phil"));
		Polly.talk("Justin");
		
//		while1 ex1 of while loops
		while1 x = new while1();
		x.printNum();
		while1.printNum();
		
//		dowhile ex1 
		DoWhile doWh = new DoWhile();
		doWh.doWhile();
		
//		while bonus example
		WhileBonus WhBo = new WhileBonus();
		WhBo.WhileBonus();

		WhileBonus.WhileBonus();
		
		DoWhile.doWhile();
		
//		byte array
		ForLoop.byteArray();
		
//		bonus for
		ForBonus prOdd = new ForBonus();
		prOdd.printOdd();
		
//		getPi   
		GetPi pi = new GetPi();
		pi.getPi();
		System.out.println(pi.getPi());

//		???
//		toString(prOdd);
		
//		alphabet array
//		getAlphabetArray array = new getAlphabetArray();
		
		
	}
}
