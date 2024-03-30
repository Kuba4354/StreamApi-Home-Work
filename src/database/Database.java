package database;

import model.Phone;

import java.util.ArrayList;
import java.util.List;

public class Database {
    private static List<Phone> phones = new ArrayList<>();

    public static List<Phone> getPhones() {
        return phones;
    }

    public static void setPhones(List<Phone> phones) {
        Database.phones = phones;
    }
}
