package programmers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

public class Delivery {
    public static void main(String[] args) {
//        int N = 5;
//        int[][] road = {
//                {1, 2, 1},
//                {2, 3, 3},
//                {5, 2, 2},
//                {1, 4, 2},
//                {5, 3, 1},
//                {5, 4, 2}
//        };
//        int K = 3;

        int N = 6;
        int[][] road = {
                {1, 2, 1},
                {1, 3, 2},
                {2, 3, 2},
                {3, 4, 3},
                {3, 5, 2},
                {3, 5, 3},
                {5, 6, 1}
        };
        int K = 4;

        System.out.println(solution(N, road, K));
    }

    public static int solution(int N, int[][] road, int K) {
        Graph graph = new Graph(N);

        for (int i = 0; i < road.length; i++) {
            graph.input(road[i][0], road[i][1], road[i][2]);
        }

        return graph.dijkstra(1, K);
    }

    public static class Graph {
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
            list.get(j).add(new Node(i, w));
        }

        public int dijkstra(int start, int K) {
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

            for (int i = 1; i < distance.length; i++) {
                System.out.print(distance[i] + " ");
            }
            System.out.println();

            int count = 0;

            for (int i = 1; i < distance.length; i++) {
                if (distance[i] <= K) {
                    count++;
                }
            }

            return count;
        }
    }

    public static class Node implements Comparable<Node> {
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
