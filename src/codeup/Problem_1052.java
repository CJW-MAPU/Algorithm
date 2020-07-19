package codeup;

import java.io.*;
import java.util.StringTokenizer;

public class Problem_1052 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String input = br.readLine();

        StringTokenizer st = new StringTokenizer(input, " ");

        if (Integer.parseInt(st.nextToken()) != Integer.parseInt(st.nextToken())) {
            System.out.println(1);
        } else {
            System.out.println(0);
        }

        bw.flush();
        bw.close();
    }
}
