package acmicpc;

import java.io.*;

public class Problem_2606 {

    static int virusCount = 0;
    static int[][] mappingInfo;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int numberOfComputer = Integer.parseInt(br.readLine());
        int numberOfMapping = Integer.parseInt(br.readLine());
        mappingInfo = new int[numberOfComputer + 1][numberOfComputer * 2];
        int[] count = new int[numberOfComputer + 1];
        visited = new boolean[numberOfComputer + 1];

        for (int i = 0; i < numberOfMapping; i++) {
            String[] input = br.readLine().split(" ");
            int n = Integer.parseInt(input[0]);
            int m = Integer.parseInt(input[1]);
            mappingInfo[n][count[n]++] = m;
            mappingInfo[m][count[m]++] = n;
        }


        dfs(1);
        bw.write(String.valueOf(virusCount));
        bw.flush();
        bw.close();
    }

    private static void dfs(int n) {
        int i = 0;
        visited[1] = true;
        while (mappingInfo[n][i] != 0) {
            int a = mappingInfo[n][i];
            if (!visited[a]) {
                visited[a] = true;
                virusCount++;
                dfs(a);
            }
            i++;
        }
    }
}
