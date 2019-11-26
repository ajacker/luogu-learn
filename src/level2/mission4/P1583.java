package level2.mission4;

import java.util.Arrays;
import java.util.Scanner;

/**
 * P1583 魔法照片
 *
 * @author ajacker
 * @date 2019/11/26 11:18
 */
public class P1583 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int k = scanner.nextInt();
        int[] E = new int[10];
        for (int i = 0; i < 10; i++) {
            E[i] = scanner.nextInt();
        }
        Person[] persons = new Person[n];
        for (int i = 0; i < n; i++) {
            persons[i] = new Person(i + 1, scanner.nextInt());
        }
        //按照初始权重由大到小
        Arrays.sort(persons, (o1, o2) -> o2.weight - o1.weight);
        //给他们序号和分类
        for (int i = 0; i < n; i++) {
            int type = i % 10;
            //加上分类权重
            persons[i].weight += E[type];
        }
        //再次排序
        Arrays.sort(persons);
        //输出结果
        for (int i = 0; i < k; i++) {
            System.out.print(persons[i].id + " ");
        }

    }

    static class Person implements Comparable<Person> {
        int id;
        int weight;

        public Person(int id, int weight) {
            this.weight = weight;
            this.id = id;
        }

        @Override
        public int compareTo(Person o) {
            if (this.weight == o.weight) {
                return this.id - o.id;
            } else {
                return o.weight - this.weight;
            }
        }
    }
}
