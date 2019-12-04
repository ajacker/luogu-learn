package level2.mission15;

import java.util.Scanner;

/**
 * P1048 采药
 *
 * @author ajacker
 * @date 2019/12/4 14:54
 */
public class P1048 {

    private static int T;
    private static int M;
    private static int[] cost;
    private static int[] value;
    private static int[][] dp;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        //总共能够用来采药的时间
        T = sc.nextInt();
        //山洞里的草药的数目
        M = sc.nextInt();
        cost = new int[M + 1];
        value = new int[M + 1];
        for (int i = 1; i <= M; i++) {
            cost[i] = sc.nextInt();
            value[i] = sc.nextInt();
        }
//        dp=new int[M+1][T+1];
//        for (int i = 1; i <= M; i++) {
//            for (int j = 1; j <= T; j++) {
//                dp[i][j]=dp[i-1][j];
//                if(cost[i]<=j){
//                    //从采不采草药中选择价值最大的
//                    dp[i][j]=Integer.max(dp[i][j],dp[i-1][j-cost[i]]+value[i]);
//                }
//            }
//        }
        //System.out.print(dp[M][T]);
        int[] dp = new int[T + 1];
        for (int i = 1; i <= M; i++) {
            //倒序，避免覆盖前面的结果（要用j-cost[i])
            for (int j = T; j >= cost[i]; j--) {
                dp[j] = Math.max(dp[j], dp[j - cost[i]] + value[i]);
            }
        }
        System.out.print(dp[T]);


    }
}
