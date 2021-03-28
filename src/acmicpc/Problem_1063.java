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
                if (stone.isMove(move.get(i))) {
                    king.move(move.get(i));

                    if (king.toString().equals(stone.toString())) {
                        stone.move(move.get(i));
                    }
                } else {
                    king.move(move.get(i));

                    if (king.toString().equals(stone.toString())) {
                        king.setX(-king.getX());
                        king.setY(-king.getY());
                        king.move(move.get(i));
                        king.setX(-king.getX());
                        king.setY(-king.getY());
                    }
                }
            }
        }

        /*for (int i = 0; i < N; i++) {
            king.move(move.get(i));

            if (king.toString().equals(stone.toString())) {
                stone.move(move.get(i));
            }
        }*/

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

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    @Override
    public String toString() {
        return (char)(x + 64) + "" + y;
//        return x + "" + y;
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

    public boolean isMove(String input) {
        switch (input) {
            case "R":
                if (x < 8) {
                    return true;
                }
                break;
            case "L":
                if (x > 1) {
                    return true;
                }
                break;
            case "T":
                if (y < 8) {
                    return true;
                }
                break;
            case "B":
                if (y > 1) {
                    return true;
                }
                break;
            case "RT":
                if (x < 8 && y < 8) {
                    return true;
                }
                break;
            case "RB":
                if (x < 8 && y > 1) {
                    return true;
                }
                break;
            case "LT":
                if (x > 1 && y < 8) {
                    return true;
                }
                break;
            case "LB":
                if (x > 1 && y > 1) {
                    return true;
                }
                break;
        }

        return false;
    }
}
