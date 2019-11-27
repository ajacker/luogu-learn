package level2.mission7;

import java.util.Scanner;
import java.util.Stack;

/**
 * P1219 八皇后
 *
 * @author ajacker
 * @date 2019/11/27 12:47
 */
public class P1219 {

    private static int n;
    private static Stack<Integer> stack = new Stack<>();
    /**
     * 记录列是否访问
     */
    private static boolean[] colVisited;
    /**
     * 记录左撇
     */
    private static boolean[] leftVisited;
    /**
     * 记录右撇
     */
    private static boolean[] rightVisited;
    private static int count = 0;
    private static int outCount = 0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        colVisited = new boolean[n + 1];
        leftVisited = new boolean[2 * n];
        rightVisited = new boolean[2 * n];
        dfs(1);
        System.out.print(count);
    }

    private static void dfs(int i) {
        if (i == n + 1) {
            if (outCount < 3) {
                for (Integer num : stack) {
                    System.out.print(num + " ");
                }
                System.out.println();
                outCount++;
            }
            count++;
            return;
        }
        for (int j = 1; j <= n; j++) {
            if (check(i, j)) {
                setVisited(i, j);
                stack.push(j);
                dfs(i + 1);
                stack.pop();
                unsetVisited(i, j);
            }
        }
    }


    private static boolean check(int i, int j) {
        if (leftVisited[i + j - 1]) {
            return false;
        }
        if (rightVisited[n + i - j]) {
            return false;
        }
        if (colVisited[j]) {
            return false;
        }
        return true;
    }

    private static void setVisited(int i, int j) {
        leftVisited[i + j - 1] = true;
        rightVisited[n + i - j] = true;
        colVisited[j] = true;
    }

    private static void unsetVisited(int i, int j) {
        leftVisited[i + j - 1] = false;
        rightVisited[n + i - j] = false;
        colVisited[j] = false;
    }


}
