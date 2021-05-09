import dhbw.refactor.Movie;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MovieTest {

    Movie m;

    @BeforeEach
    void setUp() {
        this.m = new Movie("Titel", 10);
    }

    @Test
    void getPriceCode() {
        assertEquals(10, m.getPriceCode());
    }

    @Test
    void getTitle() {
        assertEquals("Titel", m.getTitle());
    }

    @Test
    void setPriceCode() {
        this.m.setPriceCode(42);
        assertEquals(42, m.getPriceCode());
    }
}
