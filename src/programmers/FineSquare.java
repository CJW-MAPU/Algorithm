package programmers;

import java.math.BigInteger;

public class FineSquare {
    public static void main(String[] args) {

        int w = 8;
        int h = 12;

        System.out.println(solution(w, h));
    }

    public static long solution(int w, int h) {
        long total = (long) w * h;

        long temp = w + h - BigInteger.valueOf(w).gcd(BigInteger.valueOf(h)).longValue();

        return total - temp;
    }
}
