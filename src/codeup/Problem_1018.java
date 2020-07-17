package codeup;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Problem_1018 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String n = br.readLine();

        int h, m;

        StringTokenizer st = new StringTokenizer(n, ":");

        h = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        bw.write(h + ":" + m);

        bw.flush();
        bw.close();
    }
}
