package level1.mission5;


import java.util.Scanner;

/**
 * P1914 小书童——密码
 *
 * @author ajacker
 * @date 2019/11/23 22:12
 */
public class P1914 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        String str = scanner.next();
        char[] chars = str.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            int pos = chars[i] - 'a';
            int newPos = (n + pos) % 26;
            chars[i] = (char) ('a' + newPos);
        }
        System.out.println(new String(chars));
    }
}
