package HomeWork3;

public interface Figure {
    double getArea();

    double getPerimeter();

    default void printInfo(){
        System.out.println("Площадь: " + getArea());
        System.out.println("Периметр: " + getPerimeter());
    }
}
