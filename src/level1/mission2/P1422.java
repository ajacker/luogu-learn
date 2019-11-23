package level1.mission2;

import java.util.Scanner;

/**
 * P1422 小玉家的电费
 *
 * @author ajacker
 * @date 2019/11/23 18:43
 */
public class P1422 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        double money = 0;
        money += n > 150 ? 150 * 0.4463 : n * 0.4463;
        money += n > 400 ? 250 * 0.4663 : n > 150 ? (n - 150) * 0.4663 : 0;
        money += n > 400 ? (n - 400) * 0.5663 : 0;
        System.out.printf("%.1f", money);
    }
}
