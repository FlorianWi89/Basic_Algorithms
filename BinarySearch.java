public class BinarySearch {

    public static int binSearch(int[] array, int left, int right, int target) {
        if (right >= left) {

            int middle = left + (right - left) / 2;

            if (array[middle] == target) {
                return middle;
            }

            if (array[middle] > target) {
                return binSearch(array, left, middle - 1, target);
            } else {
                return binSearch(array, middle + 1, right, target);
            }
        }
        return -1;
    }

}
