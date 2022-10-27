package acmicpc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Problem_10951 {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        String line;
        while((line = bufferedReader.readLine()) != null) {
            String[] temp = line.split(" ");
            System.out.println(Integer.parseInt(temp[0]) + Integer.parseInt(temp[1]));
        }
    }
}
