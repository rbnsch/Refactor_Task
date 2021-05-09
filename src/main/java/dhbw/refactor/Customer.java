package dhbw.refactor;

import java.lang.*;
import java.util.*;


public class Customer {
    private final String name;
    private final Vector<Rental> rentals = new Vector<>();
    public Customer (String name){
        this.name = name;
    }
    public void addRental(Rental rental) {
        rentals.addElement(rental);
    }
    public String getName (){
        return name;
    }
    public String statement() {

        Enumeration<Rental> enum_rentals = rentals.elements();
        StringBuilder result = new StringBuilder("Rental Record for " + this.getName() + "\n");
        result.append("\t" + "Title" + "\t" + "\t" + "Days" + "\t" + "Amount" + "\n");

        while (enum_rentals.hasMoreElements()) {
            double thisAmount = 0;
            Rental each = (Rental) enum_rentals.nextElement();
            result.append("\t").append(each.getMovie().getTitle()).append("\t").append("\t").append(each.getDaysRented()).append("\t").append(each.getCharge()).append("\n");
        }

        result.append("Amount owed is ").append(getTotalCharge()).append("\n");
        result.append("You earned ").append(getTotalFrequentRenterPoints()).append(" frequent renter points");
        return result.toString();
    }

    private double getTotalCharge() {
        double charge = 0;
        Enumeration<Rental> rentals = this.rentals.elements();
        while (rentals.hasMoreElements()) {
            Rental rental = (Rental) rentals.nextElement();
            charge += rental.getCharge();
        }
        return charge;
    }

    private int getTotalFrequentRenterPoints() {
        int points = 0;
        Enumeration<Rental> rentals = this.rentals.elements();
        while (rentals.hasMoreElements()) {
            Rental rental = (Rental) rentals.nextElement();
            points += rental.getFrequentRenterPoints();
        }
        return points;
    }



}
    