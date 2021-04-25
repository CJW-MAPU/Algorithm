package acmicpc;

import java.io.*;

public class Problem_16918 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1};

        String[] input = br.readLine().split(" ");
        int R = Integer.parseInt(input[0]);
        int C = Integer.parseInt(input[1]);
        int N = Integer.parseInt(input[2]);

        char[][] field = new char[R][C];
        int[][] map = new int[R][C];
        boolean[][] visited;

        for (int i = 0; i < R; i++) {
            field[i] = br.readLine().toCharArray();
        }

        for (int i = 0; i < field.length; i++) {
            for (int j = 0; j < field[0].length; j++) {
                if (field[i][j] == 'O') {
                    map[i][j] += 1;
                }
            }
        }

        for (int t = 2; t <= N; t++) {
            if (t % 2 == 0) { // 짝수
                for (int i = 0; i < R; i++) {
                    for (int j = 0; j < C; j++) {
                        if (field[i][j] == 'O') {
                            map[i][j]++;
                        }
                        field[i][j] = 'O';
                    }
                }
            } else { // 홀수
                visited = new boolean[R][C];
                for (int i = 0; i < R; i++) {
                    for (int j = 0; j < C; j++) {

                        if(!visited[i][j]) {
                            map[i][j]++;
                        }

                        if (map[i][j] == 3) {
                            visited[i][j] = true;
                            map[i][j] = 0;
                            for (int k = 0; k < 4; k++) {
                                int nx = i + dx[k];
                                int ny = j + dy[k];

                                if (nx < 0 || nx >= R || ny < 0 || ny >= C) {
                                    continue;
                                } else {
                                    if (map[nx][ny] != 2) {
                                        map[nx][ny] = 0;
                                        visited[nx][ny] = true;
                                    }
                                }
                            }
                        }
                    }
                }
                for (int i = 0; i < R; i++) {
                    for (int j = 0; j < C; j++) {
                        if (map[i][j] == 0) {
                            field[i][j] = '.';
                        } else {
                            field[i][j] = 'O';
                        }
                    }
                }
            }
        }
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                bw.write(String.valueOf(field[i][j]));
            }
            bw.newLine();
        }
        bw.flush();
        bw.close();
    }
}