package codeup;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Problem_1026 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String input = br.readLine();

        StringTokenizer st = new StringTokenizer(input, ":");

        List<Integer> integerList = new ArrayList<>();

        while(st.hasMoreTokens()) {
            integerList.add(Integer.parseInt(st.nextToken()));
        }

        System.out.println(integerList.get(1));

        bw.flush();
        bw.close();
    }
}
