import java.util.*;

public class ContactManager {

    public static void main(String[] args) {

        HashMap<String, Contact> contacts = new HashMap<>();

        // Step 4: add contacts here
        contacts.put("James Kamu", new Contact("James Kamu", "+1 637 264 87634"));
        contacts.put("Ninja Al", new Contact("Ninja Al", "+1 617 555 0101"));
        contacts.put("Mary White", new Contact("Mary White", "+1 212 555 0142"));
        contacts.put("Newton Jong", new Contact("Newton Jong", "+1 207 846 0958"));
        contacts.put("Jungle Book", new Contact("Jungle Book", "+1 415 555 0199"));

        // Step 5: look up a contact

        String nameToLookup = "Ninja Al";
        Contact found = contacts.get(nameToLookup);

        if (found == null) {
            System.out.println("Contact not found.");
        } else {
            System.out.println(found);
        }

        String missingName = "Unknown";
        Contact notFound = contacts.get(missingName);

        if (notFound == null) {
            System.out.println("Contact not found.");
        } else {
            System.out.println(notFound);
        }

        ArrayList<Contact> sorted = new ArrayList<>(contacts.values());
        sorted.sort((a, b) -> a.getName().compareTo(b.getName()));

        System.out.println("===All Contacts ===");
        for (Contact contact : sorted) {
            System.out.println(contact);
        }

        // Step 6: print sorted list
    }
}