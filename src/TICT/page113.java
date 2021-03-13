package TICT;

import java.io.*;

public class page113 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        int count = 0;

        for (int i = 0; i <= N; i++) {
            for (int j = 0; j < 60; j++) {
                for (int k = 0; k < 60; k++) {
                    String temp = String.valueOf(i) + j + k;

                    if (temp.contains("3")) {
                        count++;
                    }
                }
            }
        }

        bw.write(String.valueOf(count));

        bw.flush();
        bw.close();
    }
}
