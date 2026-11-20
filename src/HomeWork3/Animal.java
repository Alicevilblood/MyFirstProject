package HomeWork3;

public class Animal {
    String name;
    static int animalCount = 0;

    public Animal(String name) {
        this.name = name;
        animalCount++;
    }
}
