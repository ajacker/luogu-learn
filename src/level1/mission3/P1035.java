package level1.mission3;

import java.util.Scanner;

/**
 * 级数求和
 *
 * @author ajacker
 * @date 2019/11/23 19:51
 */
public class P1035 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int k = scanner.nextInt();
        double sum = 0;
        int n = 1;
        while (sum <= k) {
            sum += 1d / n++;
        }
        System.out.print(n - 1);
    }
}
