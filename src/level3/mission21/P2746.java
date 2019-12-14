package level3.mission21;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StreamTokenizer;
import java.util.ArrayList;
import java.util.Stack;

/**
 * P2746 [USACO5.3]校园网Network of Schools
 *
 * @author ajacker
 * @date 2019/12/14 15:36
 */
public class P2746 {
    private static StreamTokenizer in = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
    private static int N;
    private static ArrayList<Integer>[] map;
    private static int[] dfn, low, type, inDegree, outDegree;
    private static Stack<Integer> stack = new Stack<>();
    private static int tot, id;
    private static boolean[] inStack;

    public static void main(String[] args) throws IOException {
        in.nextToken();
        N = (int) in.nval;
        map = new ArrayList[N + 1];
        dfn = new int[N + 1];
        low = new int[N + 1];
        inDegree = new int[N + 1];
        outDegree = new int[N + 1];
        type = new int[N + 1];
        inStack = new boolean[N + 1];
        for (int i = 1; i <= N; i++) {
            map[i] = new ArrayList<>();
        }
        for (int i = 1; i <= N; i++) {
            while (true) {
                in.nextToken();
                int n = (int) in.nval;
                if (n == 0) {
                    break;
                } else {
                    map[i].add(n);
                }
            }
        }
        for (int i = 1; i <= N; i++) {
            if (dfn[i] == 0) {
                tarjan(i);
            }
        }
        for (int u = 1; u <= N; u++) {
            int a = type[u];
            for (int v : map[u]) {
                int b = type[v];
                if (a != b) {
                    //u的类型的出度+1
                    outDegree[a]++;
                    //v的类型的入度+1
                    inDegree[b]++;

                }
            }
        }
        //求聚点后的出度和入度
        int zeroIn = 0, zeroOut = 0;
        for (int i = 1; i <= id; i++) {
            if (inDegree[i] == 0) {
                zeroIn++;
            }
            if (outDegree[i] == 0) {
                zeroOut++;
            }
        }
        //输出结果
        if (id == 1) {
            System.out.print("1\n0");
        } else {
            System.out.printf("%d\n%d", zeroIn, Math.max(zeroIn, zeroOut));
        }
    }

    public static void tarjan(int u) {
        dfn[u] = low[u] = ++tot;
        stack.push(u);
        inStack[u] = true;
        for (Integer v : map[u]) {
            if (dfn[v] == 0) {
                tarjan(v);
                low[u] = Math.min(low[u], low[v]);
            } else if (inStack[v]) {
                low[u] = Math.min(low[u], dfn[v]);
            }
        }
        if (low[u] == dfn[u]) {
            int t;
            ++id;
            do {
                t = stack.pop();
                inStack[t] = false;
                type[t] = id;
            } while (u != t);

        }
    }
}
