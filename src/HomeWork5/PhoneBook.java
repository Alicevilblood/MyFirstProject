package HomeWork5;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.HashMap;

public class PhoneBook {
    Map<String, List<String>> phoneBook = new HashMap<>();

    public void add(String surname, String phone) {
        phoneBook
                .computeIfAbsent(surname, key -> new ArrayList<>())
                .add(phone);
    }

    public void get(String surname) {
        List<String> phones = phoneBook.get(surname);
        if (phones != null) {
            for (String phone : phones) {
                System.out.println(phone);
            }
        } else {
            System.out.println("Фамилия не найдена");
        }
    }
}
