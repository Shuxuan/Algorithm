package main.company.goog2;

import java.util.*;

public class SubdomainVisitCount {

    public List<String> subdomainVisits(String[] cpdomains) {

        Map<String, Integer> map = new HashMap<>();

        for (String cpdomain : cpdomains) {
            String[] splits = cpdomain.split(" ");
            int count = Integer.parseInt(splits[0]);
            String domain = splits[1];
            map.put(domain, map.getOrDefault(domain, 0) + count);

            String[] subDomains = domain.split("\\.");
            String prev = "";
            for (int i = subDomains.length - 1; i > 0; i--) {
                String key = prev == "" ? subDomains[i] : subDomains[i] + "." + prev;
                map.put(key, map.getOrDefault(key, 0) + count);
                prev = key;
            }
        }

        List<String> res = new ArrayList<>();

        for (String key : map.keySet()) {
            String ans = String.valueOf(map.get(key) + " " + key);
            res.add(ans);
        }

        return res;

    }

    public static void main(String[] args) {
        String[] cpdomains = {"9001 discuss.leetcode.com"};
        SubdomainVisitCount myObj = new SubdomainVisitCount();

        List<String> res = myObj.subdomainVisits(cpdomains);

        for (String i : res) {
            System.out.println(i);
        }

        System.out.println(Arrays.toString("abc.com".split("\\.")));
    }

}
