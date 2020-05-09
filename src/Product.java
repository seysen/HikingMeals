import java.util.HashMap;

public class Product {
    private static HashMap<String ,Product> products = new HashMap<String, Product>();
    private String productName;//name of the product
    private double energy;//energy per 100 grams
    private double protein;//protein per 100 grams
    private double fat;//fat per 100 grams
    private double carbohydrate;//carbohydrate per 100 grams

    static {
        Product pasta = new Product("Макароны",350,13,1.5,72);
        Product rice = new Product("Рис",374,7.51,1.03,80.89);
        Product buckwheat = new Product("Гречка",340,10.9,2.7,71.3);
        Product lentils = new Product("Чечевица",352,24.63,1.06,63.35);
        Product cereals = new Product("Овсянка",414,3.45,3.45,89.66);
        Product ketchup = new Product("Кетчуп",93,1.8,1,22.2);
        Product mayonnaise = new Product("Майонез",624,3.1,67,2.6);
        Product jam = new Product("Джем",226,0,0,56.5);
        Product beef = new Product("Тушенка",232,16.8,18.4,0);
        Product milk = new Product("Молоко",362,33.2,1,52.6);
        Product onion = new Product("Лук",47,1.4,0,10.4);
        Product carrot = new Product("Морковь",32,1.3,0.1,6.9);
        Product garlic = new Product("Чеснок",134,6.5,0.5,29.9);
        Product oil = new Product("Масло",899,0,99,0);
        Product cheese = new Product("Сыр",330,24,26,0);
        Product chicken = new Product("Курица",110,23.1,1.2,0);
        Product candy = new Product("Конфета", 535);
        Product nut = new Product("Орех", 607);
        Product driedFruits = new Product("Сухофрукты",250);
        Product bread = new Product("Хлеб",264,7.5,2.9,50.9);
        Product sausage = new Product("Колбаса",461,24,40.5,0);
    }

    //Methods

    public static HashMap<String, Product> getProducts() {
        return products;
    }

    public static void setProducts(HashMap<String, Product> products) {
        Product.products = products;
    }

    public static Product getProduct (String productName) {
        return products.get(productName);
    }

    public static void putProduct (String productName, Product product) {
        products.put(productName, product);
    }

    public static void removeProduct (String productName) {
        products.remove(productName);
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
        this.productName = productName;
        this.energy = 0;
        this.protein = 0;
        this.fat = 0;
        this.carbohydrate = 0;
        products.put(productName,this);
    }

    public Product(String productName, double energy) {
        this.productName = productName;
        this.energy = energy;
        this.protein = 0;
        this.fat = 0;
        this.carbohydrate = 0;
        products.put(productName,this);
    }

    public Product(String productName, double energy, double protein, double fat, double carbohydrate) {
        this.productName = productName;
        this.energy = energy;
        this.protein = protein;
        this.fat = fat;
        this.carbohydrate = carbohydrate;
        products.put(productName,this);
    }
}
