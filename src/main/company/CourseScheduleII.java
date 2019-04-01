package main.company;

import java.util.*;

public class CourseScheduleII {

    public int[] findOrder(int numCourses, int[][] prerequisites) {
        int[] inDegree = new int[numCourses];
        ArrayList[] graph = new ArrayList[numCourses];

        for (int i = 0; i < numCourses; i++) {
            graph[i] = new ArrayList();
        }

        for (int i = 0; i < prerequisites.length; i++) {
            inDegree[prerequisites[i][0]]++;
            graph[prerequisites[i][1]].add(prerequisites[i][0]);
        }

        // find indegree == 0 and added into queue
        Queue<Integer> queue = new LinkedList<>();
        int count = 0;
        for (int i = 0; i < numCourses; i++) {
            if (inDegree[i] == 0) {
                queue.add(i);
                count++;
            }
        }

        int[] res = new int[numCourses];
        int index = 0;
        while (!queue.isEmpty()) {
            Integer curr = queue.poll();
            res[index++] = curr;
            List<Integer> list = graph[curr];
            for (Integer item : list) {
                inDegree[item]--;
                if (inDegree[item] == 0) {
                    queue.add(item);
                    count++;
                }
            }
        }

        System.out.println("count : " + count);
        if (count == numCourses) {
            return res;
        }
        return new int[0];

    }


    public static void main(String[] args) {
        int numCourses = 2;
        int[][] prerequisites = {{1,0}, {0, 1}};

        CourseScheduleII myObj = new CourseScheduleII();
        int[] res = myObj.findOrder(numCourses, prerequisites);

        System.out.println("result : " + Arrays.toString(res));
    }

}
