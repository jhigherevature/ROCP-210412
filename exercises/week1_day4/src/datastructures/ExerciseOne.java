package datastructures;

import java.util.ArrayList;
import java.util.List;

public class ExerciseOne {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		List<String> list = new ArrayList<String>();
		String[] array = {"Jaque", "Alex", "Carrie", "Ignacio", "Byron", "Gordon", "Hazel", "Max", 
				"Stephanie", "Dev", "Eric", "Faith"};
		for(String name: array)
		{
			list.add(name);
		}
		System.out.println(list);
	}
}