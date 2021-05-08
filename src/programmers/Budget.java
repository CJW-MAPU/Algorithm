package programmers;

import java.util.Arrays;
import java.util.Stack;

public class Budget {
    public static void main(String[] args) {
//        int[] d = {1, 3, 2, 5, 4};
        int[] d = {2, 2, 3, 3};
        int budget = 10;


        System.out.println(solution(d, budget));
    }

    public static int solution(int[] d, int budget) {

        Arrays.sort(d);

        int sum = 0;
        int answer = 0;

        for (int i = 0; i < d.length; i++) {
            sum += d[i];

            if (sum <= budget) {
                answer++;
            }
        }

        return answer;
    }
}