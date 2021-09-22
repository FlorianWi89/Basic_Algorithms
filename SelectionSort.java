public class SelectionSort {

    // O(n^2) Time and O(1) Space
    public static void selSort(int[] array) {

        int len = array.length;

        // move the boundry of the unsorted subarray one by one
        for (int i = 0; i < len - 1; i++) {

            // find the min in the unsorted array
            int minIndex = i;
            for (int j = i + 1; j < len; j++) {
                if (array[j] < array[minIndex])
                    minIndex = j;
            }

            // swap the found min element with the first elem
            int temp = array[minIndex];
            array[minIndex] = array[i];
            array[i] = temp;
        }
    }

    /*
     * Implementation in Python
     * 
     * def selectionSort(array): for i in range(len(array)): minIndex=i for j in
     * range(i+1,len(array)): if array[minIndex] > array[j]: minIndex=j
     * 
     * array[i], array[minIndex] = array[minIndex], array[i]
     */

}
