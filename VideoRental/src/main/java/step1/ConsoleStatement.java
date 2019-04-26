package step1;

public class ConsoleStatement {
    public String statement(Customer customer) {
        return statementHeader(customer)
                + statementBody(customer)
                + statementTail(customer);
    }

    private String statementTail(Customer customer) {
        String result = "Amount owed is " + String.valueOf(customer.getTotalAmount()) + "\n";
        result += "You earned " + String.valueOf(customer.getFrequentRenterPoints()) + " frequent renter pointers";
        return result;
    }

    private String statementBody(Customer customer) {
        String result = "";
        for (Rental rental : customer.getRentals()) {
            result += showFigures(customer, rental);
        }
        return result;
    }

    private String showFigures(Customer customer, Rental rental) {
        return "\t" +  String.valueOf(rental.getAmount()) + "(" + rental.getMovie().getTitle() + ")" + "\n";
    }

    private String statementHeader(Customer customer) {
        return "Rental Record for " + customer.getName() + "\n";
    }
}
