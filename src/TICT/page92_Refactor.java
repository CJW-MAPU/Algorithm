package TICT;

import java.io.*;
import java.util.*;

public class page92_Refactor {
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
            list.add(Integer.parseInt(st.nextToken()));
        }

        list.sort(Comparator.reverseOrder());

        int first = list.get(0);
        int second = list.get(1);

        int MaxValueCount = (M / (K + 1)) * K;
        MaxValueCount += M % (K + 1);

        int result = MaxValueCount * first;
        result += (M - MaxValueCount) * second;

        bw.write(String.valueOf(result));

        bw.flush();
        bw.close();
    }
}
