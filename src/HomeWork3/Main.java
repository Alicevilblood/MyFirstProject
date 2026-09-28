package HomeWork3;

public class Main {
    public static void main(String[] args) {
        Dog bobic = new Dog("Бобик");
        Cat murzik = new Cat("Мурзик");
        Cat barsik = new Cat("Барсик");

        Cat[] cats = {murzik, barsik};

        Bowl bowl = new Bowl(10);

        for (Cat cat : cats) {
            cat.eat(bowl);
            System.out.println(cat.name + " сыт: " + cat.full);
        }

        System.out.println("Еды в миске: " + bowl.food);

        bowl.addFood(15);
        System.out.println("После добавления еды: " + bowl.food);
        System.out.println("Всего животных: " + Animal.animalCount);
        System.out.println("Котов: " + Cat.catCount);
        System.out.println("Собак: " + Dog.dogCount);

        bobic.run(150);
        murzik.run(150);

        bobic.swim(5);
        murzik.swim(5);

        Circle circle = new Circle(5, "Красный", "Черный");

        System.out.println("Круг:");
        circle.printInfo();

        System.out.println("Заливка: " + circle.fillColor);
        System.out.println("Граница: " + circle.borderColor);

        Rectangle rectangle = new Rectangle(10, 5, "Голубой", "Желтый");

        System.out.println("Прямоугольник:");
        rectangle.printInfo();

        System.out.println("Заливка: " + rectangle.fillColor);
        System.out.println("Границы: " + rectangle.borderColor);

        Triangle triangle = new Triangle(6, 4, 5, 5, "Зелный", "Черный");

        System.out.println("Треугольник:");
        triangle.printInfo();

        System.out.println("Заливка: " + triangle.fillColor);
        System.out.println("Граница: " + triangle.borderColor);
    }
}
