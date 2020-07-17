package codeup;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Problem_1024 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String input = br.readLine();

        for (int i = 0; i < input.length(); i++) {
            System.out.println("'" + input.charAt(i) + "'");
        }


        bw.flush();
        bw.close();
    }
}
