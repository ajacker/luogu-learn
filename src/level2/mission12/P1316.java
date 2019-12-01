package level2.mission12;

import java.util.Arrays;
import java.util.Scanner;

/**
 * P1316 丢瓶盖
 *
 * @author ajacker
 * @date 2019/12/1 19:56
 */
public class P1316 {

    private static int a;
    private static int b;
    private static int[] pos;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        a = sc.nextInt();
        b = sc.nextInt();
        pos = new int[a + 1];
        for (int i = 1; i <= a; i++) {
            pos[i] = sc.nextInt();
        }
        Arrays.sort(pos);
        int ans = 0, left = 0, right = pos[a];
        //若mid为解，则最优解一定属于[mid, right]。若mid不为解，则最优解一定属于[right, mid)
        while (left <= right) {
            int mid = (left + right) / 2;
            if (check(mid)) {
                //mid如果为解就更新最优解，并且往右找可能的更优解
                left = mid + 1;
                ans = Integer.max(ans, mid);
            } else {
                //否则解应该在左侧
                right = mid - 1;
            }
        }
        System.out.print(ans);

    }

    /**
     * 检查n是否能够有可能作为答案
     *
     * @param n
     * @return 是否能够有可能
     */
    private static boolean check(int n) {
        int count = 1, pre = pos[1];
        //尝试加入瓶盖
        for (int i = 2; i <= a; i++) {
            //如果当前瓶盖和上一个的距离大于等于假设的最近距离
            //代表可以加入此瓶盖
            if (pos[i] - pre >= n) {
                count++;
                pre = pos[i];
            }
        }
        //如果数量满足至少b个，就代表此解可行
        return count >= b;
    }
}
