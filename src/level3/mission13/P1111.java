package level3.mission13;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

/**
 * P1111 修复公路
 *
 * @author ajacker
 * @date 2019/12/12 14:13
 */
public class P1111 {

    private static int N;
    private static int M;
    private static int[] parent;
    private static ArrayList<Mission> missions = new ArrayList<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();
        parent = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            parent[i] = i;
        }
        for (int i = 0; i < M; i++) {
            int u = sc.nextInt();
            int v = sc.nextInt();
            int t = sc.nextInt();
            missions.add(new Mission(u, v, t));
        }
        Collections.sort(missions);
        int count = 0;
        for (Mission mission : missions) {
            if (union(mission.u, mission.v)) {
                count++;
            }
            if (count == N - 1) {
                System.out.print(mission.t);
                System.exit(0);
            }
        }
        System.out.print(-1);

    }

    static int find(int i) {
        return parent[i] == i ? i : (parent[i] = find(parent[i]));
    }

    static boolean union(int u, int v) {
        int a = find(u);
        int b = find(v);
        if (a == b) {
            return false;
        } else {
            parent[a] = b;
            return true;
        }
    }

    static class Mission implements Comparable<Mission> {
        int u, v, t;

        public Mission(int u, int v, int t) {
            this.u = u;
            this.v = v;
            this.t = t;
        }

        @Override
        public int compareTo(Mission o) {
            return t - o.t;
        }
    }
}
