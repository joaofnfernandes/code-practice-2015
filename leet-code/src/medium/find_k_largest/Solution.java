package medium.find_k_largest;

// Uses a modified heapsort with max heap to find the Kth largest number in an array
// O(nlogn) to construct the heap + O(klogn) to find Kth largest
public class Solution {
    public int findKthLargest(int[] nums, int k) {
        if(nums == null || nums.length < 1 ||
           k < 1 || k > nums.length) { 
                return -1; 
            }
        int N = nums.length - 1;

        // ensure heap invariant
        for (int i = N/2; i >=0; i--) {
            sink(nums, i, N);
        }

        // Move largest number to the end of the array, and sink new root element
        // If K == N, this revert-sorts the array
        while(nums.length - N <= k) {
            swap(nums, 0, N--);
            sink(nums, 0, N);
        }
        return nums[nums.length - k];
    }
    
    // Swaps elements in an array
    private void swap(int[] nums, int i, int j) {
        int aux = nums[i];
        nums[i] = nums[j];
        nums[j] = aux;
    }
    
    // Sinks element i on the heap, to at most N
    private void sink(int[] nums, int i, int N) {
        while(2 * i + 1 <= N) {
            int maxIndex = 2 * i + 1;
            if(maxIndex + 1 <= N && nums[maxIndex] < nums[maxIndex + 1]) { 
                maxIndex++; 
            }
            if(nums[i] < nums[maxIndex]) {
                swap(nums, i, maxIndex);
                i = maxIndex;
            } else {
                break;
            }
        }
    }
}