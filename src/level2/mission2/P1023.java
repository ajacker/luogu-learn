package level2.mission2;

import java.util.Scanner;

/**
 * P1023 税收与补贴问题
 *
 * @author ajacker
 * @date 2019/11/24 17:24
 */
public class P1023 {
    private static int[] sellCount = new int[100000 + 100];

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int except = scanner.nextInt();
        //成本
        int m = scanner.nextInt();
        //成本销售量
        int n = scanner.nextInt();
        sellCount[m] = n;
        // 上一次的价格
        int prev = m;
        while (true) {
            int x = scanner.nextInt();
            int y = scanner.nextInt();
            if (x == -1 && y == -1) {
                break;
            }


            sellCount[x] = y;
            //递推填充未知价格销量
            for (int i = prev + 1; i < x; i++) {
                sellCount[i] = sellCount[i - 1] + (y - sellCount[prev]) / (x - prev);
            }
            prev = x;

        }
        int downPerPrice = scanner.nextInt();
        //递推填充可能的更高价格直到销量大于0
        while (sellCount[prev] > downPerPrice) {
            prev++;
            sellCount[prev] = sellCount[prev - 1] - downPerPrice;
        }
        //从成本到最大可能值的递推（prev刚刚好推到最大的价格）
        double max = 1e9;
        double min = -1e9;
        for (int i = m; i <= prev; i++) {
            double ans = (sellCount[except] * (except - m) - sellCount[i] * (i - m)) * 1f / (sellCount[i] - sellCount[except]);
            //求(x+d[i])*(i-r)<=（x+d[x_])+(x_-r)的通解，x_是期望价格
            double g = sellCount[i] - sellCount[except];
            //判断解的符号,g为正是小于，反之为大于。

            if (g > 0) {
                //取所有"x<=..."中的最小值
                max = Math.min(max, ans);
            } else if (g < 0) {
                //取所有"x>=..."中的最大值
                min = Math.max(min, ans);
            }
        }
        if (min > 0) {
            //Max>Min>0，答案为Min上取整
            System.out.printf("%d", (int) Math.ceil(min));
        } else if (max < 0) {
            //Min<Max<0，答案为Max下取整
            System.out.printf("%d", (int) Math.floor(max));
        } else {
            //Min<0<Max，显然是0绝对值最小
            System.out.print(0);
        }

    }
}
