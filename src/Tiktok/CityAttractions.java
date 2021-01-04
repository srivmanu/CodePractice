package Tiktok;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

public class CityAttractions {
    static HashSet<Integer> visited = new HashSet<>();

    static HashMap<Integer, HashMap<Integer, Integer>> map = new HashMap<>();

    public static int findBestPath(int n, int m, int max_t, List<Integer> beauty, List<Integer> u, List<Integer> v, List<Integer> t) {
        createGraph(n, m, u, v, t);
        visited.add(0);
        dfs2(0, beauty, max_t, beauty.get(0));
        return totalAns;

    }
    static int totalAns = Integer.MIN_VALUE;


    public static void dfs2(int node, List<Integer> beauty, int maxT, int sum) {

        if (node == 0) {
            totalAns = Math.max(totalAns, sum);

        }
        for (int nbr : map.get(node).keySet()) {

            int time = map.get(node).get(nbr);
            if (time <= maxT) {
                if (!visited.contains(nbr)) {
                    visited.add(nbr);
                    dfs2(nbr,
                            beauty,
                            maxT - time,
                            sum + beauty.get(nbr));
                    visited.remove(nbr);
                } else
                    dfs2(nbr, beauty, maxT - time, sum);

            }

        }

    }

    public static void createGraph(int n, int m, List<Integer> u, List<Integer> v, List<Integer> t) {
        for (int i = 0; i < n; ++i) {
            map.put(i, new HashMap<>());
        }

        for (int i = 0; i < m; ++i) {
            int x = u.get(i);
            int y = v.get(i);
            int z = t.get(i);

            map.get(x).put(y, z);
            map.get(y).put(x, z);
        }

    }
}
