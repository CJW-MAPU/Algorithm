package acmicpc;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Problem_1032 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int numberOfInputs = Integer.parseInt(br.readLine());

        List<String> inputs = new ArrayList<>();

        for (int i = 0; i < numberOfInputs; i++) {
            inputs.add(br.readLine());
        }

        int stringLength = inputs.get(0).length();

        char[] array = new char[stringLength];

        for (int i = 0; i < stringLength; i++) {
            char temp = inputs.get(0).toCharArray()[i];;
            array[i] = temp;
            for (int j = 1; j < numberOfInputs; j++) {
                if (inputs.get(j).toCharArray()[i] != temp) {
                    array[i] = '?';
                    break;
                }
            }
        }

        bw.write(array);

        bw.flush();
        bw.close();
    }
}