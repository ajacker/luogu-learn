package level2.mission5;

import java.util.*;
import java.util.stream.Collectors;

/**
 * P1603 斯诺登的密码
 *
 * @author ajacker
 * @date 2019/11/26 16:04
 */
public class P1603 {
    static HashMap<String, Integer> map;
    private static List<String> list;
    private static Stack<Integer> stack = new Stack<>();
    private static long min = Long.MAX_VALUE;
    private static boolean[] visited = new boolean[6];
    private static boolean hasResult = false;

    static {
        map = new HashMap<>();
        map.put("one", 1);
        map.put("a", 1);
        map.put("first", 1);
        map.put("another", 1);
        map.put("two", 2);
        map.put("both", 2);
        map.put("second", 2);
        map.put("third", 3);
        map.put("three", 3);
        map.put("four", 4);
        map.put("five", 5);
        map.put("six", 6);
        map.put("seven", 7);
        map.put("eight", 8);
        map.put("nine", 9);
        map.put("ten", 10);
        map.put("eleven", 11);
        map.put("twelve", 12);
        map.put("thirteen", 13);
        map.put("fourteen", 14);
        map.put("fifteen", 15);
        map.put("sixteen", 16);
        map.put("seventeen", 17);
        map.put("eighteen", 18);
        map.put("nineteen", 19);
        map.put("twenty", 20);

    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        list = new ArrayList<>(6);
        for (int i = 0; i < 6; i++) {
            String str = scanner.next();
            if (map.containsKey(str)) {
                int num = map.get(str);
                num = (num * num) % 100;
                list.add(String.format("%2d", num).replaceAll(" ", "0"));
            }
        }
        process(0);
        System.out.println(hasResult ? min : 0);
    }

    public static void process(int count) {
        if (count == list.size()) {
            String collect = stack.stream().map(list::get).collect(Collectors.joining());
            try {
                min = Long.min(Long.parseLong(collect), min);
                hasResult = true;
            } catch (Exception ignored) {
            }
        }
        for (int i = 0; i < list.size(); i++) {
            if (!visited[i]) {
                stack.push(i);
                visited[i] = true;
                process(count + 1);
                stack.pop();
                visited[i] = false;
            }
        }
    }
}
