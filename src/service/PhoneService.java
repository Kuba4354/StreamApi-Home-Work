package service;

import model.Phone;

import java.util.List;

public interface PhoneService {
    String addPhone(Phone phone) throws Exception;

    Phone getPhoneById(int phoneId) throws Exception;

    Phone updatePhoneNameById(int phoneId, String newName) throws Exception;

    List<Phone> getAllPhones() throws Exception;

    List<Phone> getAllPhonesByBrand(String brand) throws Exception;

    void deletePhoneById(int phoneId) throws Exception;
}
