
public class NestedLoops1 {
	public void nestedLoop() {
		String s = "*";
		for (int i=1; i<=1;i++) {
			System.out.println("```");
			
			}
			for (int a=1;a<=5;a++) {
				System.out.println(s);
				s = s.concat("*");
			}
				for (int i=1; i<=1;i++) {
					System.out.println("```");
					
				}

		}
	public void letNum() {
		char c = 'a';
		for (int j=1; j<=26; j++) {
			System.out.print(c);
			c++;
			for (int num=1;num<=1;num++) {
				System.out.print(" - " + j + "\n");
			}
		}
	}
	public void nameGenerator() {
		String [] fname = {"Adam", "Alexis", "Dennis", "Jose", "Jessica", "Meghan", "Memphis", "Nicky", "Sarah", "William"};
		String [] lname = {"Adamson", "Bond", "Brown", "Johnson", "Gallagher", "Smith", "Thompson", "Perez", "Snow", "Tran"};
		int var = 0;
		int var2 = 0;
		first: while (var <= fname.length-1) {
			last: while (var2 <= lname.length-1) {
				System.out.println(fname[var]+" "+lname[var2]);
				var2++;
			}
			var++;
			var2=0;
		}
	}
		
}
		
	


// ex1 bonus 2
//creating a Name Generator. We’ll stick to just first and last names. Your program should list all possible combinations between a first name and a last name from the lists that are provided below.
//
//First Names:
//*   Adam, Alexis, Dennis, Jose, Jessica, Meghan, Memphis, Nicky, Sarah, William 
//Last Names:
//*   Adamson, Bond, Brown, Johnson, Gallagher, Smith, Thompson, Perez, Snow, Tran

// ex1 bonus
//Create a nested loop structure that prints each letter of the alphabet and it's corresponding numerical position.
//i.e. `A - 1`.


// ex1
//Use nested for-loops to print the following:
//
//```
//*
//**
//***
//****
//*****
//```
//
//HINT: you can use `System.out.print` to print information on the same line, instead of `System.out.println` which prints to a new line.
