package main.company.facebook;

public class ReverseWordsinaString {

    public String reverseWords(String s) {
        if (s == null || s.isEmpty()) {
            return s;
        }

        String[] ss = s.split(" ");

        StringBuilder sb = new StringBuilder();
        for (String sub : ss) {
            if (sub.length() > 0 ) {
                sb.insert(0, sub);
                sb.insert(0, " ");
            }

        }

        return sb.length() > 1 ? sb.toString().substring(1) : sb.toString();
    }

    public static void main(String[] args) {
        String s = "a good   example";
        System.out.println(s.isEmpty());
        ReverseWordsinaString myObj = new ReverseWordsinaString();
        System.out.println(myObj.reverseWords(s));
    }

}
