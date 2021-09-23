public class QuickSort {

    // O(N log N) Time in AVC and o(n^2) in WC

    // helper function to swap two elems
    public static void swap(int[] array, int x, int y) {
        int temp = array[x];
        array[x] = array[y];
        array[y] = temp;
    }

    // placec the pivot to the right position, it placec smaller
    // elems to the left of pivot and greater to the right
    public static int partition(int[] array, int low, int high) {

        // select pivot
        int pivot = array[high];

        int i = low - 1;

        for (int j = low; j <= high - 1; j++) {
            if (array[j] < pivot) {
                i++;
                swap(array, i, j);
            }
        }
        swap(array, i + 1, high);
        return (i + 1);
    }

    public static void qSort(int[] array, int low, int high) {
        if (low < high) {
            int pi = partition(array, low, high);
            qSort(array, low, pi - 1);
            qSort(array, pi + 1, high);
        }
    }
}
