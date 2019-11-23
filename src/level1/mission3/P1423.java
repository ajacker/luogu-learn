package level1.mission3;

import java.util.Scanner;

/**
 * 小玉在游泳
 *
 * @author ajacker
 * @date 2019/11/23 20:07
 */
public class P1423 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double aim = scanner.nextDouble();
        int step = 0;
        double dis = 0;
        double last = 2;
        while (dis < aim) {
            dis += last;
            last *= 0.98;
            step++;
        }
        System.out.println(step);
    }
}
