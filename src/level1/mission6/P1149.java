package level1.mission6;

import java.util.Scanner;

/**
 * P1149 火柴棒等式
 *
 * @author ajacker
 * @date 2019/11/23 23:25
 */
public class P1149 {
    static int[] info = new int[1000];
    static int count = 0;

    static {
        info[0] = 6;
        info[1] = 2;
        info[2] = 5;
        info[3] = 5;
        info[4] = 4;
        info[5] = 5;
        info[6] = 6;
        info[7] = 3;
        info[8] = 7;
        info[9] = 6;
    }

    public static void main(String[] args) {
        //求所有两位数所需要的火柴棒数量
        for (int i = 1; i <= 9; i++) {
            for (int j = 0; j <= 9; j++) {
                info[i * 10 + j] = info[i] + info[j];
            }
        }
        //求所有三位数
        for (int i = 1; i <= 9; i++) {
            for (int j = 0; j <= 9; j++) {
                info[i * 100 + j] = info[i] + info[0] + info[j];
            }
            for (int j = 10; j <= 99; j++) {
                info[i * 100 + j] = info[i] + info[j];
            }
        }

        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        for (int i = 0; i < 1000; i++) {
            for (int j = 0; j < 1000; j++) {
                for (int k = 0; k < 1000; k++) {
                    if (i + j == k && info[i] + info[j] + info[k] == n - 4) {
                        count++;
                    }
                }
            }
        }
        System.out.println(count);

    }

}
