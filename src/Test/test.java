package Test;

import java.io.*;
import java.math.BigInteger;
import java.util.*;

public class test {
    public static void main(String[] args) throws Exception {

        System.out.println(solution(8, 12));
    }


    private static long solution(int w, int h) {
        long total = (long) w * h;
        long temp = w + h - BigInteger.valueOf(w).gcd(BigInteger.valueOf(h)).longValue();


        return total - temp;
    }
}




