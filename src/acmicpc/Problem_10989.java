package acmicpc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Problem_10989 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int numberOfInputs = Integer.parseInt(br.readLine());
        int[] inputs = new int[numberOfInputs];
        int[] counting = new int[10001];
        int[] result = new int[numberOfInputs];

        for (int i = 0; i < numberOfInputs; i++) {
            inputs[i] = Integer.parseInt(br.readLine());
        }

        for (int i = 0; i < inputs.length; i++) {
            counting[inputs[i]]++;
        }

        for (int i = 1; i < counting.length; i++) {
            counting[i] += counting[i - 1];
        }

        for (int i = inputs.length - 1; i >= 0; i--) {
            result[--counting[inputs[i]]] = inputs[i];
        }

        for (int i = 0; i < result.length; i++) {
            sb.append(result[i]).append('\n');
        }
        System.out.println(sb);
    }
}
