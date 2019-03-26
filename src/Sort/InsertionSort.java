package Sort;

public class InsertionSort {
    public static void main(String[] args) {
        int array[] = {64,25,12,22,11};
        sort(array);

        System.out.println("Selection sort.\nSorted array: ");
        for (int i : array)
            System.out.print(i + " ");
    }

    public static void sort(int[] array)
    {
        // loop through all array elements except the first
        for (int i = 1; i < array.length; i++)
        {
            // store current data and initial insertion position
            int key = array[i];
            int insertPos = i;

            // if necessary, shuffle elements across until the correct insertion position is found for the data
            while ( (insertPos > 0) && (array[insertPos-1] > key) ) {
                array[insertPos] = array[insertPos-1];
                insertPos--;
            }

            // insert data into the insertion position
            array[insertPos] = key;
        }
    }
}
