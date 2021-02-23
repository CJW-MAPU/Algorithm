package TICT;

import java.io.*;
import java.util.*;

public class page92 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String inputValue = br.readLine();
        String inputList = br.readLine();

        StringTokenizer st = new StringTokenizer(inputValue);

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        List<Integer> list = new ArrayList<>();

        st = new StringTokenizer(inputList);

        for (int i = 0; i < N; i++) {
            list.add(Integer.valueOf(st.nextToken()));
        }

        Collections.sort(list);

        int result = 0;
        int count = 0;

        while(count < M) {
            for (int i = 0; i < K; i++) {
                result += list.get(N - 1);
                count++;
            }
            result += list.get(N - 2);
            count++;
        }

        bw.write(String.valueOf(result));
        bw.flush();
        bw.close();
    }
}
