package TICT;

import java.io.*;
import java.util.StringTokenizer;

public class page96 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String input = br.readLine();

        StringTokenizer st = new StringTokenizer(input);

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[][] cardArray = new int[N][M];

        for (int i = 0; i < N; i++) {
            input = br.readLine();
            st = new StringTokenizer(input);

            for (int j = 0; j < M; j++) {
                cardArray[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int result = Integer.MIN_VALUE;

        for (int i = 0; i < cardArray.length; i++) {
            int min = Integer.MAX_VALUE;

            for (int j = 0; j < cardArray[i].length; j++) {
                if (cardArray[i][j] < min) {
                    min = cardArray[i][j];
                }
            }
            if (result < min) {
                result = min;
            }
        }

        bw.write(String.valueOf(result));
        bw.flush();
        bw.close();
    }
}