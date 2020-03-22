package tudelft.roman;

import java.util.HashMap;

public class RomanNumeral {

	private HashMap<String, Integer> table;

	public RomanNumeral() {
		this.table = new HashMap<>();
		table.put("I", 1);
		table.put("V", 5);
		table.put("X", 10);
		// ...
	}

	public int parse(String input) {
		int total = 0;
		for(int i = 0; i < input.length(); i++) {
			total += table.get(String.valueOf(input.charAt(i)));
			// to be continued...

		}
		return total;

	}
}
