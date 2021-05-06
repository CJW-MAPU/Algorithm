package programmers;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class TerrainMovement {
    static List<Edge> list = new ArrayList<>();
    static int[] parent;

    static int[] dx = { -1, 1, 0, 0 };
    static int[] dy = { 0, 0, -1, 1 };

    public static void main(String[] args) {
        int[][] land = {
                { 1, 4, 8, 10 },
                { 5, 5, 5, 5 },
                { 10, 10, 10, 10 },
                { 10, 10, 10, 20 }
        };

//        int[][] land = {
//                { 1, 3 },
//                { 10, 8 }
//        };

        int height = 3;

//        System.out.println(solution(land, height));
        System.out.println(solution(land, height));
    }

    private static int solution(int[][] land, int height) {
        int count = 1;

        // 이건 그래프 만들기임 크루스칼 아님
        // 이것도 메소드로 빼면 더 좋았을 것

        for (int i = 1; i < land.length + 1; i++) {
            for (int j = 1; j < land[0].length + 1; j++) {
                for (int k = 0; k < 4; k++) {
                    int nx = j - 1 + dx[k];
                    int ny = i - 1 + dy[k];
                    int dest = k >= 2 ? count + (dy[k] * land.length) : count + (dx[k]);
                    if (k % 2 == 1) {
                        if (!(nx < 0 || nx >= land.length || ny < 0 || ny >= land.length)) {
                            if (land[ny][nx] >= land[i - 1][j - 1]) {
                                list.add(new Edge(count, dest, land[ny][nx] - land[i - 1][j - 1]));
                            } else {
                                list.add(new Edge(count, dest, land[i - 1][j - 1] - land[ny][nx]));
                            }
                        }
                    }
                }
                count++;
            }
        }


        // 여기부터 크루스칼임
        // parent 는 스태틱으로 선언
        // 맨 밑까지 다 크루스칼에 필요한거임 ㅇㅇ

        parent = new int[land.length * land.length + 1];

        for (int i = 1; i < parent.length; i++) {
            parent[i] = i;
        }

        Collections.sort(list);

        int sum = 0;

        for (int i = 0; i < list.size(); i++) {
            Edge edge = list.get(i);
            if (!isSameParent(edge.start, edge.destination)) {
                if (height < edge.weight) {
                    sum += edge.weight;
                }
                union(edge.start, edge.destination);
            }
        }

        return sum;
    }

    public static void union(int x, int y) {
        int a = find(x);
        int b = find(y);
        if (a != b) {
            parent[b] = a;
        }
    }

    public static int find(int x) {
        if (parent[x] == x) {
            return x;
        }
        return parent[x] = find(parent[x]);
    }

    public static boolean isSameParent(int x, int y) {
        int a = find(x);
        int b = find(y);

        return a == b;
    }

    private static class Edge implements Comparable<Edge>{
        int start; // 출발지
        int destination; // 도착지
        int weight; // 가중치

        Edge(int start, int destination, int weight) {
            this.start = start;
            this.destination = destination;
            this.weight = weight;
        }

        @Override
        public String toString() {
            return "[ " + this.start + ", " + this.destination + ", " + this.weight + " ]";
        }

        @Override
        public int compareTo(Edge o) {
            return Integer.compare(this.weight, o.weight);
        }
    }
}
