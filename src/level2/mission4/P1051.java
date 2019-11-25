package level2.mission4;

import java.util.Arrays;
import java.util.Scanner;

/**
 * P1051 谁拿了最多奖学金
 *
 * @author ajacker
 * @date 2019/11/26 0:11
 */
public class P1051 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        Student[] students = new Student[n];
        for (int i = 0; i < n; i++) {
            students[i] = new Student(i, sc.next(), sc.nextInt(), sc.nextInt(), sc.next(), sc.next(), sc.nextInt());
        }
        Arrays.sort(students);
        System.out.println(students[0].name);
        System.out.println(students[0].scholarship);
        System.out.println(Arrays.stream(students).mapToInt(s -> s.scholarship).sum());

    }

    static class Student implements Comparable<Student> {
        String name;
        int avgScore;
        int evaluationScore;
        boolean isLeader;
        boolean isWest;
        int paperCount;
        int scholarship;
        int id;

        public Student(int id, String name, int avgScore, int evaluationScore, String isLeader, String isWest, int paperCount) {
            this.id = id;
            this.name = name;
            this.avgScore = avgScore;
            this.evaluationScore = evaluationScore;
            this.isLeader = "Y".equals(isLeader);
            this.isWest = "Y".equals(isWest);
            this.paperCount = paperCount;
            this.calScholarShip();

        }

        private void calScholarShip() {
            if (avgScore > 80) {
                if (paperCount >= 1) {
                    scholarship += 8000;
                }
                if (avgScore > 85) {
                    if (isWest) {
                        scholarship += 1000;
                    }
                    if (evaluationScore > 80) {
                        scholarship += 4000;
                    }
                    if (avgScore > 90) {
                        scholarship += 2000;
                    }
                }
            }
            if (evaluationScore > 80 && isLeader) {
                scholarship += 850;
            }
        }

        @Override
        public int compareTo(Student o) {
            if (this.scholarship == o.scholarship) {
                return Integer.compare(this.id, o.id);
            } else {
                return Integer.compare(o.scholarship, this.scholarship);
            }
        }
    }
}
