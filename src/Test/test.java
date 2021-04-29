package Test;

import java.io.*;
import java.util.*;

public class test {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(stk.nextToken());
        int k = Integer.parseInt(stk.nextToken());
        int[] team = new int[n];
        long min = Integer.MAX_VALUE;
        long max = Integer.MAX_VALUE;

        for (int i = 0; i < n; i++) {
            team[i] = Integer.parseInt(br.readLine());
            min = Math.min(min, team[i]);
        }
        long ans = 0;
        while (min <= max) {
            long mid = (min + max) / 2;
            long sum = 0;
            for (int i = 0; i < n; i++) {
                if (mid >= team[i]) {
                    sum += mid - team[i];
                }
            }
            if (k >= sum) {
                min = mid + 1;
                ans = Math.max(ans, mid);
            } else {
                max = mid - 1;
            }
        }
        System.out.println(ans);
    }
}

