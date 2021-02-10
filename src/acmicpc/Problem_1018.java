package acmicpc;

import java.io.*;
import java.util.StringTokenizer;

public class Problem_1018 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        String[] inputs = new String[N];

        for (int i = 0; i < N; i++) {
            inputs[i] = br.readLine();
        }

        int min = Integer.MAX_VALUE;

        for (int i = 0; i < N - 7; i++) {
            for (int j = 0; j < M - 7; j++) {
                int count = compareBoard(inputs, i, j);

                if (min > count) {
                    min = count;
                }
            }
        }
        System.out.println(min);
    }

    private static int compareBoard(String[] inputBoard, int x, int y) {
        String[] chessBoard = {
                "BWBWBWBW",
                "WBWBWBWB",
                "BWBWBWBW",
                "WBWBWBWB",
                "BWBWBWBW",
                "WBWBWBWB",
                "BWBWBWBW",
                "WBWBWBWB"
        };

        int count = 0;

        for (int i = x; i < x + 8; i++) {
            for (int j = y; j < y + 8; j++) {
                if (inputBoard[i].charAt(j) != chessBoard[i - x].charAt(j - y)) {
                    count++;
                }
            }
        }

        if (count > 32) {
            return 64 - count;
        }

        return count;
    }
}