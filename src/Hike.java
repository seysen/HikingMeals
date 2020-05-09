import java.util.ArrayList;
import java.util.HashMap;

public class Hike {
    //variables
    private static HashMap<String, Hike> hikes = new HashMap<String, Hike>();
    private String hikeName;
    private int quantity;
    private ArrayList<HikeDay> hikeDays = new ArrayList<HikeDay>();
    private HashMap<Product,Double> shippingChart = new HashMap<Product,Double>();
    //methods

    public int getDuration() {
        return hikeDays.size();
    }
    public int getQuantity() {
        return quantity;
    }
    public void setDuration (int duration) {
        if (hikeDays.size()>duration) {
            while (hikeDays.size()!=duration) {
                hikeDays.remove(duration);
            }
        } else if (hikeDays.size()<duration) {
            while (hikeDays.size()!=duration) {
                hikeDays.add(new HikeDay());
            }
        }
    }
    public void setQuantity (int quantity) {
        this.quantity = quantity;
    }

    public static HashMap<String, Hike> getHikes() {
        return hikes;
    }

    public static void setHikes(HashMap<String, Hike> hikes) {
        Hike.hikes = hikes;
    }

    public String getHikeName() {
        return hikeName;
    }

    public void setHikeName(String hikeName) {
        this.hikeName = hikeName;
    }

    public ArrayList<HikeDay> getHikeDays() {
        return hikeDays;
    }

    public HikeDay getHikeDay(int index) {
        return hikeDays.get(index);
    }

    public void setHikeDays(ArrayList<HikeDay> hikeDays) {
        this.hikeDays = hikeDays;
    }

    public void addDay(HikeDay hikeDay) {
        hikeDays.add(hikeDay);
    }
    public void addDay(int index, HikeDay hikeDay) {
        hikeDays.add(index,hikeDay);
    }
    public void removeDay() {
        hikeDays.remove(hikeDays.size()-1);
    }
    public void removeDay(int index) {
        hikeDays.remove(index-1);
    }
    public HashMap<Product,Double> getShippingChart() {
        return shippingChart;
    }
    public void generateShippingChart() {
        HashMap<Product,Double> chart = new HashMap<Product, Double>();
        for (HikeDay hikeDay:hikeDays
        ) {
            for (Meal meal:hikeDay.getMeals()
            ) {
                for (HashMap.Entry<Product, Double> pair : meal.getMealProducts().entrySet()
                ) {
                    Product product = pair.getKey();
                    double weight = pair.getValue();
                    if (chart.keySet().contains(product)) {
                        chart.put(product,chart.get(product)+weight*Hike.this.getQuantity());
                    } else {
                        chart.put(product,weight*Hike.this.getQuantity());
                    }
                }
            }
        }
        shippingChart = chart;
    }
    @Override
    public String toString() {
        return this.hikeName;
    }

    //constructors

    public Hike(String hikeName) {
        this.hikeName = hikeName;
        this.quantity = 0;
        hikes.put(hikeName,this);
        hikeDays.add(new HikeDay());
    }

    public Hike(String hikeName, int quantity) {
        this.hikeName = hikeName;
        this.quantity = quantity;
        hikes.put(hikeName,this);
        hikeDays.add(new HikeDay());
    }

    public Hike(String hikeName, int quantity, int duration) {
        this.hikeName = hikeName;
        this.quantity = quantity;
        hikes.put(hikeName,this);
        hikeDays.add(new HikeDay());
    }

    public Hike(String hikeName, int quantity, ArrayList<HikeDay> hikeDays) {
        this.hikeName = hikeName;
        this.quantity = quantity;
        this.hikeDays = hikeDays;
        hikes.put(hikeName,this);
    }

    public class HikeDay {
        //variables
        private ArrayList<Meal> meals = new ArrayList<Meal>();
        //methods
        public void addMeal (Meal meal) {
            meals.add(meal);
        }
        public void removeMeal (int index) {
            meals.remove(index);
        }

        public void setMeals(ArrayList<Meal> meals) {
            this.meals = meals;
        }

        public ArrayList<Meal> getMeals () {
            return meals;
        }

        public double getHikeDayEnergy () {
            double energy = 0;
            for (Meal meal: meals) {
                energy += meal.getEnergy();
            }
            return energy;
        }

        //constructors

        public HikeDay() {

        }

        public HikeDay(ArrayList<Meal> meals) {
            this.meals = meals;
        }
    }

    /*public class ShippingChart {
        private static ShippingChart chart;


        public ShippingChart getShippingChart() {
            if (chart == null)
                chart = new ShippingChart(generateShippingChart());
            return chart;
        }

        public HashMap<Product,Double> generateShippingChart() {
            HashMap<Product,Double> chart = new HashMap<Product, Double>();
            for (HikeDay hikeDay:hikeDays
            ) {
                for (Meal meal:hikeDay.getMeals()
                ) {
                    for (HashMap.Entry<Product, Double> pair : meal.getMealProducts().entrySet()
                    ) {
                        Product product = pair.getKey();
                        double weight = pair.getValue();
                        if (chart.keySet().contains(product)) {
                            chart.put(product,chart.get(product)+weight*Hike.this.getQuantity());
                        } else {
                            chart.put(product,weight*Hike.this.getQuantity());
                        }
                    }
                }
            }
            return chart;
        }

        private ShippingChart(HashMap<Product, Double> shippingChart) {
            this.shippingChart = shippingChart;
        }
    }*/
}
