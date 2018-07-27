package main.study.algorithm.Array;

/**
 *
 * https://leetcode.com/problems/search-a-2d-matrix/description/
 *
 * Write an efficient algorithm that searches for a value in an m x n matrix. This matrix has the following properties:
 *
 * Integers in each row are sorted from left to right.
 * The first integer of each row is greater than the last integer of the previous row.
 * Example 1:
 *
 * Input:
 * matrix = [
 *   [1,   3,  5,  7],
 *   [10, 11, 16, 20],
 *   [23, 30, 34, 50]
 * ]
 * target = 3
 * Output: true
 * Example 2:
 *
 * Input:
 * matrix = [
 *   [1,   3,  5,  7],
 *   [10, 11, 16, 20],
 *   [23, 30, 34, 50]
 * ]
 * target = 13
 * Output: false
 */
public class Searcha2DMatrix_74 {

    /**
     * @param matrix
     * @param target
     * @return
     */
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return false;
        }

        int left = 0;
        int right = matrix.length - 1;

        while (left <= right) {
            int mid = (left + right) / 2;
            if (target == matrix[mid][0])
                return true;
            else if (target < matrix[mid][0]) {
                right = mid - 1;
            } else
                left = mid + 1;
        }


        int row = right;
        if (row < 0) row = left;

        left = 0;
        right = matrix[0].length - 1;

        while (left <= right) {
            int mid = (left + right) / 2;
            if (target == matrix[row][mid])
                return true;
            else if (target < matrix[row][mid]) {
                right = mid - 1;
            } else
                left = mid + 1;
        }

        return false;
    }

    public static void main(String[] args) {

        int[][] matrix = {{1}};
        Searcha2DMatrix_74 myObj = new Searcha2DMatrix_74();
        System.out.println(myObj.searchMatrix(matrix, 0));

    }
}
