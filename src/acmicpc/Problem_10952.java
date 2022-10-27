package acmicpc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Objects;

public class Problem_10952 {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        String line;
        while(!Objects.equals(line = bufferedReader.readLine(), "0 0")) {
            String[] temp = line.split(" ");
            System.out.println(Integer.parseInt(temp[0]) + Integer.parseInt(temp[1]));
        }
    }
}
