package programmers;

public class JumpAndTeleport {
    public static void main(String[] args) {
        int n = 5000;

        System.out.println(solution(n));
    }

    public static int solution(int n) {
        int count = 0;

        while (true) {
            if (n == 1) {
                count++;
                break;
            }

            if (n % 2 == 0) {
                n /= 2;
            } else {
                n -= 1;
                count ++;
            }
        }

        return count;
    }
}
