package T100;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

/**
 * P5704 【深基2.例6】字母转换
 *
 * @author ajacker
 * @date 2020/7/10 19:46
 */
public class P5704 {
    public static void main(String[] args) throws IOException {
        InputStream in = System.in;
        BufferedReader reader = new BufferedReader(new InputStreamReader(in));
        char ch = (char) reader.read();
        System.out.println((char) (ch + ('A' - 'a')));
    }
}
