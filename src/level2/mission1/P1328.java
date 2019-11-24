package level2.mission1;

import java.util.Scanner;

/**
 * P1328 生活大爆炸版石头剪刀布
 *
 * @author ajacker
 * @date 2019/11/24 16:58
 */
public class P1328 {
    static boolean[][] rules = new boolean[][]{
            {false, false, true, true, false},
            {true, false, false, true, false},
            {false, true, false, false, true},
            {false, false, true, false, true},
            {true, true, false, false, false}
    };
    static int[] taskA, taskB;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        //猜拳次数
        int n = scanner.nextInt();
        //小 A出拳的周期长度
        int na = scanner.nextInt();
        taskA = new int[na];
        //小 B 出拳的周期长度
        int nb = scanner.nextInt();
        taskB = new int[nb];
        //A的周期任务
        for (int i = 0; i < na; i++) {
            taskA[i] = scanner.nextInt();
        }
        //B的周期任务
        for (int i = 0; i < nb; i++) {
            taskB[i] = scanner.nextInt();
        }
        //分数
        int scoreA = 0, scoreB = 0;
        //进行猜拳
        for (int i = 0; i < n; i++) {
            int a = taskA[i % na];
            int b = taskB[i % nb];
            if (a != b) {
                if (rules[a][b]) {
                    scoreA++;
                } else {
                    scoreB++;
                }
            }
        }
        //输出结果
        System.out.printf("%d %d", scoreA, scoreB);
    }
}
