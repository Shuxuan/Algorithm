package main.VMWare;

import main.study.algorithm.LinkedList.ListNode;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * Merge k sorted linked lists and return it as one sorted list. Analyze and describe its complexity.
 *
 * Example:
 *
 * Input:
 * [
 *   1->4->5,
 *   1->3->4,
 *   2->6
 * ]
 * Output: 1->1->2->3->4->4->5->6
 */
public class MergekSortedLists {

    public ListNode mergeKLists(ListNode[] lists) {

        //用min heap，最小出列，然后如果最小.next 不为空，入列
        //java里的minHeap是priorityQueue

        if (lists==null||lists.length==0) return null;

        PriorityQueue<ListNode> queue= new PriorityQueue<ListNode>(lists.length,new Comparator<ListNode>(){
            @Override
            public int compare(ListNode o1,ListNode o2){
                if (o1.val<o2.val)
                    return -1;
                else if (o1.val==o2.val)
                    return 0;
                else
                    return 1;
            }
        });

        ListNode dummy = new ListNode(0);
        ListNode tail=dummy;

        for (ListNode node:lists)
            if (node!=null)
                queue.add(node);

        while (!queue.isEmpty()){
            tail.next=queue.poll();
            tail=tail.next;

            if (tail.next!=null)
                queue.add(tail.next);
        }
        return dummy.next;

    }

    public static void main(String[] args) {
        ListNode n11 = new ListNode(1);
        ListNode n12 = new ListNode(4);
        ListNode n13 = new ListNode(5);

        n11.next = n12;
        n12.next = n13;

        ListNode n21 = new ListNode(1);
        ListNode n22 = new ListNode(3);
        ListNode n23 = new ListNode(4);

        n21.next = n22;
        n22.next = n23;

        ListNode[] lists = new ListNode[2];
        lists[0] = n11;
        lists[1] = n21;

        MergekSortedLists myTest = new MergekSortedLists();
        ListNode rst = myTest.mergeKLists(lists);
        while (rst != null) {
            System.out.println(rst.val);
            rst = rst.next;
        }


    }


}
