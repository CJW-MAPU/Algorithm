package programmers;

import java.util.*;

public class LengthOfVisit {
    public static void main(String[] args) {
        String dirs = "LULLLLLLU";
//        String dirs = "ULURRDLLU";

        System.out.println(solution(dirs));
    }

    public static int solution(String dirs) {

        String[] array = dirs.split("");

        Map<String, int[]> map = new HashMap<>();
        map.put("L", new int[] {-1, 0});
        map.put("R", new int[] {1, 0});
        map.put("U", new int[] {0, 1});
        map.put("D", new int[] {0, -1});

        Set<String> set = new HashSet<>();

        int nx = 0;
        int ny = 0;

        for (int i = 0; i < array.length; i++) {
            String s = array[i];

            int x = map.get(s)[0];
            int y = map.get(s)[1];

            nx += x;
            ny += y;

            if (nx < -5 || nx > 5) {
                nx -= x;
                continue;
            }

            if (ny < -5 || ny > 5) {
                ny -= y;
                continue;
            }

            set.add("" + (nx - x) + "" + (ny - y) + "" + nx + "" + ny);
            set.add("" + nx + ""+ ny + "" + (nx - x) + "" + (ny - y));
        }

        return set.size() / 2;
    }
}
