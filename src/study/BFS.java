package study;

import java.util.LinkedList;
import java.util.Queue;

public class BFS {

    static Queue<Integer> queue = new LinkedList<>();
    static boolean[] visited = new boolean[9];
    static int[][] graph = new int[][] {
            {},
            {2, 3, 8},
            {1, 7},
            {1, 4, 5},
            {3, 5},
            {3, 4},
            {7},
            {2, 6, 8},
            {1, 7}
    };

    public static void main(String[] args) {
        bfs(1);
    }

    private static void bfs(int start) {
        queue.add(start);
        visited[start] = true;

        while (!queue.isEmpty()) {
            int v = queue.remove();
            System.out.print(v + " ");

            for (int i : graph[v]) {
                if(!visited[i]) {
                    queue.add(i);
                    visited[i] = true;
                }
            }
        }
    }
}
