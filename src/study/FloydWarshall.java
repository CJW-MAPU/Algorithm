package study;

import java.io.*;
import java.util.Arrays;

public class FloydWarshall {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());

        long[][] graph = new long[N + 1][N + 1];

        for (long[] longs : graph) {
            Arrays.fill(longs, Long.MAX_VALUE);
        }

        for (int i = 0; i < graph.length; i++) {
            graph[i][i] = 0;
        }

        for (int i = 0; i < M; i++) {
            String[] input = br.readLine().split(" ");
            int a = Integer.parseInt(input[0]);
            int b = Integer.parseInt(input[1]);
            long c = Long.parseLong(input[2]);

            graph[a][b] = c;
        }


        for (int k = 1; k < N + 1; k++) {
            for (int a = 1; a < N + 1; a++) {
                for (int b = 1; b < N + 1; b++) {
                    graph[a][b] = Math.min(graph[a][b], graph[a][k] + graph[k][b]);
                }
            }
        }


        for (int i = 1; i < graph.length; i++) {
            for (int j = 1; j < graph[i].length; j++) {
                if (graph[i][j] == Long.MAX_VALUE) {
                    bw.write("INF ");
                } else {
                    bw.write(graph[i][j] + " ");
                }
            }
            bw.newLine();
        }

        bw.flush();
        bw.close();
    }
}
