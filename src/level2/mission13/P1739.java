package level2.mission13;

import java.util.Scanner;
import java.util.Stack;

/**
 * P1739 表达式括号匹配
 *
 * @author ajacker
 * @date 2019/12/2 17:52
 */
public class P1739 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        System.out.print(judgeMatch(str) ? "YES" : "NO");
    }

    static boolean judgeMatch(String str) {
        Stack<Character> stack = new Stack<>();
        char[] chars = str.toCharArray();
        for (char c : chars) {
            if (c == '(') {
                stack.push(c);
            } else if (c == ')') {
                if (!stack.isEmpty()) {
                    stack.pop();
                } else {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }
}
