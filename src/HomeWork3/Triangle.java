package HomeWork3;

public class Triangle implements Figure {
    double base;
    double height;
    double sideA;
    double sideB;
    String fillColor;
    String borderColor;

    public Triangle(double base, double height, double sideA, double sideB, String fillColor, String borderColor) {
        this.base = base;
        this.height = height;
        this.sideA = sideA;
        this.sideB = sideB;
        this.fillColor = fillColor;
        this.borderColor = borderColor;
    }

    @Override
    public double getArea() {
        return base * height / 2;
    }

    @Override
    public double getPerimeter() {
        return base + sideA + sideB;
    }
}
