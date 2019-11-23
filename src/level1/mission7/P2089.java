package level1.mission7;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;
import java.util.stream.Collectors;

/**
 * P2089 烤鸡
 *
 * @author ajacker
 * @date 2019/11/24 0:32
 */
public class P2089 {
    static Stack<Integer> method = new Stack<>();
    static List<String> result = new ArrayList<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        process(n, 10);
        if (result.size() == 0) {
            System.out.print(0);
        } else {
            System.out.println(result.size());
            System.out.println(String.join("\n", result));
        }

    }

    public static void process(int n, int left) {
        if (left == 0) {
            if (n == 0) {
                result.add(method.stream().map(String::valueOf).collect(Collectors.joining(" ")));
            }
            return;
        }
        for (int i = 1; i <= 3; i++) {
            method.push(i);
            process(n - i, left - 1);
            method.pop();
        }
    }
}
