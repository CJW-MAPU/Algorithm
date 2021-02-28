package acmicpc;

import java.io.*;

public class Problem_1439 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String input = br.readLine();

        char[] str = input.toCharArray();

        boolean flag = false;

        char first = str[0];
        int count = 0;

        for (int i = 1; i < str.length; i++) {
            if (first != str[i] && !flag) {
                flag = true;
                count++;
            } else if (first == str[i] && flag) {
                flag = false;
            }
        }

        bw.write(String.valueOf(count));

        bw.flush();
        bw.close();
    }
}
