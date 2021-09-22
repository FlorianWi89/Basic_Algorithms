public class BubbleSort {

    public static void bubbleSrt(int[] array) {
        int len = array.length;
        // traverse through all elems
        for (int i = 0; i < len - 1; i++) {
            // last i elems are already in place
            for (int j = 0; j < len - i - 1; j++) {
                // swap elems if the current elem is greater than the next one
                if (array[j] > array[j + 1]) {

                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }
            }
        }
    }
}
