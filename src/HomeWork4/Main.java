package HomeWork4;

public class Main {
    public static void main(String[] args) {

        String[][] array = {
                {
                        "1", "2", "3", "4"
                },
                {
                        "5", "6", "7", "8"
                },
                {
                        "9", "10", "11", "12"
                },
                {
                        "13", "14", "15", "16"
                }
        };
        int result = 0;
        try {
            result = ArrayUtils.sumArray(array);
        } catch (MyArraySizeException e) {
            System.out.println(e.getMessage());
        } catch (MyArrayDataException e) {
            System.out.println(e.getMessage());
        }
        System.out.println("Сумма " + result);

        try {
            System.out.println(array[10][10]);
        } catch (
                ArrayIndexOutOfBoundsException e) {
            System.out.println("Выход за пределы массива");
        }
    }
}