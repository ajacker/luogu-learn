package level1.mission2;

import java.util.Scanner;

/**
 * 津津的储蓄计划
 *
 * @author ajacker
 * @date 2019/11/23 19:14
 */
public class P1089 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] prepare = new int[12];
        int save = 0;
        for (int i = 0; i < 12; i++) {
            prepare[i] = scanner.nextInt();
        }
        int left = 0;
        for (int i = 0; i < prepare.length; i++) {
            left += 300;
            left -= prepare[i];
            if (left < 0) {
                System.out.printf("-%d", i + 1);
                System.exit(0);
            }
            int saveMoney = (left / 100) * 100;
            left -= saveMoney;
            save += saveMoney;
        }
        System.out.printf("%d", ((int) (left + save * 1.2)));
    }
}
