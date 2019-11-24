package level2.mission2;

import java.util.Scanner;
import java.util.function.Function;

/**
 * P1098 字符串的展开
 *
 * @author ajacker
 * @date 2019/11/24 20:00
 */
public class P1098 {
    static int p1, p2, p3;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        //展开方式
        p1 = scanner.nextInt();
        //填充字符的重复次数
        p2 = scanner.nextInt();
        //是否逆序
        p3 = scanner.nextInt();
        //读入要处理的字符串
        String str = scanner.next();
        char[] chars = str.toCharArray();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < chars.length; i++) {
            char cur = chars[i];
            sb.append(cur);
            if (cur == '-') {
                if (i - 1 >= 0 && i + 1 < chars.length) {
                    char prev = chars[i - 1];
                    char next = chars[i + 1];
                    //如果不同为数字或者字母，就跳过
                    if ((isNumber(prev) && isNumber(next)) || (isLetter(prev) && isLetter(next))) {
                        if (next - prev == 1) {
                            //减号右边的字符恰好是左边字符的后继,删除-号
                            sb.deleteCharAt(sb.length() - 1);
                        } else if (prev < next) {

                            //填充字符
                            sb.deleteCharAt(sb.length() - 1);
                            sb.append(getAppendChars(prev, next));

                        }
                    }

                }
            }
        }
        System.out.print(sb.toString());
    }

    public static boolean isNumber(char c) {
        return '0' <= c && c <= '9';
    }

    public static boolean isLetter(char c) {
        return 'a' <= c && c <= 'z';
    }

    public static String getAppendChars(int startEx, int endEx) {


        StringBuilder sb = new StringBuilder();
        Function<Character, Character> function = Character::toLowerCase;
        switch (p1) {
            case 1:
                function = Character::toLowerCase;
                break;
            case 2:
                function = Character::toUpperCase;
                break;
            case 3:
                function = (x) -> '*';
                break;
            default:
                break;
        }
        for (int j = startEx + 1; j < endEx; j++) {
            for (int i = 0; i < p2; i++) {
                sb.append(function.apply((char) j));
            }
        }
        if (p3 == 2) {
            return sb.reverse().toString();
        } else {
            return sb.toString();
        }
    }
}
