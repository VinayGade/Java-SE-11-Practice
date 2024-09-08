package collections;

public class NthLargest_QuickSelect {

    static int findKthLargest(int[] nums, int k) {
        return quickSelect(nums, 0, nums.length - 1, nums.length - k);
    }
    static int quickSelect(int[] nums, int l, int r, int k) {
        int p = partition(nums, l, r);
        if (p < k) return quickSelect(nums, p + 1, r, k);
        if (p > k) return quickSelect(nums, l, p - 1, k);
        return nums[p];
    }
    static int partition(int[] nums, int l, int r) {
        int pivot = nums[r];
        int p = r;
        for (int i = l; i < p; i++) {
            if (nums[i] > pivot) {
                swap(nums, i, p - 1);
                swap(nums, p, p - 1);
                i--;
                p--;
            }
        }
        return p;
    }
    static void swap(int[] nums, int a, int b) {
        int tmp = nums[a];
        nums[a] = nums[b];
        nums[b] = tmp;
    }

    public static void main(String[] args) {
        int arr[] = {7, 10, 4, 3, 20, 15, 70, 90, 25, 50};
        int k = 3;

        int kthLargest = findKthLargest(arr, k);
        System.out.println(kthLargest);
    }
}
