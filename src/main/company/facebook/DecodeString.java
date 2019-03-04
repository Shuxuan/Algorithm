package main.company.facebook;

/**
 * Given an encoded string, return it's decoded string.
 *
 * The encoding rule is: k[encoded_string], where the encoded_string inside the square brackets is being repeated exactly k times. Note that k is guaranteed to be a positive integer.
 *
 * You may assume that the input string is always valid; No extra white spaces, square brackets are well-formed, etc.
 *
 * Furthermore, you may assume that the original data does not contain any digits and that digits are only for those repeat numbers, k. For example, there won't be input like 3a or 2[4].
 *
 * Examples:
 *
 * s = "3[a]2[bc]", return "aaabcbc".
 * s = "3[a2[c]]", return "accaccacc".
 * s = "2[abc]3[cd]ef", return "abcabccdcdcdef".
 *
 *
 *
 * 这道题让我们把一个按一定规则编码后的字符串解码成其原来的模样，编码的方法很简单，就是把重复的字符串放在一个括号里，
 * 把重复的次数放在括号的前面，注意括号里面有可能会嵌套括号，
 *
 * 这题可以用递归和迭代两种方法来解，我们首先来看递归的解法，我们把一个括号中的所有内容看做一个整体，
 * 一次递归函数返回一对括号中解码后的字符串。
 * 给定的编码字符串实际上只有四种字符，数字，字母，左括号，和右括号。那么我们开始用一个变量i从0开始遍历到字符串的末尾，
 * 由于左括号都是跟在数字后面，所以我们首先遇到的字符只能是数字或者字母，如果是字母，我们直接存入结果中，
 * 如果是数字，我们循环读入所有的数字，并正确转换，那么下一位非数字的字符一定是左括号，我们指针右移跳过左括号，
 * 对之后的内容调用递归函数求解，注意我们循环的停止条件是遍历到末尾和遇到右括号，由于递归调用的函数返回了子括号里解码后的字符串，
 * 而我们之前把次数也已经求出来了，那么循环添加到结果中即可，参见代码如下：
 *
 */
public class DecodeString {
    int index = 0;
    public String decodeString(String s) {

        return decode(s, index);

    }

    private String decode(String s, int i) {
        StringBuilder sb = new StringBuilder();
        int n = s.length();
        this.index = i;

        while (this.index < n && s.charAt(this.index) != ']') {
            if (s.charAt(this.index) < '0' || s.charAt(this.index) > '9') {
                sb.append(s.charAt(this.index));
                this.index++;
            } else {
                int cnt = 0;
                while (s.charAt(this.index) >= '0' && s.charAt(this.index) <= '9') {
                    cnt = cnt * 10 + s.charAt(this.index) - '0';
                    this.index++;
                }

                this.index++; // skip '[', because '[' alwayts follow the numbers
                String t = decode(s, this.index);
                this.index++;
                while (cnt-- > 0) {
                    sb.append(t);
                }
            }
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        String s = "3[a]2[bc]";
        DecodeString myTest = new DecodeString();
        System.out.println(myTest.decodeString(s));
    }
}
