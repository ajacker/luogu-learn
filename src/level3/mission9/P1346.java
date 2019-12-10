package level3.mission9;

import java.util.*;

/**
 * P1346 电车
 *
 * @author ajacker
 * @date 2019/12/10 12:18
 */
public class P1346 {

    private static int N;
    private static int A;
    private static int B;
    private static ArrayList<Integer>[] map;
    private static int[] switches;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        A = sc.nextInt();
        B = sc.nextInt();
        map = new ArrayList[N + 1];
        switches = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            map[i] = new ArrayList<>();
            int Ki = sc.nextInt();
            for (int j = 0; j < Ki; j++) {
                int v = sc.nextInt();
                map[i].add(v);
                //记录开关的起始状态
                switches[i] = j == 0 ? v : switches[i];
            }
        }
        spfa(A, B);

    }

    static void spfa(int start, int end) {
        boolean[] inQueue = new boolean[N + 1];
        int[] times = new int[N + 1];
        Queue<Integer> queue = new LinkedList<>();
        Arrays.fill(times, Integer.MAX_VALUE);
        queue.offer(start);
        times[start] = 0;
        inQueue[start] = true;
        while (!queue.isEmpty()) {
            Integer u = queue.poll();
            inQueue[u] = false;
            for (Integer v : map[u]) {
                //开关对就不用调，不对就调一次
                int time = switches[u] == v ? 0 : 1;
                if (times[u] + time < times[v]) {
                    times[v] = times[u] + time;
                    //调开关
                    switches[u] = v;
                    if (!inQueue[v]) {
                        queue.offer(v);
                        inQueue[v] = true;
                    }
                }
            }
        }
        //输出调整次数，如果end没有改变代表走不到
        System.out.println(times[end] == Integer.MAX_VALUE ? -1 : times[end]);
    }


}
