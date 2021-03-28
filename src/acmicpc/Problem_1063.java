package acmicpc;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Problem_1063 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] inputs = br.readLine().split(" ");

        int N = Integer.parseInt(inputs[2]);

        List<String> move = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            move.add(br.readLine());
        }

        ChessPosition king = new ChessPosition(inputs[0]);
        ChessPosition stone = new ChessPosition(inputs[1]);


        for (int i = 0; i < N; i++) {
            if (king.isMove(move.get(i))) {
                king.move(move.get(i));

                boolean equals = king.toString().equals(stone.toString());

                if (stone.isMove(move.get(i))) {
                    if (equals) {
                        stone.move(move.get(i));
                    }
                } else {
                    if (equals) {
                        king.rollback(move.get(i));
                    }
                }
            }
        }

        bw.write(king.toString());
        bw.newLine();
        bw.write(stone.toString());

        bw.flush();
        bw.close();
    }
}

class ChessPosition {
    private int x;
    private int y;

    ChessPosition(String input) {
        this.x = input.toCharArray()[0] - 64;
        this.y = input.toCharArray()[1] - 48;
    }

    @Override
    public String toString() {
        return (char)(x + 64) + "" + y;
    }

    public void move(String input) {
        if (input.equals("R")) {
            x++;
        } else if (input.equals("L")) {
            x--;
        } else if (input.equals("T")) {
            y++;
        } else if (input.equals("B")) {
            y--;
        } else if (input.equals("RT")) {
            x++;
            y++;
        } else if (input.equals("RB")) {
            x++;
            y--;
        } else if (input.equals("LT")) {
            x--;
            y++;
        } else if (input.equals("LB")) {
            x--;
            y--;
        }
    }

    public void rollback(String input) {
        this.x = -this.x;
        this.y = -this.y;
        move(input);
        this.x = -this.x;
        this.y = -this.y;
    }

    public boolean isMove(String input) {
        boolean flag;

        move(input);
        flag = 1 <= x && x <= 8 && 1 <= y && y <= 8;
        rollback(input);

        return flag;
    }
}
