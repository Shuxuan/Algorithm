package main.study.algorithm.Tree.BinarySearchTree;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/problems/my-calendar-ii/description/
 *
 * Implement a MyCalendarTwo class to store your events. A new event can be added if adding the event will not cause a triple booking.
 *
 * Your class will have one method, book(int start, int end). Formally, this represents a booking on the half open interval [start, end), the range of real numbers x such that start <= x < end.
 *
 * A triple booking happens when three events have some non-empty intersection (ie., there is some time that is common to all 3 events.)
 *
 * For each call to the method MyCalendar.book, return true if the event can be added to the calendar successfully without causing a triple booking. Otherwise, return false and do not add the event to the calendar.
 *
 * Your class will be called like this: MyCalendar cal = new MyCalendar(); MyCalendar.book(start, end)
 * Example 1:
 * MyCalendar();
 * MyCalendar.book(10, 20); // returns true
 * MyCalendar.book(50, 60); // returns true
 * MyCalendar.book(10, 40); // returns true
 * MyCalendar.book(5, 15); // returns false
 * MyCalendar.book(5, 10); // returns true
 * MyCalendar.book(25, 55); // returns true
 * Explanation:
 * The first two events can be booked.  The third event can be double booked.
 * The fourth event (5, 15) can't be booked, because it would result in a triple booking.
 * The fifth event (5, 10) can be booked, as it does not use time 10 which is already double booked.
 * The sixth event (25, 55) can be booked, as the time in [25, 40) will be double booked with the third event;
 * the time [40, 50) will be single booked, and the time [50, 55) will be double booked with the second event.
 * Note:
 *
 * The number of calls to MyCalendar.book per test case will be at most 1000.
 * In calls to MyCalendar.book(start, end), start and end are integers in the range [0, 10^9].
 */
public class MyCalendarTwo_Method2 {

    /**
     * The big idea is pretty simple:
     * Each time of book, instead of fail a book when there is 1 or more overlap with existing books as in MyCalendar I, we just want to make sure these overlaps does not overlap - having overlap is now ok, but overlapped period cannot be overlapped again.
     * So we just need to keep track of all the overlaps with any previous books
     *
     * MyCalendar I can be reused to track the overlaps during each book.
     *
     * How to calculate overlap of 2 intervals
     * Assume a start earlier than b, (if not reverse), there could be 3 case, but in any case, an overlap(either positive or negative) can always be represented as:
     * (max(a0, b0), min(a1, b1))
     *
     * case 1: b ends before a ends:
     * a: a0 |-------------| a1
     * b:     b0 |-----| b1
     *
     * case 2: b ends after a ends:
     * a: a0 |--------| a1
     * b:     b0 |--------| b1
     *
     * case 3: b starts after a ends: (negative overlap)
     * a: a0 |----| a1
     * b:              b0 |----| b1
     */

    private List<int[]> books = new ArrayList<>();
    public boolean book(int s, int e) {
        MyCalendar overlaps = new MyCalendar();
        for (int[] b : books)
            if (Math.max(b[0], s) < Math.min(b[1], e)) // overlap exist
                if (!overlaps.book(Math.max(b[0], s), Math.min(b[1], e))) return false; // overlaps overlapped
        books.add(new int[]{ s, e });
        return true;
    }

    private static class MyCalendar {
        List<int[]> books = new ArrayList<>();
        public boolean book(int start, int end) {
            for (int[] b : books)
                if (Math.max(b[0], start) < Math.min(b[1], end)) return false;
            books.add(new int[]{ start, end });
            return true;
        }
    }

    public static void main(String[] args) {
        MyCalendarTwo_Method2 myObj = new MyCalendarTwo_Method2();
        System.out.println(myObj.book(36,41));
        System.out.println(myObj.book(28,34));
        System.out.println(myObj.book(40,46));
        System.out.println(myObj.book(10,18));
        System.out.println(myObj.book(4,11));
        System.out.println(myObj.book(25,34));
        System.out.println(myObj.book(36,44));
        System.out.println(myObj.book(32,40));
        System.out.println(myObj.book(34,39));

    }
}
