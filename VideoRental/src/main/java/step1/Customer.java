package step1;

import java.util.ArrayList;
import java.util.List;

class Customer {
	private String name;
	private List<Rental> rentals = new ArrayList<>();

	public Customer(String name) {
		this.name = name;
	};

	public void addRental(Rental rental) {
		rentals.add(rental);
	}

	public String getName() {
		return name;
	};

    public double getTotalAmount() {
		double totalAmount = 0;
		for ( Rental rental : rentals ) {
			totalAmount += rental.getAmount();
		}
		return totalAmount;
	}

	public int getFrequentRenterPoints() {
		int frequentRenterPoints = 0;
		for ( Rental rental : rentals ) {
			frequentRenterPoints += frequentRenterPointsFor(rental);
		}
		return frequentRenterPoints;
	}

    private int frequentRenterPointsFor(Rental rental) {
		// add frequent renter points
		int frequentRenterPoints = 0;
		frequentRenterPoints++;
		// add bonus for a two day new release rental
		if ((rental.getMovie().getPriceCode() == Movie.NEW_RELEASE)
				&&
				rental.getDaysRented() > 1)
			frequentRenterPoints++;
		return frequentRenterPoints;
	}

    List<Rental> getRentals() {
        return rentals;
    }
}