package codeup;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Problem_1046 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String input = br.readLine();

        StringTokenizer st = new StringTokenizer(input, " ");

        int sum = 0;
        int i = 0;
        while(st.hasMoreTokens()) {
            sum += Integer.parseInt(st.nextToken());
            i++;
        }

        System.out.println(sum);
        System.out.format("%.1f", (double)sum / (double)i);

        bw.flush();
        bw.close();
    }
}
