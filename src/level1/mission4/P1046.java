package level1.mission4;

import java.util.Scanner;

/**
 * P1046 陶陶摘苹果
 *
 * @author ajacker
 * @date 2019/11/23 20:47
 */
public class P1046 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] height = new int[10];
        for (int i = 0; i < 10; i++) {
            height[i] = scanner.nextInt();
        }
        int len = scanner.nextInt();
        int count = 0;
        for (int i = 0; i < height.length; i++) {
            if (len + 30 >= height[i]) {
                count++;
            }
        }
        System.out.println(count);
    }
}
