package main.study.algorithm.Array;


import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

/**
 *
 * https://leetcode.com/problems/insert-interval/description/
 *
 * Given a set of non-overlapping intervals, insert a new interval into the intervals (merge if necessary).
 *
 * You may assume that the intervals were initially sorted according to their start times.
 *
 * Example 1:
 *
 * Input: intervals = [[1,3],[6,9]], newInterval = [2,5]
 * Output: [[1,5],[6,9]]
 * Example 2:
 *
 * Input: intervals = [[1,2],[3,5],[6,7],[8,10],[12,16]], newInterval = [4,8]
 * Output: [[1,2],[3,10],[12,16]]
 * Explanation: Because the new interval [4,8] overlaps with [3,5],[6,7],[8,10].
 *
 *
 */
public class InsertInterval_57 {

    public List<Interval> insert(List<Interval> intervals, Interval newInterval) {


        if (intervals == null) {
            return new LinkedList<>();
        }

        intervals.add(newInterval);

        Collections.sort(intervals, new IntervalComparator());

        List<Interval> rst = this.merged(intervals);

        return rst;

    }

    public List<Interval> merged(List<Interval> intervals) {
        LinkedList<Interval> merged = new LinkedList<>();

        for (Interval interval : intervals) {
            if (merged.isEmpty() || merged.getLast().end < interval.start) {
                merged.add(interval);
            } else {
                merged.getLast().end = Math.max(merged.getLast().end, interval.end);
            }
        }

        return merged;

    }

    private class IntervalComparator implements Comparator<Interval> {
        @Override
        public int compare(Interval a, Interval b) {
            return a.start < b.start ? -1 : a.start == b.start ? 0 : 1;
        }
    }

    public static void main(String[] args) {

    }
}


