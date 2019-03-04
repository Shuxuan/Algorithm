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
