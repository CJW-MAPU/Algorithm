package TICT;

import java.io.*;

public class page115 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] input = br.readLine().split("");

        int column = Integer.parseInt(String.valueOf(input[0].charAt(0) - 96));
        int row = Integer.parseInt(input[1]);

        int[][] steps = { { 2, -1 }, { 2, 1 }, { 1, -2 }, { 1, 2 }, { -1, 2 }, { -1, -2 }, { -2, 1 }, { -2 , -1 } };

        int count = 0;

        for (int i = 0; i < steps.length; i++) {
            int x = column + steps[i][0];
            int y = row + steps[i][1];

            if (!(x < 1 || x > 8 || y < 1 || y > 8)) {
                count++;
            }
        }

        bw.write(String.valueOf(count));

        bw.flush();
        bw.close();
    }
}
