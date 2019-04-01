package main.company.fb;

import java.util.*;

public class EvaluateDivision {

    public double[] calcEquation(String[][] equations, double[] values, String[][] queries) {
        Map<String, Map<String, Double>> graph = new HashMap<>();
        for(int i = 0; i < equations.length; i++) {
            if(!graph.containsKey(equations[i][0])) {
                graph.put(equations[i][0], new HashMap<>());
            }
            if(!graph.containsKey(equations[i][1])) {
                graph.put(equations[i][1], new HashMap<>());
            }
            graph.get(equations[i][0]).put(equations[i][1], values[i]);
            graph.get(equations[i][1]).put(equations[i][0], 1/values[i]);
        }

        double[] res = new double[queries.length];
        Set<String> visited = new HashSet<>();
        for(int i = 0; i < queries.length; i++) {
            res[i] = dfs(graph, queries[i][0], queries[i][1], visited);
        }
        return res;

    }

    private double dfs(Map<String, Map<String, Double>> graph, String source, String dest, Set<String> visited) {
        if(visited.contains(source) || !graph.containsKey(source)) {
            return -1;
        }

        if(graph.containsKey(source) && graph.get(source).containsKey(dest)) {
            return graph.get(source).get(dest);
        }
        double res = 0.0;
        visited.add(source);
        for(Map.Entry<String, Double> entry : graph.get(source).entrySet()) {
            res = entry.getValue()*dfs(graph, entry.getKey(), dest, visited);
            if(res > 0) {
// Idea was to add an edge from source to dest so that subsequent queries for the same pair are directly answered but it increases runtime significantly so commenting out
                /*if(!graph.containsKey(dest)) {
                    graph.put(dest, new HashMap<>());
                }

                graph.get(source).put(dest, res);
                graph.get(dest).put(source, 1/res);*/
                visited.remove(source);
                return res;
            }
        }
        visited.remove(source);
        return -1;

    }

    public static void main(String[] args) {

        String[][] equation = {{"a", "b"}, {"b", "c"}};
        double[] values = {2.0, 3.0};
        String[][] queries = {{"a","c"},{"b","c"},{"a","e"},{"a","a"},{"x","x"}};


        /*
        String[][] equation = {{"x1","x2"},{"x2","x3"},{"x3","x4"},{"x4","x5"}};
        double[] values = {3.0,4.0,5.0,6.0};
        String[][] queries = {{"x1","x5"},{"x5","x2"},{"x2","x4"},{"x2","x2"},{"x2","x9"},{"x9","x9"}};
*/



        EvaluateDivision myObj = new EvaluateDivision();
        double[] rst = myObj.calcEquation(equation,values,queries);
        System.out.println(Arrays.toString(rst));
    }
}
