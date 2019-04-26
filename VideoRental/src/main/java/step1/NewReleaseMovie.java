package step1;

public class NewReleaseMovie extends Movie {
    public NewReleaseMovie(String title) {
        super(title, Movie.NEW_RELEASE);
    }

    @Override
    double getAmount(int daysRented) {
        double thisAmount = 0;

        thisAmount += daysRented * 3;
        return thisAmount;
    }

    @Override
    int getFrequentRenterPoints(int daysRented) {
        // add frequent renter points
        int frequentRenterPoints = 1;

        // add bonus for a two day new release rental
        if ( daysRented > 1)
            frequentRenterPoints++;
        return frequentRenterPoints;
    }
}