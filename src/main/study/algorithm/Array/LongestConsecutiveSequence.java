package main.study.algorithm.Array;

import java.util.HashSet;
import java.util.Set;

public class LongestConsecutiveSequence {

    public int longestConsecutive(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        if (nums.length == 1) {
            return 1;
        }

        Set<Integer> set = new HashSet<>();

        for (int i : nums) {
            set.add(i);
        }

        int max = 1;

        for (int num : nums) {
            int local = 1;
            int candidate = num + 1;
            while (set.contains(candidate)) {
                set.remove(candidate);
                local++;
                candidate++;
            }

            candidate = num - 1;
            while (set.contains(candidate)) {
                set.remove(candidate);
                local++;
                candidate--;
            }

            max = Math.max(max, local);
        }

        return max;
    }

    public static void main(String[] args) {
        int[] nums = {100,4,200,1,3,2};

        LongestConsecutiveSequence myObj = new LongestConsecutiveSequence();
        System.out.println(myObj.longestConsecutive(nums));
    }


}
