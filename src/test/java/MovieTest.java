import dhbw.refactor.Movie;
import dhbw.refactor.PriceCode;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MovieTest {

    Movie m;

    @BeforeEach
    void setUp() {
        this.m = new Movie("Titel", PriceCode.CHILDRENS);
    }

    @Test
    void getPriceCode() {
        assertEquals(PriceCode.CHILDRENS, m.getPriceCode());
    }

    @Test
    void getTitle() {
        assertEquals("Titel", m.getTitle());
    }

    @Test
    void setPriceCode() {
        this.m.setPriceCode(PriceCode.REGULAR);
        assertEquals(PriceCode.REGULAR, m.getPriceCode());
    }
}
