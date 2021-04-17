package TICT;

import java.io.*;

public class page149 {
    static int[][] frame;

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        buildFrame();
        process();
    }

    private static void buildFrame() throws IOException {
        String[] input = br.readLine().split(" ");
        int N = Integer.parseInt(input[0]);
        int M = Integer.parseInt(input[1]);

        frame = new int[N][M];

        for (int i = 0; i < N; i++) {
            String[] ice = br.readLine().split("");

            for (int j = 0; j < M; j++) {
                frame[i][j] = Integer.parseInt(ice[j]);
            }
        }
    }

    private static void process() throws IOException {

        int result = 0;

        for (int i = 0; i < frame.length; i++) {
            for (int j = 0; j < frame[i].length; j++) {
                if (dfs(i, j)) {
                    result++;
                }
            }
        }
        bw.write(String.valueOf(result));
        bw.flush();
        bw.close();
    }

    private static boolean dfs(int i, int j) {
        if (i < 0 || i > frame.length - 1 || j < 0 || j > frame[0].length - 1) {
            return false;
        } else {
            if (frame[i][j] == 0) {
                frame[i][j] = 1;

                dfs(i - 1, j);
                dfs(i + 1, j);
                dfs(i, j - 1);
                dfs(i, j + 1);
                return true;
            } else {
                return false;
            }
        }
    }


    /*private static void printFrame() throws IOException {
        for (int i = 0; i < frame.length; i++) {
            for (int j = 0; j < frame[i].length; j++) {
                bw.write(String.valueOf(frame[i][j]));
            }
            bw.newLine();
        }
    }*/

}
