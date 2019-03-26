package Sort;

public class QuickSort {
    public static void main(String[] args) {
        int array[] = {64, 34, 25, 12, 22, 11, 90};
        sort(array, 0, array.length-1);

        System.out.println("Quick sort.\nSorted array: ");
        for (int i : array)
            System.out.print(i + " ");
    }

    /* This function takes last element as pivot, position in sorted array, and places all
       smaller (smaller than pivot) to left of pivot and all greater elements to right of pivot */
    private static int partition(int array[], int low, int high)
    {
        int pivot = array[high];
        int i = (low-1); // index of smaller element
        for (int j=low; j<high; j++) {
            // If current element is smaller than or equal to pivot
            if (array[j] <= pivot) {
                i++;
                swap(array, i, j);
            }
        }
        swap(array, i+1, high);

        return i+1;
    }

    /* The main function that implements QuickSort()
      arr[] --> Array to be sorted,
      low  --> Starting index,
      high  --> Ending index */
    public static void sort(int array[], int low, int high)
    {
        if (low < high)
        {
            // pi is partitioning index, arr[pi] is now at right place
            int pi = partition(array, low, high);

            // Recursively sort elements before partition and after partition
            sort(array, low, pi-1);
            sort(array, pi+1, high);
        }
    }

    private static void swap(int[] array, int a, int b)
    {
        int temp = array[a];
        array[a] = array[b];
        array[b] = temp;
    }
}
