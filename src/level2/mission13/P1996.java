package level2.mission13;

import java.util.Scanner;

/**
 * P1996 约瑟夫问题
 *
 * @author ajacker
 * @date 2019/12/2 18:14
 */
public class P1996 {

    private static int n;
    private static int m;
    private static boolean[] persons;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        persons = new boolean[n];
        int count = 0;
        int i = 0;
        int last = n;
        while (last >= 1) {
            int pos = i++ % n;
            if (!persons[pos]) {
                if (++count == m) {
                    System.out.printf("%d ", pos + 1);
                    persons[pos] = true;
                    count = 0;
                    last--;
                }
            }
        }
    }
}
