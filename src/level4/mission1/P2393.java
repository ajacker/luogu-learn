package level4.mission1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StreamTokenizer;
import java.math.BigDecimal;

/**
 * P2393 yyy loves Maths II
 *
 * @author ajacker
 * @date 2019/12/4 22:23
 */
public class P2393 {
    private static StreamTokenizer in = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));

    public static void main(String[] args) throws IOException {
        BigDecimal sum = new BigDecimal("0");
        while (in.nextToken() != StreamTokenizer.TT_EOF) {
            //BigDecimal要高精度计算需要用String构造函数
            sum = sum.add(new BigDecimal(String.valueOf(in.nval)));
        }
        System.out.print(sum.setScale(5, BigDecimal.ROUND_HALF_UP));

    }
}
