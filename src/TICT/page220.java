package TICT;

import java.io.*;

public class page220 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int[] dp_table = new int[100];

        int N = Integer.parseInt(br.readLine());

        String[] input = br.readLine().split(" ");
        int[] array = new int[input.length];

        for (int i = 0; i < N; i++) {
            array[i] = Integer.parseInt(input[i]);
        }

        dp_table[0] = array[0];
        dp_table[1] = Math.max(array[0], array[1]);

        for (int i = 2; i < N; i++) {
            dp_table[i] = Math.max(dp_table[i - 1], dp_table[i - 2] + array[i]);
        }

        bw.write(String.valueOf(dp_table[N - 1]));

        bw.flush();
        bw.close();
    }
}
