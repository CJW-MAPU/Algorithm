package acmicpc;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Problem_1541 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        boolean flag = false;

        String str = br.readLine();
        StringTokenizer st = new StringTokenizer(str, "+-", true);

        List<Integer> operand = new ArrayList<Integer>();
        List<String> operator = new ArrayList<String>();

        while(st.hasMoreTokens()) {
            String token = st.nextToken();
            try {
                operand.add(Integer.parseInt(token));
            } catch (NumberFormatException e) {
                operator.add(token);
            }
        }

        int sum = 0;
        int temp = 0;

        int a = 0;

        for(int i = 0; i < operator.size(); i++) {
            if(operator.get(i).equals("-")) {
                a = i;
                flag = true;
                break;
            }
        }
        if(flag) {
            for(int i = 0; i <= a; i++) {
                sum += operand.get(i);
            }

            for(int i = a + 1; i < operand.size(); i++) {
                temp += operand.get(i);
            }
        } else {
            for(int i = 0; i < operand.size(); i++) {
                sum += operand.get(i);
            }
        }
        sum -= temp;

        /*for (int i = 0; i < operator.size(); i++) {
            sum += operand.get(i);
            if(operator.get(i).equals("-")) {
                j = i + 1;
                flag = true;
                break;
            }
            if(i == operator.size() - 1) {
                sum += operand.get(i + 1);
            }
        }

        if(flag) {
            for (int i = j; i < operand.size(); i++) {
                sum += -operand.get(i);
            }
        }*/

        /*int temp = 0;
        for (int i = 0; i < operand.size() - 1; i++) {
            if((operator.get(i).equals("-") && !flag)) {
                flag = true;
                sum += operand.get(i);
                temp += operand.get(i + 1);
                if(i == operator.size() - 1) {
                    sum += (-temp);
                }
                System.out.println("1: "+sum);

            } else if(operator.get(i).equals("+") && flag) {
                temp += operand.get(i + 1);
                sum += (-temp);
                temp = 0;
                System.out.println("2: "+sum);

            } else if(operator.get(i).equals("+") && !flag) {
                sum += operand.get(i);
                if(i == operator.size() - 1) {
                    sum += operand.get(i + 1);
                }
                System.out.println("3: "+sum);

            } else if(operator.get(i).equals("-") && flag) {
                sum += (-temp);
                if(i == operator.size() - 1) {
                    sum += (-operand.get(i + 1));
                }
                temp = 0;
                temp += operand.get(i + 1);
                System.out.println("4: "+sum);

            }
        }*/

        bw.write(String.valueOf(sum));
        bw.flush();
        bw.close();
    }
}

