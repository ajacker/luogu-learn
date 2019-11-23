package level1.mission7;

import java.util.HashSet;
import java.util.Scanner;

/**
 * P1618 三连击（升级版）
 *
 * @author ajacker
 * @date 2019/11/24 0:25
 */
public class P1618 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int A = scanner.nextInt(), B = scanner.nextInt(), C = scanner.nextInt();
        HashSet<Integer> set = new HashSet<>();
        boolean hasResult = false;
        for (int i = 1; i < 10; i++) {
            for (int j = 1; j < 10; j++) {
                if (j != i) {
                    for (int k = 1; k < 10; k++) {
                        if (k != i && k != j) {
                            int num1 = 100 * i + 10 * j + k;
                            if (num1 % A != 0) {
                                continue;
                            }
                            int num2 = B * num1 / A;
                            int num3 = C * num1 / A;
                            set.clear();
                            //添加第一个数字的三个位和0，因为不能有0
                            set.add(i);
                            set.add(j);
                            set.add(k);
                            set.add(0);
                            boolean flag = true;
                            //尝试添加其他的数字，有重复就不输出
                            while (num2 != 0) {
                                if (!set.add(num2 % 10)) {
                                    flag = false;
                                    break;
                                }
                                num2 /= 10;
                            }
                            while (num3 != 0) {
                                if (!set.add(num3 % 10)) {
                                    flag = false;
                                    break;
                                }
                                num3 /= 10;
                            }
                            if (flag) {
                                hasResult = true;
                                System.out.printf("%d %d %d\n", num1, B * num1 / A, C * num1 / A);
                            }
                        }
                    }
                }

            }
        }
        if (!hasResult) {
            System.out.println("No!!!");
        }
    }
}
