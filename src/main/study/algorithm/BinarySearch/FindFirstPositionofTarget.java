package main.study.algorithm.BinarySearch;

public class FindFirstPositionofTarget {
    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 3, 4, 5, 10};
        int target = 3;

        FindFirstPositionofTarget myObj = new FindFirstPositionofTarget();
        int rst = myObj.firsPosition(nums, target);
        System.out.println(rst);

    }

    public int firsPosition(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return -1;
        }

        int rst = -1;
        int start = 0;
        int end = nums.length - 1;
        while (start + 1 < end) {
            int mid = (start + end) >> 1;
            if (nums[mid] >= target) {
                end = mid;
            } else
                start = mid;
        }
        if (nums[start] == target)
            rst = start;
        else if (nums[end] == target) {
            rst = end;
        }

        System.out.println("start : " + start);
        System.out.println("end : " + end);

        return rst;
    }
}
