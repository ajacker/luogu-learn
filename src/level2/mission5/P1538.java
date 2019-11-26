package level2.mission5;

import java.util.Arrays;
import java.util.Scanner;

/**
 * P1538 迎春舞会之数字舞蹈
 *
 * @author ajacker
 * @date 2019/11/26 19:11
 */
public class P1538 {
    static char[][] out;
    static int height, width;
    static int k;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        k = scanner.nextInt();
        String str = scanner.next();
        char[] array = str.toCharArray();
        height = 2 * k + 1 + 2;
        width = 2 + k;
        out = new char[height][(width + 1) * (array.length - 1) + width];
        for (char[] chars : out) {
            Arrays.fill(chars, ' ');
        }
        for (int i = 0; i < array.length; i++) {
            int row = i == 0 ? 0 : width + (i - 1) * (width + 1) + 1;
            fillNum(row, array[i]);
        }
        for (int i = 0; i < out.length; i++) {
            for (char c : out[i]) {
                System.out.print(c);
            }
            System.out.println();
        }
    }

    static void fillNum(int startRow, char i) {
        switch (i) {
            case '0':
                drawLine(1, startRow, 2 * k + 1, true);
                out[1 + k][startRow] = ' ';
                drawLine(1, startRow + k + 1, 2 * k + 1, true);
                out[1 + k][startRow + k + 1] = ' ';
                drawLine(0, startRow + 1, k, false);
                drawLine(2 * k + 2, startRow + 1, k, false);
                break;
            case '9':
                drawLine(1, startRow, k, true);
                drawLine(1, startRow + k + 1, 2 * k + 1, true);
                out[1 + k][startRow + k + 1] = ' ';
                drawLine(0, startRow + 1, k, false);
                drawLine(1 + k, startRow + 1, k, false);
                drawLine(2 * k + 2, startRow + 1, k, false);
                break;
            case '8':
                drawLine(1, startRow, 2 * k + 1, true);
                out[1 + k][startRow] = ' ';
                drawLine(1, startRow + k + 1, 2 * k + 1, true);
                out[1 + k][startRow + k + 1] = ' ';
                drawLine(0, startRow + 1, k, false);
                drawLine(1 + k, startRow + 1, k, false);
                drawLine(2 * k + 2, startRow + 1, k, false);
                break;
            case '7':
                drawLine(1, startRow + k + 1, 2 * k + 1, true);
                out[1 + k][startRow + k + 1] = ' ';
                drawLine(0, startRow + 1, k, false);
                break;
            case '6':
                drawLine(1, startRow, 2 * k + 1, true);
                out[1 + k][startRow] = ' ';
                drawLine(k + 2, startRow + k + 1, k, true);
                drawLine(0, startRow + 1, k, false);
                drawLine(1 + k, startRow + 1, k, false);
                drawLine(2 * k + 2, startRow + 1, k, false);
                break;
            case '5':
                drawLine(1, startRow, k, true);
                drawLine(k + 2, startRow + k + 1, k, true);
                drawLine(0, startRow + 1, k, false);
                drawLine(1 + k, startRow + 1, k, false);
                drawLine(2 * k + 2, startRow + 1, k, false);
                break;
            case '4':
                drawLine(1, startRow, k, true);
                drawLine(1, startRow + k + 1, 2 * k + 1, true);
                out[1 + k][startRow + k + 1] = ' ';
                drawLine(1 + k, startRow + 1, k, false);
                break;
            case '3':
                drawLine(1, startRow + k + 1, 2 * k + 1, true);
                out[1 + k][startRow + k + 1] = ' ';
                drawLine(0, startRow + 1, k, false);
                drawLine(1 + k, startRow + 1, k, false);
                drawLine(2 * k + 2, startRow + 1, k, false);
                break;
            case '2':
                drawLine(1, startRow + k + 1, k, true);
                drawLine(2 + k, startRow, k, true);
                drawLine(0, startRow + 1, k, false);
                drawLine(1 + k, startRow + 1, k, false);
                drawLine(2 * k + 2, startRow + 1, k, false);
                break;
            case '1':
                drawLine(1, startRow + k + 1, 2 * k + 1, true);
                out[1 + k][startRow + k + 1] = ' ';
                break;
            default:
                break;
        }
    }

    static void drawLine(int a, int b, int len, boolean row) {
        if (row) {
            for (int j = a; j < a + len; j++) {
                out[j][b] = '|';
            }
        } else {
            for (int j = b; j < b + len; j++) {
                out[a][j] = '-';
            }
        }
    }

}
