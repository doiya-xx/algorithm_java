package algorithms.tree;

import java.io.IOException;
import java.util.Arrays;

public class Base2n {
    public static void main(String[] args) throws IOException {
        String lxmon = base8("lxmon");
    }

    Base2n() {

    }

    public static String base8(String s) throws IOException {
        byte[] bytes = s.getBytes();
        System.out.println("bytes = " + Arrays.toString(bytes));

        return s;
    }
}
