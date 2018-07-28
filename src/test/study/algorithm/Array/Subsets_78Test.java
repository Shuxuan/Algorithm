package test.study.algorithm.Array;

import main.study.algorithm.Array.Subsets_78;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class Subsets_78Test {

    @Test
    void subsets() {
        int[] nums = {1,2,3};
        Subsets_78 myObj = new Subsets_78();
        List<List<Integer>> rst = myObj.subsets(nums);
        System.out.println(Arrays.toString(rst.toArray()));

    }
}