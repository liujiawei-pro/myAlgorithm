package sort.util;

import java.util.Random;

public class InitArr {
    public static int[] init(int length) {
        int[] init = new int[length];
        Random random = new Random();
        for (int i = 0; i < length; i++) {
            init[i] = random.nextInt(100);
        }
        return init;
    }
}
