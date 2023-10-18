import java.util.*;

class Nodeinfo implements Comparable<Nodeinfo> {
    int data;
    int x;
    int y;

    Nodeinfo(int data, int x, int y) {
        this.data = data;
        this.x = x;
        this.y = y;
    }

    @Override
    public int compareTo(Nodeinfo no) {
        if (no.y == this.y) return this.x - no.x;
        else
            return no.y - this.y;
    }

}


class Node {
    int data;
    Node lt;
    Node rt;
    int x;
    int y;

    Node(int data, int x, int y) {
        this.data = data;
        this.x = x;
        this.y = y;
        lt = null;
        rt = null;
    }


}

class Solution {



    static Node binaryTree;
    static ArrayList<Integer> preorder;
    static ArrayList<Integer> postorder;

    public  int[][] solution(int[][] nodeinfo) {
        int[][] answer = new int[2][nodeinfo.length];
        PriorityQueue<Nodeinfo> tmpNodes = new PriorityQueue<>();
        for (int i = 1; i <= nodeinfo.length; i++) {
            tmpNodes.add(new Nodeinfo(i, nodeinfo[i - 1][0], nodeinfo[i - 1][1]));
        }


        ArrayList<Nodeinfo> nodes = new ArrayList<>();
        while (!tmpNodes.isEmpty()) {
            nodes.add(tmpNodes.poll());
        }


        binaryTree = new Node(nodes.get(0).data, nodes.get(0).x, nodes.get(0).y);

        for (int i = 1; i < nodes.size(); i++) {
            Node child = new Node(nodes.get(i).data, nodes.get(i).x, nodes.get(i).y);
            findChildren(child);
        }

        preorder = new ArrayList<>();
        postorder = new ArrayList<>();
        preOrder(binaryTree);
        postOrder(binaryTree);

        for (int j = 0; j < nodeinfo.length; j++) {
            answer[0][j] = preorder.get(j);
            answer[1][j] = postorder.get(j);
        }


        return answer;
    }

    static void findChildren(Node child) {

        Node parent = binaryTree;

        while (true) {
            if (child.x < parent.x) {
                if (parent.lt == null) {
                    parent.lt = child;
                    return;
                } else {
                    parent = parent.lt;
                }
            } else if (child.x > parent.x) {
                if (parent.rt == null) {
                    parent.rt = child;
                    return;
                } else {
                    parent = parent.rt;
                }
            }
        }


    }

    static void preOrder(Node parent) {
        if (parent != null) {
            preorder.add(parent.data);
            preOrder(parent.lt);
            preOrder(parent.rt);

        }
    }

    static void postOrder(Node parent) {
        if (parent != null) {
            postOrder(parent.lt);
            postOrder(parent.rt);
            postorder.add(parent.data);

        }
    }

}