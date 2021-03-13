package TICT;

import java.io.*;

public class page110 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        String[] moving = br.readLine().split(" ");

        Position position = new Position();

        for (int i = 0; i < moving.length; i++) {
            position.move(moving[i], N);
        }

        bw.write(position.printPosition());

        bw.flush();
        bw.close();
    }
}

class Position {
    private int x;
    private int y;

    Position() {
        this.x = 1;
        this.y = 1;
    }

    void move(String input, int N) {
        if (input.equals("R")) {
            if (y < N) {
                y++;
            }
        } else if (input.equals("L")) {
            if (y > 1) {
                y--;
            }
        } else if (input.equals("U")) {
            if (x > 1) {
                x--;
            }
        } else if (input.equals("D")) {
            if (x < N) {
                x++;
            }
        }
    }

    String printPosition() {
        return this.x + " " + this.y;
    }
}