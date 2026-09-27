package HomeWork2;

public class Park {
    static class Attraction {
        String name;
        String workingTime;
        int price;

        Attraction(String name, String workingTime, int price) {
            this.name = name;
            this.workingTime = workingTime;
            this.price = price;
        }
    }

    public static void main(String[] args) {
        Attraction wheel = new Attraction(
                "Колесо обозрения",
                "10:00-22:00",
                500
        );
        System.out.println(wheel.name);
        System.out.println(wheel.workingTime);
        System.out.println(wheel.price);
    }
}
