package level1.mission6;

import java.util.HashMap;
import java.util.Scanner;

/**
 * P1028 数的计算
 * 递归+记忆化
 *
 * @author ajacker
 * @date 2019/11/23 22:22
 */
public class P1028 {
    static HashMap<Integer, Integer> result = new HashMap<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        System.out.println(process(n));

    }

    public static int process(int n) {
        //如果之前求过，直接返回结果
        if (result.containsKey(n)) {
            return result.get(n);
        }
        if (n == 1) {
            return 1;
        }
        int half = n / 2;
        int count = 1;
        for (int i = 1; i <= half; i++) {
            count += process(i);
        }
        //将结果存入（记忆）
        result.put(n, count);
        return count;
    }

}
