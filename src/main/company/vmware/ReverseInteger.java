package main.company.vmware;

public class ReverseInteger {
    public int reverse(int x) {
        int res = 0;

        while (x != 0) {
            //盘点是否溢出
            if ((res * 10 + (x % 10) - (x % 10)) / 10 != res) { return 0; }
            res = res * 10 + (x % 10);
            x = x / 10;
        }

        return res;

    }

    public static void main(String[] args) {
        int input = 12345679;
        ReverseInteger myTest = new ReverseInteger();
        System.out.println(myTest.reverse(input));
    }
}
