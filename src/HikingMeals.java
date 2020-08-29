import java.util.ArrayList;
import java.util.HashMap;

public class HikingMeals {

    static {//generate default meals

    }
    public static void main (String[] args) {
        Hike pvd = new Hike("Weekend hike",6);
        System.out.println("Created hike: " + pvd + " duration " + pvd.getDuration() + " days for " + pvd.getQuantity() + " persons" );
        pvd.setDuration(2);
        System.out.println("Changed hike: " + pvd + " on duration " + pvd.getDuration() + " days");
        System.out.println();
        pvd.getHikeDay(0).addMeal(Meal.getMeal("pilaf"));
        System.out.println("Meals on day 1: " + pvd.getHikeDay(0).getMeals());
        pvd.getHikeDay(1).addMeal(Meal.getMeal("porridge"));
        pvd.getHikeDay(1).addMeal(Meal.getMeal("sandwich"));
        System.out.println("meals on day 2: " + pvd.getHikeDay(1).getMeals());
        System.out.println("Energy of meals on day 1: " + pvd.getHikeDay(0).getHikeDayEnergy());
        System.out.println("Energy of meals on day 2: " + pvd.getHikeDay(1).getHikeDayEnergy());
        System.out.println();
        System.out.println("Generated shipping chart for hike");
        System.out.println();
        pvd.generateShippingChart();
        for (HashMap.Entry<Product, Double> pair : pvd.getShippingChart().entrySet()
             ) {
            Product product = pair.getKey();
            double weight = pair.getValue();
            System.out.println("Product: " + product + " " + weight + " grams" );
        }
        System.out.println();
        pvd.setQuantity(8);
        System.out.println("Changed number of participants to " + pvd.getQuantity());
        System.out.println();
        System.out.println("Generated shipping chart for hike");
        System.out.println();
        pvd.generateShippingChart();
        for (HashMap.Entry<Product, Double> pair : pvd.getShippingChart().entrySet()
        ) {
            Product product = pair.getKey();
            double weight = pair.getValue();
            System.out.println("Product: " + product + " " + weight + " grams" );
        }
    }
}
