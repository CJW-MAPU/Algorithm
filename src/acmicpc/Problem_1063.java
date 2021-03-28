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
//        return x + "" + y;
    }

    public void move(String input) {
        if (input.equals("R")) {
            if (x < 8) {
                x++;
            }
        } else if (input.equals("L")) {
            if (x > 1) {
                x--;
            }
        } else if (input.equals("T")) {
            if (y < 8) {
                y++;
            }
        } else if (input.equals("B")) {
            if (y > 1) {
                y--;
            }
        } else if (input.equals("RT")) {
            if (x < 8 && y < 8) {
                x++;
                y++;
            }
        } else if (input.equals("RB")) {
            if (x < 8 && y > 1) {
                x++;
                y--;
            }
        } else if (input.equals("LT")) {
            if (x > 1 && y < 8) {
                x--;
                y++;
            }
        } else if (input.equals("LB")) {
            if (x > 1 && y > 1) {
                x--;
                y--;
            }
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
