package acmicpc;

import java.io.*;

public class Problem_5639 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        Node root = new Node(Integer.parseInt(br.readLine()));

        while (true) {
            try {
                root.insertNode(Integer.parseInt(br.readLine()));
            } catch (Exception e) {
                break;
            }
        }

        postOrder(root);

        bw.flush();
        bw.close();
    }

    public static class Node {
        Node left;
        Node right;
        int data;

        public Node(int data) {
            this.data = data;
        }

        public void insertNode(int data) {
            if (data < this.data) {
                if (!hasLeft()) {
                    this.left = new Node(data);
                } else {
                    left.insertNode(data);
                }
            } else if (this.data < data) {
                if (!hasRight()) {
                    this.right = new Node(data);
                } else {
                    right.insertNode(data);
                }
            }
        }

        public boolean hasLeft() {
            return left != null;
        }

        public boolean hasRight() {
            return right != null;
        }
    }

    public static void postOrder(Node node) {
        if (node != null) {
            postOrder(node.left);
            postOrder(node.right);
            System.out.println(node.data);
        }
    }
}