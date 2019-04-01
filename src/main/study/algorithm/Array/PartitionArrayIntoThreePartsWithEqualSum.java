package main.study.algorithm.Array;

public class PartitionArrayIntoThreePartsWithEqualSum {

    public boolean canThreePartsEqualSum(int[] A) {
        if (A == null || A.length <= 2)
            return false;
        int N = A.length;
        int[] sum = new int[N];
        sum[0] = A[0];

        for (int i = 1; i < N; i++) {
            sum[i] = sum[i-1] + A[i];
        }

        if (sum[N-1] % 3 != 0) return false;
        int sub = sum[N-1] / 3;

        boolean sub1 = false;
        int i = 0;
        for (; i < N; i++ ) {
            if (sum[i] == sub) {
                sub1 = true;
                break;
            }

        }

        boolean sub2 = false;
        for (int j = i+1; j < N; j++) {
            if (sum[j] == sub * 2) {
                sub2 = true;
                break;
            }

        }

        return sub1 && sub2;
    }

    public static void main(String[] args) {
        int[] A = {6,1,1,13,-1,0,-10,20};
        PartitionArrayIntoThreePartsWithEqualSum myObj = new PartitionArrayIntoThreePartsWithEqualSum();
        System.out.println(myObj.canThreePartsEqualSum(A));
    }
}
