package dhbw.refactor;

import static dhbw.refactor.PriceCode.NEW_RELEASE;

public class Rental {
    private final Movie movie;
    private final int daysRented;
    public Rental(Movie newmovie, int newdaysRented) {
        movie = newmovie;
        daysRented = newdaysRented;
    }
    public int getDaysRented() {
        return daysRented;
    }
    public Movie getMovie() {
        return movie;
    }

    public double getCharge() {
        double result = 0;
        switch (getMovie().getPriceCode()) {
            case REGULAR -> {
                result += 2;
                if (getDaysRented() > 2)
                    result += (getDaysRented() - 2) * 1.5;
            }
            case NEW_RELEASE -> result += getDaysRented() * 3;
            case CHILDREN -> {
                result += 1.5;
                if (getDaysRented() > 3)
                    result += (getDaysRented() - 3) * 1.5;
            }
            default -> System.out.println("Error!");

        }
        return result;
    }

    public int getFrequentRenterPoints() {
        if ((getMovie().getPriceCode() == NEW_RELEASE) && getDaysRented() > 1) {
            return 2;
        }
        return 1;
    }

}