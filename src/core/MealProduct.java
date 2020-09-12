package core;

public class MealProduct {
    private final static String TAG = "core.MealProduct";
    private Product product;//name of the product
    private String productName;
    private double energy;//energy per weight
    private double protein;//protein per weight
    private double fat;//fat per weight
    private double carbohydrate;//carbohydrate per weight
    private double weight;

    public MealProduct(Product product, double weight) {
        this.product = product;
        this.productName = product.getProductName();
        this.weight = weight;
        this.update();
    }

    public Product getProduct() {
        return product;
    }

    public String getProductName() {
        return productName;
    }

    public double getEnergy() {
        return energy;
    }

    public double getProtein() {
        return protein;
    }

    public double getFat() {
        return fat;
    }

    public double getCarbohydrate() {
        return carbohydrate;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public void update() {
        this.energy = product.getEnergy()*weight/100;
        this.protein = product.getProtein()*weight/100;
        this.fat = product.getFat()*weight/100;
        this.carbohydrate = product.getCarbohydrate()*weight/100;
    }

    public void setProduct(Product product) {
        this.product = product;
        productName = product.getProductName();
        update();
    }

    public int getProductID() {
        return this.product.getProductID();
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof MealProduct) {
            return this.getProduct().getProductID() == ((MealProduct) obj).getProduct().getProductID();
        } else {
            return false;
        }
    }

    @Override
    public String toString() {
        return this.productName;
    }
}
