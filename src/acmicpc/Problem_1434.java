package acmicpc;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Problem_1434 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        List<Integer> box = new ArrayList<>();
        List<Integer> book = new ArrayList<>();

        String input = br.readLine();

        StringTokenizer st = new StringTokenizer(input);

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        input = br.readLine();

        st = new StringTokenizer(input);

        for (int i = 0; i < N; i++) {
            box.add(Integer.parseInt(st.nextToken()));
        }

        input = br.readLine();

        st = new StringTokenizer(input);

        for (int i = 0; i < M; i++) {
            book.add(Integer.parseInt(st.nextToken()));
        }

        int boxValue = 0;
        int bookValue = 0;

        for (int item : box) {
            boxValue += item;
        }

        for (int item : book) {
            bookValue += item;
        }

        bw.write(String.valueOf(boxValue - bookValue));

        bw.flush();
        bw.close();
    }
}