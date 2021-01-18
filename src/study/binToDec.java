package study;

import java.util.Scanner;

public class binToDec {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] T = new int[8];
        int[] C = new int[8];


        int sign = 1;

        for (int i = 0; i < T.length; i++) {
            T[i] = scanner.nextInt();
        }

        if(T[0] != 0) {
            sign = -1;
            int B = 1;
            for (int i = 7; i >= 1; i--) {
                C[i] = T[i] - B;
                if(T[i] != 0 || B != 1) {
                    B = 0;
                }
                C[i] = Math.abs(C[i]);
                T[i] = 1 - C[i];
            }
        }
        int D = 0;
        for (int i = 1; i < 8; i++) {
            D += T[i] * Math.pow(2, (7 - i));
        }
        D *= sign;
        System.out.println(D);

        scanner.close();
    }
}
