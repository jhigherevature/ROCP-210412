package nested_loops;

public class Bonus1 {
	
	public static void main(String[] args) {
	
		int x = 1;
		
		System.out.println("All the alphabet:");
	for (char letter = 'a'; letter <= 'z'; letter++) {
		
		System.out.print(letter);
		
		for(int position = x; position <= 26; ) {
			
			System.out.println(" - " + position);
			x++;
			break;
			
		}
		
	}
	
	System.out.println("Alphabet without vowels");
	int y = 1;
	for (char letter = 'a'; letter <= 'z'; letter++) {
		if (y == 1 || y == 5 || y == 9 || y == 15 || y == 21 || y == 25) {
			
			y++;
			continue;
			
		}
		System.out.print(letter);
		
		for(int position = y; position <= 26; ) {
			
			System.out.println(" - " + position);
			y++;
			break;
			
		}
		
	}

}
	
}

