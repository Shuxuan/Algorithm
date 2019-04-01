package main.company.fb;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Maintain two counts left and the right count
 * You can add left parentheses as long as they are less than n
 * backtrack, only add right parenthese if left count is greater than it, otherwise leads to unbalanced parentheses.
 */


public class GenerateParentheses {

    List<String> rst = null;
    int n = 0;
    public List<String> generateParenthesis(int n) {
        //dfs
        rst = new ArrayList<>();
        this.n = n;
        char[] item = new char[2 * n];
        generateParenthesis(0,0,0,item);

        return rst;
    }

    private void generateParenthesis(int lc, int rc, int pos, char[] item) {
        if(pos == item.length) {
            rst.add(new String(item));
        }

        if (lc < n) {
            item[pos] = '(';
            generateParenthesis(lc + 1, rc, pos + 1, item);
        }

        if (lc > rc) {
            item[pos] = ')';
            generateParenthesis(lc, rc + 1, pos + 1, item);
        }
    }

    public static void main(String[] args) {
        int n = 3;
        GenerateParentheses myObj = new GenerateParentheses();
        List<String> rst = myObj.generateParenthesis(n);

        System.out.println(Arrays.toString(rst.toArray()));
    }
}
