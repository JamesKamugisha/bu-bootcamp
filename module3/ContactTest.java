import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ContactTest {

    private Contact contact;

    @BeforeEach
    void setUp() {
        contact = new Contact("Ninja Al", "+1 617 555 0101");
    }

    @Test
    void getName_returnsCorrectName() {
        assertEquals("Ninja Al", contact.getName());
    }

    @Test
    void getPhone_returnsCorrectPhone() {
        assertEquals("+1 617 555 0101", contact.getPhone());
    }

    @Test
    void toString_containsBothFields() {
        assertTrue(contact.toString().contains("Ninja Al"));
        assertTrue(contact.toString().contains("+1 617 555 0101"));
    }

    @Test
    void contactsWithSameName_areIndependent() {
        Contact firstContact = new Contact("James Kamu", "+1 637 264 87634");
        Contact secondContact = new Contact("James Kamu", "+1 212 555 0142");

        assertEquals("James Kamu", firstContact.getName());
        assertEquals("James Kamu", secondContact.getName());
        assertNotEquals(firstContact.getPhone(), secondContact.getPhone());
    }

    @Test
    void changingOneContactDoesNotChangeAnotherContact() {
        Contact anotherContact = new Contact("Mary White", "+1 212 555 0142");

        contact = new Contact("Ninja Al", "+1 999 999 9999");

        assertEquals("Mary White", anotherContact.getName());
        assertNotEquals(contact.getPhone(), anotherContact.getPhone());
    }
}
