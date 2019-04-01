package main.company.airb2;

// given int array, and threshold, find the minimum number bigger than threshhold
//[1,1,2,2,2], 11243

import java.util.ArrayList;
import java.util.Arrays;

public class MinimumNumberBiggerThanThreshold {

    int[] count;

    public int getMin(int[] nums, int threshold) {
        if (nums == null || nums.length == 0) {
            return -1;
        }

        int res = 0;
        count = new int[10];
        for (int i : nums) {
            count[i]++;
        }

        System.out.println("*******************count*********************");
        System.out.println(Arrays.toString(count));
        System.out.println("*******************count*********************");

        // transfer threshold to digit
        int temp = threshold;
        ArrayList<Integer> array = new ArrayList<Integer>();
        do{
            array.add(0, temp % 10);
            temp /= 10;
        } while  (temp > 0);

        System.out.println(Arrays.toString(array.toArray()));

        int[] resArray = new int[array.size()];
        int index = 0;
        boolean flag = false;
        for (int i : array) {
            System.out.println(i);
            // find i from the count
            if (count[i] > 0) {
                resArray[index++] = i;
                count[i]--;
            } else {
                // find bigger value
                int tmp = i + 1;
                while (tmp < 10) {
                    if (count[tmp] > 0) {
                        resArray[index++] = tmp;
                        count[tmp]--;
                        break;
                    }
                    tmp++;
                }
                // can not find bigger value, move to previous index, increase the value
                if (tmp == 10) {
                    // find the prevous index with bigger value
                    while (index > 1) {
                        index--;
                        int digit = resArray[index];

                        for (int j = digit+ 1; j < 10; j++) {
                            if (count[j] > 0) {
                                count[digit]++;
                                resArray[index++] = j;
                                flag = true;
                                break;
                            }
                        }

                        if (flag) {
                            for (int k = index; k < array.size(); k++) {
                                resArray[k] = getMin();
                            }
                            return array2Int(resArray);
                        }
                    }

                }
            }
        }

        System.out.println(Arrays.toString(resArray));
        return array2Int(resArray);
    }

    private int array2Int(int[] array) {
        int res = 0;
        for (int i = 0; i < array.length; i++) {
            res = res * 10 + array[i];
        }
        System.out.println("result : " + res);
        return res;
    }

    private int getMin() {
        for (int i = 0; i < 10; i++) {
            if (count[i] > 0) {
                count[i]--;
                return i;
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        int[] nums = {1,1,2,2,2};
        //int threshold = 11211;
        int threshold = 11243;
        MinimumNumberBiggerThanThreshold myObj = new MinimumNumberBiggerThanThreshold();
        int res = myObj.getMin(nums, threshold);

        System.out.println("res : " + res);
    }
}
