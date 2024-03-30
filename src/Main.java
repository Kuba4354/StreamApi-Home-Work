import model.Contact;
import model.Phone;
import service.ContactService;
import service.PhoneService;
import service.impl.ContactServiceImpl;
import service.impl.PhoneServiceImpl;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        PhoneService phoneService = new PhoneServiceImpl();
        ContactService contactService = new ContactServiceImpl();

        while (true) {
            try {
                System.out.println("""
                                 Choose an option:
                                 1. 📱 Add Phone
                                 2. 🔍 Get Phone by ID
                                 3. 🔄 Update Phone Name by ID
                                 4. 📞 Get All Phones
                                 5. 📞 Get All Phones by Brand
                                 6. ❌ Delete Phone by ID
                                 7. ➕ Add Contact to Phone
                                 8. 🔍 Find Contact by Name
                                 9. 🔍 Find Contact by Phone Number
                                 10. 🔤 Sort Contacts by Name
                                 11. ❌ Delete Contact by Name from Phone
                                 12. 🚪 Exit
                                 
                           """);


                int choice = scanner.nextInt();
                scanner.nextLine();

                switch (choice) {
                    case 1:
                        System.out.println("Enter phone details:");
                        System.out.print("ID: ");
                        Long id = scanner.nextLong();
                        scanner.nextLine();
                        System.out.print("Name: ");
                        String name = scanner.nextLine();
                        System.out.print("Brand: ");
                        String brand = scanner.nextLine();

                        Phone phone = new Phone(id, name, brand, new ArrayList<>());
                        System.out.println(phoneService.addPhone(phone));
                        break;
                    case 2:
                        System.out.print("Enter phone ID: ");
                        int phoneId = scanner.nextInt();
                        System.out.println(phoneService.getPhoneById(phoneId));
                        break;
                    case 3:
                        System.out.print("Enter phone ID: ");
                        int idToUpdate = scanner.nextInt();
                        scanner.nextLine();
                        System.out.print("Enter new name: ");
                        String newName = scanner.nextLine();
                        System.out.println(phoneService.updatePhoneNameById(idToUpdate, newName));
                        break;
                    case 4:
                        System.out.println(phoneService.getAllPhones());
                        break;
                    case 5:
                        System.out.print("Enter brand: ");
                        String brandToSearch = scanner.nextLine();
                        System.out.println(phoneService.getAllPhonesByBrand(brandToSearch));
                        break;
                    case 6:
                        System.out.print("Enter phone ID to delete: ");
                        int idToDelete = scanner.nextInt();
                        phoneService.deletePhoneById(idToDelete);
                        System.out.println("Phone with ID " + idToDelete + " deleted successfully.");
                        break;
                    case 7:
                        System.out.print("Enter phone ID: ");
                        int phoneIdToAddContact = scanner.nextInt();
                        scanner.nextLine();
                        System.out.print("Enter contact name: ");
                        String contactName = scanner.nextLine();
                        System.out.print("Enter contact phone number: ");
                        String phoneNumber = scanner.nextLine();

                        Contact contact = new Contact(contactName, phoneNumber);
                        System.out.println(contactService.addContactToPhone(phoneIdToAddContact, contact));
                        break;
                    case 8:
                        System.out.print("Enter phone ID: ");
                        int phoneIdToFindContactByName = scanner.nextInt();
                        scanner.nextLine();
                        System.out.print("Enter contact name: ");
                        String nameToFind = scanner.nextLine();
                        System.out.println(contactService.findContactByName(phoneIdToFindContactByName, nameToFind));
                        break;
                    case 9:
                        System.out.print("Enter phone ID: ");
                        int phoneIdToFindContactByNumber = scanner.nextInt();
                        scanner.nextLine();
                        System.out.print("Enter contact phone number: ");
                        String numberToFind = scanner.nextLine();
                        System.out.println(contactService.findContactByPhoneNumber(phoneIdToFindContactByNumber, numberToFind));
                        break;
                    case 10:
                        System.out.print("Enter phone ID: ");
                        int phoneIdToSortContacts = scanner.nextInt();
                        System.out.println(contactService.sortContactsByName(phoneIdToSortContacts));
                        break;
                    case 11:
                        System.out.print("Enter phone ID: ");
                        int phoneIdToDeleteContact = scanner.nextInt();
                        scanner.nextLine();
                        System.out.print("Enter contact name to delete: ");
                        String contactNameToDelete = scanner.nextLine();
                        contactService.deleteContactByNameFromPhone(phoneIdToDeleteContact, contactNameToDelete);
                        System.out.println("Contact " + contactNameToDelete + " deleted from phone with ID " + phoneIdToDeleteContact);
                        break;
                    case 12:
                        return;
                    default:
                        System.out.println("Invalid choice. Please enter a number between 1 and 12.");
                        scanner.nextLine();
                        break;
                }
            } catch (Exception e) {
                System.out.println("Error: " + e.getMessage());
            }
            break;
        }

    }
}
