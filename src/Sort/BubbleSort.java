package Sort;

public class BubbleSort {
    public static void main(String[] args) {
        int array[] = {64, 34, 25, 12, 22, 11, 90};
        sort(array);

        System.out.println("Bubble sort.\nSorted array: ");
        for (int i : array)
            System.out.print(i + " ");
    }

    public static void sort(int array[])
    {
        int n = array.length;
        for (int i = 0; i < n-1; i++)
            for (int j = 0; j < n-i-1; j++)
                if (array[j] > array[j+1]) {
                    // swap arr[j+1] and arr[i]
                    int temp = array[j];
                    array[j] = array[j+1];
                    array[j+1] = temp;
                }
    }
}
