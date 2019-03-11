package main.company.amazon;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class RemoveInvalidParentheses {

    /**
     * Remove the minimum number of invalid parentheses in order to make the input string valid.
     * Return all possible results.
     *
     * Note: The input string may contain letters other than the parentheses ( and ).
     *
     * Example 1:
     *
     * Input: "()())()"
     * Output: ["()()()", "(())()"]
     * Example 2:
     *
     * Input: "(a)())()"
     * Output: ["(a)()()", "(a())()"]
     * Example 3:
     *
     * Input: ")("
     * Output: [""]
     *
     * @param s
     * @return
     */
    public List<String> removeInvalidParentheses(String s) {
        List<String>  res = new ArrayList<String> ();
        if(s == null){
            return res;
        }

        removeInvalid(s, res, 0, 0, '(', ')');

        return res;
    }


    private void removeInvalid(String target, List<String> res, int istart, int jstart, char open, char close){
        int tl = target.length();
        int count = 0;

        for(int i = istart; i < tl; i++){
            char c = target.charAt(i);
            if(c == open){
                count++;
            }
            if(c == close){
                count--;
            }
            if(count < 0){
                for(int j = jstart; j <= i; j++){
                    if(target.charAt(j) == close && (j == jstart || target.charAt(j - 1) != close)){
                        String newTarget = target.substring(0, j) + target.substring(j + 1);
                        removeInvalid(newTarget, res, i, j, open, close);
                    }
                }

                return;
            }
        }

        String reverse = new StringBuilder(target).reverse().toString();
        if(open == '('){
            removeInvalid(reverse, res, 0, 0, close, open);
        } else {
            res.add(reverse);
        }
    }

    public static void main(String[] args) {
        String s = "()())()";
        RemoveInvalidParentheses myObj = new RemoveInvalidParentheses();
        List<String> rst = myObj.removeInvalidParentheses(s);

        System.out.println(Arrays.toString(rst.toArray()));

    }



}
