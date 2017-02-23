package nl.ica.oose;

import java.util.Enumeration;
import java.util.Vector;

/**
 * Created by Mick on 23/02/2017.
 */
public class Customer {
	private String _name;
	private Vector _rentals = new Vector();

	public Customer(String name) {
		_name = name;
	}

	public void addRental(Rental arg) {
		_rentals.addElement(arg);
	}

	public String getName() {
		return _name;
	}

	public String statement() {
		Enumeration rentals = _rentals.elements();
		String result = "Rental Record for " + getName() +  "\n";
		
		while (rentals.hasMoreElements()) {
			Rental each = (Rental) rentals.nextElement();
			result += "\t" + each.getMovie().getTitle()+ "\t" +
					String.valueOf(each.getCharge()) + "\n";

		}

		result += "Amount owed is "+String.valueOf(getTotalAmount()) + "\n";
		result += "You earned "+String.valueOf(getTotalFrequentRenterPoints())
				+ "frequent renter points\n";
		return result;
	}

	public String htmlStatement() {
		Enumeration rentals = _rentals.elements();
		String result = "<H1>Rental Record for<EM> " +
				getName() +  "<EM></H1><P>\n";
		while (rentals.hasMoreElements()) {
			Rental each = (Rental) rentals.nextElement();
			result +=  each.getMovie().getTitle()+ ": " +
					String.valueOf(each.getCharge()) + "<BR>\n";
		}

		result += "<P>Amount owed is<EM>"
				+ String.valueOf(getTotalAmount())
				+ "</EM><P>\n";
		result += "You earned <EM>"
				+ String.valueOf(getTotalFrequentRenterPoints())+
          		  "</EM> frequent renter points<P>\n";
		return result;
	}

	private int getTotalFrequentRenterPoints() {
		int totalFrequentRenterPoints = 0;
		while (_rentals.elements().hasMoreElements()) {
			Rental each = (Rental) _rentals.elements().nextElement();
			totalFrequentRenterPoints += each.getFrequentRenterPoints();
		}
		return totalFrequentRenterPoints;
	}

	private double getTotalAmount() {
		double totalAmount = 0;
		while (_rentals.elements().hasMoreElements()) {
			Rental each = (Rental) _rentals.elements().nextElement();
			totalAmount = totalAmount + each.getCharge();
		}
		return totalAmount;
	}

}