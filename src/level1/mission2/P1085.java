package level1.mission2;

import java.util.Scanner;

/**
 * P1085 不高兴的津津
 *
 * @author ajacker
 * @date 2019/11/23 19:07
 */
public class P1085 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int sadDay = 0;
        int sadTime = 0;
        for (int i = 0; i < 7; i++) {
            int time = scanner.nextInt() + scanner.nextInt();
            if (time > 8) {
                if (time > sadTime) {
                    sadDay = i + 1;
                    sadTime = time;
                }
            }
        }
        System.out.println(sadDay);
    }
}
