package level2.mission14;

import java.util.Scanner;

/**
 * P1030 求先序排列
 *
 * @author ajacker
 * @date 2019/12/3 18:03
 */
public class P1030 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String in = sc.next();
        String after = sc.next();
        getPre(in, after);
    }

    static void getPre(String in, String after) {
        int len = in.length();
        if (len > 0) {
            char root = after.charAt(len - 1);
            System.out.print(root);
            String[] split = in.split(String.valueOf(root));
            if (split.length >= 1) {

                String leftIn = split[0];
                String leftAfter = after.substring(0, leftIn.length());
                getPre(leftIn, leftAfter);
                if (split.length >= 2) {
                    String rightIn = split[1];
                    String rightAfter = after.substring(leftIn.length(), leftIn.length() + rightIn.length());
                    getPre(rightIn, rightAfter);
                }
            }
        }
    }
}
