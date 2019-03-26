package ReverseString;

import java.util.*; 

/* Method: Reverse a String using ListIterator
	1. We copy String contents to an object of ArrayList.
	2. We create a ListIterator object by using the listIterator() method on the LinkedList object.
	3. ListIterator object is used to iterate over the list.
	4. ListIterator object helps us to iterate over the reversed list and print it one by one to the output screen.
*/
class reverseLI 
{
	public static void main(String[] args) 
	{
		String input = "Hello my friend!";
		reverse(input);
	}

	public static void reverse(String str){

		char[] hello = str.toCharArray();
		List<Character> trial1 = new ArrayList<>();

		for (char c: hello)
			trial1.add(c);

		Collections.reverse(trial1);
		ListIterator<Character> li = trial1.listIterator();
		while (li.hasNext())
			System.out.print(li.next());

	}
}