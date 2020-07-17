package SWM;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Problem_Brix {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String firstInput = br.readLine();
        String secondInput = br.readLine();

        List<Integer> brix = new ArrayList<>();

        int sum = 0;

        StringTokenizer st = new StringTokenizer(secondInput);

        while(st.hasMoreTokens()) {
            brix.add(Integer.parseInt(st.nextToken()));
        }

        int max = 0;

        for (int i = 0; i < Integer.parseInt(firstInput); i++) {
            sum += brix.get(i);
            if(sum <= 0) {
                sum = 0;
            } else {
                if(max < sum) {
                    max = sum;
                }
            }
        }
        if (max == 0) {
            System.out.println(Collections.max(brix));
        } else {
            System.out.println(max);
        }

        /* Test Case #1
        4
        -1 -2 -3 -4
        -1
         */

        /* Test Case #2
        4
        1 2 3 4
        10
         */

        /* Test Case #3
        4
        0 0 0 0
        0
        */
    }
}
