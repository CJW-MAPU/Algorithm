package acmicpc;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Problem_1018 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        List<String> inputs = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            inputs.add(br.readLine());
        }

        int countW = 0;
        int countB = 0;

        // 홀수
        if ((N * M) % 2 == 1) {
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {

                }
            }
        }
        // 짝수
        else {

        }
    }
}
