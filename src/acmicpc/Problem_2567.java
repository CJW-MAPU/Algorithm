package acmicpc;

import java.io.*;

public class Problem_2567 {
    private static final int[][] board = new int[102][102];
    private static int result = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());

        for (int i = 0; i < N; i++) {
            String[] temp = br.readLine().split(" ");
            coloringPaper(Integer.parseInt(temp[0]), Integer.parseInt(temp[1]));
        }

        for (int i = 1; i < 101; i++) {
            for (int j = 1; j < 101; j++) {
                if (board[i][j] == 1) {
                    result += isRound(board[i][j - 1], board[i][j + 1], board[i - 1][j], board[i + 1][j]);
                }
            }
        }

        bw.write(String.valueOf(result));

        bw.flush();
        bw.close();
    }

    private static void coloringPaper(int x, int y) {
        for (int i = x; i < x + 10; i++) {
            for (int j = y; j < y + 10; j++) {
                board[i][j] = 1;
            }
        }
    }

    private static int isRound(int lx, int rx, int uy, int dy) {
        if (lx + rx + uy + dy == 2) {
            return 2;
        } else if (lx + rx + uy + dy == 3) {
            return 1;
        } else {
            return 0;
        }
    }
}