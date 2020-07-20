package T100;

import java.util.Scanner;

/**
 * P5705 【深基2.例7】数字反转
 *
 * @author ajacker
 * @date 2020/7/20 13:41
 */
public class P5705 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double in = sc.nextDouble();
        String sIn = String.valueOf(in);
        StringBuilder sb = new StringBuilder(sIn);
        sb.reverse();
        while (sb.length() > 0 && sb.charAt(0) == '0') {
            sb.deleteCharAt(0);
        }
        System.out.println(sb);
    }
}
