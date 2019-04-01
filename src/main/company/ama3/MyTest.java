package main.company.ama3;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

import static java.util.stream.Collectors.toList;

public class MyTest {

    public static void finalPrice(List<Integer> prices) {
        // Write your code here
        if (prices == null || prices.size() == 0) {
            return;
        }

        if (prices.size() == 1) {
            System.out.println(prices.get(0));
            System.out.println(0);
        }

        int res = 0;
        List<Integer> slice = new ArrayList<>();

        int[] min = new int[prices.size()];
        min[0] = prices.get(0);
        for (int i = 1; i < prices.size(); i++) {
            min[i] = Math.min(min[i-1], prices.get(i));
        }

        System.out.println(Arrays.toString(min));

        for (int i = 0; i < prices.size() - 2; i++) {
            if (prices.get(i) >= min[i+1]) {
                res += prices.get(i) - min[i+1];
            } else {
                res += prices.get(i);
                slice.add(i);
            }
        }

        res += prices.get(prices.size()-1);
        slice.add(prices.size() - 1);

        System.out.println(res);
        for (int i : slice) {
            System.out.print(i + " ");
        }
    }


    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int pricesCount = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> prices = IntStream.range(0, pricesCount).mapToObj(i -> {
            try {
                return bufferedReader.readLine().replaceAll("\\s+$", "");
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        })
                .map(String::trim)
                .map(Integer::parseInt)
                .collect(toList());

        MyTest.finalPrice(prices);

        bufferedReader.close();
    }


}
