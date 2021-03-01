package acmicpc;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Problem_2217 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());

        List<Integer> ropeList = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            ropeList.add(Integer.parseInt(br.readLine()));
        }

        ropeList.sort(Collections.reverseOrder());

        int max = ropeList.get(0);

        for (int i = 1; i < ropeList.size(); i++) {
            int temp = ropeList.get(i) * (i + 1);

            if (max <= temp) {
                max = temp;
            }
        }

        bw.write(String.valueOf(max));

        bw.flush();
        bw.close();
    }
}
