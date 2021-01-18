package brandy;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class first_1 {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        List<Integer> list = new ArrayList<>();
        List<Integer> range = new ArrayList<>();
        range.add(60); range.add(68); range.add(75); range.add(80); range.add(90); // 60% 68% 75% 80% 90%
        int []result = { 0, 0, 0, 0, 0, 0 };

        String input = "";

        // 최대 심박수
        int maxHeartRate = 220 - /*Integer.parseInt(br.readLine());*/ scanner.nextInt();

        // 최대 심박수 기준 %
        for (int i = 0; i < range.size(); i++) {
            range.set(i, (maxHeartRate * range.get(i)) / 100);
        }

        // 입력 및 운동의 형태 구분
        while(/*(input = br.readLine()) != null*/scanner.hasNextLine()) {
            list.add(scanner.nextInt());
            /*int num = Integer.parseInt(input);
            range.add(num);
            Collections.sort(range);
            int pos = Collections.binarySearch(range, num);
            result[pos]++;
            range.remove(pos);*/
        }

        for (int num : list) {
            if(num < range.get(0)) {
                result[0]++;
            }
            else if(range.get(0) <= num && num < range.get(1)) {
                result[1]++;
            }
            else if(range.get(1) <= num && num < range.get(2)) {
                result[2]++;
            }
            else if(range.get(2) <= num && num < range.get(3)) {
                result[3]++;
            }
            else if(range.get(3) <= num && num < range.get(4)) {
                result[4]++;
            }
            else if(range.get(4) <= num) {
                result[5]++;
            }
        }
        System.out.println(list);
        System.out.println(range);
        System.out.format("%d %d %d %d %d %d", result[5], result[4], result[3], result[2], result[1], result[0]);
    }
}
