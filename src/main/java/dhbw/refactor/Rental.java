package dhbw.refactor;

import static dhbw.refactor.PriceCode.NEW_RELEASE;

public record Rental(Movie movie, int daysRented) {

    public int getDaysRented() {
        return daysRented;
    }

    public Movie getMovie() {
        return movie;
    }

    public double getCharge() {
        double result = 0;
        switch (movie.getPriceCode()) {
            case REGULAR -> {
                result += 2;
                if (daysRented > 2)
                    result += (daysRented - 2) * 1.5;
            }
            case NEW_RELEASE -> result += daysRented * 3;
            case CHILDREN -> {
                result += 1.5;
                if (daysRented > 3)
                    result += (daysRented - 3) * 1.5;
            }
            default -> System.out.println("Error!");

        }
        return result;
    }

    public int getFrequentRenterPoints() {
        if ((movie.getPriceCode() == NEW_RELEASE) && daysRented > 1) {
            return 2;
        }
        return 1;
    }

}