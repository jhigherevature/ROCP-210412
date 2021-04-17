package iteration;

import java.util.HashMap;
import java.util.Map;

public class MapSimluator {
	public static void main(String[] args) {
		System.out.println("::: Maps :::");
		Map<String, Integer> hMap = new HashMap<String, Integer>();
		hMap.put("Assembly", 1);
		hMap.put("Binary", 2);
		hMap.put("Compile", 3);
		hMap.put("Compile", 4);
		hMap.put("Compile", 5);
		hMap.put("DataStructure", 6);
		hMap.put("Function", 7);

		System.out.println("Map - KeySet Loop");
		for (String key : hMap.keySet()) {
			System.out.println("Key is: " + key);
		}

		System.out.println("Map - Values Loop");
		for (Integer num : hMap.values()) {
			System.out.println("Values: " + num);
		}

		System.out.println("Map - EntrySet Loop");
		for (Map.Entry<String, Integer> entry : hMap.entrySet()) {
			System.out.println("Key: " + entry.getKey() + ", Value: " + entry.getValue());
		}
	}
}
