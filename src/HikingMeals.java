import java.util.ArrayList;
import java.util.HashMap;

public class HikingMeals {

    static {//generate default meals

    }
    public static void main (String[] args) {
        Hike pvd = new Hike("ПВД",6);
        System.out.println("Создан поход; " + pvd + " длительностью " + pvd.getDuration() + " дней на " + pvd.getQuantity() + " человек" );
        pvd.setDuration(2);
        System.out.println("Изменен поход; " + pvd + " на длительность " + pvd.getDuration() + " дней");
        pvd.getHikeDay(0).addMeal(Meal.getMeal("Плов"));
        System.out.println("Блюда на день 1: " + pvd.getHikeDay(0).getMeals());
        pvd.getHikeDay(1).addMeal(Meal.getMeal("Каша"));
        pvd.getHikeDay(1).addMeal(Meal.getMeal("Бутерброд"));
        System.out.println("Блюда на день 2: " + pvd.getHikeDay(1).getMeals());
        System.out.println("Калорийность питания на день 1: " + pvd.getHikeDay(0).getHikeDayEnergy());
        System.out.println("Калорийность питания на день 2: " + pvd.getHikeDay(1).getHikeDayEnergy());
        System.out.println();
        System.out.println("Создаем список закупок на поход");
        System.out.println();
        pvd.generateShippingChart();
        for (HashMap.Entry<Product, Double> pair : pvd.getShippingChart().entrySet()
             ) {
            Product product = pair.getKey();
            double weight = pair.getValue();
            System.out.println("Продукт: " + product + " " + weight + "грамм" );
        }
        System.out.println();
        System.out.println("Изменяем количество человек на 8");
        pvd.setQuantity(8);
        System.out.println();
        System.out.println("Создаем список закупок на поход");
        System.out.println();
        pvd.generateShippingChart();
        for (HashMap.Entry<Product, Double> pair : pvd.getShippingChart().entrySet()
        ) {
            Product product = pair.getKey();
            double weight = pair.getValue();
            System.out.println("Продукт: " + product + " " + weight + "грамм" );
        }
    }
}
