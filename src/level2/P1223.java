package level2;

import java.util.Arrays;
import java.util.Scanner;

/**
 * P1223 排队接水
 *
 * @author ajacker
 * @date 2019/11/27 2:09
 */
public class P1223 {
    static int n;
    static People[] T;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        T = new People[n];
        for (int i = 0; i < n; i++) {
            T[i] = new People(i + 1, sc.nextInt());
        }
        Arrays.sort(T);
        double sum = 0;
        double last = 0;
        for (int i = 0; i < n; i++) {
            if (i != 0) {
                sum += last * (n - i);
            }
            last = T[i].waitTime;

        }
        for (int i = 0; i < T.length; i++) {
            System.out.print(T[i].id + " ");
        }
        System.out.printf("\n%.2f", sum / n);

    }

    static class People implements Comparable<People> {
        int id;
        int waitTime;

        public People(int id, int waitTime) {
            this.id = id;
            this.waitTime = waitTime;
        }

        @Override
        public int compareTo(People o) {
            return Integer.compare(this.waitTime, o.waitTime);
        }
    }
}
