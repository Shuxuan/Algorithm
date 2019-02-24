package main.company.facebook;

public class PalindromeNumber {

    public boolean isPalindrome(int x) {
        int reverse = reverse(x);
        if (reverse == x) {
            return true;
        }

        return false;
    }

    private int reverse(int x) {
        int rst = 0;
        while (x > 0) {
            rst = rst * 10 + x % 10;
            x = x / 10;
        }

        return rst;
    }

    public static void main(String[] args) {
        PalindromeNumber myObj = new PalindromeNumber();
        int x = 121;
        System.out.println(myObj.isPalindrome(x));
    }
}
