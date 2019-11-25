package level2.mission2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * P1042 乒乓球
 *
 * @author ajacker
 * @date 2019/11/25 10:41
 */
public class P1042 {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        char c;
        StringBuilder stringBuilder = new StringBuilder();
        while ((c = (char) bufferedReader.read()) != 'E') {
            stringBuilder.append(c);
        }
        process(stringBuilder.toString().toCharArray(), 11);
        System.out.println();
        process(stringBuilder.toString().toCharArray(), 21);
    }

    /**
     * 进行比赛
     *
     * @param race 比赛字符数组
     * @param win  赛制
     */
    public static void process(char[] race, int win) {
        int l = 0, w = 0;
        //进行比赛
        for (int i = 0; i < race.length; i++) {
            if (race[i] == 'L') {
                l++;
            } else if (race[i] == 'W') {
                w++;
            }
            if ((l >= win && l - w >= 2) || (w >= win && w - l >= 2)) {
                System.out.printf("%d:%d\n", w, l);
                l = 0;
                w = 0;
            }
        }
        System.out.printf("%d:%d\n", w, l);
    }
}
