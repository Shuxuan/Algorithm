package main.study.algorithm.Sort;

import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

/**
 *
 * https://leetcode.com/problems/merge-intervals/description/
 *
 * Given a collection of intervals, merge all overlapping intervals.
 *
 * Example 1:
 *
 * Input: [[1,3],[2,6],[8,10],[15,18]]
 * Output: [[1,6],[8,10],[15,18]]
 * Explanation: Since intervals [1,3] and [2,6] overlaps, merge them into [1,6].
 * Example 2:
 *
 * Input: [[1,4],[4,5]]
 * Output: [[1,5]]
 * Explanation: Intervals [1,4] and [4,5] are considerred overlapping.
 */
public class MergeIntervals_56 {

    public List<Interval> merge(List<Interval> intervals) {

        Collections.sort(intervals, new IntervalComparator());
        LinkedList<Interval> rst = new LinkedList<>();

        if (intervals == null || intervals.size() == 0) {
            return rst;
        }

        for (Interval interval : intervals) {
            if (rst.isEmpty() || rst.getLast().end < interval.start) {
                rst.add(interval);
            } else {
                // start to merge
                rst.getLast().end = Math.max(rst.getLast().end, interval.end);
            }
        }



        return rst;
    }

    private class IntervalComparator implements Comparator<Interval> {
        @Override
        public int compare(Interval a, Interval b) {
            return a.start < b.start ? -1 : a.start == b.start ? 0 : 1;
        }
    }
}
