public class MergeSort {

    // the idea is to merge to subarrays of array, arr[l..m],arr[m+1..r]
    public static void merge(int[] array, int left, int middle, int right) {

        // sizes of the two subarrays
        int n1 = middle - left + 1;
        int n2 = right - middle;

        // create temporary arrays
        int[] L = new int[n1];
        int[] R = new int[n2];

        // copy elems to the temp arrays
        for (int i = 0; i < n1; ++i)
            L[i] = array[left + i];
        for (int j = 0; j < n2; ++j)
            R[j] = array[middle + 1 + j];

        // indices of temp arrays
        int i = 0, j = 0;

        // index of merged array
        int k = left;

        // merge the two arrays
        while (i < n1 && j < n2) {
            if (L[i] <= R[j]) {
                array[k] = L[i];
                i++;
            } else {
                array[k] = R[j];
                j++;
            }
            k++;
        }

        // copy remaining elements if there are any
        while (i < n1) {
            array[k] = L[i];
            i++;
            k++;
        }

        while (j < n2) {
            array[k] = R[j];
            j++;
            k++;
        }

    }

    public static void sort(int[] array, int left, int right) {

        if (left < right) {
            int middle = left + (right - left) / 2;

            sort(array, left, middle);
            sort(array, middle + 1, right);

            merge(array, left, middle, right);
        }
    }
}
