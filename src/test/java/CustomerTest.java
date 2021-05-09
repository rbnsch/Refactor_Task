import dhbw.refactor.Customer;
import dhbw.refactor.Movie;
import dhbw.refactor.PriceCode;
import dhbw.refactor.Rental;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CustomerTest {

    Customer c;


    @BeforeEach
    void setUp() {
        this.c = new Customer("Test");
    }

    @Test
    void getName() {
        assertEquals("Test", c.getName());
    }

    @Test
    void addRental() {
        Movie m = new Movie("Title", PriceCode.CHILDREN);
        Rental r = new Rental(m, 10);
        this.c.addRental(r);
        //tbd

    }

    @Test
    void statement() {
        Movie m = new Movie("Title", PriceCode.CHILDREN);
        Rental r = new Rental(m, 10);
        this.c.addRental(r);
        System.out.println(c.statement());
        String expected = "Rental Record for Test\n" + "\t" + "Title" + "\t" + "\t" + "Days" + "\t" + "Amount" + "\n" + "\t" + "Title" + "\t" + "\t" + "10" + "\t" + "12.0" + "\n" +"Amount owed is 12.0\n" + "You earned 1 frequent renter points";
        assertEquals(expected, c.statement());
    }
}
