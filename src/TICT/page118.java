package TICT;

import java.io.*;

public class page118 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    static int[][] map;
    static int N;
    static int M;
    static CharacterPosition character;

    static int numberOfMoves = 0;

    public static void main(String[] args) throws IOException {
        initialMap();
        createCharacter();
        buildMap();
        process();
//        print();
        printResult();
    }

    private static void initialMap() throws IOException {
        String[] size = br.readLine().split(" ");

        N = Integer.parseInt(size[0]);
        M = Integer.parseInt(size[1]);

        map = new int[N][M];
    }

    private static void createCharacter() throws IOException {
        String[] position = br.readLine().split(" ");

        character = new CharacterPosition(position);
    }

    private static void buildMap() throws IOException {
        for (int i = 0; i < N; i++) {
            String[] terrain = br.readLine().split(" ");

            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(terrain[j]);
            }
        }
    }

    private static void process() {
        recordCurrentLocation();
        int count = 0;

        while(true) {
            while(count != 4) {
                count = 0;
                do {
                    character.turnLeft();
                    count++;
                } while (character.frontalTerrain(map) != 0 && count != 4);
                if (count != 4) {
                    character.move();
                    recordCurrentLocation();
                }
            }
            character.turnAround();
            if (character.frontalTerrain(map) == 2) {
                character.move();
                count = 0;
            } else {
                break;
            }
            character.turnAround();
        }
    }

    private static void recordCurrentLocation() {
        int[] location = character.currentLocation();

        map[location[0]][location[1]] = 2;

        numberOfMoves++;
    }

    /*private static void print() throws IOException {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                bw.write(map[i][j] + " ");
            }
            bw.newLine();
        }
        bw.write(character.toString());

        bw.flush();
        bw.close();
    }*/

    private static void printResult() throws IOException {
        bw.write(String.valueOf(numberOfMoves));

        bw.flush();
        bw.close();
    }
}

class CharacterPosition {
    private int x;
    private int y;
    private int direction;

    private final int[] dy = { -1, 0, 1, 0 };
    private final int[] dx = { 0, 1, 0, -1 };

    CharacterPosition(String[] input) {
        this.x = Integer.parseInt(input[1]);
        this.y = Integer.parseInt(input[0]);
        this.direction = Integer.parseInt(input[2]);
    }

    public void turnLeft() {
        if (direction == 0) {
            direction = 3;
        } else {
            direction--;
        }
    }

    public void turnAround() {
        direction = direction + 2;
        if (direction >= 4) {
            direction = direction - 4;
        }
    }

    public int[] currentLocation() {
        return new int[]{ y, x };
    }

    public int frontalTerrain(int[][] map) {
        switch (map[y + dy[direction]][x + dx[direction]]) {
            case 1:
                return 1;
            case 2:
                return 2;
            default:
                return 0;
        }
    }

    public void move() {
        this.x = x + dx[direction];
        this.y = y + dy[direction];
    }

    @Override
    public String toString() {
        return "[ " + this.x + ", " + this.y + ", " + this.direction + " ]";
    }
}
