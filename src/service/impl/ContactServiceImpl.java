package service.impl;

import database.Database;
import model.Contact;
import model.Phone;
import service.ContactService;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class ContactServiceImpl implements ContactService {
    @Override
    public String addContactToPhone(int phoneId, Contact contact) throws Exception {
        try {
            Phone phone = Database.getPhones().stream()
                    .filter(p -> p.getId() == phoneId)
                    .findFirst()
                    .orElseThrow(() -> new Exception("Phone not found"));

            phone.getContacts().add(contact);
            return "Contact added to phone successfully.";
        } catch (Exception e) {
            throw new Exception("Failed to add contact to phone: " + e.getMessage());
        }
    }

    @Override
    public Contact findContactByName(int phoneId, String contactName) throws Exception {
        try {
            Phone phone = Database.getPhones().stream()
                    .filter(p -> p.getId() == phoneId)
                    .findFirst()
                    .orElseThrow(() -> new Exception("Phone not found"));

            return phone.getContacts().stream()
                    .filter(c -> c.getName().equals(contactName))
                    .findFirst()
                    .orElse(null);
        } catch (Exception e) {
            throw new Exception("Failed to find contact by name: " + e.getMessage());
        }
    }

    @Override
    public Contact findContactByPhoneNumber(int phoneId, String phoneNumber) throws Exception {
        try {
            Phone phone = Database.getPhones().stream()
                    .filter(p -> p.getId() == phoneId)
                    .findFirst()
                    .orElseThrow(() -> new Exception("Phone not found"));

            return phone.getContacts().stream()
                    .filter(c -> c.getPhoneNumber().equals(phoneNumber))
                    .findFirst()
                    .orElse(null);
        } catch (Exception e) {
            throw new Exception("Failed to find contact by phone number: " + e.getMessage());
        }
    }

    @Override
    public List<Contact> sortContactsByName(int phoneId) throws Exception {
        try {
            Phone phone = Database.getPhones().stream()
                    .filter(p -> p.getId() == phoneId)
                    .findFirst()
                    .orElseThrow(() -> new Exception("Phone not found"));

            return phone.getContacts().stream()
                    .sorted(Comparator.comparing(Contact::getName))
                    .collect(Collectors.toList());
        } catch (Exception e) {
            throw new Exception("Failed to sort contacts by name: " + e.getMessage());
        }
    }

    @Override
    public void deleteContactByNameFromPhone(int phoneId, String contactName) throws Exception {
        try {
            Phone phone = Database.getPhones().stream()
                    .filter(p -> p.getId() == phoneId)
                    .findFirst()
                    .orElseThrow(() -> new Exception("Phone not found"));

            phone.getContacts().removeIf(c -> c.getName().equals(contactName));
        } catch (Exception e) {
            throw new Exception("Failed to delete contact by name from phone: " + e.getMessage());
        }
    }
}
