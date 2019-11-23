package level1.mission5;

import java.util.Scanner;

/**
 * P1308 统计单词数
 *
 * @author ajacker
 * @date 2019/11/23 21:01
 */
public class P1308 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String target = scanner.next();
        String line = scanner.useDelimiter("\n").next();
        int count = 0;
        int firstPos = -1;
        String str;
        char[] targetChars = target.toCharArray();
        char[] chars = line.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            char cur = chars[i];
            if (Character.toUpperCase(cur) == Character.toUpperCase(targetChars[0])) {
                boolean flag = true;
                for (int j = 1; j < targetChars.length; j++) {
                    if (i + j >= chars.length || Character.toUpperCase(chars[i + j]) != Character.toUpperCase(targetChars[j])) {
                        flag = false;
                    }
                }
                if (flag && (i + targetChars.length == chars.length || chars[i + targetChars.length] == ' ')
                        && (i - 1 == -1 || chars[i - 1] == ' ')) {
                    count++;
                    if (firstPos == -1) {
                        firstPos = i;
                    }
                }
            }

        }
        if (count == 0) {
            System.out.print(-1);
        } else {
            System.out.printf("%d %d", count, firstPos);
        }
    }
}
