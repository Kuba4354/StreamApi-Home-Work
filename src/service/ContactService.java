package service;

import model.Contact;

import java.util.List;

public interface ContactService {
    String addContactToPhone(int phoneId, Contact contact) throws Exception;

    Contact findContactByName(int phoneId, String contactName) throws Exception;

    Contact findContactByPhoneNumber(int phoneId, String phoneNumber) throws Exception;

    List<Contact> sortContactsByName(int phoneId) throws Exception;

    void deleteContactByNameFromPhone(int phoneId, String contactName) throws Exception;
}
