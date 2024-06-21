import java.io.*;
import java.util.*;

public class Main {
    static Node head = new Node('A', null, null); // 트리는 A부터 시작
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int N = Integer.parseInt(st.nextToken());

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            char root = st.nextToken().charAt(0);
            char left = st.nextToken().charAt(0);
            char right = st.nextToken().charAt(0);

            insertNode(head, root, left, right);
        }

        preOrder(head);
        System.out.println();
        inOrder(head);
        System.out.println();
        postOrder(head);
        System.out.println();
    }


    static class Node {
        char value;
        Node left;
        Node right;

        Node(char value, Node left, Node right) {
            this.value = value;
            this.left = left;
            this.right = right;
        }
    }

    public static void insertNode(Node tmp, char root, char left, char right) {
        if (tmp.value == root) {
            tmp.left = (left == '.' ? null : new Node(left, null, null));
            tmp.right = (right == '.' ? null : new Node(right, null, null));
        } else {
            if (tmp.left != null) {
                insertNode(tmp.left, root, left, right);
            }
            if (tmp.right != null) {
                insertNode(tmp.right, root, left, right);
            }
        }
    }

    private static void preOrder(Node node) {
        if (node == null) {
            return;
        }
        System.out.print(node.value); 
        preOrder(node.left); 
        preOrder(node.right); 
    }

    private static void inOrder(Node node) {
        if (node == null) { 
            return;
        }
        inOrder(node.left); 
        System.out.print(node.value); 
        inOrder(node.right); 
    }

    private static void postOrder(Node node) {
        if (node == null) { 
            return;
        }
        postOrder(node.left); 
        postOrder(node.right);
        System.out.print(node.value);
    }
}