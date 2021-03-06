import dhbw.refactor.Movie;
import dhbw.refactor.PriceCode;
import dhbw.refactor.Rental;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class RentalTest {

    Rental r;

    @BeforeEach
    void setUp() {
        Movie m = new Movie("Titel", PriceCode.CHILDREN);
        this.r = new Rental(m, 10);
    }

    @Test
    void getDaysRented() {
        assertEquals(10, r.getDaysRented());
    }

    @Test
    void getMovie() {
        assertEquals("Titel", r.getMovie().getTitle());
        assertEquals(PriceCode.CHILDREN, r.getMovie().getPriceCode());
    }
}
