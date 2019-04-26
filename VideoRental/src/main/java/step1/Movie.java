package step1;

public class Movie {
	public static final int CHILDRENS = 2;
	public static final int REGULAR = 0;
	public static final int NEW_RELEASE = 1;
	private final Price price;

	private String title;

	public Movie(String title, int priceCode) {
		this.price = new Price(priceCode);
		this.title = title;
	}

	public void setPriceCode(int arg) {
		price.priceCode = arg;
	}

	public String getTitle() {
		return title;
	};

	double getAmount(int daysRented) {
		return price.getAmount(daysRented);
	}

	int getFrequentRenterPoints(int daysRented) {
		return price.getFrequentRenterPoints(daysRented);
	}

}