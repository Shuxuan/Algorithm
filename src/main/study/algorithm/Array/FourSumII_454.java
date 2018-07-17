package main.study.algorithm.Array;

import java.util.Arrays;
import java.util.HashMap;

/*

https://leetcode.com/problems/4sum-ii/description/

Given four lists A, B, C, D of integer values, compute how many tuples (i, j, k, l) there are such that A[i] + B[j] + C[k] + D[l] is zero.

To make problem a bit easier, all A, B, C, D have same length of N where 0 ≤ N ≤ 500. All integers are in the range of -228 to 228 - 1 and the result is guaranteed to be at most 231 - 1.

Example:

Input:
A = [ 1, 2]
B = [-2,-1]
C = [-1, 2]
D = [ 0, 2]

Output:
2

Explanation:
The two tuples are:
1. (0, 0, 0, 1) -> A[0] + B[0] + C[0] + D[1] = 1 + (-2) + (-1) + 2 = 0
2. (1, 1, 0, 0) -> A[1] + B[1] + C[0] + D[0] = 2 + (-1) + (-1) + 0 = 0


 */
public class FourSumII_454 {
    /*
    brute force impl
     */
    public int fourSumCount_bruteforce(int[] A, int[] B, int[] C, int[] D) {
        int rst = 0;
        if (A == null || B == null || C == null || D == null)
            return rst;
        if (A.length < 1 || B.length < 1 || C.length < 1 || D.length < 1)
            return rst;

        Arrays.sort(A);
        Arrays.sort(B);
        Arrays.sort(C);
        Arrays.sort(D);
        for (int i = 0; i < A.length; i++) {

            for (int j = 0; j < B.length; j++) {


                for (int k = 0; k < C.length; k++) {


                    for (int g = 0; g < D.length; g++) {


                        if (A[i] + B[j] + C[k] + D[g] == 0) {
                            rst++;
                        }
                    }


                }


            }
        }
        return rst;
    }

    /*

     */
    public int fourSumCount(int[] A, int[] B, int[] C, int[] D) {
        int rst = 0;
        if (A == null || B == null || C == null || D == null)
            return rst;
        if (A.length < 1 || B.length < 1 || C.length < 1 || D.length < 1)
            return rst;

        Arrays.sort(A);
        Arrays.sort(B);
        Arrays.sort(C);
        Arrays.sort(D);

        HashMap<Integer, Integer> ab = new HashMap<>();
        for (int a : A) {
            for (int b : B) {
                ab.put(a+b, ab.getOrDefault(a+b, 0) + 1);
            }
        }

        for (int c : C) {
            for (int d : D) {
                int part2 = c + d;
                int part1 = - part2;
                rst += ab.getOrDefault(part1, 0);
            }
        }
        return rst;
    }

}
