public class QuickSelect {

    public static void swap(int[] arr, int x, int y) {
        int temp = arr[x];
        arr[x] = arr[y];
        arr[y] = temp;
    }

    // WC of O(N^2) but in AVC O(N)
    public static int partition(int[] nums, int low, int high) {
        int pivot = nums[high], pivotLoc = low;
        for (int i = low; i <= high; i++) {
            if (nums[i] < pivot) {
                swap(nums, nums[i], pivotLoc);
                pivotLoc++;
            }
        }
        swap(nums, high, pivotLoc);

        return pivotLoc;
    }

    public static int findKthSmallest(int[] nums, int low, int high, int k) {
        int partition = partition(nums, low, high);

        if (partition == k - 1) {
            return nums[partition];
        } else if (partition < k - 1) {
            return findKthSmallest(nums, partition + 1, high, k);
        } else {
            return findKthSmallest(nums, low, partition - 1, k);
        }
    }

}
