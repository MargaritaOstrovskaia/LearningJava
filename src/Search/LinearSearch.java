package Search;

public class LinearSearch {
    public static void main(String[] args) {
        String input = "The linear search is the simplest possible algorithm for searching data; it is however, the least efficient";
        System.out.println("Linear search.");
        System.out.println(input);
        char find = 's';
        int index = search(input.toCharArray(), find);
        System.out.println(String.format("Index '%s' = %d", find, index));
    }

    public static int search(char[] data, char key)
    {
        // iterate through the array
        for (int i = 0; i < data.length; i++) {
            // if the data matches the key, return the index
            if (data[i] == key)
                return i;
        }

        // if the iteration concludes, return -1 as a signal that the data was not found
        return -1;
    }
}
