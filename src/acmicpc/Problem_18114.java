package acmicpc;

import java.io.*;
import java.util.Arrays;

public class Problem_18114 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] input = br.readLine().split(" ");
        int N = Integer.parseInt(input[0]);
        int C = Integer.parseInt(input[1]);
        boolean flag = false;

        int[] data = new int[N];
        input = br.readLine().split(" ");

        for (int i = 0; i < N; i++) {
            data[i] = Integer.parseInt(input[i]);
        }
        Arrays.sort(data);

        if (Arrays.binarySearch(data, C) < 0) {
            for (int i = 0; i < N; i++) {
                for (int j = i + 1; j < N; j++) {
                    if (data[i] + data[j] == C) {
                        flag = true;
                        break;
                    } else if (data[i] + data[j] < C) {
                        int diff = C - (data[i] + data[j]);

                        if (Arrays.binarySearch(data, diff) >= 0 && diff != data[i] && diff != data[j]) {
                            flag = true;
                            break;
                        }
                    }
                }

                if (flag) {
                    break;
                }
            }


        } else {
            flag = true;
        }

        if (flag) {
            bw.write("1");
        } else {
            bw.write("0");
        }

        bw.flush();
        bw.close();
    }
}
