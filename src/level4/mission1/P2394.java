package level4.mission1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigDecimal;

/**
 * P2394 yyy loves Chemistry I
 *
 * @author ajacker
 * @date 2019/12/4 23:15
 */
public class P2394 {
    private static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        StringBuilder in = new StringBuilder();
        int i;
        int count = 0;
        while ((i = reader.read()) != -1 && count <= 20) {
            char c = ((char) i);
            if (c != '\n') {
                in.append(c);
                count++;
            } else {
                break;
            }
        }
        BigDecimal res = new BigDecimal(in.toString()).divide(new BigDecimal("23"), 8, BigDecimal.ROUND_HALF_UP);
        System.out.print(res.toPlainString());
    }
}
