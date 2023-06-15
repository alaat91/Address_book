import java.util.*;

public class AddressBook {
    // May remove final if problems arisen
    private final Contact contact;
    private final List<Contact> addressBook;

    private static final String nextLine = "\n";


    public AddressBook() {
        this.addressBook = new ArrayList<>();
        this.contact = new Contact();
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

    public void removeContact(String name) {
        String trimmedName = name.toLowerCase().trim();

        for (int i = 0; i < addressBook.size(); i++) {
            if (addressBook.get(i).getName().toLowerCase().trim().equals(trimmedName)) {
                //noinspection SuspiciousListRemoveInLoop
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AddressBook that = (AddressBook) o;
        return Objects.equals(contact, that.contact) && Objects.equals(addressBook, that.addressBook);
    }

    @Override
    public int hashCode() {
        return Objects.hash(contact, addressBook);
    }
}