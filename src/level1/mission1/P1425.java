package level1.mission1;

import java.util.Scanner;

/**
 * @author ajacker
 * @date 2019/11/23 18:34
 */
public class P1425 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int a = scanner.nextInt(), b = scanner.nextInt(), c = scanner.nextInt(), d = scanner.nextInt();
        int totalMinutes = (c * 60 + d) - (a * 60 + b);
        System.out.printf("%d %d", totalMinutes / 60, totalMinutes % 60);
    }
}
