package level3.mission13;

import java.util.Scanner;

/**
 * P2024 [NOI2001]食物链
 *
 * @author ajacker
 * @date 2019/12/12 14:34
 */
public class P2024 {

    private static int N;
    private static int K;
    private static int[] set;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        K = sc.nextInt();
        set = new int[3 * N + 10];
        for (int i = 1; i <= 3 * N; i++) {
            set[i] = i;
        }
        int ans = 0;
        for (int i = 0; i < K; i++) {
            int type = sc.nextInt();
            int a = sc.nextInt();
            int b = sc.nextInt();
            if (a > N || b > N) {
                ans++;
                continue;
            }
            if (type == 1) {
                //如果a是b的天敌或猎物，显然为谎言
                if (find(a + N) == find(b) || find(a + 2 * N) == find(b)) {
                    ans++;
                    continue;
                }
                //如果为真，那么a的同类和b的同类，a的猎物是b的猎物，a的天敌是b的天敌
                union(a, b);
                union(a + N, b + N);
                union(a + 2 * N, b + 2 * N);
            } else {
                if (a == b) {
                    ans++;
                    continue;
                }
                //如果a是b的同类或猎物，显然为谎言
                if (find(a) == find(b) || find(a + 2 * N) == find(b)) {
                    ans++;
                    continue;
                }
                //如果为真，那么a的同类是b的天敌，a的猎物是b的同类，a的天敌是b的猎物
                union(a, b + 2 * N);
                union(a + N, b);
                union(a + 2 * N, b + N);
            }
        }
        System.out.println(ans);
    }

    static int find(int i) {
        return set[i] == i ? i : (set[i] = find(set[i]));
    }

    static void union(int u, int v) {
        int a = find(u);
        int b = find(v);
        if (a != b) {
            set[a] = b;
        }
    }
}
