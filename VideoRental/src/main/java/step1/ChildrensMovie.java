package step1;

public class ChildrensMovie extends Movie {
    public ChildrensMovie(String title) {
        super(title, Movie.CHILDRENS);
    }

    @Override
    double getAmount(int daysRented) {
        double thisAmount = 0;

        thisAmount += 1.5;
        if (daysRented > 3)
            thisAmount += (daysRented - 3) * 1.5;
        return thisAmount;
    }

    @Override
    int getFrequentRenterPoints(int daysRented) {
        return 1;
    }
}
