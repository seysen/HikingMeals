import java.util.ArrayList;

public class HikeDay {
    //variables
    private ArrayList<Meal> meals = new ArrayList<>();

    //constructors
    public HikeDay() {

    }

    public HikeDay(ArrayList<Meal> meals) {
        this.meals = meals;
    }

    //methods
    public void addMeal(Meal meal) {
        if (meal!=null) {
            meals.add(meal);
        }
    }

    public void removeMeal(int index) {
        meals.remove(index);
    }

    public void removeMeal(Meal meal) {
        meals.remove(meal);
    }

    public void setMeals(ArrayList<Meal> meals) {
        this.meals = meals;
    }

    public ArrayList<Meal> getMeals() {
        return meals;
    }

    public double getHikeDayEnergy() {
        double energy = 0;
        for (Meal meal : meals) {
            energy += meal.getEnergy();
        }
        return energy;
    }
}
