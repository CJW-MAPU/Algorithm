package codeup;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Problem_1027 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String input = br.readLine();

        StringTokenizer st = new StringTokenizer(input, ".");

        List<Integer> integerList = new ArrayList<>();
        while(st.hasMoreTokens()) {
            integerList.add(Integer.parseInt(st.nextToken()));
        }

        System.out.format("%02d-%02d-%04d", integerList.get(2), integerList.get(1), integerList.get(0));

        bw.flush();
        bw.close();
    }
}
