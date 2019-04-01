package main.company;

public class ValidWordAbbreviation {

    public boolean validWordAbbreviation(String word, String abbr) {
        // if char, match.
        // if number, move pointer
        int i = 0;
        for (int j = 0; j < abbr.length();) {

            int digit = 0;
            if (Character.isDigit(abbr.charAt(j))) {
                if (abbr.charAt(j) == '0')
                    return false;
                while ( j < abbr.length() && Character.isDigit(abbr.charAt(j))) {
                    digit = digit * 10 + abbr.charAt(j) - '0';
                    j++;

                }
                i += digit;
                if (i == word.length() && j == abbr.length()) {
                    return true;
                }
                if (i >= word.length()) {
                    return false;
                }

            } else if (Character.isLetter(abbr.charAt(j))) {
                if (word.charAt(i) != abbr.charAt(j)) {
                    return false;
                }
                i++;
                j++;

            }
        }

        return true;
    }

    public static void main(String[] args) {
        String word = "internationalization";
        String abbr = "i5a11o1";

        ValidWordAbbreviation myObj = new ValidWordAbbreviation();
        System.out.println(myObj.validWordAbbreviation(word, abbr));
    }
}
