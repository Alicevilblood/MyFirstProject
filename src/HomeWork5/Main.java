package HomeWork5;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        Set<Student> students = new HashSet<>();

        students.add(new Student(
                "Иван",
                "A1",
                2,
                List.of(4, 5, 3, 4)
        ));
        students.add(new Student(
                "Мария",
                "A1",
                2,
                List.of(2, 3, 2, 2)
        ));
        students.add(new Student(
                "Валентин",
                "B2",
                1,
                List.of(5, 4, 5, 4)
        ));
        students.add(new Student(
                "Елена",
                "D3",
                3,
                List.of(3, 3, 4, 3)
        ));
        removeStudents(students);
        nextCourse(students);
        printStudents(students, 3);

        PhoneBook phoneBook = new PhoneBook();
        phoneBook.add("Иванов", "111-111-111");
        phoneBook.add("Петров", "222-222-222");
        phoneBook.add("Иванов", "333-333-333");
        phoneBook.get("Иванов");
        phoneBook.get("Сидоров");
    }

    public static void removeStudents(Set<Student> students) {
        students.removeIf(student -> student.getAverageGrade() < 3);
    }

    public static void nextCourse(Set<Student> students) {
        for (Student student : students) {
            if (student.getAverageGrade() >= 3) {
                student.course++;
            }
        }
    }

    public static void printStudents(Set<Student> students, int course) {
        for (Student student : students) {
            if (student.course == course) {
                System.out.println(student.name);
            }
        }
    }
}


