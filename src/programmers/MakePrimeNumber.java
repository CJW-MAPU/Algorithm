package programmers;

public class MakePrimeNumber {
    private static boolean[] prime = new boolean[1001];

    public static void main(String[] args) {
        int[] nums = { 1, 2, 3, 4 };

        System.out.println(solution(nums));

    }

    public static int solution(int[] nums) {
        int count = 0;
        checkPrime();

        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                for (int k = j + 1; k < nums.length; k++) {
                    int sum = nums[i] + nums[j] + nums[k];

                    if (!prime[sum]) {
                        count++;
                    }
                }
            }
        }

        return count;
    }

    public static void checkPrime() {
        prime[0] = true;
        prime[1] = true;

        for (int i = 2; i < Math.sqrt(prime.length); i++) {
            if (!prime[i]) {
                for (int j = i + i; j < prime.length; j += i) {
                    prime[j] = true;
                }
            }
        }
    }
}
