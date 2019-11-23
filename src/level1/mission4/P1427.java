package level1.mission4;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * P1427 小鱼的数字游戏
 *
 * @author ajacker
 * @date 2019/11/23 20:55
 */
public class P1427 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Integer> list = new ArrayList<>();
        while (scanner.hasNext()) {
            int i = scanner.nextInt();
            if (i != 0) {
                list.add(i);
            } else {
                break;
            }
        }
        for (int i = list.size() - 1; i >= 0; i--) {
            System.out.printf("%d ", list.get(i));
        }
    }
}
