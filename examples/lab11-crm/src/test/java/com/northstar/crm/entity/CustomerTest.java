Cpackage com.northstar.crm.entity;

import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class CustomerTest {

    @Test
    void equals_based_on_customerId() {
        Customer c1 = new Customer("CUS-1001", "Alice A", "alice@example.com", "111-1111", CustomerStatus.ACTIVE, LocalDateTime.now());
        Customer c2 = new Customer("CUS-1001", "Bob B", "bob@example.com", "222-2222", CustomerStatus.SUSPENDED, LocalDateTime.now().minusDays(1));
        assertEquals(c1, c2);
    }

    @Test
    void toString_contains_customerId() {
        Customer c = new Customer("CUS-1001", "Alice A", "alice@example.com", "111-1111", CustomerStatus.PROSPECT, LocalDateTime.now());
        assertTrue(c.toString().contains("CUS-1001"));
    }
}