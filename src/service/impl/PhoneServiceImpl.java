package service.impl;

import database.Database;
import model.Phone;
import service.PhoneService;

import java.util.List;
import java.util.stream.Collectors;

public class PhoneServiceImpl implements PhoneService {
    @Override
    public String addPhone(Phone phone) throws Exception {
        try {
            Database.getPhones().add(phone);
            return "Phone added successfully.";
        } catch (Exception e) {
            throw new Exception("Failed to add phone: " + e.getMessage());
        }
    }

    @Override
    public Phone getPhoneById(int phoneId) throws Exception {
        try {
            return Database.getPhones().stream()
                    .filter(p -> p.getId() == phoneId)
                    .findFirst()
                    .orElseThrow(() -> new Exception("Phone not found"));
        } catch (Exception e) {
            throw new Exception("Failed to get phone by ID: " + e.getMessage());
        }
    }

    @Override
    public Phone updatePhoneNameById(int phoneId, String newName) throws Exception {
        try {
            Phone phone = Database.getPhones().stream()
                    .filter(p -> p.getId() == phoneId)
                    .findFirst()
                    .orElseThrow(() -> new Exception("Phone not found"));

            phone.setName(newName);
            return phone;
        } catch (Exception e) {
            throw new Exception("Failed to update phone name by ID: " + e.getMessage());
        }
    }

    @Override
    public List<Phone> getAllPhones() throws Exception {
        try {
            return Database.getPhones();
        } catch (Exception e) {
            throw new Exception("Failed to get all phones: " + e.getMessage());
        }
    }

    @Override
    public List<Phone> getAllPhonesByBrand(String brand) throws Exception {
        try {
            return Database.getPhones().stream()
                    .filter(p -> p.getBrand().equalsIgnoreCase(brand))
                    .collect(Collectors.toList());
        } catch (Exception e) {
            throw new Exception("Failed to get phones by brand: " + e.getMessage());
        }
    }

    @Override
    public void deletePhoneById(int phoneId) throws Exception {
        try {
            Database.getPhones().removeIf(p -> p.getId() == phoneId);
        } catch (Exception e) {
            throw new Exception("Failed to delete phone by ID: " + e.getMessage());
        }
    }
}

