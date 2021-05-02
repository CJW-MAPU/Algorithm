package TICT;

import java.io.*;
import java.util.Arrays;

public class page201 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] input = br.readLine().split(" ");
        int N = Integer.parseInt(input[0]);
        int M = Integer.parseInt(input[1]);
        int[] array = new int[N];
        input = br.readLine().split(" ");

        for (int i = 0; i < N; i++) {
            array[i] = Integer.parseInt(input[i]);
        }

        Arrays.sort(array);

        int start = 0;
        int end = array[array.length - 1];

        int result = 0;

        while (start <= end) {
            int total = 0;
            int mid = (start + end) / 2;
            for (int i = 0; i < array.length; i++) {
                if (mid < array[i]) {
                    total += array[i] - mid;
                }
            }

            if (total < M) {
                end = mid - 1;
            } else {
                result = mid;
                start = mid + 1;
            }
        }

        bw.write(String.valueOf(result));

        bw.flush();
        bw.close();
    }
}
