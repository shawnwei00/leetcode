/**
 * There are two sorted arrays nums1 and nums2 of size m and n respectively. 
 * Find the median of the two sorted arrays. The overall run time complexity should be O(log (m+n)).
 *
 */

public class MedianOfTwoSortedArrays {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;
        int k = m + n;
        
        if (k % 2 != 0) {
            return findKthElement(nums1, 0, nums2, 0, k/2+1);
        } else {
            return findKthElement(nums1, 0, nums2, 0, k/2)/2.0 + findKthElement(nums1, 0, nums2, 0, k/2+1)/2.0;
        }
    }
    
    private int findKthElement(int[] A, int a, int[] B, int b, int k) {
        if (A.length-a > B.length-b) {
            return findKthElement(B, b, A, a, k);
        }
        
        if (A.length <= a) {
            return B[b+k-1];
        }
        
        if (k == 1) {
            return Math.min(A[a], B[b]);
        }
        
        int midA = Math.min(k/2, A.length-a);
        int midB = k - midA;
        
        if (A[a+midA-1] > B[b+midB-1]) {
            return findKthElement(A, a, B, b+midB, k-midB);
        } else if (A[a+midA-1] < B[b+midB-1]) {
            return findKthElement(A, a+midA, B, b, k-midA);
        } else {
            return A[a+midA-1];
        }
    }
}