package level1.mission8;

import java.util.Scanner;

/**
 * P1426 小鱼会有危险吗
 *
 * @author ajacker
 * @date 2019/11/24 0:54
 */
public class P1426 {
    static double distance = 7;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int s = scanner.nextInt(), x = scanner.nextInt();
        boolean danger = false;
        boolean dictated = false;
        int pos = 0;
        while (pos <= s + x) {
            if (pos >= s - x) {
                if (dictated) {
                    danger = true;
                    break;
                }
                dictated = true;
            }
            pos += distance;
            distance *= 0.98;
        }
        System.out.println(danger ? 'y' : 'n');
    }
}
