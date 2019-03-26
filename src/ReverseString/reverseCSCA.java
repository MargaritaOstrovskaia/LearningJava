package ReverseString;

class reverseCSCA 
{ 
	public static void main(String[] args) 
	{
		String input = "Hello my friend!";

		reverse1(input);
		reverse2(input);
		reverse3(input);
	}

	/* Method: Reverse a String  by converting string to characters one by one
        1. First, convert String to character array by using the built in Java String class method toCharArray().
        2. Then, scan the string from end  to start, and print the character one by one.
    */
	public static void reverse1(String str) {
		// convert String to character array by using toCharArray
		char[] try1 = str.toCharArray();

		for (int i = try1.length-1; i>=0; i--)
			System.out.print(try1[i]);
		System.out.println();
	}

	/* Method: Reverse a String using swapping of variables
        1. Set the left index equal to 0 and right index equal to the length of the string -1.
        2. Swap the characters of the start index scanning with the last index scanning
            one by one. After that, increase the left index by 1 (left++) and decrease the right
            by 1 i.e., (right--) to move on to the next characters in the character array .
        3. Continue till left is less than or equal to the right.
    */
	public static void reverse2(String str) {
		char[] temparray = str.toCharArray();
		int left, right=0;
		right = temparray.length-1;

		for (left=0; left < right ; left++ ,right--)
		{
			// Swap values of left and right
			char temp = temparray[left];
			temparray[left] = temparray[right];
			temparray[right]=temp;
		}

		for (char c : temparray)
			System.out.print(c);
		System.out.println();
	}

	public static void reverse3(String str) {
		char[] s = str.toCharArray();
		int n = s.length;
		int halfLength = n / 2;

		for (int i=0; i<halfLength; i++) {
			char temp = s[i];
			s[i] = s[n-1-i];
			s[n-1-i] = temp;
		}

		System.out.println(s);
	}
}