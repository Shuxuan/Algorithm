package test.study.algorithm.Array;

import main.study.algorithm.Array.CombinationSum_39;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class CombinationSum_39Test {

    @Test
    void combinationSum() {

        int[] nums = {2,3,6,7};
        int target = 7;
        CombinationSum_39 myclass = new CombinationSum_39();
        List<List<Integer>> rst = myclass.combinationSum(nums, 7);
        List<Integer> ans1 = new ArrayList<>();
        ans1.add(2);
        ans1.add(2);
        ans1.add(3);
        List<Integer> ans2 = new ArrayList<>();
        ans2.add(7);

        assertEquals(ans1, rst.get(0));
        assertEquals(ans2, rst.get(1));
    }
}