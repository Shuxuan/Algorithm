package main.VMWare;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;
import java.util.stream.IntStream;


public class MyTest {
    public static String mySolution(String in, int line) {
        // split string via space
        if (in == null || in.isEmpty()) {
            return "FAILURE => WRONG INPUT (LINE " + line + ")";
        }

        String[] splitString = in.split(" ");
        Set<Integer> favSet = new HashSet<Integer>();
        for (String fav : splitString) {
            boolean isNumeric = fav.chars().allMatch(Character::isDigit);
            if (!isNumeric) {
                return "FAILURE => WRONG INPUT (LINE " + line + ")";
            }
            favSet.add(Integer.parseInt(fav));
        }
        if (favSet.size() == 0) {
            return "FAILURE => WRONG INPUT (LINE " + line + ")";
        }

        int min = (int) Collections.min(favSet);
        int max = (int) Collections.max(favSet);
        System.out.println("max " + max);
        System.out.println("size " + favSet.size());
        if (max != favSet.size()) {
            return "FAILURE => RECEIVED: " + favSet.size() + ", EXPECTED: " + max;
        }

        return "SUCCESS => RECEIVED: " + max;

    }
    public static void main(String args[] ) throws Exception {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT */
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));
        String countString = bufferedReader.readLine().trim();
        boolean isNumeric = countString.chars().allMatch(Character::isDigit);
        if (!isNumeric) {
            bufferedWriter.write("FAILURE => WRONG INPUT (LINE 1)");
        }else {
            int count = Integer.parseInt(countString);

            IntStream.range(0, count).forEach(i -> {
                try {

                    String lineString = bufferedReader.readLine();
                    String res = mySolution(lineString, i + 2);
                    bufferedWriter.write(res);
                    bufferedWriter.newLine();

                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }
            });
        }

        bufferedReader.close();
        bufferedWriter.close();
    }
}

