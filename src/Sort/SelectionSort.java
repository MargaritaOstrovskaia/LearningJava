package Sort;

public class SelectionSort {
    public static void main(String[] args) {
        int array[] = {64,25,12,22,11};
        sort(array);

        System.out.println("Selection sort.\nSorted array: ");
        for (int i : array)
            System.out.print(i + " ");
    }

    public static void sort(int array[])
    {
        // loop from the first to second-last element
        for (int i = 0; i < (array.length - 1); i++)
        {
            // find the smallest data in the subarray
            int smallest = i;
            for (int j = i; j < array.length; j++)
                if (array[j] < array[smallest])
                    smallest = j;

            // swap the current position with the smallest item
            swap(array, i, smallest);
        }
    }

    private static void swap(int[] array, int a, int b)
    {
        int temp = array[a];
        array[a] = array[b];
        array[b] = temp;
    }
}
