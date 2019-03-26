package Search;

public class BinarySearch {
    public static void main(String[] args) {
        int input[] = { 2, 3, 4, 10, 40 };
        System.out.println("Binary Search.");
        int find = 40;
        int index = search(input, find);
        System.out.println(String.format("Index '%d' = %d", find, index));
    }

    /*
        Algorithm
        The basic algorithm above can be refined into psuedocode:

        set left to 0, right to last element
        while left < right:
            calculate middle as (left + right) / 2
            if data[middle] = target, return middle
            else if data[middle] < target, set left to middle + 1
            else if data[middle] > target, set right to middle - 1
        return search failure
     */
    public static int search(int[] data, int key)
    {
        // initialise index variables
        int middle, left = 0, right = data.length;

        // while the bounds have not crossed
        while (left < right) {
            // find the midpoint of the data set
            middle = (left + right) / 2;

            // if there is a match, return the index
            if (data[middle] == key)
                return middle;
            // if the middle is too small, chop off the left half
            else if (data[middle] < key)
                left = middle + 1;
            // or if too large, chop off the right-hand half
            else if (data[middle] > key)
                right = middle - 1;
        }

        // if the while loop has completed without result, signal a search failure
        return -1;
    }
}
