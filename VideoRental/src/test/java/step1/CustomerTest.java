package step1;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class CustomerTest {

    public static final int RENTED_FOR_THREE_DAYS = 3;
    private Customer customer;
    private ConsoleStatement consoleStatement;

    @Before
    public void setUp() throws Exception {
        customer = new Customer(null);
        consoleStatement = new ConsoleStatement();
    }

    @Test
    public void statement_for_noRental() { //
        String statement = consoleStatement.statement(customer);

        assertEquals("Rental Record for null\n" +
                "Amount owed is 0.0\n" +
                "You earned 0 frequent renter pointers",statement);
    }

    @Test
    public void statement_for_regularMovie_daysRented_is_less_than_three_days() { //
        int daysRented = 2;
        customer.addRental(createRentalFor(Movie.REGULAR, daysRented));

        String statement = consoleStatement.statement(customer);

        assertEquals("Rental Record for null\n" +
                "\t2.0(null)\n" +
                "Amount owed is 2.0\n" +
                "You earned 1 frequent renter pointers",statement);
    }

    @Test
    public void statement_for_regularMovie_daysRented_is_more_than_2_days() { //
        customer.addRental(createRentalFor(Movie.REGULAR, RENTED_FOR_THREE_DAYS));

        String statement = consoleStatement.statement(customer);

        assertEquals("Rental Record for null\n" +
                "\t3.5(null)\n" +
                "Amount owed is 3.5\n" +
                "You earned 1 frequent renter pointers",statement);
    }

    @Test
    public void statement_for_newReleaseMovie_daysRented_is_lessThan_2_days() { //
        customer.addRental(createRentalFor(Movie.NEW_RELEASE, 1));

        String statement = consoleStatement.statement(customer);

        assertEquals("Rental Record for null\n" +
                "\t3.0(null)\n" +
                "Amount owed is 3.0\n" +
                "You earned 1 frequent renter pointers",statement);
    }

    @Test
    public void statement_for_newReleaseMovie_daysRented_is_moreThan_1_day() { //
        customer.addRental(createRentalFor(Movie.NEW_RELEASE, 2));

        String statement = consoleStatement.statement(customer);

        assertEquals("Rental Record for null\n" +
                "\t6.0(null)\n" +
                "Amount owed is 6.0\n" +
                "You earned 2 frequent renter pointers",statement);
    }

    @Test
    public void statement_for_ChildrensMovie_daysRented_is_less_than_four_days() { //
        customer.addRental(createRentalFor(Movie.CHILDRENS, 3));

        String statement = consoleStatement.statement(customer);

        assertEquals("Rental Record for null\n" +
                "\t1.5(null)\n" +
                "Amount owed is 1.5\n" +
                "You earned 1 frequent renter pointers",statement);
    }

    @Test
    public void statement_for_ChildrensMovie_daysRented_is_more_than_three_days() { //
        customer.addRental(createRentalFor(Movie.CHILDRENS, 4));

        String statement = consoleStatement.statement(customer);

        assertEquals("Rental Record for null\n" +
                "\t3.0(null)\n" +
                "Amount owed is 3.0\n" +
                "You earned 1 frequent renter pointers",statement);
    }


    @Test
    public void statement_for_multiple_rentals() { //
        customer.addRental(createRentalFor(Movie.REGULAR, 2));
        customer.addRental(createRentalFor(Movie.REGULAR, RENTED_FOR_THREE_DAYS));
        customer.addRental(createRentalFor(Movie.NEW_RELEASE, 1));
        customer.addRental(createRentalFor(Movie.NEW_RELEASE, 2));
        customer.addRental(createRentalFor(Movie.CHILDRENS, 3));
        customer.addRental(createRentalFor(Movie.CHILDRENS, 4));

        customer.addRental(createRentalFor(Movie.REGULAR, 2));
        customer.addRental(createRentalFor(Movie.REGULAR, RENTED_FOR_THREE_DAYS));
        customer.addRental(createRentalFor(Movie.NEW_RELEASE, 1));
        customer.addRental(createRentalFor(Movie.NEW_RELEASE, 2));
        customer.addRental(createRentalFor(Movie.CHILDRENS, 3));
        customer.addRental(createRentalFor(Movie.CHILDRENS, 4));

        String statement = consoleStatement.statement(customer);

        assertEquals("Rental Record for null\n" +
                "\t2.0(null)\n" +
                "\t3.5(null)\n" +
                "\t3.0(null)\n" +
                "\t6.0(null)\n" +
                "\t1.5(null)\n" +
                "\t3.0(null)\n" +
                "\t2.0(null)\n" +
                "\t3.5(null)\n" +
                "\t3.0(null)\n" +
                "\t6.0(null)\n" +
                "\t1.5(null)\n" +
                "\t3.0(null)\n" +
                "Amount owed is 38.0\n" +
                "You earned 14 frequent renter pointers",statement);
    }

    private Rental createRentalFor(int priceCode, int daysRented) {
        String title = null;
        Movie movie = new Movie(title, priceCode);
        return new Rental(movie, daysRented);
    }

}