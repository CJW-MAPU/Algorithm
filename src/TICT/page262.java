package TICT;

import java.io.*;
import java.util.Arrays;
import java.util.PriorityQueue;

public class page262 {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        String[] input = br.readLine().split(" ");

        int N = Integer.parseInt(input[0]);
        int M = Integer.parseInt(input[1]);
        int start = Integer.parseInt(input[2]);

        Graph graph = new Graph(N);

        for (int a = 0; a < M; a++) {
            input = br.readLine().split(" ");
            int i = Integer.parseInt(input[0]);
            int j = Integer.parseInt(input[1]);
            int w = Integer.parseInt(input[2]);

            graph.input(i, j, w);
        }

        graph.dijkstra(start);

        bw.flush();
        bw.close();
    }

    private static class Graph {
        private int n;
        private int[][] maps;

        Graph(int n) {
            this.n = n;
            maps = new int[n + 1][n + 1];
        }

        public void input(int i, int j, int w) {
            maps[i][j] = w;
        }

        public void dijkstra(int start) throws IOException {
            int[] distance = new int[n + 1];

            Arrays.fill(distance, Integer.MAX_VALUE);

            PriorityQueue<Node> queue = new PriorityQueue<>();
            queue.add(new Node(start, 0));
            distance[start] = 0;

            while (!queue.isEmpty()) {
                Node node = queue.poll();

                if (distance[node.vertex] < node.distance) {
                    continue;
                }

                for (int i = 1; i < n + 1; i++) {
                    if (maps[node.vertex][i] == 0) {
                        continue;
                    }

                    int cost = node.distance + maps[node.vertex][i];

                    if (cost < distance[i]) {
                        distance[i] = cost;
                        queue.add(new Node(i, cost));
                    }
                }
            }

            int count = 0;
            int max_distance = Integer.MIN_VALUE;

            for (int i = 1; i < distance.length; i++) {
                if (distance[i] != Integer.MAX_VALUE) {
                    count++;
                    max_distance = Math.max(max_distance, distance[i]);
                }
            }

            bw.write((count - 1) + " " + max_distance);

        }
    }

    private static class Node implements Comparable<Node> {
        int vertex;
        int distance;

        Node(int vertex, int distance) {
            this.vertex = vertex;
            this.distance = distance;
        }

        @Override
        public int compareTo(Node o) {
            return this.distance - o.distance;
        }
    }
}
