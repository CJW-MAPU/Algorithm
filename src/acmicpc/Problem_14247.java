package acmicpc;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Problem_14247 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        long numberOfTree = Long.parseLong(br.readLine());
        String[] inputInitialTreeLength = br.readLine().split(" ");
        String[] inputTreeGrowth = br.readLine().split(" ");

        List<Tree> treeList = new ArrayList<>();

        for (int i = 0; i < numberOfTree; i++) {
            treeList.add(new Tree(inputInitialTreeLength[i], inputTreeGrowth[i]));
        }

        treeList.sort((o1, o2) -> {
            if (o1.getTreeGrowth() == o2.getTreeGrowth()) {
                return (int) (o2.getInitialTreeLength() - o1.getInitialTreeLength());
            } else {
                return (int) (o1.getTreeGrowth() - o2.getTreeGrowth());
            }
        });

        long result = 0;

        for (int i = 0; i < numberOfTree; i++) {
            result += treeList.get(i).getInitialTreeLength() + (treeList.get(i).getTreeGrowth() * i);
        }

        bw.write(String.valueOf(result));

        bw.flush();
        bw.close();
    }
}

class Tree {
    private long initialTreeLength;
    private long TreeGrowth;

    public Tree(String initialTreeLength, String TreeGrowth) {
        this.initialTreeLength = Integer.parseInt(initialTreeLength);
        this.TreeGrowth = Integer.parseInt(TreeGrowth);
    }

    public long getInitialTreeLength() {
        return this.initialTreeLength;
    }

    public long getTreeGrowth() {
        return this.TreeGrowth;
    }

    /*@Override
    public String toString() {
        return " Tree { " + initialTreeLength + ", " + TreeGrowth + " } ";
    }*/
}