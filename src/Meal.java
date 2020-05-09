import java.util.HashMap;

public class Meal {
    private static HashMap<String,Meal> meals = new HashMap<String, Meal>();
    private HashMap<Product, Double> mealProducts = new HashMap<Product, Double>();
    private String mealName;
    private double energy;
    private double protein;
    private double fat;
    private double carbohydrate;

    static {
        Meal pilaf = new Meal("Плов");
        pilaf.addMealProduct("Рис",100);
        pilaf.addMealProduct("Лук",30);
        pilaf.addMealProduct("Морковь",30);
        pilaf.addMealProduct("Масло",10);
        pilaf.addMealProduct("Чеснок",2.5);
        pilaf.addMealProduct("Майонез",10);
        pilaf.addMealProduct("Кетчуп", 10);
        Meal porridge = new Meal("Каша");
        porridge.addMealProduct("Овсянка",70);
        porridge.addMealProduct("Молоко", 25);
        porridge.addMealProduct("Джем",10);
        Meal sandwich = new Meal("Бутерброд");
        sandwich.addMealProduct("Хлеб",50);
        sandwich.addMealProduct("Колбаса",80);
    }

    //Methods

    public static HashMap<String, Meal> getMeals() {
        return meals;
    }

    public static void setMeals(HashMap<String, Meal> meals) {
        Meal.meals = meals;
    }

    public HashMap<Product, Double> getMealProducts() {
        return mealProducts;
    }

    public static Meal getMeal(String mealName) {
        return meals.get(mealName);
    }

    public void setMealProducts(HashMap<Product, Double> mealProducts) {
        this.mealProducts = mealProducts;
    }

    public String getMealName() {
        return mealName;
    }

    public void setMealName(String mealName) {
        this.mealName = mealName;
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

    public void addMealProduct (Product mealProduct, double weight) {
        mealProducts.put(mealProduct,weight);
        this.updateEnergy();
    }

    public void addMealProduct (String productName, double weight) {
        mealProducts.put(Product.getProduct(productName),weight);
        this.updateEnergy();
    }

    public void removeMealProduct (Product product) {
        mealProducts.remove(product);
        this.updateEnergy();
    }

    private void updateEnergy() {
        this.energy = 0;
        this.protein = 0;
        this.fat = 0;
        this.carbohydrate = 0;
        for (HashMap.Entry<Product, Double> pair : this.mealProducts.entrySet()) {
            Product product = pair.getKey();
            double weight = pair.getValue();
            this.energy += product.getEnergy() * weight / 100;
            this.protein += product.getProtein() * weight / 100;
            this.fat += product.getFat() * weight / 100;
            this.carbohydrate += product.getCarbohydrate() * weight / 100;
        }
    }

    @Override
    public String toString() {
        return this.mealName;
    }

    //Constructors

    public Meal(String mealName) {
        this.mealName = mealName;
        this.energy = 0;
        this.protein = 0;
        this.fat = 0;
        this.carbohydrate = 0;
        meals.put(mealName, this);
    }

    public Meal(String mealName, double energy) {
        this.mealName = mealName;
        this.energy = energy;
        this.protein = 0;
        this.fat = 0;
        this.carbohydrate = 0;
        meals.put(mealName, this);
    }

    public Meal(String mealName, double energy, double protein, double fat, double carbohydrate) {
        this.mealName = mealName;
        this.energy = energy;
        this.protein = protein;
        this.fat = fat;
        this.carbohydrate = carbohydrate;
        meals.put(mealName, this);
    }

    public Meal(String mealName, HashMap<Product, Double> mealProducts) {
        this.mealName = mealName;
        this.mealProducts = mealProducts;
        this.updateEnergy();
        meals.put(mealName,this);
    }
}
