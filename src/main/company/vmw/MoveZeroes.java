package main.company.vmw;

import java.util.Arrays;

/**
 * Given an array nums, write a function to move all 0's to the end of it while maintaining the relative order of the non-zero elements.
 *
 * Example:
 *
 * Input: [0,1,0,3,12]
 * Output: [1,3,12,0,0]
 * Note:
 *
 * You must do this in-place without making a copy of the array.
 * Minimize the total number of operations.
 *
 */
public class MoveZeroes {

    public void moveZeroes(int[] nums) {
        if(nums == null || nums.length <= 1) {
            return;
        }

        int index1 = 0;
        int index2 = 0;

        while (index1 < nums.length && index2 < nums.length) {
            while ( index1 < nums.length && nums[index1] != 0) {
                index1++;
            }

            //index1 : 0 item

            index2 = index1+1;
            while (index2 < nums.length && nums[index2] == 0 ) {
                index2++;
            }

            if (index1 < nums.length && index2 < nums.length && index2 > index1) {
                nums[index1] = nums[index2];
                nums[index2] = 0;
            }
        }
    }

    public static void main(String[] args) {
        int[] nums = {0,1,0,3,12};
        MoveZeroes myObj = new MoveZeroes();
        myObj.moveZeroes(nums);
        System.out.println(Arrays.toString(nums));
    }

}
