package level2.mission14;

import java.util.HashMap;
import java.util.Scanner;

/**
 * P1305 新二叉树
 *
 * @author ajacker
 * @date 2019/12/3 19:59
 */
public class P1305 {

    private static int n;
    private static HashMap<Character, Node> map = new HashMap<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        Node r = null;
        for (int i = 0; i < n; i++) {
            char[] chars = sc.next().toCharArray();
            Node root = get(chars[0]);
            r = r == null ? root : r;
            Node left = get(chars[1]);
            Node right = get(chars[2]);
            root.left = left;
            root.right = right;
        }
        preOrder(r);
    }

    private static void preOrder(Node root) {
        System.out.print(root.val);
        if (root.left != null) {
            preOrder(root.left);
        }
        if (root.right != null) {
            preOrder(root.right);
        }
    }

    static Node get(char c) {
        if (c == '*') {
            return null;
        }
        if (!map.containsKey(c)) {
            map.put(c, new Node(c));
        }
        return map.get(c);
    }

    static class Node {
        char val;
        Node left, right;

        public Node(char val) {
            this.val = val;
        }
    }
}
