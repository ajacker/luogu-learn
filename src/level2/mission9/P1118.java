package level2.mission9;

import java.util.Scanner;

/**
 * P1118 [USACO06FEB]数字三角形
 *
 * @author ajacker
 * @date 2019/11/29 0:27
 */
public class P1118 {

    private static int n;
    private static int sum;
    private static int[] nums;
    private static boolean[] visited;
    private static int[][] yhsj = new int[14][14];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        nums = new int[n];
        visited = new boolean[n + 1];
        sum = sc.nextInt();
        makes();
        dfs(0, 0);
    }

    static void dfs(int count, int ans) {
        //剪枝
        if (ans > sum) {
            return;
        }
        //满足条件返回
        if (count == n && ans == sum) {
            for (int num : nums) {
                System.out.print(num + " ");
            }
            System.exit(0);
        }
        for (int i = 1; i <= n; i++) {
            if (!visited[i]) {
                visited[i] = true;
                nums[count] = i;
                //带着这一步的结果递归
                dfs(count + 1, ans + i * yhsj[n][count + 1]);
                visited[i] = false;
            }
        }
    }

    /**
     * 构造杨辉三角
     */
    static void makes() {

        yhsj[1][1] = 1;
        for (int i = 2; i <= n; i++) {
            for (int j = 1; j <= i; j++) {
                yhsj[i][j] = yhsj[i - 1][j - 1] + yhsj[i - 1][j];
            }
        }
    }

}
