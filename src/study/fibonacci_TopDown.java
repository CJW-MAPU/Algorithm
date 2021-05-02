package study;

public class fibonacci_TopDown {

    static int[] memo = new int[100];

    public static void main(String[] args) {

        System.out.println(fibonacci(10));


        for (int i = 0; i < 20; i++) {
            System.out.print(memo[i] + " ");
        }

    }

    private static int fibonacci(int idx) {
        if (idx == 1 || idx == 2) {
            return 1;
        }

        if (memo[idx] != 0) {
            return memo[idx];
        }

        memo[idx] = fibonacci(idx - 1) + fibonacci(idx - 2);

        return memo[idx];
    }
}
