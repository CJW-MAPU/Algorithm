package acmicpc;

import java.io.*;
import java.math.BigInteger;
import java.util.Scanner;

public class Problem_1793 {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);

        BigInteger[] dp_table = new BigInteger[251];

        dp_table[0] = new BigInteger("1");
        dp_table[1] = new BigInteger("1");
        dp_table[2] = new BigInteger("3");

        for (int i = 3; i < 251; i++) {
            dp_table[i] = dp_table[i - 2].multiply(new BigInteger("2"));

            dp_table[i] = dp_table[i].add(dp_table[i - 1]);
        }

        while (sc.hasNextInt()) {
            int n = sc.nextInt();
            System.out.println(dp_table[n]);
        }
    }
}
