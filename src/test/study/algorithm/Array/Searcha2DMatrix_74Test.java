package test.study.algorithm.Array;

import main.study.algorithm.Array.Searcha2DMatrix_74;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Searcha2DMatrix_74Test {

    @Test
    void searchMatrix() {

        int[][] matrix = {{1,3,5,7},{10,11,16,20},{23,30,34,50}};
        Searcha2DMatrix_74 myObj = new Searcha2DMatrix_74();
        System.out.println(myObj.searchMatrix(matrix, 3));
        boolean rst = myObj.searchMatrix(matrix, 3);
        assertEquals(rst, true);
    }

    @Test
    void searchMatrix2() {

        int[][] matrix = {{1}};
        Searcha2DMatrix_74 myObj = new Searcha2DMatrix_74();
        System.out.println(myObj.searchMatrix(matrix, 3));
        boolean rst = myObj.searchMatrix(matrix, 0);
        assertEquals(rst, false);
    }
}