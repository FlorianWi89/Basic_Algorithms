public class BinarySearch {

    // O(log N) Time Complexity and O(log N) Space in the recursive approach, O(1)
    // in iterative one
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
