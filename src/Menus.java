import ExeptionContact.ContactDataExeption;
import java.util.InputMismatchException;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class Menus {
    // need proper error handling on user input
    Controller controller = new Controller();

    public void mainMenu() {

        Scanner scanner = new Scanner(System.in);
        int choice;
        try {
            while (true) {
                System.out.println("*****************************************");
                System.out.println("1. Add a new contact");
                System.out.println("2. Delete Contact");
                System.out.println("3. Review and Edit Address Book");
                System.out.println("4. Search for a Contact");
                System.out.println("5. Exit");
                System.out.println("*****************************************");
                System.out.print("Please choose a menu option: ");

                choice = scanner.nextInt();

                switch (choice) {
                    case 1:  addContactToMenu(); break;
                    case 2: deleteContactsFromMenu(); break;
                    case 3: reviewAndEditContactFromMenu(); break;
                    case 4: searchForAContactFromMenu(); break;
                    case 5: {
                        System.out.println("Exist");
                        System.exit(0);
                    }
                    break;
                    default: System.out.println("Invalid number try between 1 and 5"); break;
                }

            }
        } catch (InputMismatchException ime) {
            System.out.println("------------------------------------------");
            System.out.println("YOU NEED TO TYPE A NUMBER!");
            System.out.println("------------------------------------------");
            mainMenu();
        }

    }


    public void addContactToMenu() {
        Scanner scanner = new Scanner(System.in);
        int choice;
        boolean isLooping = true;

        while (isLooping){
            System.out.println("*****************************************");
            System.out.println("Welcome to a register menu:");
            System.out.println("1. Register a new contact");
            System.out.println("2. Back to main menu");
            System.out.println("*****************************************");
            System.out.print("Please pick an option: ");
            choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    try {
                        controller.addNewContact();
                    } catch (ContactDataExeption cde) {
                        System.out.println("------------------------------------------");
                        System.out.println("INPUT INVALID: " + cde.getMessage());
                        System.out.println("------------------------------------------");
                        addContactToMenu();
                        break;
                    }
                    break;
                case 2:
                    mainMenu();
                    break;
                default:
                    System.out.println("Wrong number please choice between 1 and 2");
                    break;
            }
            isLooping = false;
        }
    }



    public void reviewAndEditContactFromMenu() {
        Scanner scanner = new Scanner(System.in);
        int choice;
        boolean isLooping = true;
        while (isLooping) {
            System.out.println("*****************************************");
            System.out.println("Welcome to a contact menu:");
            System.out.println("1. Review your contacts");
            System.out.println("2. Edit Contact Information");
            System.out.println("3. Back to main menu");
            System.out.println("*****************************************");
            System.out.print("Please pick an option: ");
            choice = scanner.nextInt();
            switch (choice) {
                case 1: controller.reviewContactFromMenu();
                break;
                case 2: {
                    try {
                        controller.editContactFromList();
                    } catch (NoSuchElementException nsee) {
                        System.out.println(nsee.getMessage());
                    }
                }
                break;
                case 3: mainMenu();
                break;
                default: System.out.println("Wrong number please choice between 1 and 3");
                break;
            }
            isLooping = false;
        }
    }

    public void deleteContactsFromMenu() {
        Scanner scanner = new Scanner(System.in);
        int choice;
        boolean isLooping = true;
        while (isLooping) {
            System.out.println("*****************************************");
            System.out.println("Welcome here you can delete contacts from menu:");
            System.out.println("1. Delete a contact");
            System.out.println("2. Back to main menu");
            System.out.println("*****************************************");
            System.out.print("Please pick an option: ");
            choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    Scanner scanner2 = new Scanner(System.in);
                    System.out.println("------------------------------------------");
                    System.out.print("Please enter the name of the contact you want to delete: ");
                    String username = scanner2.nextLine();
                    controller.deleteContactFromList(username);
                case 2:
                    mainMenu();
                    break;
                default:
                    System.out.println("Wrong number please choice between 1 and 2");
            }
          isLooping = false;
        }
    }
    public void searchForAContactFromMenu() {
        Scanner scanner = new Scanner(System.in);
        int choice;
        boolean isLooping = true;
        while (isLooping) {
            System.out.println("*****************************************");
            System.out.println("Welcome here you can Search for a contacts from menu:");
            System.out.println("1. Search by a Name");
            System.out.println("2. Search by a Phone Number");
            System.out.println("3. Back to main menu");
            System.out.println("*****************************************");
            System.out.print("Please pick an option: ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1: {
                    try {
                        controller.searchForAContactName();
                    } catch (NoSuchElementException nse) {
                        System.out.println("------------------------------------------");
                        System.out.println(nse.getMessage());
                        System.out.println("------------------------------------------");
                    }
                    
                }
                break;
                case 2: {
                    try {
                        controller.searchForAContactPhoneNum();
                    } catch (NoSuchElementException nse) {
                        System.out.println("------------------------------------------");
                        System.out.println(nse.getMessage());
                        System.out.println("------------------------------------------");
                    }
                }
                break;
                case 3: mainMenu(); break;
                default: System.out.println("Wrong number please choice between 1 and 3"); break;
            }
            isLooping = false;
        }
    }
}
