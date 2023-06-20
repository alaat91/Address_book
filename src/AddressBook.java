import FileOperationHandler.ContactHandlerToJSON;

import java.util.*;

public class AddressBook {
    // May remove final if problems arisen

    private final List<Contact> addressBook;

    private static final String nextLine = "\n";


    public AddressBook() {
        this.addressBook = new ArrayList<>();
    }

    public void addContact(Contact c) {
        addressBook.add(c);
    }

    public void deleteContact(String name) {
        int duplicate = 0;
        for (Contact value : addressBook) {
            if (value.getName().equals(name)) {
                duplicate++;
            }
        }
        if (duplicate > 1) {
            System.out.println("You have multiple contacts with similar names!");
            contactsWithSimilarNames(name);
        } else if(duplicate == 1) {
            removeContact(name);
        } else {
            System.out.println("Contact does not exit!");
        }
    }


    @SuppressWarnings("SuspiciousListRemoveInLoop")
    public void removeContact(String name) {
        String trimmedName = name.toLowerCase().trim();

        for (int i = 0; i < addressBook.size(); i++) {
            if (addressBook.get(i).getName().toLowerCase().trim().equals(trimmedName)) {
                addressBook.remove(i);
                System.out.println(name + " Has been deleted successfully!");
            }
        }
    }

    public void contactsWithSimilarNames(String name) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("All Contacts with name " + name);
        int counter = addressBook.size() - 1;
        while (counter >= 0) {
            if(addressBook.get(counter).getName().equals(name)) {
                System.out.println("----------------------------------------");
                System.out.println("Name        : " + addressBook.get(counter).getName());
                System.out.println("Email       : " + addressBook.get(counter).getEmail());
                System.out.println("PhoneNumber : " + addressBook.get(counter).getPhoneNumber());
                System.out.println("UserId      : " + addressBook.get(counter).getUniqueID());
                System.out.println("----------------------------------------");
            }
            counter--;
        }
        System.out.println("Please provide the ID of the user you wish to delete: ");
        String uuid = scanner.nextLine();
        for (Contact c: addressBook) {
            if(c.getUniqueID().equals(uuid)) {
                addressBook.remove(c);
                System.out.println("Contact with Name: " + c.getName() + " ID: " + c.getUniqueID() + " Has been deleted successfully.");
            }
        }
    }

    // Contacts list rendering needs to be modularised into its own function + solving the optional parameter problem
    public void reviewContacts() {

        if(addressBook.size() == 0) {
            System.out.println("----------------------------");
            System.out.println("Your list is empty");
            System.out.println("----------------------------");
        }else {
            System.out.println("Your list of contacts contains (" + addressBook.size() + ") contacts ");
            System.out.println("----------------------------");
            for (Contact value : addressBook) {
                System.out.println("Name: " + value.getName() + nextLine + "Email: " + value.getEmail() + nextLine + "Phone number: " + value.getPhoneNumber());
                System.out.println("----------------------------");
            }
        }
    }

    public Contact editContactInformation(String uuid) {
        if (addressBook.isEmpty()) {
            throw new NoSuchElementException("The Address Book Is Empty!");
        }
        for(Contact c: addressBook) {
                if (c.getUniqueID().equals(uuid)) {
                    return c;
                }
            }
        throw new NoSuchElementException("No contact found with the specified UUID.");
    }

    public List<Contact> searchForAContactByName(String contactName) {
        ArrayList<Contact> contacts = new ArrayList<>();
        for(Contact c: addressBook) {
            if(c.getName().startsWith(contactName)) {
                contacts.add(c);
            }
        }
        return contacts;
    }

    public List<Contact> searchForAContactByPhoneNum(String contactPN) {
        ArrayList<Contact> contacts = new ArrayList<>();
        for(Contact c: addressBook) {
            if(c.getPhoneNumber().startsWith(contactPN)) {
                contacts.add(c);
            }
        }
        return contacts;
    }




    public boolean renderAllContactList() {
        boolean isEmpty = false;
        if(addressBook.size() == 0) {
            isEmpty = true;
        } else {
            for (Contact contact : addressBook) {
                System.out.println("----------------------------------------");
                System.out.println("UserId      : " + contact.getUniqueID());
                System.out.println("Name        : " + contact.getName());
                System.out.println("Email       : " + contact.getEmail());
                System.out.println("PhoneNumber : " + contact.getPhoneNumber());
                System.out.println("----------------------------------------");
            }
        }
        return isEmpty;
    }
    public void renderAllContactListNoID(List<Contact> contactList) {
            for (Contact contact : contactList) {
                System.out.println("----------------------------------------");
                System.out.println("Name        : " + contact.getName());
                System.out.println("Email       : " + contact.getEmail());
                System.out.println("PhoneNumber : " + contact.getPhoneNumber());
                System.out.println("----------------------------------------");
        }
    }
}