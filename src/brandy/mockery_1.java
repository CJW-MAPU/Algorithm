package brandy;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class mockery_1 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N, K;
        int count = 0;
        StringTokenizer st;
        List<Integer> list = new ArrayList<>();

        String input1 = br.readLine();
        String input2 = br.readLine();

        st = new StringTokenizer(input1, " ");
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(input2, " ");
        while (st.hasMoreTokens()) {
            list.add(Integer.parseInt(st.nextToken()));
        }

        Collections.sort(list);

        int a = list.get(0);
        for (int i = 1; i < list.size(); i = i + K - 1) {
            for (int j = i; j < i + K - 1; j++) {
                if (j == list.size()) {
                    break;
                }
                list.set(j, a);
            }
            count++;
        }

        System.out.println(count);
    }
}
