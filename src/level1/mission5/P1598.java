package level1.mission5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * P1598 垂直柱状图
 *
 * @author ajacker
 * @date 2019/11/23 21:30
 */
public class P1598 {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int[] count = new int[26];
        int c;
        int max = Integer.MIN_VALUE;
        while ((c = bufferedReader.read()) != -1) {
            if (Character.isAlphabetic(c)) {
                max = Integer.max(++count[c - 'A'], max);
            }
        }
        //填充输出结果
        char[][] output = new char[26][max];
        for (int i = 0; i < 26; i++) {
            Arrays.fill(output[i], ' ');
            for (int j = 0; j < count[i]; j++) {
                output[i][j] = '*';
            }
        }
        //输出结果
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = max - 1; i >= 0; i--) {
            for (int j = 0; j < 26; j++) {
                stringBuilder.append(output[j][i]).append(' ');
            }
            stringBuilder.deleteCharAt(stringBuilder.length() - 1);
            stringBuilder.append('\n');
        }
        //输出字母
        for (int i = 0; i < 26; i++) {
            stringBuilder.append(((char) ('A' + i))).append(' ');
        }
        stringBuilder.deleteCharAt(stringBuilder.length() - 1);
        System.out.println(stringBuilder.toString());
    }
}
