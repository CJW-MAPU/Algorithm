package TICT;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;

public class page152 {
    static Queue<String> queue = new LinkedList<>();

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    static int[][] maze;

    static int[] dx = { -1, 1, 0, 0 };
    static int[] dy = { 0, 0, -1, 1 };

    public static void main(String[] args) throws IOException {
        buildMaze();
        bfs(0, 0);
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

    private static void bfs(int x, int y) throws IOException {
        String positionString = positionToString(x, y);
        queue.add(positionString);

        while (!queue.isEmpty()) {
            int[] position = stringToPosition(queue.remove());

            for (int i = 0; i < 4; i++) {
                int nx = position[0] + dx[i];
                int ny = position[1] + dy[i];

                if (nx < 0 || nx > maze.length - 1 || ny < 0 || ny > maze[0].length - 1) {
                    continue;
                }

                if (maze[nx][ny] == 0) {
                    continue;
                }

                if (maze[nx][ny] == 1) {
                    maze[nx][ny] = maze[position[0]][position[1]] + 1;
                    queue.add(positionToString(nx, ny));
                }
            }
        }
//        bw.write(String.valueOf(maze[maze.length - 1][maze[0].length - 1]));
//        bw.flush();
//        bw.close();

        for (int i = 0; i < maze.length; i++) {
            for (int j = 0; j < maze[i].length; j++) {
                System.out.format("%3d", maze[i][j]);
            }
            System.out.println();
        }
    }

    private static int[] stringToPosition(String input) {
        String[] temp = input.split(" ");
        return new int[]{ Integer.parseInt(temp[0]), Integer.parseInt(temp[1]) };
    }

    private static String positionToString(int x, int y) {
        return x + " " + y;
    }
}
