package level2.mission16;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StreamTokenizer;

/**
 * P1020 导弹拦截
 *
 * @author ajacker
 * @date 2019/12/5 0:14
 */
public class P1020 {
    static int[] infos = new int[100010];
    static StreamTokenizer in = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));

    public static void main(String[] args) throws IOException {
        solve2();
    }

    static void solve2() throws IOException {
        int len = 1;
        while (in.nextToken() != StreamTokenizer.TT_EOF) {
            infos[len++] = (int) in.nval;
        }
        int[] queue = new int[len];
        int last = 0;
        //求最长不减少子序列
        queue[0] = Integer.MAX_VALUE;
        for (int i = 1; i < len; i++) {
            if (infos[i] <= queue[last]) {
                //如果可以插入单调队列，就插入队尾
                queue[++last] = infos[i];
            } else {
                //二分查找合适的位置覆盖(比要插入的数字小的靠左的）
                int left = 1, right = last;
                while (left < right) {
                    int mid = (left + right) / 2;
                    if (infos[i] <= queue[mid]) {
                        left = mid + 1;
                    } else {
                        right = mid;
                    }
                }
                queue[right] = infos[i];
            }
        }
        System.out.println(last);
        //查找最长上升子序列
        queue[0] = 0;
        last = 0;
        for (int i = 1; i < len; i++) {
            if (infos[i] > queue[last]) {
                //如果可以插入单调队列，就插入队尾
                queue[++last] = infos[i];
            } else {
                //二分查找合适的位置覆盖(比要插入的数字大或者等于的的靠左的）
                int left = 1, right = last;
                while (left < right) {
                    int mid = (left + right) / 2;
                    if (infos[i] > queue[mid]) {
                        left = mid + 1;
                    } else {
                        right = mid;
                    }
                }
                queue[right] = infos[i];
            }
        }
        System.out.print(last);
    }

    static void solve1() throws IOException {
        int len = 1;
        while (in.nextToken() != StreamTokenizer.TT_EOF) {
            infos[len++] = (int) in.nval;
        }
        int[] dp1 = new int[len];
        int[] dp2 = new int[len];
        int res1 = 0, res2 = 0;
        //求最长不增子序列（以i开始)
        for (int i = len - 1; i >= 1; i--) {
            dp1[i] = 1;
            //找从i位置往后的比它小的
            for (int j = i + 1; j < len; j++) {
                if (infos[j] <= infos[i]) {
                    dp1[i] = Integer.max(dp1[i], dp1[j] + 1);
                }
            }
            res1 = Integer.max(res1, dp1[i]);
        }
        //求最长上升子序列(以i结尾）
        for (int i = 1; i < len; i++) {
            dp2[i] = 1;
            //找从i位置往前的比它小的
            for (int j = 1; j < i; j++) {
                if (infos[j] < infos[i]) {
                    dp2[i] = Integer.max(dp2[i], dp2[j] + 1);
                }
            }
            res2 = Integer.max(res2, dp2[i]);
        }
        System.out.printf("%d\n%d", res1, res2);
    }
}
