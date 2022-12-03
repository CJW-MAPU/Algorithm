package lecture2022;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.stream.IntStream;

public class add_2022572022_test {
    public static void main(String[] args) throws IOException {
        int[] histogram = {2, 1, 4, 5, 1, 3, 3};
        int[] testCase1 = {1000, 1000, 1000, 1000};
        int[] testCase2 = {6, 2, 2, 2, 6};
        int[] testCase3 = {0, 0, 0, 0, 0, 0, 0};
        int[] testCase4 = {7, 1, 5, 9, 6, 7, 3};
        int[] testCase5 = {5, 4, 3, 2, 1};
        int N = histogram.length;
        solution(N, histogram);
        solution(testCase1.length, testCase1);
        solution(testCase2.length, testCase2);
        solution(testCase3.length, testCase3);
        solution(testCase4.length, testCase4);
        solution(testCase5.length, testCase5);
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        while (true) {
//            String input = br.readLine();
//            if (input.equals("0")) {
//                break;
//            }
//
//            String[] token = input.split(" ");
//            int[] temp = new int[token.length];
//
//            IntStream.range(0, token.length).forEach(i -> temp[i] = Integer.parseInt(token[i]));
//            int N = temp[0];
//            int[] histogram = Arrays.copyOfRange(temp, 1, temp.length);
//
//            solution(N, histogram);
//        }
    }

    public static void solution(int N, int[] histogram) {
        int left = 0;
        int right = N - 1;

        int result = getArea(left, right, histogram);
        System.out.println(result);
    }

    public static int getArea(int low, int high, int[] histogram) {
        if (low == high) {
            return histogram[low];
        }
        int minIndex = findMinIndex(low, high, histogram);
        int maxArea = 0;
        if (low == 0 && high == histogram.length - 1) {
            maxArea = histogram[minIndex] * histogram.length;
            System.out.println("Init minIndex : " + minIndex);
            System.out.println("Init MaxArea : " + maxArea);
        }
        System.out.println(minIndex);
        int left = getArea(low, minIndex, histogram);
        int right = getArea(minIndex + 1, high, histogram);

        maxArea = Math.max(maxArea, (high - low) * histogram[minIndex]);
        maxArea = Math.max(maxArea, Math.max(left, right));

        return maxArea;
    }

    public static int findMinIndex(int low, int high, int[] histogram) {
        int min = Integer.MAX_VALUE;
        int index = -1;
        for (int i = low; i <= high; i++) {
            if (min > histogram[i]) {
                min = histogram[i];
                index = i;
            }
        }

        return index;
    }
}
