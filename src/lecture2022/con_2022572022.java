package lecture2022;

import java.util.Arrays;
import java.util.stream.IntStream;

public class con_2022572022 {

    public static void main(String[] args) {
        int[] input = {-10, -7, 5, -7, 10, 5, -2, 17, -25, 1};
//        int[] testcase_1 = {-10, -2, -3, -4, -5, -6, -7, -8, -9, -1};
//        int[] testcase_2 = {0, 0, 0, 0, 0, 10, -1, 1, 5, 6};

        solution(input);
    }

    private static void solution(int[] input) {
        /*
         * 입력 배열 input 에 대하여 최대 연속 부분 수열의 합을 구하는 solution.
         * Dynamic Programming 을 활용하여 문제 해결.
         * Dynamic Programming 문제 해결 방식 중 Memoization 방식을 활용하여 문제 해결.
         * Memoization 기법은 실행 속도 증가를 위해 메모리를 소비하는 기법이므로 해당 문제 해결에 알맞음.
         *
         * 해당 솔루션은 O(n)의 시간복잡도를 가짐. 모든 메소드의 for 문이 n개의 입력에 대해 1회 순회하기 때문임.
         * for 문이 총 3번 사용되었고, 모두 for{} for{} for{} 형태로 따로 동작하기에 O(3n)이며, 상수를 상쇄하여 O(n)임.
         * */
        int[] memoization = new int[input.length];
        memoization[0] = input[0];

        IntStream.range(1, input.length).forEach(i -> memoization[i] = Math.max(0, memoization[i - 1]) + input[i]);
        int[] subSequence = findSubSequence(input, memoization);

        System.out.println("구간합이 최대가 되는 SubSequence : " + Arrays.toString(subSequence));
        System.out.println("최대 구간합 : " + Arrays.stream(subSequence).sum());
    }

    private static int[] findSubSequence(int[] input, int[] memoization) {
        /*
        * 구간합이 최대가 되는 서브 시퀀스를 추출하는 메소드.
        * 이 메소드에서 호출되는 findEndIndexOfSubSequence 메소드와 findStartIndexOfSubSequence 메소드 모두 O(n)이므로,
        * 마찬가지로 O(n)의 시간복잡도를 가짐.
        * */
        int endIndex = findEndIndexOfSubSequence(memoization);
        int startIndex = findStartIndexOfSubSequence(input, memoization, endIndex);

        return Arrays.copyOfRange(input, startIndex, endIndex + 1);
    }

    private static int findStartIndexOfSubSequence(int[] input, int[] memoization, int endIndex) {
        /*
        * 서브 시퀀스의 시작 지점을 추출하는 메소드.
        * n개의 배열을 for 문 하나로 1회 순회하므로, O(n)의 시간복잡도를 가짐.
        * */
        int index = -1;
        for (int i = 0; i < input.length; i++) {
            if ((input[i] == memoization[i]) && (index < endIndex)) {
                index = i;
            }
        }

        return index;
    }

    private static int findEndIndexOfSubSequence(int[] memoization) {
        /*
        * 서브 시퀀스의 끝 지점을 추출하는 메소드.
        * n개의 배열을 for 문 하나로 1회 순회하므로, O(n)의 시간복잡도를 가짐.
        * */
        int max = Integer.MIN_VALUE;
        int index = -1;

        for (int i = 0; i < memoization.length; i++) {
            if (memoization[i] >= max) {
                max = memoization[i];
                index = i;
            }
        }

        return index;
    }
}
