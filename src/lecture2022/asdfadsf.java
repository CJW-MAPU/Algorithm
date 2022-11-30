package lecture2022;

public class asdfadsf {
    public static int[] histogram = {7, 1, 5, 9, 6, 7, 3};

    public static void main(String[] args) {
        int N = 7;

        long area = solution(N);
        System.out.println(area);
    }

    public static long solution(int N) {
        return getArea(0, N - 1);
    }

    public static long getArea(int low, int high) {
        if (low == high) {
            return histogram[low];
        }

        int mid = (low + high) / 2;

        long leftArea = getArea(low, mid);
        long rightArea = getArea(mid + 1, high);

        long max = Math.max(leftArea, rightArea);

        max = Math.max(max, getMidArea(low, high, mid));

        return max;
    }

    public static long getMidArea(int lo, int hi, int mid) {
        int toLeft = mid;
        int toRight = mid;
        long height = histogram[mid];
        long maxArea = height;

        while (lo < toLeft && toRight < hi) {
            if (histogram[toLeft - 1] < histogram[toRight + 1]) {
                toRight++;
                height = Math.min(height, histogram[toRight]);
            }
            else {
                toLeft--;
                height = Math.min(height, histogram[toLeft]);
            }

            maxArea = Math.max(maxArea, height * (toRight - toLeft + 1));
        }

        while (toRight < hi) {
            toRight++;
            height = Math.min(height, histogram[toRight]);
            maxArea = Math.max(maxArea, height * (toRight - toLeft + 1));
        }

        while (lo < toLeft) {
            toLeft--;
            height = Math.min(height, histogram[toLeft]);
            maxArea = Math.max(maxArea, height * (toRight - toLeft + 1));
        }

        return maxArea;
    }
}