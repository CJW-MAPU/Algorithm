package lecture2022;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.stream.IntStream;

public class area_2022572022 {
    public static int N;
    public static long[] histogram;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        histogram = new long[N];
        String[] input = br.readLine().split(" ");
        IntStream.range(0, N).forEach(i -> histogram[i] = Integer.parseInt(input[i]));
        int leftIndex = 0;
        int rightIndex = N - 1;

        long maxArea = getArea(leftIndex, rightIndex);

        System.out.println(maxArea);
    }

    public static long getArea(int leftIndex, int rightIndex) {
        if (leftIndex == rightIndex) {
            return histogram[leftIndex];
        }

        int midIndex = (leftIndex + rightIndex) / 2;

        long leftArea = getArea(leftIndex, midIndex);
        long rightArea = getArea(midIndex + 1, rightIndex);

        long maxArea = Math.max(leftArea, rightArea);

        int leftPointer = midIndex;
        int rightPointer = midIndex + 1;
        long height = Long.MAX_VALUE;

        while (leftIndex <= leftPointer && rightPointer <= rightIndex) {
            height = Math.min(height, Math.min(histogram[leftPointer], histogram[rightPointer]));
            maxArea = Math.max(maxArea, (rightPointer - leftPointer + 1) * height);
            if (leftIndex == leftPointer) {
                rightPointer++;
            } else if (rightIndex == rightPointer) {
                leftPointer--;
            } else if (histogram[leftPointer - 1] <= histogram[rightPointer + 1]) {
                rightPointer++;
            } else {
                leftPointer--;
            }
        }

        return maxArea;
    }
}
