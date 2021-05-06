package study;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

public class dijkstra {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        String[] input = br.readLine().split(" ");

        int N = Integer.parseInt(input[0]); // 노드 개수
        int M = Integer.parseInt(input[1]); // 간선 수

        Graph graph = new Graph(N);

        int start = Integer.parseInt(br.readLine());

        for (int k = 0; k < M; k++) {
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

        public void dijkstra(int start) throws IOException {
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

            for (int i = 1; i < n + 1; i++) {
                if (distance[i] != Integer.MAX_VALUE) {
                    bw.write(String.valueOf(distance[i]));
                    bw.newLine();
                } else {
                    bw.write("INF");
                    bw.newLine();
                }
            }
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
