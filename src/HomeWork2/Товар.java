package HomeWork2;

public class Товар {
    String name;
    String date;
    String producer;
    String country;
    int price;
    boolean reserved;

    public Товар(String name,
                 String date,
                 String producer,
                 String country,
                 int price,
                 boolean reserved) {
        this.name = name;
        this.date = date;
        this.producer = producer;
        this.country = country;
        this.price = price;
        this.reserved = reserved;
    }

    public void printInfo() {
        System.out.println(name);
        System.out.println(date);
        System.out.println(producer);
        System.out.println(country);
        System.out.println(price);
        System.out.println(reserved);
    }

    public static void main(String[] args) {
        Товар TV = new Товар(
                "Samsung QLED 55",
                "01.02.2025",
                "Samsung",
                "South Korea",
                1200,
                false
        );
        TV.printInfo();
    }
}
