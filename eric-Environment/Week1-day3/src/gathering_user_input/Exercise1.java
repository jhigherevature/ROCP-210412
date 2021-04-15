package gathering_user_input;
import java.util.Scanner;
public class Exercise1 {

	public static void main(String[] args) {
		
		vowelsInInput();
		
	}
	
	public static void vowelsInInput() {
		
		Scanner s = new Scanner(System.in);
		String input;
		System.out.print("Enter a word or phrase: ");
		input = s.nextLine();
		int x = 0;
		for (int i = 0; i < input.length(); i++) {
			
			if (input.toLowerCase().intern().charAt(i) == 'a' || input.toLowerCase().intern().charAt(i) == 'e' || input.toLowerCase().intern().charAt(i) == 'i' || input.toLowerCase().intern().charAt(i) == 'o' || input.toLowerCase().intern().charAt(i) == 'u' || input.toLowerCase().intern().charAt(i) == 'y'){
				
				x++;
				
			}
			
		}
		
		System.out.println("Your input has " + x + " vowels in it");
		
		s.close();
		
		
		
	}

}
