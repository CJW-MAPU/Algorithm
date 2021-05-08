package programmers;

/* NOTE : 이거 못풀었음 제대로 42점 나옴 ; */
public class InstallStation {
    static int[] map;

    public static void main(String[] args) {
        int n = 16;
        int[] stations = {9};
        int w = 2;

        System.out.println(solution(n, stations, w));
    }

    public static int solution(int n, int[] stations, int w) {
        int[] dx = {-1 , 1};

        map = new int[n];

        for (int station : stations) {
            map[station - 1] = 2;
            for (int i = 0; i < 2; i++) {
                if (!(station + (dx[i] * w) < 0 || station + (dx[i] * 2) > n)) {
                    for (int j = 1; j <= w; j++) {
                        map[station - 1 + (dx[i] * j)] = 1;
                    }
                }
            }
        }

        for (int i = 0; i < map.length; i++) {
            System.out.print(map[i] + " ");
        }
        System.out.println();

        boolean flag = false;
        int count = 0;

        int leftIndex = -1;
        int rightIndex = -1;

        for (int i = 0; i < map.length; i++) {
            System.out.println(i + "   ===========================");
            if(!flag) {
                if (map[i] == 0) {
                    flag = true;
                    leftIndex = i;
                }
            } else {
                if (map[i] == 1) {
                    flag = false;
                    rightIndex = i;
                } else if (i == map.length - 1) {
                    flag = false;
                    rightIndex = i;
                }
            }
            System.out.println(leftIndex + " " + rightIndex);
            if ((leftIndex != -1 && rightIndex != -1)) {
                int areaSize = rightIndex - leftIndex;
                System.out.println(areaSize);
                count = count + (areaSize / ((2 * w) + 1)) + 1;
                leftIndex = -1;
                rightIndex = -1;
            }
        }

        return count;
    }


}
