package level2.mission14;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * P1087 FBI树
 *
 * @author ajacker
 * @date 2019/12/3 20:56
 */
public class P1087 {

    private static int N;
    private static ArrayList<Node> nodes = new ArrayList<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        int size = ((int) Math.pow(2, N));
        char[] chars = sc.next().toCharArray();
        for (int i = 0; i < size; i++) {
            nodes.add(new Node(chars[i] == '0' ? 'B' : 'I'));
        }
        while (nodes.size() > 1) {
            int sz = nodes.size();
            for (int i = 0; i < sz; i += 2) {
                Node root = new Node(nodes.get(i), nodes.get(i + 1));
                nodes.add(root);
            }
            for (int i = 0; i < sz; i++) {
                nodes.remove(0);
            }
        }
        Node root = nodes.get(0);
        lastOrder(root);
    }

    static void lastOrder(Node root) {
        if (root.left != null) {
            lastOrder(root.left);
        }
        if (root.right != null) {
            lastOrder(root.right);
        }
        System.out.print(root.val);
    }

    static class Node {
        char val;
        Node left, right;

        Node(char val) {
            this.val = val;
        }

        Node(Node left, Node right) {
            if (left.val == right.val) {
                this.val = left.val;
            } else {
                this.val = 'F';
            }
            this.left = left;
            this.right = right;
        }
    }
}
