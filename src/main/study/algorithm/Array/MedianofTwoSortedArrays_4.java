package main.study.algorithm.Array;

/**
 * There are two sorted arrays nums1 and nums2 of size m and n respectively.
 *
 * Find the median of the two sorted arrays. The overall run time complexity should be O(log (m+n)).
 *
 * Example 1:
 * nums1 = [1, 3]
 * nums2 = [2]
 *
 * The median is 2.0
 * Example 2:
 * nums1 = [1, 2]
 * nums2 = [3, 4]
 *
 * The median is (2 + 3)/2 = 2.5
 */
public class MedianofTwoSortedArrays_4 {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {

        int total = nums1.length + nums2.length;
        if (total % 2 == 0) {
            return (findKth(nums1, 0, nums2, 0, total/2) +
                    findKth(nums1, 0, nums2, 0, total/2+1)
            )/2;
        } else
            return findKth(nums1, 0, nums2, 0, total/2 + 1);

    }

    private double findKth(int A[], int startofA, int B[], int startofB, int k) {
        //always assume that m is equal or smaller than n
        if (startofA >= A.length) {
            return B[startofB + k - 1];
        }
        if (startofB >= B.length) {
            return A[startofA + k - 1];
        }
        if (k == 1) {
            return Math.min(A[startofA], B[startofB]);
        }

        int halfKthofA =  startofA + k/2 - 1 < A.length? A[startofA + k/2 - 1] : Integer.MAX_VALUE;
        int halfKthofB = startofB + k/2  -1 < B.length ? B[startofB + k/2 - 1] : Integer.MAX_VALUE;

        if (halfKthofA < halfKthofB) {
            return findKth(A, startofA + k/2, B, startofB, k-k/2);
        }else {
            return findKth(A, startofA, B, startofB+  k/2, k-k/2);
        }
    }

    public static void main(String[] args) {
        int[] nums1 = {1,3};
        int[] nums2 = {2};

        MedianofTwoSortedArrays_4 median = new MedianofTwoSortedArrays_4();
        double rst = median.findMedianSortedArrays(nums1, nums2);
        System.out.println(rst);
    }
}
