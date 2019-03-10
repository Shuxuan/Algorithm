package main.company.amazon;

public class LicenseKeyFormatting {

    public String licenseKeyFormatting(String S, int K) {
        if (S == null || S.isEmpty()) {
            return S;
        }

        StringBuffer sb = new StringBuffer();

        int i = S.length() - 1;
        while (i >= 0) {
            for (int j = K; j > 0 && i >= 0;) {
                char ch = S.charAt(i);
                if (ch != '-') {
                    sb.insert(0, Character.toUpperCase(ch));
                    j--;
                }
                i--;
            }
            if (sb.length() > 0 && sb.charAt(0) != '-')
                sb.insert(0, '-');
        }

        return sb.length() > 0 ? sb.substring(1) : "";

    }

    public static void main(String[] args) {
        //String S = "5F3Z-2e-9-w";
        //int K = 4;

        String S = "--a-a-a-a--";
        int K = 2;

        LicenseKeyFormatting myObj = new LicenseKeyFormatting();
        System.out.println(myObj.licenseKeyFormatting(S, K));
    }

}
