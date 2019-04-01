package main.company.fb;

public class AddBinary {
    public String addBinary(String a, String b) {
        if (a == null || a.isEmpty()) {
            return b;
        }

        if (b == null || b.isEmpty()) {
            return a;
        }

        if (a.length() > b.length()) {
            String tmp = a;
            a = b;
            b = tmp;
        }
        int aIndex = a.length() - 1;
        int bIndex = b.length() - 1;

        int carry = 0;

        StringBuilder sb = new StringBuilder();
        while (aIndex >= 0 && bIndex >= 0) {
            int aInt = Integer.valueOf(a.substring(aIndex, aIndex + 1));
            aIndex--;
            int bInt = Integer.valueOf(b.substring(bIndex, bIndex+ 1));
            bIndex--;

            int rst = aInt + bInt + carry;
            carry = rst / 2;
            rst = rst % 2;

            sb.insert(0, rst);
        }

        while (bIndex >= 0) {
            int rst = carry + Integer.valueOf(b.substring(bIndex, bIndex + 1));
            carry = rst / 2;
            rst = rst % 2;
            sb.insert(0, rst);
            bIndex--;
        }


        if (carry == 1) {
            sb.insert(0, 1);
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        String a = "111";
        String b = "1";

        AddBinary obj = new AddBinary();
        System.out.println(obj.addBinary(a, b));
    }
}
