package main.study.algorithm.Array;

import java.util.Arrays;

public class FindCele {
    int[][] data;
    public FindCele(int[][] data) {
        this.data = data;
    }
    public int findCelebrity(int n) {
        boolean[] cele = new boolean[n];
        Arrays.fill(cele, true);
        for (int i = 0; i < n; i++) {
            for (int j = i+1; j < n; j++) {
                if (knows(i, j) || !knows(j, i)) {
                    cele[i] = false;
                    break;
                } else {
                    cele[j] = false;
                }
            }
        }

        for (int i = 0; i < n; i++) {
            if (cele[i])
                return i;
        }

        return -1;
    }
    private boolean knows(int i, int j) {
        if (data[i][j] == 1) {
            return true;
        }

        return false;
    }
    public static void main(String[] args) {
        int[][] data = {{1,0},{0,1}};
        int n = 2;
        FindCele myObj = new FindCele(data);
        System.out.println(myObj.findCelebrity(n));
    }
}
