package main.company.amazon;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class FruitIntoBaskets {

    public int totalFruit(int[] tree) {
        if(tree == null || tree.length == 0) {
            return 0;
        }

        if (tree.length <= 2) {
            return tree.length;
        }

        int res = 0;

        Map<Integer, Integer> map = new HashMap<>(); // key: tree[i],  location, i
        int i = 0;


        for (int j = 0; j < tree.length; j++) {
            int curr = tree[j];
            map.put(curr, map.getOrDefault(curr, 0) + 1);

            while (map.size() >= 3) {
                int toDelete = tree[i];
                map.put(toDelete, map.get(toDelete) - 1);
                if (map.get(toDelete) == 0)
                    map.remove(toDelete);
                i++;

            }

            res = Math.max(res, j - i + 1);
        }

        return res;
    }

    public static void main(String[] args) {
        int[] tree = {0,1,2,2};
        FruitIntoBaskets myObj = new FruitIntoBaskets();

        System.out.println(myObj.totalFruit(tree));
    }

}
