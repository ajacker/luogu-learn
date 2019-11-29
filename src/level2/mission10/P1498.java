package level2.mission10;

import java.util.Arrays;
import java.util.Scanner;

/**
 * P1498 南蛮图腾
 *
 * @author ajacker
 * @date 2019/11/29 16:23
 */
public class P1498 {
    private static char[][] map = new char[2048][2048];
    private static int n;

    public static void main(String[] args) {
        StringBuilder sb = new StringBuilder();
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        for (int i = 0; i < 2048; i++) {
            Arrays.fill(map[i], ' ');
        }
        map[0][0] = map[1][1] = '/';
        map[0][1] = map[0][2] = '_';
        map[0][3] = map[1][2] = '\\';
        int len = 2;

        for (int i = 0; i < n - 1; i++) {
            len *= 2;
            //复制出右边的
            for (int j = 0; j < len; j++) {
                for (int k = 0; k < len; k++) {
                    map[k][len + j] = map[k][j];
                }
            }
            //复制出上面的
            for (int j = 0; j < len; j++) {
                for (int k = 0; k < len / 2; k++) {
                    map[len / 2 + k][len / 2 + j] = map[k][j];
                }
            }
        }


        for (int i = len - 1; i >= 0; i--) {
            for (int j = 0; j < 2048; j++) {
                sb.append(map[i][j]);
            }
            sb.append('\n');
        }
        System.out.print(sb.toString());
    }
}
