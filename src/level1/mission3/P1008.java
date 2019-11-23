package level1.mission3;

import java.util.HashSet;

/**
 * P1008 三连击
 *
 * @author ajacker
 * @date 2019/11/23 19:38
 */
public class P1008 {
    public static void main(String[] args) {
        HashSet<Integer> set = new HashSet<>();
        for (int i = 1; i < 10; i++) {
            for (int j = 1; j < 10; j++) {
                if (j != i) {
                    for (int k = 1; k < 10; k++) {
                        if (k != i && k != j) {
                            int num1 = 100 * i + 10 * j + k;
                            int num2 = 2 * num1;
                            int num3 = 3 * num1;
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
                                System.out.printf("%d %d %d\n", num1, 2 * num1, 3 * num1);
                            }
                        }
                    }
                }

            }
        }
    }
}
