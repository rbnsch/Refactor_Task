package dhbw.refactor;

import java.lang.*;
import java.util.*;


public class Customer {
    private final String name;
    private final Vector rentals = new Vector();
    public Customer (String newname){
        name = newname;
    };
    public void addRental(Rental arg) {
        rentals.addElement(arg);
    };
    public String getName (){
        return name;
    };
    public String statement() {
        double totalAmount = 0;
        int frequentRenterPoints = 0;
        Enumeration enum_rentals = rentals.elements();
        StringBuilder result = new StringBuilder("Rental Record for " + this.getName() + "\n");
        result.append("\t" + "Title" + "\t" + "\t" + "Days" + "\t" + "Amount" + "\n");

        while (enum_rentals.hasMoreElements()) {
            double thisAmount = 0;
            Rental each = (Rental) enum_rentals.nextElement();
            //determine amounts for each line
            thisAmount = each.getCharge();
            // add frequent renter points
            frequentRenterPoints ++;
            // add bonus for a two day new release rental
            if ((each.getMovie().getPriceCode() == PriceCode.NEW_RELEASE) && each.getDaysRented() > 1)
                frequentRenterPoints ++;
            //show figures for this rental
            result.append("\t").append(each.getMovie().getTitle()).append("\t").append("\t").append(each.getDaysRented()).append("\t").append(String.valueOf(thisAmount)).append("\n");
            totalAmount += thisAmount;
        }
        //add footer lines

        result.append("Amount owed is ").append(String.valueOf(totalAmount)).append("\n");
        result.append("You earned ").append(String.valueOf(frequentRenterPoints)).append(" frequent renter points");
        return result.toString();
    }



}
    