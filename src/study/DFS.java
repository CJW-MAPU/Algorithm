package study;

public class DFS {
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
        dfs(1);
    }

    private static void dfs(int v) {
        visited[v] = true;
        System.out.print(v + " ");

        for (int i : graph[v]) {
            if (!visited[i]) {
                dfs(i);
            }
        }
    }
}
