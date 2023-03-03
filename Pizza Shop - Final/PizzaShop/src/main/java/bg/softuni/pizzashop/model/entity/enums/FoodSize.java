package bg.softuni.pizzashop.model.entity.enums;

public enum FoodSize {
    SMALL(500),MEDIUM(750),BIG(1000),FAMILY(2000);

    public final int grams;

    private FoodSize(int grams) {
        this.grams = grams;
    }
}
