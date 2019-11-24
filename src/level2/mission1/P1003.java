package level2.mission1;

import java.util.Scanner;

/**
 * P1003 铺地毯
 *
 * @author ajacker
 * @date 2019/11/24 12:50
 */
public class P1003 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] a = new int[n];
        int[] b = new int[n];
        int[] g = new int[n];
        int[] k = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = scanner.nextInt();
            b[i] = scanner.nextInt();
            g[i] = scanner.nextInt();
            k[i] = scanner.nextInt();
        }
        int x = scanner.nextInt(), y = scanner.nextInt();
        //从最后一块地毯往前遍历，查看(x，y)是否在范围内
        for (int i = n - 1; i >= 0; i--) {
            if (x >= a[i] && x <= a[i] + g[i] && y >= b[i] && y <= b[i] + k[i]) {
                System.out.println(i + 1);
                System.exit(0);
            }
        }
        System.out.println(-1);
    }
}
