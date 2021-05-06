package acmicpc;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

public class Problem_1916 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());

        Graph graph = new Graph(n);

        for (int k = 0; k < m; k++) {
            String[] input = br.readLine().split(" ");
            int i = Integer.parseInt(input[0]);
            int j = Integer.parseInt(input[1]);
            int w = Integer.parseInt(input[2]);

            graph.input(i, j, w);
        }

        String[] input = br.readLine().split(" ");
        int start = Integer.parseInt(input[0]);
        int destination = Integer.parseInt(input[1]);

        graph.dijkstra(start, destination);

        bw.flush();
        bw.close();
    }

    private static class Graph {
        private int n;
        private List<ArrayList<Node>> list;

        Graph(int n) {
            this.n = n;
            list = new ArrayList<>();

            for (int i = 0; i < n + 1; i++) {
                list.add(new ArrayList<>());
            }
        }

        public void input(int i, int j, int w) {
            list.get(i).add(new Node(j, w));
        }

        public void dijkstra(int start, int destination) throws IOException {
            int[] distance = new int[this.n + 1];

            Arrays.fill(distance, Integer.MAX_VALUE);

            PriorityQueue<Node> queue = new PriorityQueue<>();
            queue.add(new Node(start, 0));
            distance[start] = 0;

            while (!queue.isEmpty()) {
                Node node = queue.poll();

                if (distance[node.vertex] < node.distance) {
                    continue;
                }

                for (int i = 0; i < list.get(node.vertex).size(); i++) {
                    int v = list.get(node.vertex).get(i).vertex;
                    int cost = node.distance + list.get(node.vertex).get(i).distance;

                    if (cost < distance[v]) {
                        distance[v] = cost;
                        queue.add(new Node(v, cost));
                    }
                }
            }

            bw.write(String.valueOf(distance[destination]));
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
