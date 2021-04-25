package acmicpc;

import java.io.*;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Problem_1260 {

    static boolean[] dfsVisited;
    static boolean[] bfsVisited;
    static int[] graphCount;
    static int[][] graph;

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {


        String[] input = br.readLine().split(" ");
        int N = Integer.parseInt(input[0]);
        int M = Integer.parseInt(input[1]);
        int start = Integer.parseInt(input[2]);

        graph = new int[N + 1][N - 1];
        graphCount = new int[N + 1];
        dfsVisited = new boolean[N + 1];
        bfsVisited = new boolean[N + 1];
        dfsVisited[0] = true;
        bfsVisited[0] = true;

        for (int i = 0; i < M; i++) {
            String[] edge = br.readLine().split(" ");
            int a = Integer.parseInt(edge[0]);
            int b = Integer.parseInt(edge[1]);

            graph[a][graphCount[a]++] = b;
            graph[b][graphCount[b]++] = a;
        }

        for (int i = 0; i < graph.length; i++) {
            Arrays.sort(graph[i]);
        }

        dfs(start);
        bw.newLine();
        bfs(start);

        bw.flush();
        bw.close();
    }

    private static void dfs(int v) throws IOException {
        dfsVisited[v] = true;
        bw.write(v + " ");

        for (int i : graph[v]) {
            if (!dfsVisited[i]) {
                dfs(i);
            }
        }
    }

    private static void bfs(int start) throws IOException {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(start);
        bfsVisited[start] = true;

        while (!queue.isEmpty()) {
            int v = queue.remove();
            bw.write(v + " ");

            for (int i : graph[v]) {
                if (!bfsVisited[i]) {
                    queue.add(i);
                    bfsVisited[i] = true;
                }
            }
        }
    }
}
