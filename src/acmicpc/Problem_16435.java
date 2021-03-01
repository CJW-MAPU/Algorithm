package acmicpc;

import java.io.*;
import java.util.*;

public class Problem_16435 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] inputs = br.readLine().split(" ");
        String[] fruits = br.readLine().split(" ");

        int N = Integer.parseInt(inputs[0]);
        int L = Integer.parseInt(inputs[1]);

        List<Integer> fruitList = new ArrayList<>();

        for (String fruit : fruits) {
            fruitList.add(Integer.parseInt(fruit));
        }

        Collections.sort(fruitList);

        for (int fruitHeight : fruitList) {
            if (fruitHeight <= L) {
                L++;
            }
        }

        bw.write(String.valueOf(L));

        bw.flush();
        bw.close();
    }
}
