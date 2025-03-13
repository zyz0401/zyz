public class PizzaOrderingSystem {
    private static final double Pizza_BASE_PRICE = 10.0;
    private static string[] pizzaOrder = new String[10];
    private static string[] pizzaSizesOrder = new string [10];
    private static string[] sideDisheOrdered = new String[20];
    private static string[] drinksOredered = new String[20];
    private static double totalOrdefPrice = 0;
    private static int pizzaIndex = 0;
    private static int sideDishIndex = 0;
    private static int drinkIndex = 0;

    enum PizzaSelection{
        PEPPERONI("Pepperoni","Lots of pepperoni and extra cheese", 18),
        HAWAIIAN("Hawaiian", "pineapple, ham, and extra cheese", 22),
        VEGGIE("Veggie", "Green pepper, onion, tomatoes, mushroom, and black olives", 25),
        BBQ_CHICKEN("BBQ Chicken", "Chicken in BBQ sauce, bacon, onion, green pepper, and cheddar cheese", 35),
        EXTRAVAGANZA("Extravaganza", "Pepperoni, ham, Italian sausage, beef, onions, green pepper, mushrooms, black olives, and extra cheese", 45);

        private final String pizzaName;
        private final String pizzaToppings;
        private final double price;

        PizzaSelection(String pizzaName, String pizzaToppings, double price) {
            this.pizzaName = pizzaName;
            this.pizzaToppings = pizzaToppings;
            this.price = price;
        }

        public String getPizzaName() {
            return pizzaName;
        }

        public String getPizzaToppings() {
            return pizzaToppings;
        }

        public double getPrice() {
            return price;
        }

        @Override
        public String toString() {
            return pizzaName + " Pizza with " + pizzaToppings + ", for €" + price;
        }
    }

    enum PizzaToppings {
        HAM("Ham", 2),
        PEPPERONI("Pepperoni", 2),
        BEEF("Beef", 2),
        CHICKEN("Chicken", 2),
        SAUSAGE("Sausage", 2),
        PINEAPPLE("Pineapple", 1),
        ONION("Onion", 0.5),
        TOMATOES("Tomatoes", 0.4),
        GREEN_PEPPER("Green Pepper", 0.5),
        BLACK_OLIVES("Black Olives", 0.5),
        SPINACH("Spinach", 0.5),
        CHEDDAR_CHEESE("Cheddar Cheese", 0.8),
        MOZZARELLA_CHEESE("Mozzarella Cheese", 0.8),
        FETA_CHEESE("Feta Cheese", 1),
        PARMESAN_CHEESE("Parmesan Cheese", 1);

        private final String topping;
        private final double toppingPrice;

        PizzaToppings(String topping, double toppingPrice) {
            this.topping = topping;
            this.toppingPrice = toppingPrice;
        }

        public String getTopping() {
            return topping;
        }

        public double getToppingPrice() {
            return toppingPrice;
        }

        @Override
        public String toString() {
            return topping + " (€" + toppingPrice + ")";
        }
    }

    enum PizzaSize {
        LARGE("Large", 10),
        MEDIUM("Medium", 5),
        SMALL("Small", 0);

        private final String pizzaSize;
        private final double addToPizzaPrice;

        PizzaSize(String pizzaSize, double addToPizzaPrice) {
            this.pizzaSize = pizzaSize;
            this.addToPizzaPrice = addToPizzaPrice;
        }

        public String getPizzaSize() {
            return pizzaSize;
        }

        public double getAddToPizzaPrice() {
            return addToPizzaPrice;
        }

        @Override
        public String toString() {
            return pizzaSize + " (€" + addToPizzaPrice + ")";
        }
    }

    enum SideDish {
        CALZONE("Calzone", 15),
        CHICKEN_PUFF("Chicken Puff", 20),
        MUFFIN("Muffin", 12),
        NOTHING("No side dish", 0);

        private final String sideDishName;
        private final double addToPizzaPrice;

        SideDish(String sideDishName, double addToPizzaPrice) {
            this.sideDishName = sideDishName;
            this.addToPizzaPrice = addToPizzaPrice;
        }

        public String getSideDishName() {
            return sideDishName;
        }

        public double getAddToPizzaPrice() {
            return addToPizzaPrice;
        }

        @Override
        public String toString() {
            return sideDishName + " (€" + addToPizzaPrice + ")";
        }
    }

    enum Drinks {
        COCA_COLA("Coca Cola", 8),
        COCOA_DRINK("Cocoa Drink", 10),
        NOTHING("No drinks", 0);

        private final String drinkName;
        private final double addToPizzaPrice;

        Drinks(String drinkName, double addToPizzaPrice) {
            this.drinkName = drinkName;
            this.addToPizzaPrice = addToPizzaPrice;
        }

        public String getDrinkName() {
            return drinkName;
        }

        public double getAddToPizzaPrice() {
            return addToPizzaPrice;
        }

        @Override
        public String toString() {
            return drinkName + " (€" + addToPizzaPrice + ")";
        }
    }

    public static void takeOrder() {
        Scanner scanner = new Scanner(System.in);
        boolean continueOrdering = true;

        while (continueOrdering) {
            System.out.println("Welcome to Slice - o - Heaven Pizzeria. Here’s what we serve:");
            int pizzaOption = 1;
            for (PizzaSelection pizza : PizzaSelection.values()) {
                System.out.println(pizzaOption + ". " + pizza);
                pizzaOption++;
            }
            System.out.println(pizzaOption + ". Custom Pizza with a maximum of 10 toppings that you choose");
            System.out.print("Please enter your choice (1 - " + pizzaOption + "): ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            double pizzaPrice = 0;
            String pizzaDetails = "";

            if (choice >= 1 && choice <= 5) {
                PizzaSelection selectedPizza = PizzaSelection.values()[choice - 1];
                pizzaDetails = selectedPizza.toString();
                pizzaPrice = selectedPizza.getPrice();
            } else if (choice == 6) {
                System.out.println("Available toppings:");
                int toppingOption = 1;
                for (PizzaToppings topping : PizzaToppings.values()) {
                    System.out.println(toppingOption + ". " + topping);
                    toppingOption++;
                }

                System.out.print("Enter up to 10 topping choices separated by commas: ");
                String toppingChoices = scanner.nextLine();
                String[] toppingIndices = toppingChoices.split(",");
                StringBuilder customToppings = new StringBuilder();
                double customPizzaPrice = PIZZA_BASE_PRICE;

                for (String index : toppingIndices) {
                    try {
                        int toppingIndex = Integer.parseInt(index.trim()) - 1;
                        if (toppingIndex >= 0 && toppingIndex < PizzaToppings.values().length) {
                            PizzaToppings selectedTopping = PizzaToppings.values()[toppingIndex];
                            if (customToppings.length() > 0) {
                                customToppings.append(", ");
                            }
                            customToppings.append(selectedTopping.getTopping());
                            customPizzaPrice += selectedTopping.getToppingPrice();
                        }
                    } catch (NumberFormatException e) {
                        System.out.println("Invalid topping choice: " + index);
                    }
                }
                pizzaDetails = "Custom Pizza with " + customToppings + ", for €" + customPizzaPrice;
                pizzaPrice = customPizzaPrice;
            } else {
                System.out.println("Invalid choice. Please try again.");
                continue;
            }

            pizzasOrdered[pizzaIndex++] = pizzaDetails;
            totalOrderPrice += pizzaPrice;

            System.out.println("Available pizza sizes:");
            for (PizzaSize size : PizzaSize.values()) {
                System.out.println(size.ordinal() + 1 + ". " + size);
            }
            System.out.print("Choose a pizza size: ");
            int sizeChoice = scanner.nextInt();
            scanner.nextLine();
            PizzaSize selectedSize = PizzaSize.values()[sizeChoice - 1];
            pizzaSizesOrdered[pizzaIndex - 1] = selectedSize.getPizzaSize();
            totalOrderPrice += selectedSize.getAddToPizzaPrice();

            System.out.println("Available side dishes:");
            for (SideDish sideDish : SideDish.values()) {
                System.out.println(sideDish.ordinal() + 1 + ". " + sideDish);
            }
            System.out.print("Choose a side dish: ");
            int sideDishChoice = scanner.nextInt();
            scanner.nextLine();
            SideDish selectedSideDish = SideDish.values()[sideDishChoice - 1];
            sideDishesOrdered[sideDishIndex++] = selectedSideDish.getSideDishName();
            totalOrderPrice += selectedSideDish.getAddToPizzaPrice();

            System.out.println("Available drinks:");
            for (Drinks drink : Drinks.values()) {
                System.out.println(drink.ordinal() + 1 + ". " + drink);
            }
            System.out.print("Choose a drink: ");
            int drinkChoice = scanner.nextInt();
            scanner.nextLine();
            Drinks selectedDrink = Drinks.values()[drinkChoice - 1];
            drinksOrdered[drinkIndex++] = selectedDrink.getDrinkName();
            totalOrderPrice += selectedDrink.getAddToPizzaPrice();

            System.out.print("Do you want to order more? (yes/no): ");
            String answer = scanner.nextLine();
            continueOrdering = answer.equalsIgnoreCase("yes");
        }
    }

    @Override
    public String toString() {
        StringBuilder orderDetails = new StringBuilder("Thank you for dining with Slice - o - Heaven Pizzeria. Your order details are as follows:\n");
        for (int i = 0; i < pizzaIndex; i++) {
            orderDetails.append(i + 1).append(". ").append(pizzasOrdered[i]).append("\n");
            orderDetails.append(pizzaSizesOrdered[i]).append(": €").append(getPizzaSizePrice(pizzaSizesOrdered[i])).append("\n");
            orderDetails.append(sideDishesOrdered[i]).append(": €").append(getSideDishPrice(sideDishesOrdered[i])).append("\n");
            orderDetails.append(drinksOrdered[i]).append(": €").append(getDrinkPrice(drinksOrdered[i])).append("\n");
        }
        orderDetails.append("ORDER TOTAL: €").append(totalOrderPrice);
        return orderDetails.toString();
    }

    private double getPizzaSizePrice(String size) {
        for (PizzaSize pizzaSize : PizzaSize.values()) {
            if (pizzaSize.getPizzaSize().equals(size)) {
                return pizzaSize.getAddToPizzaPrice();
            }
        }
        return 0;
    }

    private double getSideDishPrice(String sideDish) {
        for (SideDish dish : SideDish.values()) {
            if (dish.getSideDishName().equals(sideDish)) {
                return dish.getAddToPizzaPrice();
            }
        }
        return 0;
    }

    private double getDrinkPrice(String drink) {
        for (Drinks drinkOption : Drinks.values()) {
            if (drinkOption.getDrinkName().equals(drink)) {
                return drinkOption.getAddToPizzaPrice();
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        PizzaOrderingSystem orderingSystem = new PizzaOrderingSystem();
        PizzaOrderingSystem.takeOrder();
        System.out.println(orderingSystem);
    }
}










    








    


