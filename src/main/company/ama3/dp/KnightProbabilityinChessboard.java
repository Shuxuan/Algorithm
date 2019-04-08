package main.company.ama3.dp;

import java.util.*;

public class KnightProbabilityinChessboard {

    Map<int[], List<int[]>> map;
    public double knightProbability(int N, int K, int r, int c) {
        map = new HashMap<>();

        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{r,c});

        int count = 0;
        double divid = 1.0;
        while ( count < K && !queue.isEmpty()) {

            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int[] curr = queue.poll();
                if (!map.containsKey(curr)) {
                    List<int[]> items = move(N, curr[0], curr[1]);
                    map.put(curr, items);
                }
                queue.addAll(map.get(curr));
            }

            divid *= 8.0;
            count++;
        }

        return queue.size()/divid;

    }

    private List<int[]> move(int N, int r, int c) {
        List<int[]> ans = new ArrayList<>();

        // up, down,left, right
        int[] r1 = {0, 0, -2, 2};
        int[] c1 = {2, -2, 0, 0};

        int[] r2 = {-1,1, -1, 1, 0, 0, 0, 0};
        int[] c2 = {0, 0, 0, 0, -1, 1, -1, 1};

        int count = 0;
        for (int i = 0; i < 4; i++) {
            int a = r + r1[i];
            int b = c + c1[i];
            if (a >= N || a < 0) continue;
            if (b >= N || b < 0) continue;
            int tmp_r1 = a + r2[2 * i];
            int tmp_c1 = b + c2[2 * i];
            if (tmp_r1 >= 0 && tmp_r1 < N && tmp_c1 >= 0 && tmp_c1 < N)
                ans.add(new int[]{tmp_r1, tmp_c1});

            int tmp_r2 = a + r2[2 * i + 1];
            int tmp_c2 = b + c2[2 * i + 1];
            if (tmp_r2 >= 0 && tmp_r2 < N && tmp_c2 >= 0 && tmp_c2 < N)
                ans.add(new int[]{tmp_r2, tmp_c2});

        }

        return ans;
    }

    public static void main(String[] args) {
        int N = 3;
        int K = 2;
        int r = 0;
        int c = 0;

        KnightProbabilityinChessboard myObj = new KnightProbabilityinChessboard();
        double ans = myObj.knightProbability(N, K, r, c);
        System.out.println(ans);

    }

}
