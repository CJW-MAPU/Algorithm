package acmicpc;

import java.io.*;
import java.util.Arrays;

public class Problem_16564 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));


        String[] input = br.readLine().split(" ");
        int N = Integer.parseInt(input[0]);
        int K = Integer.parseInt(input[1]);

        int[] character = new int[N];
        int min = Integer.MAX_VALUE;

        for (int i = 0; i < N; i++) {
            int level = Integer.parseInt(br.readLine());
            character[i] = level;
            min = Math.min(min, character[i]);
        }

        Arrays.sort(character);

        int result;

        while (true) {
            min = character[0];
            int n = upperBound(character, min);

            if (n == N) {
                result = min + (K / n);
                break;
            }

            int dif = character[n] - min;

            if (dif * n <= K) {
                character[0] += dif;
            } else {
                result = min + (K / n);
                break;
            }

            K -= dif * n;
        }

        bw.write(String.valueOf(result));


        bw.flush();
        bw.close();
    }

    private static int upperBound(int[] data, int target) {
        int begin = 0;
        int end = data.length;

        while(begin < end) {
            int mid = (begin + end) / 2;

            if(data[mid] <= target) {
                begin = mid + 1;
            }
            else {
                end = mid;
            }
        }
        return end;
    }
}
