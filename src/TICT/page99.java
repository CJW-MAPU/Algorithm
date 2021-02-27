package TICT;

import java.io.*;
import java.util.StringTokenizer;

public class page99 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String input = br.readLine();

        StringTokenizer st = new StringTokenizer(input);

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int count = 0;

        while(N > 1) {
            if (N % K == 0) {
                N /= K;
            } else {
                N--;
            }
            count++;
        }

        bw.write(String.valueOf(count));

        bw.flush();
        bw.close();
    }
}