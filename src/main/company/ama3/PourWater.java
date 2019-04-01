package main.company.ama3;

public class PourWater {

    /**
     * 首先我们尝试向左走，找到第一个局部最低点，停止条件是左边的高度大于当前高度，
     * 但是为了防止出现大家高度都一样而需要停止在靠近起始点位置的情况，
     * 我们来一个回滚操作，就是只要和右边的高度一样，就一直往右滚。
     * 同样，在尝试向右走，找第一个局部最低点，停止条件是右边的高度大于当前高度，但是为了防止出现大家高度都一样而需要停止在靠近起始点位置的情况，我们也来一个回滚操作，就是只要和左边的高度一样，就一直往左滚。那么此时我们来做比较，如果左边的局部最低点小于雨滴落下位置的高度，那么左边局部最低点高度自增1。否则如果右边的局部最低点高度小于雨滴落下位置的高度，则右边局部最低点高度自增1。如果左右高度都一样，则雨滴落下位置的高度自增1，
     *
     * @param H
     * @param V
     * @param K
     * @return
     */
    public int[] pourWater(int[] H, int V, int K) {
        for (int i = 0; i < V; i++) {
            int l = K;
            int r = K;
            int n = H.length;
            while (l > 0 && H[l] >= H[l - 1]) l--;
            while (l < K && H[l] == H[l + 1]) l++;
            while (r < n && H[r] >= H[r - 1]) r++;
            while (r > K && H[r] == H[r - 1]) r--;
            if (H[l] < H[K]) {
                H[l]++;
            } else {
                H[r]++;
            }
        }
        return H;
    }

}
