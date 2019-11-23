package level1.mission7;

import java.util.Arrays;
import java.util.Scanner;

/**
 * P1478 陶陶摘苹果（升级版）
 *
 * @author ajacker
 * @date 2019/11/23 23:59
 */
public class P1478 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt(), s = scanner.nextInt();
        int a = scanner.nextInt(), b = scanner.nextInt();
        Apple[] apples = new Apple[n];
        int count = 0;
        for (int i = 0; i < n; i++) {
            apples[i] = new Apple(scanner.nextInt(), scanner.nextInt());
        }
        //按照最小花费排序才能拿到最多苹果
        Arrays.sort(apples);
        for (Apple apple : apples) {
            if (a + b >= apple.height && s - apple.cost >= 0) {
                count++;
                s -= apple.cost;
            }
        }
        System.out.println(count);
    }

    static class Apple implements Comparable<Apple> {
        int height;
        int cost;

        public Apple(int height, int cost) {
            this.height = height;
            this.cost = cost;
        }

        @Override
        public int compareTo(Apple o) {
            return Integer.compare(this.cost, o.cost);
        }
    }
}
