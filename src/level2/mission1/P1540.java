package level2.mission1;

import java.util.*;

/**
 * P1540 机器翻译
 *
 * @author ajacker
 * @date 2019/11/24 13:50
 */
public class P1540 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int m = scanner.nextInt(), n = scanner.nextInt();
        //模拟内存
        Queue<Integer> queue = new LinkedList<>();
        //去重
        Set<Integer> set = new HashSet<>();
        int count = 0;
        for (int i = 0; i < n; i++) {
            int number = scanner.nextInt();
            if (set.add(number)) {
                count++;
                queue.offer(number);
            }
            if (queue.size() > m) {
                set.remove(queue.poll());
            }
        }
        System.out.println(count);
    }
}
