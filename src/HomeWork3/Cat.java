package HomeWork3;

public class Cat extends Animal {
    static int catCount = 0;
    boolean full = false;

    public Cat(String name) {
        super(name);
        catCount++;
    }

    public void run(int distance) {
        if (distance <= 200) {
            System.out.println(name + " пробежал " + distance + "м.");
        } else {
            System.out.println(name + " не может пробежать " + distance + "м.");
        }
    }

    public void swim(int distance) {
        System.out.println(name + " не умеет плавать.");
    }

    public void eat(Bowl bowl) {
        if (bowl.food >= 5) {
            full = true;
            bowl.food -= 5;
        }
    }
}
