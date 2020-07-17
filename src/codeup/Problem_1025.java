package codeup;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Problem_1025 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String input = br.readLine();
        int n = Integer.parseInt(input);
        int j = 1;
        List<Integer> integerList = new ArrayList<>();

        while(n > 0) {
            integerList.add((n % 10) * j);
            n /= 10;
            j *= 10;
        }
        Collections.reverse(integerList);

        for (int i = 0; i < integerList.size(); i++) {
            System.out.println("[" + integerList.get(i) + "]");
        }

        bw.flush();
        bw.close();
    }
}
