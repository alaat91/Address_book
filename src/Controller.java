

import ExeptionContact.ContactDataExeption;
import FileOperationHandler.ContactHandlerToJSON;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class Controller {

    ContactHandlerToJSON contactHandlerToJSON = new ContactHandlerToJSON();
    AddressBook addressBook = new AddressBook();
    static final String NEWLINE = "\n";

    public void addNewContact()  {

            Scanner scanner = new Scanner(System.in);
            System.out.println("------------------------------------------");
            System.out.print("1. Please type your Name: ");
            String userName = scanner.nextLine();
            System.out.println("Your name: " + userName);
            System.out.println("------------------------------------------");
            System.out.print("2. Please type your Email: ");
            String userEmail = scanner.nextLine();
            System.out.println("Your email: " + userEmail);
            System.out.print("2. Please type your Phone Number: ");
            String userPN = scanner.nextLine();
            System.out.println("Your Phone Number: " + userPN);
            System.out.println("------------------------------------------");

            Contact contact = new Contact(userName, userEmail, userPN);
            contactHandlerToJSON.writeToFile(userName, userEmail, userPN);
            //addressBook.addContact(contact);



            System.out.println("Congratulations your new contact has been successfully added!");
            System.out.println("------------------------------------------");
            System.out.println("Contact details: ");
            System.out.println("UserID:          " + contact.getUniqueID());
            System.out.println("Name:            " + contact.getName());
            System.out.println("Email:           " + contact.getEmail());
            System.out.println("Phone Number:    " + contact.getPhoneNumber());
            System.out.println("------------------------------------------");


    }

    public void deleteContactFromList(String username) {
        System.out.println("--------------------------------------------");
        //addressBook.deleteContact(username);
        contactHandlerToJSON.deleteRecordFromFile(username);
        System.out.println("--------------------------------------------");

    }

    public void reviewContactFromMenu() {
        contactHandlerToJSON.readFromFile();
    }

    public void editContactFromList() {
        boolean isEmpty = addressBook.renderAllContactList();
        if (isEmpty) {
            System.out.println("----------------------------");
            System.out.println("No contact to be edited, please add contact first");
            System.out.println("----------------------------");
        }
        else {
            Scanner scanner = new Scanner(System.in);
            System.out.print("Please Provide User ID to edit Contact: ");
            String userID = scanner.nextLine();
            Contact contact = addressBook.editContactInformation(userID);
            if (contact != null) {
                editChosenContact(contact);
            } else {
                System.out.println("----------------------------");
                System.out.println("Please provide valid User ID");
                System.out.println("----------------------------");
            }
        }

    }
    public void editChosenContact(Contact c) {

        Scanner scanner = new Scanner(System.in);
        boolean isEdited = false;

        while (!isEdited) {
            System.out.println("Choose what you want to edit: ");
            System.out.println("---------------------------------");
            System.out.println("Type (name, email, or phone number) to Change the respective field or (ENTER) to go back to previous List");
            System.out.print("YOUR CHOICE: ");

            String choice = scanner.nextLine();
            switch (choice) {
                case "name": {
                    System.out.print("Please type the new name: ");
                    String newName = scanner.nextLine();
                    c.setName(newName);
                    isEdited = true;
                }
                break;
                case "email": {
                    System.out.print("Please type the new Email: ");
                    String newEmail = scanner.nextLine();
                    c.setEmail(newEmail);
                    isEdited = true;
                }
                break;
                case "phone number": {
                    System.out.print("Please type the new Phone Number: ");
                    String newPN = scanner.nextLine();
                    c.setPhoneNumber(newPN);
                    isEdited = true;
                }
                break;
                case "": isEdited = true; break;
                default: {
                    System.out.println("You provided wrong input");
                    System.out.println("Please type name, email, or phone number to edit");
                }
                break;
            }
            if (isEdited) {
                System.out.println("---------------------------------");
                System.out.println("Your Edit Contact: " + NEWLINE + "Name: " + c.getName() + NEWLINE + "Email: " + c.getEmail() + NEWLINE + "Phone Number: " + c.getPhoneNumber());
                System.out.println("---------------------------------");
                reviewContactFromMenu();
            }
        }
    }

    public void searchForAContactName() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Please Type the User Name: ");
        String userName = scanner.nextLine();
        List<Contact> c = addressBook.searchForAContactByName(userName);
        if (c != null) {
            addressBook.renderAllContactListNoID(c);
        } else {
            throw new NoSuchElementException("Contact Is Not Found!");
        }
    }

    public void searchForAContactPhoneNum() throws ContactDataExeption {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Please Type the User Phone Number: ");
        String userPN = scanner.nextLine();
        List<Contact> c = addressBook.searchForAContactByPhoneNum(userPN);
        if (c != null) {
            addressBook.renderAllContactListNoID(c);
        } else {
            throw new NoSuchElementException("Contact Is Not Found!");
        }
    }
}
