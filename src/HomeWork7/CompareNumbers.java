package HomeWork7;

import java.awt.*;

public class CompareNumbers {
    public static int compare(int a, int b) {
        if (a > b) {
            return 1;
        } else if (a < b) {
            return -1;
        } else {
            return 0;
        }
    }

    public static void main(String[] args) {
        System.out.println(compare(10, 5));
        System.out.println(compare(5, 10));
        System.out.println(compare(5, 5));
    }
}
