package level2.mission5;

import java.util.Scanner;
import java.util.Stack;

/**
 * P1012 拼数
 *
 * @author ajacker
 * @date 2019/11/26 18:31
 */
public class P1012 {
    static Stack<Integer> stack = new Stack<>();
    static boolean[] visited;
    static String[] strs;
    static String max = "";

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        strs = new String[n];
        visited = new boolean[n];
        for (int i = 0; i < n; i++) {
            strs[i] = sc.next();
        }
        process(0);
        System.out.println(max);

    }

    static void process(int count) {
        if (count == visited.length) {
            StringBuilder sb = new StringBuilder();
            for (Integer i : stack) {
                sb.append(strs[i]);
            }
            String str = sb.toString();
            if (str.length() > max.length() || str.compareTo(max) > 0) {
                max = str;
            }
        }
        for (int i = 0; i < visited.length; i++) {
            if (!visited[i]) {
                visited[i] = true;
                stack.push(i);
                process(count + 1);
                stack.pop();
                visited[i] = false;
            }
        }
    }
}
