package TICT;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class page182 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] input = br.readLine().split(" ");
        int N = Integer.parseInt(input[0]);
        int K = Integer.parseInt(input[1]);

        List<Integer> firstList = new ArrayList<>();
        List<Integer> secondList = new ArrayList<>();

        String[] firstInput = br.readLine().split(" ");
        String[] secondInput = br.readLine().split(" ");

        for (int i = 0; i < N; i++) {
            firstList.add(Integer.parseInt(firstInput[i]));
            secondList.add(Integer.parseInt(secondInput[i]));
        }

        Collections.sort(firstList);
        secondList.sort(Comparator.reverseOrder());

        for (int i = 0; i < K; i++) {
            firstList.add(secondList.get(i));
            firstList.remove(0);
        }

        int result = 0;

        for (int item :
                firstList) {
            result += item;
        }

        bw.write(String.valueOf(result));

        bw.flush();
        bw.close();
    }
}
