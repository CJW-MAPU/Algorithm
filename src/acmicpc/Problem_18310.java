package acmicpc;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Problem_18310 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int numberOfAntenna = Integer.parseInt(br.readLine());
        String[] inputOfAntennaPosition = br.readLine().split(" ");

        List<Integer> antennaPositionList = new ArrayList<>();

        for (int i = 0; i < numberOfAntenna; i++) {
            antennaPositionList.add(Integer.parseInt(inputOfAntennaPosition[i]));
        }

        Collections.sort(antennaPositionList);

        bw.write(String.valueOf(antennaPositionList.get((numberOfAntenna - 1) / 2)));

        bw.flush();
        bw.close();
    }
}
