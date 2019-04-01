package main.study.algorithm.Array;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class MaximumDistanceinArrays {

    class Node implements Comparable<Node>{
        int index;
        int val;
        public Node(int index, int val) {
            this.index = index;
            this.val = val;
        }

        @Override
        public int compareTo(Node o) {
            return this.val - o.val;
        }
    }

    public int maxDistance(List<List<Integer>> arrays) {
        PriorityQueue<Node> minQ = new PriorityQueue<Node>();
        PriorityQueue<Node> maxQ = new PriorityQueue<Node>((node1, node2) -> node2.val - node1.val);

        for (int i = 0; i < arrays.size(); i++) {
            List<Integer> list = arrays.get(i);
            Node min = new Node(i, list.get(0));
            Node max = new Node(i, list.get(list.size()-1));
            minQ.add(min);
            maxQ.add(max);
        }

        Node minN = minQ.poll();
        Node maxN = maxQ.poll();
        if (minN.index == maxN.index) {

            if (Math.abs(minQ.peek().val- minN.val) > Math.abs(maxQ.peek().val - maxN.val)) {
                minN = minQ.peek();
            } else
                maxN = maxQ.peek();
        }
        return Math.abs(minN.val - maxN.val);
    }


    public static void main(String[] args) {
        List<Integer> item1 = new ArrayList<>();
        item1.add(1);
        item1.add(2);
        item1.add(3);

        List<Integer> item2 = new ArrayList<>();
        item2.add(4);
        item2.add(5);

        List<Integer> item3 = new ArrayList<>();
        item3.add(1);
        item3.add(2);
        item3.add(3);

        List<List<Integer>> arrays = new ArrayList<>();
        arrays.add(item1);
        arrays.add(item2);
        arrays.add(item3);

        MaximumDistanceinArrays myObj = new MaximumDistanceinArrays();

        System.out.println(myObj.maxDistance(arrays));
    }
}
