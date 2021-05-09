package dhbw.refactor;

public record Movie(String title, PriceCode priceCode) {

    public PriceCode getPriceCode() {
        return priceCode;
    }

    public String getTitle() {
        return title;
    }
}