package codeup;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Problem_1020 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String IdCardNumber = br.readLine();

        StringTokenizer st = new StringTokenizer(IdCardNumber, "-");
        while(st.hasMoreTokens()) {
            System.out.print(st.nextToken());
        }

        bw.flush();
        bw.close();
    }
}
