package level1.mission4;

import java.util.Scanner;

/**
 * P1047 校门外的树
 *
 * @author ajacker
 * @date 2019/11/23 20:51
 */
public class P1047 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int L = scanner.nextInt();
        int M = scanner.nextInt();
        boolean[] hasRemoved = new boolean[L + 1];
        for (int i = 0; i < M; i++) {
            int start = scanner.nextInt();
            int end = scanner.nextInt();
            for (int j = start; j <= end; j++) {
                hasRemoved[j] = true;
            }
        }
        int leftTree = 0;
        for (boolean b : hasRemoved) {
            if (!b) {
                leftTree++;
            }
        }
        System.out.println(leftTree);
    }
}
