package acmicpc;

import java.io.*;
import java.util.*;

public class Problem_1181 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int numberOfInputs = Integer.parseInt(br.readLine());

        Set<String> set = new HashSet<>();


        for (int i = 0; i < numberOfInputs; i++) {
            set.add(br.readLine());
        }

        Comparator<String> myComp = (o1, o2) -> {
            if (o1.length() > o2.length()) {
                return 1;
            } else if (o1.length() < o2.length()) {
                return -1;
            } else {
                return o1.compareTo(o2);
            }
        };

        List<String> list = new ArrayList<>(set);

        list.sort(myComp);

        for (String item : list) {
            bw.write(item + '\n');
        }

        bw.close();
    }
}