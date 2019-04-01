package main.company.fb;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class MergeIntervals {
    public List<Interval> merge(List<Interval> intervals) {
        //sorting
        //merge

        if (intervals == null || intervals.size() <= 1) {
            return intervals;
        }

        List<Interval> rst = new ArrayList<>();

        Collections.sort(intervals, new Comparator<Interval>() {
            @Override
            public int compare(Interval o1, Interval o2) {
                return o1.start == o2.start ? o1.end - o2.end : o1.start - o2.start;
            }
        });


        Interval prev = intervals.get(0);
        for (int i = 1; i < intervals.size(); i++) {

            Interval curr = intervals.get(i);
            if (curr.start <= prev.end) {
                prev.end = Math.max(prev.end, curr.end);
            } else {
                rst.add(prev);
                prev = curr;
            }

        }

        rst.add(prev);
        return rst;
    }
}
