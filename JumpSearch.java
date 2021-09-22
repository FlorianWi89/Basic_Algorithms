
public class JumpSearch {

    // Time of O(sqrt(n)), Space of O(1), is between linear and binary Search
    public static int jumpSrch(int[] array, int target) {

        int len = array.length;

        // Ideal jump size is sqrt(array.length)
        int step = (int) Math.floor(Math.sqrt(len));

        int prev = 0;

        while (array[Math.min(step, len) - 1] < target) {
            prev = step;
            step += (int) Math.floor(Math.sqrt(len));
            if (prev >= len)
                return -1;
        }

        while (array[prev] < target) {
            prev++;

            if (prev == Math.min(step, len))
                return -1;
        }

        if (array[prev] == target)
            return prev;

        return -1;
    }

    /*
     * Implementation in Python def jumpSearch(arr,t): n=len(arr) step=math.sqrt(n)
     * 
     * prev =0
     * 
     * while arr[int(math.min(step,n)-1)] < t: prev=step step+=step if prev >= n:
     * return -1
     * 
     * while arr[int(prev)] < t: prev+=1
     * 
     * if prev == min(step,n): return -1
     * 
     * if arr[prev] == t: return prev
     * 
     * return -1
     * 
     */

}
