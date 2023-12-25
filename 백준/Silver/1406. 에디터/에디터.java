import org.w3c.dom.Node;

import java.io.*;
import java.util.*;


class Main {

    static String N;
    static LinkedList<Character> nodes;
    static int idx;
    static Stack<Character> left;
    static Stack<Character> right;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = null;

        N = br.readLine();
        int M = Integer.parseInt(br.readLine());

        left = new Stack<>();
        right = new Stack<>();

        for (int j = 0; j < N.length(); j++) {
            left.add(N.charAt(j));
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            char command = st.nextToken().charAt(0);
            if (st.countTokens() == 0) {
                command(command);
            } else {
                char ch = st.nextToken().charAt(0);
                left.add(ch);
            }
        }


       for(char ch: left) {
           bw.write(ch+"");
       }

        while (!right.isEmpty()) {
            bw.write(right.pop()+"");
        }

        br.close();
        bw.flush();
        br.close();
    }


    public static void command(char command) {
        if (command == 'L') {
            if (!left.isEmpty()) {
                right.add(left.pop());
            }

        } else if (command == 'D') {
            if (!right.isEmpty()) {
                left.add(right.pop());
            }

        } else if (command == 'B') {
            if (!left.isEmpty()) {
                left.pop();
            }
        }

    }
}


