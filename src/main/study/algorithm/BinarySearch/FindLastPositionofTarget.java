package main.study.algorithm.BinarySearch;

public class FindLastPositionofTarget {

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 3, 4, 5, 10};
        int target = 3;

        FindLastPositionofTarget myObj = new FindLastPositionofTarget();
        int rst = myObj.lastPosition(nums, target);
        System.out.println(rst);

    }

    public int lastPosition(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return -1;
        }

        int rst = -1;
        int start = 0;
        int end = nums.length - 1;
        while (start + 1 < end) {
            int mid = (start + end) >> 1;
            if (nums[mid] > target) {
                end = mid;
            } else if (nums[mid] < target)
                start = mid;
            else
                start = mid;
        }
        if (nums[end] == target)
            rst = end;
        else if (nums[start] == target) {
            rst = start;
        }

        System.out.println("start : " + start);
        System.out.println("end : " + end);
        return rst;
    }

}
