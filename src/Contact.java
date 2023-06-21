
import ExeptionContact.ContactDataExeption;
import java.util.Objects;
import java.util.UUID;

public class Contact  {

    // need data validation ie. regex to validate contact info



    private  String uniqueID;
    private String name;
    private String email;
    private String phoneNumber;

    private static final String nextLine = "\n";

    public Contact() {}
    // need proper error handling in constructor
    public Contact(String name, String email, String phoneNumber) throws ContactDataExeption {
        if (!isUsernameValid(name)) {
            throw new ContactDataExeption("INVALID USER NAME");
        }
        if (!isEmailValid(email)) {
            throw new ContactDataExeption("INVALID USER EMAIL");

        }
        if (!isPhoneNumValid(phoneNumber)) {
            throw new ContactDataExeption("INVALID USER PHONE NUMBER");
        }
        this.uniqueID = UUID.randomUUID().toString();
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.email = email;
    }

    public boolean isUsernameValid(String username) {
        String pattern = "^[a-zA-Z\\d]+$";
        return username.matches(pattern);
    }

    public boolean isPhoneNumValid(String userPN) {
        String pattern = "^\\d{3}(?:-\\d{3})?-\\d{4}$";
        return userPN.matches(pattern);
    }

    public boolean isEmailValid(String userEmail) {
        String pattern = "^[A-Za-z\\d._%+-]+@[A-Za-z\\d.-]+\\.[A-Za-z]{2,}$";
        return userEmail.matches(pattern);
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUniqueID() {
        return uniqueID;
    }


    @Override
    public int hashCode() {
        return Objects.hash(name, email, phoneNumber);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Contact contact = (Contact) o;
        return name.equals(contact.name)
                && email.equals(contact.email)
                && phoneNumber.equals(contact.phoneNumber);
    }



    public String toString() {
        return "User ID: " + getUniqueID() + nextLine + "Name: " + getName()  + nextLine + "Email: " + getEmail() + nextLine +"Phone Number: " + getPhoneNumber();
    }

}
