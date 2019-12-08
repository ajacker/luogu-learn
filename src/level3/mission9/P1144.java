package level3.mission9;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * P1144 最短路计数
 * 最短路
 *
 * @author ajacker
 * @date 2019/12/8 10:58
 */
public class P1144 {
    /**
     * 顶点数
     */
    private static int N;
    /**
     * 边数
     */
    private static int M;
    /**
     * 储存图的领接表
     */
    private static ArrayList<Integer>[] map;

    public static void main(String[] args) {
        N = InputReader.nextInt();
        M = InputReader.nextInt();
        map = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) {
            map[i] = new ArrayList<>();
        }
        for (int i = 0; i < M; i++) {
            int x = InputReader.nextInt();
            int y = InputReader.nextInt();
            map[x].add(y);
            map[y].add(x);
        }
        spfa(1);
    }

    /**
     * spfa算法
     *
     * @param start 起始点
     */
    public static void spfa(int start) {
        boolean[] inQueue = new boolean[N + 1];
        int[] distance = new int[N + 1];
        Arrays.fill(distance, Integer.MAX_VALUE);
        //开始点到自己的距离为0
        distance[start] = 0;
        //开始点在队列内
        inQueue[start] = true;
        //初始化队列
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(start);
        //计算最短路径个数
        int[] count = new int[N + 1];
        count[start] = 1;
        //开始算法
        while (!queue.isEmpty()) {
            Integer u = queue.poll();
            inQueue[u] = false;
            //遍历以它为起点的所有边
            for (Integer v : map[u]) {
                //更新最短距离
                if (distance[u] + 1 < distance[v]) {
                    distance[v] = distance[u] + 1;
                    //最短距离更新的话，那么到达v点的方法数量就等于到达u的数量（因为更新的时候是u-v的路径）
                    count[v] = count[u];
                    //如果不在队列就入队
                    if (!inQueue[v]) {
                        queue.offer(v);
                        inQueue[v] = true;
                    }
                } else if (distance[u] + 1 == distance[v]) {
                    //距离相同的话，那么到达v点的方法数量就加上到达u的方法数量（因为是相当于多了u-v的路径）
                    count[v] = (count[v] + count[u]) % 100003;
                }
            }
        }
        for (int i = 1; i <= N; i++) {
            System.out.println(count[i]);
        }

    }

    /**
     * 速读
     */
    static class InputReader {
        private static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        private static StringTokenizer tokenizer = null;

        private static String next() {
            while (tokenizer == null || !tokenizer.hasMoreTokens()) {
                try {
                    tokenizer = new StringTokenizer(reader.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return tokenizer.nextToken();
        }

        private static int nextInt() {
            return Integer.parseInt(next());
        }
    }

}
