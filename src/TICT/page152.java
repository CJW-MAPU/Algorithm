package TICT;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;

public class page152 {
    static Queue<Character> queue = new LinkedList<>();

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    static int[][] maze;

    public static void main(String[] args) throws IOException {
        buildMaze();
    }

    private static void buildMaze() throws IOException {
        String[] input = br.readLine().split(" ");
        int N = Integer.parseInt(input[0]);
        int M = Integer.parseInt(input[1]);

        maze = new int[N][M];

        for (int i = 0; i < N; i++) {
            String[] terrain = br.readLine().split("");
            for (int j = 0; j < M; j++) {
                maze[i][j] = Integer.parseInt(terrain[j]);
            }
        }
    }

    private static void process() throws IOException {

    }
}
