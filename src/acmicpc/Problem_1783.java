package acmicpc;

import java.io.*;

public class Problem_1783 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] inputs = br.readLine().split(" ");

        int N = Integer.parseInt(inputs[0]);
        int M = Integer.parseInt(inputs[1]);

        if (N == 1) {
            bw.write(String.valueOf(1));
        } else if (N == 2) {
            bw.write(String.valueOf(Math.min(4, (M + 1) / 2)));
        } else if (N >= 3) {
            if (M <= 6) {
                bw.write(String.valueOf(Math.min(4, M)));
            } else {
                bw.write(String.valueOf(M - 2));
            }
        }

        bw.flush();
        bw.close();
    }
}
