package main.company.fb;

import java.util.Arrays;

public class SortColor {

    public void sortColors(int[] nums) {
        if(nums.length<2)
            return;
        int zero = -1;//[0,zero]内的元素都是0
        int two = nums.length;//[zero,nums.length-1]内的元素都是2
        for(int i = 0;i<two&&i>zero;){
            if(nums[i]==0){
                swap(nums,i,++zero);
                if(i==zero)
                    i++;
            }
            if(i<two&&nums[i]==2){
                swap(nums,i,--two);
            }
            if(i<two&&nums[i]==1)
                i++;
        }
    }

    private void swap(int[] nums, int i, int p0) {
        int tmp = nums[p0];
        nums[p0] = nums[i];
        nums[i] = tmp;
    }

    public static void main(String[] args) {
        //int[] nums = {2,0,2,1,1,0};
        int[] nums = {1,2,0};
        SortColor myObj = new SortColor();
        myObj.sortColors(nums);
        System.out.println(Arrays.toString(nums));
    }

}
