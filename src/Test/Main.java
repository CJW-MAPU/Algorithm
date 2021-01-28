package Test;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());

        List<Integer> N = new ArrayList<>();
        List<Integer> M = new ArrayList<>();

        for (int i = 0; i < T; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            N.add(Integer.parseInt(st.nextToken()));
            M.add(Integer.parseInt(st.nextToken()));
        }

        for (int i = 0; i < T; i++) {
            bw.write(N.get(i) + " " + M.get(i) + '\n');
        }

        bw.flush();
        bw.close();
    }


}