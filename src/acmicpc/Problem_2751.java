package acmicpc;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Problem_2751 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int numberOfInputs = Integer.parseInt(br.readLine());

        List<Integer> inputs = new ArrayList<>();

        for (int i = 0; i < numberOfInputs; i++) {
            inputs.add(Integer.parseInt(br.readLine()));
        }

        Collections.sort(inputs);

        for (int item : inputs) {
            sb.append(item).append('\n');
        }

        System.out.println(sb);
    }
}
