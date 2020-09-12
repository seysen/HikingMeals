package core;

import java.util.ArrayList;

public class Product {
    private static ArrayList<Product> products = new ArrayList<>();

    private int productID;
    private String productName;//name of the product
    private double energy;//energy per 100 grams
    private double protein;//protein per 100 grams
    private double fat;//fat per 100 grams
    private double carbohydrate;//carbohydrate per 100 grams

    static {
        Product pasta = new Product("pasta",350,13,1.5,72);
        Product rice = new Product("rice",374,7.51,1.03,80.89);
        Product buckwheat = new Product("buckwheat",340,10.9,2.7,71.3);
        Product lentils = new Product("lentils",352,24.63,1.06,63.35);
        Product cereals = new Product("cereals",414,3.45,3.45,89.66);
        Product ketchup = new Product("ketchup",93,1.8,1,22.2);
        Product mayonnaise = new Product("mayonnaise",624,3.1,67,2.6);
        Product jam = new Product("jam",226,0,0,56.5);
        Product beef = new Product("beef",232,16.8,18.4,0);
        Product milk = new Product("milk",362,33.2,1,52.6);
        Product onion = new Product("onion",47,1.4,0,10.4);
        Product carrot = new Product("carrot",32,1.3,0.1,6.9);
        Product garlic = new Product("garlic",134,6.5,0.5,29.9);
        Product oil = new Product("oil",899,0,99,0);
        Product cheese = new Product("cheese",330,24,26,0);
        Product chicken = new Product("chicken",110,23.1,1.2,0);
        Product candy = new Product("candy", 377,0,0.1,97.5);
        Product nut = new Product("nut", 653,13,62.6,9.3);
        Product driedFruits = new Product("driedFruits",215,5.2,0.3,51);
        Product bread = new Product("bread",264,7.5,2.9,50.9);
        Product sausage = new Product("sausage",461,24,40.5,0);
    }

    //Methods

    public static ArrayList<Product> getProducts() {
        return products;
    }

    public static void setProducts(ArrayList<Product> products) {
        Product.products = products;
    }

    public static Product getProduct(int id) {
        Product result = null;
        for (Product product: products) {
            if (product.getProductID()==id) {
                result = product;
            }
        }
        return result;
    }

    public static Product getProduct(String name) {
        Product result = null;
        for (Product product: products) {
            if (product.getProductName().equals(name)) {
                result = product;
            }
        }
        return result;
    }

    public static void removeProduct (int id) {
        products.removeIf(product -> product.getProductID() == id);
    }

    public static void removeProduct (String productName) {
        products.removeIf(product -> product.getProductName().equals(productName));
    }

    public static void removeProduct (Product mProduct) {
        products.remove(mProduct);
    }

    public int getProductID() {
        return productID;
    }

    private void setProductID() {
        int maxID=0;
        for (Product product: products
        ) {
            if (product.productID > maxID) maxID = product.productID;
        }
        this.productID = maxID + 1;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public double getEnergy() {
        return energy;
    }

    public void setEnergy(double energy) {
        this.energy = energy;
    }

    public double getProtein() {
        return protein;
    }

    public void setProtein(double protein) {
        this.protein = protein;
    }

    public double getFat() {
        return fat;
    }

    public void setFat(double fat) {
        this.fat = fat;
    }

    public double getCarbohydrate() {
        return carbohydrate;
    }

    public void setCarbohydrate(double carbohydrate) {
        this.carbohydrate = carbohydrate;
    }

    @Override
    public String toString() {
        return this.productName;
    }

    //Constructors

    public Product(String productName) {
        setProductID();
        this.productName = productName;
        this.energy = 0;
        this.protein = 0;
        this.fat = 0;
        this.carbohydrate = 0;
        products.add(this);
    }

    public Product(String productName, double energy) {
        setProductID();
        this.productName = productName;
        this.energy = energy;
        this.protein = 0;
        this.fat = 0;
        this.carbohydrate = 0;
        products.add(this);
    }

    public Product(String productName, double energy, double protein, double fat, double carbohydrate) {
        setProductID();
        this.productName = productName;
        this.energy = energy;
        this.protein = protein;
        this.fat = fat;
        this.carbohydrate = carbohydrate;
        products.add(this);
    }
}
