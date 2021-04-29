package study;

import java.io.*;

public class BS {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int[] A = { 0, 2, 4, 6, 8, 10, 12, 14, 16, 18 };

        int L = 0;
        int R = A.length;
        int target = Integer.parseInt(br.readLine());

        int result = process(A, target, L, R);

        bw.write(String.valueOf(result));

        bw.flush();
        bw.close();
    }

    private static int process(int[] A, int target, int L, int R) {
        if (L > R) {
            return -99;
        }
        int mid = (L + R) / 2;

        if (target > A[mid]) {
            return process(A, target, mid + 1, R);
        } else if (target < A[mid]) {
            return process(A, target, L, mid - 1);
        } else {
            return mid;
        }
    }
}
