package level1.mission8;

import java.util.Scanner;

/**
 * P1014 Cantor表
 *
 * @author ajacker
 * @date 2019/11/24 10:44
 */
public class P1014 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        //得到起始行号/列号
        int line = 1;
        for (; n - line > 0; line++) {
            n -= line;
        }
        //得到遍历方向
        Type type;
        if ((line & 1) == 1) {
            type = Type.RightUp;
        } else {
            type = Type.LeftDown;
        }
        switch (type) {
            case LeftDown:
                System.out.printf("%d/%d", n, line + 1 - n);
                break;
            case RightUp:
                System.out.printf("%d/%d", line + 1 - n, n);
                break;
            default:
                break;
        }
    }

    enum Type {
        /**
         * 向着左下角方向
         */
        LeftDown,
        /**
         * 向着右下角方向
         */
        RightUp;
    }
}
