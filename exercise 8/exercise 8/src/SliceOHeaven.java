import java.util.Scanner;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.Period;

enum PizzaSelection {
    PEPPERONI("Pepperoni", "Lots of pepperoni and extra cheese", 18),
    HAWAIIAN("Hawaiian", "Pineapple, ham, and extra cheese", 22),
    VEGGIE("Veggie", "Green pepper, onion, tomatoes, mushroom, and black olives", 25),
    BBQ_CHICKEN("BBQ Chicken", "Chicken in BBQ sauce, bacon, onion, green pepper, cheddar cheese", 35),
    EXTRAVAGANZA("Extravaganza", "Pepperoni, ham, Italian sausage, beef, onions, green pepper, mushrooms, black olives, extra cheese", 45);
    
    private final String pizzaName;
    private final String pizzaToppings;
    private final int price;
    
    PizzaSelection(String pizzaName, String pizzaToppings, int price) {
        this.pizzaName = pizzaName;
        this.pizzaToppings = pizzaToppings;
        this.price = price;
    }
    
    public String getPizzaName() { return pizzaName; }
    public String getPizzaToppings() { return pizzaToppings; }
    public int getPrice() { return price; }
    
    @Override
    public String toString() {
        return pizzaName + " Pizza with " + pizzaToppings + ", for €" + price;
    }
}


enum PizzaToppings {
    HAM("Ham", 2), PEPPERONI("Pepperoni", 2), BEEF("Beef", 2), CHICKEN("Chicken", 2), 
    SAUSAGE("Sausage", 2), PINEAPPLE("Pineapple", 1), ONION("Onion", 0.5), 
    TOMATOES("Tomatoes", 0.4), GREEN_PEPPER("Green Pepper", 0.5), 
    BLACK_OLIVES("Black Olives", 0.5), SPINACH("Spinach", 0.5), 
    CHEDDAR_CHEESE("Cheddar Cheese", 0.8), MOZZARELLA_CHEESE("Mozzarella Cheese", 0.8), 
    FETA_CHEESE("Feta Cheese", 1), PARMESAN_CHEESE("Parmesan Cheese", 1);
    
    private final String topping;
    private final double toppingPrice;
    
    PizzaToppings(String topping, double toppingPrice) {
        this.topping = topping;
        this.toppingPrice = toppingPrice;
    }
    
    public String getTopping() { return topping; }
    public double getToppingPrice() { return toppingPrice; }
    
    @Override
    public String toString() {
        return topping + " (€" + toppingPrice + ")";
    }
}

enum PizzaSize {
    LARGE("Large", 10), MEDIUM("Medium", 5), SMALL("Small", 0);
    
    private final String pizzaSize;
    private final int addToPizzaPrice;
    
    PizzaSize(String pizzaSize, int addToPizzaPrice) {
        this.pizzaSize = pizzaSize;
        this.addToPizzaPrice = addToPizzaPrice;
    }
    
    public String getPizzaSize() { return pizzaSize; }
    public int getAddToPizzaPrice() { return addToPizzaPrice; }
    
    @Override
    public String toString() {
        return pizzaSize + " (€" + addToPizzaPrice + ")";
    }
}

enum SideDish {
    CALZONE("Calzone", 15), CHICKEN_PUFF("Chicken Puff", 20), MUFFIN("Muffin", 12), NOTHING("No side dish", 0);
    
    private final String sideDishName;
    private final int addToPizzaPrice;
    
    SideDish(String sideDishName, int addToPizzaPrice) {
        this.sideDishName = sideDishName;
        this.addToPizzaPrice = addToPizzaPrice;
    }
    
    public String getSideDishName() { return sideDishName; }
    public int getAddToPizzaPrice() { return addToPizzaPrice; }
    
    @Override
    public String toString() {
        return sideDishName + " (€" + addToPizzaPrice + ")";
    }
}

enum Drinks {
    COCA_COLA("Coca Cola", 8), COCOA_DRINK("Cocoa Drink", 10), NOTHING("No drinks", 0);
    
    private final String drinkName;
    private final int addToPizzaPrice;
    
    Drinks(String drinkName, int addToPizzaPrice) {
        this.drinkName = drinkName;
        this.addToPizzaPrice = addToPizzaPrice;
    }
    
    public String getDrinkName() { return drinkName; }
    public int getAddToPizzaPrice() { return addToPizzaPrice; }
    
    @Override
    public String toString() {
        return drinkName + " (€" + addToPizzaPrice + ")";
    }
}

public class SliceOHeaven {
    private static final double PIZZA_BASE_PRICE = 10.0;
    private static String[] pizzasOrdered = new String[10];
    private static String[] pizzaSizesOrdered = new String[10];
    private static String[] sideDishesOrdered = new String[20];
    private static String[] drinksOrdered = new String[20];
    private static double totalOrderPrice = 0;
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean ordering = true;
        
        while (ordering) {
            System.out.println("Welcome to Slice-o-Heaven Pizzeria. Here’s what we serve:");
            int index = 1;
            for (PizzaSelection pizza : PizzaSelection.values()) {
                System.out.println(index + ". " + pizza);
                index++;
            }
            System.out.println(index + ". Custom Pizza with up to 10 toppings");
            System.out.println("Please enter your choice (1 - " + index + "):");
            
            int choice = scanner.nextInt();

            
            System.out.println("Would you like to order more? (Y/N):");
            ordering = scanner.next().equalsIgnoreCase("Y");
        }
        
        System.out.println("ORDER TOTAL: €" + totalOrderPrice);
        scanner.close();
    }
}
