package main.study.algorithm.Array;

public class LongestTurbulentSubarray {

    public int maxTurbulenceSize(int[] A) {
        if (A.length <= 2) {
            return A.length;
        }
        int res = 0;
        int N = A.length;
        boolean up = false;
        for (int i = 0; i < N-1; ) {
            int end = i+1;
            if (A[end-1] < A[end]) {
                up = true;
            } else if (A[end - 1] > A[end]){
                up = false;
            } else {
                // same value
                res = Math.max(1, res);
            }
            end++;
            while (end < N) {
                if (up) {
                    //down
                    if (A[end-1] > A[end]) {
                        end++;
                        up = false;
                    }else {
                        break;
                    }
                } else {
                    //up
                    if ((A[end-1] < A[end])) {
                        end++;
                        up = true;
                    } else
                        break;
                }
            }

            res = Math.max(res, end - i);
            i = end - 1;
        }

        return res;
    }

    public static void main(String[] args) {
        //int[] A = {9,4,2,10,7,8,8,1,9};
        int[] A = {4, 8, 12, 16};

        LongestTurbulentSubarray myObj = new LongestTurbulentSubarray();
        System.out.println(myObj.maxTurbulenceSize(A));
    }

}
