package ReverseString;  

/* Method: Converting String Into Bytes 
	1. Create a temporary byte[]  of length equal to the length of the input string.
	2. Store the bytes (which we get by using getBytes() method) in reverse order into the temporary byte[] .
	3. Create a new String abject using byte[] to store result.
*/
class reverseCSIB
{ 
	public static void main(String[] args) 
	{ 
		String input = "Hello my friend!";
		System.out.println(reverse(input));
	}

	public static String reverse(String str){
		// getBytes() method to convert string into bytes[].
		byte [] strAsByteArray = str.getBytes();
		byte [] result = new byte [strAsByteArray.length];

		// Store result in reverse order into the result byte[]
		for (int i = 0; i<strAsByteArray.length; i++)
			result[i] = strAsByteArray[strAsByteArray.length-i-1];

		return new String(result);
	}
}