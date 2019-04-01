package main.company.ama3;

public class RectangleOverlap {

    public boolean isRectangleOverlap(int[] rec1, int[] rec2) {
        if (rec1 == null || rec2 == null || rec1.length < 4 || rec2.length < 4) {
            return false;
        }

        int a0 = rec1[0];
        int a2 = rec1[2];

        int b0 = rec2[0];
        int b2 = rec2[2];

        // 盘点interval [a0, a2] 和[b0, b2] 有没有交接
        if (a2 <= b0 || b2 <= a0) {
            return false;
        }

        int a1 = rec1[1];
        int a3 = rec1[3];

        int b1 = rec2[1];
        int b3 = rec2[3];

        if (a3 <= b1 || b3 <= a1) {
            return false;
        }

        return true;
    }

}
