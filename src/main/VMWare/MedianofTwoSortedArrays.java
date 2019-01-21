package main.VMWare;

import java.util.ArrayList;
import java.util.Arrays;

/**
 *
 * There are two sorted arrays nums1 and nums2 of size m and n respectively.
 *
 * Find the median of the two sorted arrays. The overall run time complexity should be O(log (m+n)).
 *
 * You may assume nums1 and nums2 cannot be both empty.
 *
 * Example 1:
 *
 * nums1 = [1, 3]
 * nums2 = [2]
 *
 * The median is 2.0
 * Example 2:
 *
 * nums1 = [1, 2]
 * nums2 = [3, 4]
 *
 * The median is (2 + 3)/2 = 2.5
 *
 */
public class MedianofTwoSortedArrays {

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {



        int len1 = (nums1 == null) ? 0 : nums1.length;
        int len2 = (nums2 == null) ? 0 : nums2.length;

        int len = len1 + len2;

        if (len % 2 == 0) {
            return (findKth(nums1, nums2, 0, len1, 0, len2, len/2) + findKth(nums1, nums2, 0,len1, 0, len2, len/2 + 1)) /2.0;
        } else
            return findKth(nums1, nums2, 0, len1, 0, len2, len/2 + 1);




    }

    /**
     * //参考思路 https://www.jianshu.com/p/9bd57fd52062
     *
     * nums1和nums2表示原始的两个数组，
     * start1、len1表示nums1数组中以start1位置开始、len1长度的一个子数组；
     * start2、lens2表示nums2数组中以start2位置开始、len2长度的一个子数组；
     * k表示从这两个子数组中找到第k小的数。之所以提供start1、len1、start2、len2，是因为经验告诉我们分治法解决问题都是递归的，我们在二分的时候就需要记录这些相关的数据。
     *

     * @param nums1
     * @param nums2
     * @param start1
     * @param len1
     * @param start2
     * @param len2
     * @param k
     * @return
     */
    public int findKth(int[] nums1, int[] nums2, int start1, int len1, int start2, int len2, int k) {
        if (len1 > len2) {
            return findKth(nums2, nums1, start2, len2, start1, len1, k);
        }

        if (len1 == 0) {
            return nums2[start2 + k - 1];
        }
        if (k == 1) {
            return Math.min(nums1[start1], nums2[start2]);
        }

        //容易被忽略的边界问题，那就是p=k/2这一句，如果p大于len1的话，就会出现越界访问的问题，这个时候需要对其进行控制
        int p = Math.min(k/2, len1);
        int q = k - p;

        if (nums1[start1 + p - 1] == nums2[start2 + q - 1]) {
            return nums1[start1 + p - 1];
        } else if (nums1[start1 + p - 1] > nums2[start2 + q - 1]) {
            //可以舍弃nums2中的从start2开始的前q个
            return findKth(nums1, nums2, start1, len1, start2 + q, len2 - q, k-q);
        } else {
            //可以舍弃nums1中的从start1开始的前p个
            return findKth(nums1, nums2, start1 + p, len1 - p, start2, len2, k - p);
        }

    }

    public static void main(String[] args) {
        int[] nums1 = {1};
        int[] nums2 = {2,3,4,5,6};

        MedianofTwoSortedArrays myTest = new MedianofTwoSortedArrays();
        System.out.println(myTest.findMedianSortedArrays(nums1, nums2));
    }

}
