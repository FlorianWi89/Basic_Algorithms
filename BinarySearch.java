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

    /*
     * Python implementation def binSearch(arr,l,r,t): if r >= l: mid = l+(l-r) // 2
     * 
     * if arr[mid] == t : return mid
     * 
     * elif arr[mid] > t : return binSearch(arr,l,mid-1,t)
     * 
     * else: return binSearch(arr,mid+1,r,t)
     * 
     * return -1
     */

}
