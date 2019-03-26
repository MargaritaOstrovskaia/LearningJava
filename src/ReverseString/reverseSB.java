package ReverseString;

import java.lang.*;

// Method: Reverse String using StringBuilder
class reverseSB
{ 
	public static void main(String[] args) 
	{ 
		String input = "Hello my friend!";
		System.out.println(reverse(input));
	}

	public static String reverse(String str) {
		StringBuilder builder = new StringBuilder();

		// append a string into StringBuilder input1
		builder.append(str);

		// reverse StringBuilder input1
		builder = builder.reverse();

		// print reversed String
		return builder.toString();
	}
}