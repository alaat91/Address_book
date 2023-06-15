import java.util.Objects;
import java.util.UUID;

public class Contact  {

    private String uniqueID;
    private String name;
    private String email;
    private String phoneNumber;

    public Contact() {}
    public Contact(String name, String email, String phoneNumber)  {
            this.uniqueID = UUID.randomUUID().toString();
            this.name = name;
            this.email = email;
            this.phoneNumber = phoneNumber;

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



    @Override
    public int hashCode() {
        return Objects.hash(name, email, phoneNumber);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Contact contact = (Contact) o;
        return name.equals(contact.name) && email.equals(contact.email) && phoneNumber.equals(contact.phoneNumber);
    }

    public String getUniqueID() {
        return uniqueID;
    }

    public String toString() {
        return "Name: " + getName() + " Id: " + getUniqueID() + " Email: " + getEmail();
    }

}
