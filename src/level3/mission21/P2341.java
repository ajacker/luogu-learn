package level3.mission21;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StreamTokenizer;
import java.util.ArrayList;
import java.util.Stack;

/**
 * P2341 【模板】强连通分量 / [HAOI2006]受欢迎的牛
 *
 * @author ajacker
 * @date 2019/12/13 0:19
 */
public class P2341 {
    private static Stack<Short> stack = new Stack<>();
    private static int N, M, index, id;
    private static short[] dfn, low, type, count, du;
    private static boolean[] inStack;
    private static ArrayList<Short>[] map;
    private static StreamTokenizer in = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));

    public static void main(String[] args) throws IOException {
        in.nextToken();
        N = (int) in.nval;
        dfn = new short[N + 1];
        low = new short[N + 1];
        type = new short[N + 1];
        count = new short[N + 1];
        du = new short[N + 1];
        inStack = new boolean[N + 1];
        map = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) {
            map[i] = new ArrayList<>();
        }
        in.nextToken();
        M = (int) in.nval;
        for (int i = 0; i < M; i++) {
            in.nextToken();
            short a = (short) in.nval;
            in.nextToken();
            short b = (short) in.nval;
            map[a].add(b);
        }

        //从所有点出发找可能的连通分量
        for (short i = 1; i <= N; i++) {
            if (dfn[i] == 0) {
                tarjan2(i);
            }
        }
        for (int u = 1; u <= N; u++) {
            for (Short v : map[u]) {
                //遍历每一个点并记录出度(连通图的出度)
                if (type[u] != type[v]) {
                    du[type[u]]++;
                }
            }
        }
        int res = -1;
        for (int i = 1; i <= id; i++) {
            if (du[i] == 0) {
                if (res != -1) {
                    //两次出现出度为0直接输出0
                    System.out.println(0);
                    return;
                }
                //记录出度为零的分量的类号
                res = i;
            }
        }
        //输出该强联通分量(出度为0）中的点数量
        System.out.println(count[res]);

    }

    /**
     * 非递归的tarjan 模拟栈
     *
     * @param u
     */
    static void tarjan2(short u) {
        Stack<Short> tStack = new Stack<>();
        tStack.push(u);
        while (!tStack.isEmpty()) {
            Short cur = tStack.peek();
            //只有第一次才初始化（因为这是peek，之后会来的时候不能走这部分
            if (dfn[cur] == 0) {
                dfn[cur] = low[cur] = (short) ++index;
                stack.push(cur);
                inStack[cur] = true;
            }
            int i = 0;
            boolean flag = false;
            while (i < map[cur].size()) {
                short next = map[cur].get(i);
                if (dfn[next] == 0) {
                    tStack.push(next);
                    //模拟递归调用，压栈并不继续后面的
                    flag = true;
                    break;
                } else if (inStack[next]) {
                    //如果遇到了自己的父亲，那自己的父亲肯定有机会更新自己的low
                    low[cur] = (short) Integer.min(low[cur], dfn[next]);
                }
                i++;
            }
            if (flag) {
                continue;
            }
            //如果本层遍历完成，处理联通分量(模拟for循环中的递归完成)
            if (i == map[cur].size()) {
                short v = tStack.pop();
                if (dfn[cur] == low[cur]) {
                    int next;
                    ++id;
                    do {
                        next = stack.pop();
                        inStack[next] = false;
                        type[next] = (short) id;
                        count[id]++;
                    } while (cur != next);
                }
                //模拟回溯后更新父节点的low
                if (!tStack.isEmpty()) {
                    low[tStack.peek()] = (short) Integer.min(low[tStack.peek()], low[v]);
                }
            }
        }
    }


    static void tarjan(short u) {
        dfn[u] = low[u] = (short) ++index;
        stack.push(u);
        inStack[u] = true;
        for (Short v : map[u]) {
            if (dfn[v] == 0) {
                tarjan(v);
                //更新当前点的low  表示这个点以及其子孙节点连的所有点中dfn最小的值
                low[u] = (short) Integer.min(low[u], low[v]);
            } else if (inStack[v]) {
                //如果遇到了自己的父亲，那自己的父亲肯定有机会更新自己的low
                low[u] = (short) Integer.min(low[u], dfn[v]);
            }
        }
        //处理联通分量
        if (dfn[u] == low[u]) {
            int v;
            ++id;
            do {
                v = stack.pop();
                inStack[v] = false;
                type[v] = (short) id;
                count[id]++;
            } while (u != v);
        }
    }
}
