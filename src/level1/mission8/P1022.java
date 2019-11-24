package level1.mission8;

import java.util.Scanner;
import java.util.StringTokenizer;

/**
 * P1022 计算器的改良
 *
 * @author ajacker
 * @date 2019/11/24 11:22
 */
public class P1022 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
        //左右常数和系数
        int leftAmount = 0, leftUnknown = 0, rightAmount = 0, rightUnknown = 0;
        StringTokenizer tokenizer = new StringTokenizer(str, "+-=", true);
        //标记正负号
        byte mark = 1;
        //标记是否在等式左边
        boolean inleft = true;
        char unkn = 0;
        while (tokenizer.hasMoreTokens()) {
            String token = tokenizer.nextToken();
            switch (token) {
                case "+":
                    mark = 1;
                    break;
                case "-":
                    mark = -1;
                    break;
                case "=":
                    inleft = false;
                    mark = 1;
                    break;
                default:
                    try {
                        int amount = Integer.parseInt(token) * mark;
                        if (inleft) {
                            leftAmount += amount;
                        } else {
                            rightAmount += amount;
                        }
                    } catch (Exception e) {
                        unkn = token.charAt(token.length() - 1);
                        //应对-a这种情况
                        String temp = token.substring(0, token.length() - 1);
                        int unknown = temp.isEmpty() ? 1 : Integer.parseInt(temp) * mark;
                        if (inleft) {
                            leftUnknown += unknown;
                        } else {
                            rightUnknown += unknown;
                        }
                    }
                    break;
            }
        }
        System.out.printf("%c=%.3f", unkn, (rightAmount - leftAmount) * 1f / (leftUnknown - rightUnknown));

    }
}
