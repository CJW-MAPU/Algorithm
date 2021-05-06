package TICT;

import java.io.*;
import java.util.Arrays;

public class page259 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] input = br.readLine().split(" ");
        int N = Integer.parseInt(input[0]);
        int M = Integer.parseInt(input[1]);

        long[][] graph = new long[N + 1][N + 1];

        for (long[] item : graph) {
            Arrays.fill(item, Integer.MAX_VALUE);
        }

        for (int i = 0; i < graph.length; i++) {
            graph[i][i] = 0;
        }

        for (int i = 0; i < M; i++) {
            input = br.readLine().split(" ");
            int a = Integer.parseInt(input[0]);
            int b = Integer.parseInt(input[1]);

            graph[a][b] = 1;
            graph[b][a] = 1;
        }

        input = br.readLine().split(" ");
        int X = Integer.parseInt(input[0]);
        int K = Integer.parseInt(input[1]);

        for (int k = 1; k < N + 1; k++) {
            for (int a = 1; a < N + 1; a++) {
                for (int b = 1; b < N + 1; b++) {
                    graph[a][b] = Math.min(graph[a][b], graph[a][k] + graph[k][b]);
                }
            }
        }

        long answer = graph[1][K] + graph[K][X];

        if (answer >= Integer.MAX_VALUE) {
            bw.write(String.valueOf(-1));
        } else {
            bw.write(String.valueOf(answer));
        }

        bw.flush();
        bw.close();
    }
}
