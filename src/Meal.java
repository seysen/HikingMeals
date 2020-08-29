import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

public class Meal {
    private static ArrayList<Meal> meals = new ArrayList<>();

    private ArrayList<MealProduct> mealProducts = new ArrayList<>();
    private String mealName;
    private double energy;
    private double protein;
    private double fat;
    private double carbohydrate;
    private double weight;

    static {
        Meal pilaf = new Meal("pilaf");
        pilaf.addMealProduct(new MealProduct(Product.getProduct("rice"),100));
        pilaf.addMealProduct(new MealProduct(Product.getProduct("onion"),30));
        pilaf.addMealProduct(new MealProduct(Product.getProduct("carrot"),30));
        pilaf.addMealProduct(new MealProduct(Product.getProduct("oil"),10));
        pilaf.addMealProduct(new MealProduct(Product.getProduct("garlic"),2.5));
        pilaf.addMealProduct(new MealProduct(Product.getProduct("mayonnaise"),10));
        pilaf.addMealProduct(new MealProduct(Product.getProduct("ketchup"), 10));
        meals.add(pilaf);
        Meal porridge = new Meal("porridge");
        porridge.addMealProduct(new MealProduct(Product.getProduct("cereals"),70));
        porridge.addMealProduct(new MealProduct(Product.getProduct("milk"), 25));
        porridge.addMealProduct(new MealProduct(Product.getProduct("jam"),10));
        meals.add(porridge);
        Meal sandwich = new Meal("sandwich");
        sandwich.addMealProduct(new MealProduct(Product.getProduct("bread"),50));
        sandwich.addMealProduct(new MealProduct(Product.getProduct("sausage"),80));
        meals.add(sandwich);
    }

    //Methods

    public static ArrayList<Meal> getMeals() {
        return meals;
    }

    public static void setMeals(ArrayList<Meal> meals) {
        Meal.meals = meals;
    }

    public ArrayList<MealProduct> getMealProducts() {
        return mealProducts;
    }

    public static Meal getMeal(String mealName) {
        Meal result = null;
        for (Meal meal: meals) {
            if (meal.getMealName().equals(mealName)){
                result=meal;
            }
        }
        return result;
    }

    public static void removeProduct(Product product) {
        for (Meal meal: meals
        ) {
            Iterator<MealProduct> iterator = meal.getMealProducts().iterator();
            while (iterator.hasNext()) {
                MealProduct mealProduct = iterator.next();
                if (mealProduct.getProduct().equals(product)) {
                    iterator.remove();
                    meal.update();
                }
            }
        }
    }

    public void setMealProducts(ArrayList<MealProduct> mealProducts) {
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

    public void updateMealProducts() {
        for (MealProduct mealProduct: mealProducts) {
            Product product = Product.getProduct(mealProduct.getProductID());
            mealProduct.setProduct(product);
        }
        update();
    }

    public void addMealProduct(@NotNull MealProduct product) {
        if (product.getProduct()!=null) {
            this.mealProducts.add(product);
            this.update();
        }
    }

    public void removeMealProduct (MealProduct product) {
        mealProducts.remove(product);
        this.update();
    }

    private void update() {
        this.energy = 0;
        this.protein = 0;
        this.fat = 0;
        this.carbohydrate = 0;
        this.weight = 0;
        for (MealProduct product: mealProducts) {
            this.energy += product.getEnergy();
            this.protein += product.getProtein();
            this.fat += product.getFat();
            this.carbohydrate += product.getCarbohydrate();
            this.weight += product.getWeight();
        }
    }

    @Override
    public String toString() {
        return this.mealName;
    }

    //Constructors

    public Meal(String mealName, ArrayList<MealProduct> mealProducts) {
        this.mealName = mealName;
        this.mealProducts = mealProducts;
        this.update();
    }

    public Meal(String mealName) {
        this(mealName,new ArrayList<MealProduct>());
    }
}
