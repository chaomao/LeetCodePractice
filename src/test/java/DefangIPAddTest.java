import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DefangIPAddTest {

    private DefangIPAdd defangIPAdd = new DefangIPAdd();

    @Test
    void should_simple_ip_address() {
        assertEquals("1[.]1[.]1[.]1", defangIPAdd.defangIPAddr("1.1.1.1"));
    }

    @Test
    void should_complex_ip_address() {
        assertEquals("255[.]100[.]50[.]0", defangIPAdd.defangIPAddr("255.100.50.0"));
    }

}