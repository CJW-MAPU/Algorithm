package TICT;

import java.io.*;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class page178 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int input = Integer.parseInt(br.readLine());

        List<Integer> list = new ArrayList<>();

        for (int i = 0; i < input; i++) {
            list.add(Integer.parseInt(br.readLine()));
        }

        list.sort(Comparator.reverseOrder());

        for (int item :
                list) {
            bw.write(item + " ");
        }

        bw.flush();
        bw.close();
    }
}
