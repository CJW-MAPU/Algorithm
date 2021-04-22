package acmicpc;

import java.io.*;

public class Problem_1012 {

    static int[][] field;
    static int[] result;

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        int numberOfTestCase = Integer.parseInt(br.readLine());
        result = new int[numberOfTestCase];

        for (int k = 0; k < numberOfTestCase; k++) {
            buildData();

            for (int i = 0; i < field.length; i++) {
                for (int j = 0; j < field[0].length; j++) {
                    if (dfs(j, i)) {
                        result[k]++;
                    }
                }
            }
        }

        for (int i = 0; i < numberOfTestCase; i++) {
            bw.write(result[i] + "\n");
        }


        bw.flush();
        bw.close();
    }

    private static void buildData() throws IOException {
        String[] inputFrameData = br.readLine().split(" ");
        int N = Integer.parseInt(inputFrameData[1]);
        int M = Integer.parseInt(inputFrameData[0]);
        int K = Integer.parseInt(inputFrameData[2]);

        field = new int[N][M];

        for (int i = 0; i < K; i++) {
            String[] cabbage = br.readLine().split(" ");
            int x = Integer.parseInt(cabbage[0]);
            int y = Integer.parseInt(cabbage[1]);

            field[y][x] = 1;
        }
    }

    private static boolean dfs(int x, int y) {
        if (x < 0 || x > field[0].length - 1 || y < 0 || y > field.length - 1) {
            return false;
        } else {
            if (field[y][x] == 1) {
                field[y][x]++;
                dfs(x + 1, y);
                dfs(x - 1, y);
                dfs( x, y + 1);
                dfs( x, y - 1);
                return true;
            } else {
                return false;
            }
        }
    }
}
