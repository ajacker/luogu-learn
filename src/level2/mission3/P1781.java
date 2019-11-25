package level2.mission3;

import java.util.Scanner;

/**
 * P1781 宇宙总统
 *
 * @author ajacker
 * @date 2019/11/25 23:04
 */
public class P1781 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int maxId = 0;
        String max = "";
        for (int i = 0; i < n; i++) {
            String temp = scanner.next();
            //字符串长的一定大，如果字符串相同那么比较字典序（compareTo就是比较字典序的）
            if (temp.length() > max.length() || (temp.length() == max.length() && temp.compareTo(max) > 0)) {
                maxId = i + 1;
                max = temp;
            }
        }
        System.out.println(maxId);
        System.out.print(max);
    }
}
