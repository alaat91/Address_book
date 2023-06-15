import java.util.Scanner;

public class Menus {
    AddressBook addressBook = new AddressBook();
    static final String NEWLINE = "\n";
    public void mainMenu() {
        
        Scanner scanner = new Scanner(System.in);
        int choice;

        while (true) {
            System.out.println("*****************************************");
            System.out.println("1. Add a new contact");
            System.out.println("2. Delete Contact");
            System.out.println("3. Review Address Book");
            System.out.println("4. Exit");
            System.out.println("*****************************************");
            System.out.print("Please choose a menu option: ");

            choice = scanner.nextInt();

            switch (choice) {
                case 1 -> addContactToMenu();
                case 2 -> deleteContactsFromMenu();
                case 3 -> reviewContactFromMenu();
                case 4 -> {
                    System.out.println("Exist");
                    System.exit(0);
                }
                default -> System.out.println("Invalid number try between 1 and 4");
            }

        }
    }


    public  void addContactToMenu() {
        Scanner scanner = new Scanner(System.in);
        int choice;

        while (true) {
            System.out.println("*****************************************");
            System.out.println("Welcome to a register menu:");
            System.out.println("1. Register a new contact");
            System.out.println("2. Back to main menu");
            System.out.println("*****************************************");
            System.out.print("Please pick an option: ");
            choice =  scanner.nextInt();
            switch (choice) {
                case 1:
                    addNewContact();
                case 2:
                    mainMenu();
                    break;
                default:
                    System.out.println("Wrong number please choice between 1 and 2");
            }
        }
    }

    public  void addNewContact() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("------------------------------------------");
        System.out.println("1. Please type your Name: ");
        String userName = scanner.nextLine();
        System.out.println("Your name: " + userName);

        System.out.println("------------------------------------------");
        System.out.println("2. Please type your Email: ");
        String userEmail = scanner.nextLine();
        System.out.println("Your email: " + userEmail);

        System.out.println("2. Please type your Phone Number: ");
        String userPN = scanner.nextLine();
        System.out.println("Your Phone Number: " + userPN);
        System.out.println("------------------------------------------");

        Contact contact = new Contact(userName,userEmail,userPN);
        addressBook.addContact(contact);

        System.out.println("Congratulations your new contact has been successfully added!" + NEWLINE);
        System.out.println("Contact details: ");
        System.out.println("UserID:          " + contact.getUniqueID());
        System.out.println("Name:            " + contact.getName());
        System.out.println("Email:           " + contact.getEmail());
        System.out.println("Phone Number:    " + contact.getPhoneNumber());
        System.out.println("------------------------------------------");

    }

    public  void reviewContactFromMenu() {
        Scanner scanner = new Scanner(System.in);
        int choice;

        while (true) {
            System.out.println("*****************************************");
            System.out.println("Welcome to a contact menu:");
            System.out.println("1. Review your contacts");
            System.out.println("2. Back to main menu");
            System.out.println("*****************************************");
            System.out.print("Please pick an option: ");
             choice =  scanner.nextInt();
            switch (choice) {
                case 1:
                    addressBook.reviewContacts();
                case 2:
                    mainMenu();
                    break;
                default:
                    System.out.println("Wrong number please choice between 1 and 2");
            }
        }
    }

    public  void deleteContactsFromMenu() {
        Scanner scanner = new Scanner(System.in);
        int choice;

        while (true) {
            System.out.println("*****************************************");
            System.out.println("Welcome here you can delete contacts from menu:");
            System.out.println("1. Delete a contact");
            System.out.println("2. Back to main menu");
            System.out.println("*****************************************");
            System.out.print("Please pick an option: ");
            choice =  scanner.nextInt();
            switch (choice) {
                case 1:
                    Scanner scanner2 = new Scanner(System.in);
                    System.out.println("------------------------------------------");
                    System.out.println("Please enter the name of the contact you want to delete: ");
                    String username = scanner2.nextLine();
                    deleteContact2(username);

                case 2:
                    mainMenu();
                    break;
                default:
                    System.out.println("Wrong number please choice between 1 and 2");
            }
        }
    }

    public void deleteContact2(String username) {
        System.out.println("--------------------------------------------");
        addressBook.deleteContact(username);
        System.out.println("--------------------------------------------");

    }

}