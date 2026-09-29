package HomeWork4;

public class ArrayUtils {
    public static int sumArray(String[][] array)
            throws MyArraySizeException, MyArrayDataException {
        if (array.length != 4 || array[0].length != 4) {
            throw new MyArraySizeException("Массив должен быть размером 4x4");
        }
        int sum = 0;
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                try {
                    int number = Integer.parseInt(array[i][j]);
                    sum += number;
                } catch (NumberFormatException e) {
                    throw new MyArrayDataException(
                            "Некорректные данные в ячейке [" + i + "][" + j + "]"
                    );
                }
            }
        }
        return sum;
    }
}
