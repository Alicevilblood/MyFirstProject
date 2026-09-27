package HomeWork2;

public class Массив {
    public static void main(String[] args) {
        Товар[] productsArray = new Товар[5];
        productsArray[0] = new Товар(
                "Samsung S25 Ultra",
                "01.02.2025",
                "Samsung Corp.",
                "Korea",
                5599,
                true
        );
        productsArray[1] = new Товар(
                "iPhone 17 Pro",
                "15.09.2025",
                "Apple",
                "USA",
                1299,
                false
        );
        productsArray[2] = new Товар(
                "LG OLED C4",
                "20.03.2025",
                "LG",
                "South Korea",
                1499,
                false
        );
        productsArray[3] = new Товар(
                "MacBook Air M4",
                "10.03.2025",
                "Apple",
                "USA",
                1199,
                false
        );
        productsArray[4] = new Товар(
                "Xiaomi 15",
                "20.02.2025",
                "Xiaomi",
                "China",
                799,
                true
        );
    }
}
