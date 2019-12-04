package level2.mission15;

import java.util.Scanner;

/**
 * P1164 小A点菜
 *
 * @author ajacker
 * @date 2019/12/4 10:19
 */
public class P1164 {

    private static int n;
    private static int m;
    private static int[] price;
    private static int[][] method;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        price = new int[n + 1];
        for (int i = 1; i <= m; i++) {
            price[i] = sc.nextInt();
        }
        method = new int[n + 1][m + 1];
        //前i个菜
        for (int i = 1; i <= n; i++) {
            //花光j元
            for (int j = 1; j <= m; j++) {
                if (price[i] == j) {
                    //如果第i道菜的价格等于要花完的价格，那么花的方法多了一个（就是只买第i个菜）
                    method[i][j] = method[i - 1][j] + 1;
                } else if (price[i] < j) {
                    //如果第i个菜的价格小于要花完的价格，那么花的方法等于不买这个菜花光j元的+买这个菜花光j-这个菜价格的花法
                    method[i][j] = method[i - 1][j] + method[i - 1][j - price[i]];
                } else {
                    //如果买不起第i个菜，那么花法就只能和买前i-1个菜花完j元的办法一样了
                    method[i][j] = method[i - 1][j];
                }
            }
        }
        System.out.print(method[n][m]);
    }
}
