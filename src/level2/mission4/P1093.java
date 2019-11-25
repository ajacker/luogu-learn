package level2.mission4;

import java.util.Arrays;
import java.util.Scanner;

/**
 * P1093 奖学金
 *
 * @author ajacker
 * @date 2019/11/25 23:24
 */
public class P1093 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        Student[] students = new Student[n];
        for (int i = 0; i < n; i++) {
            students[i] = new Student(i + 1, scanner.nextInt(), scanner.nextInt(), scanner.nextInt());
        }
        Arrays.sort(students);
        for (int i = 0; i < 5; i++) {
            System.out.println(students[i]);
        }
    }

    static class Student implements Comparable<Student> {
        int id;
        int chinese;
        int math;
        int english;
        int sum;

        public Student(int id, int chinese, int math, int english) {
            this.id = id;
            this.chinese = chinese;
            this.math = math;
            this.english = english;
            this.sum = chinese + math + english;
        }

        @Override
        public int compareTo(Student o) {
            if (this.sum == o.sum) {
                if (this.chinese == o.chinese) {
                    return Integer.compare(this.id, o.id);
                } else {
                    return Integer.compare(o.chinese, this.chinese);
                }
            } else {
                return Integer.compare(o.sum, this.sum);
            }
        }

        @Override
        public String toString() {
            return id + " " + sum;
        }
    }
}
