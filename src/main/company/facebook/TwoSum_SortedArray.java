package main.company.facebook;

public class TwoSum_SortedArray {
    public int[] twoSum(int[] numbers, int target) {
        int l = 0;
        int r = numbers.length - 1;
        int[] rst = new int[2];
        while (l < r) {
            int sum = numbers[l] + numbers[r];
            if (sum == target) {
                rst[0] = l;
                rst[1] = r;
            } else if (sum < target) {
                l++;
            } else
                r--;
        }

        return rst;

    }

}
