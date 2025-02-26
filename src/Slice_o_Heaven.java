public class Slice_o_Heaven {
    public String storeAddress;
    @SuppressWarnings("unused")
    private String storemenu;
    public String storeName;
    public String storeEmail;
    public long storePhone;
    private String pizzaIngredients;
    public double pizzaPrice;
    private String sides;
    private String orderID;
    private static double orderTotal;
    private static String drinks;

    public static final String DEF_ORDER_ID = "DEF-SOH-099";
    public static final String DEF_PIZZA_INGREDIENTS = "Mozzarella Cheese";
    public static final double DEF_ORDER_TOTAL = 15.00;

    
    public Slice_o_Heaven() {
        this.orderID = DEF_ORDER_ID;
        this.pizzaIngredients = DEF_PIZZA_INGREDIENTS;
        Slice_o_Heaven.orderTotal = DEF_ORDER_TOTAL;
    }

    public Slice_o_Heaven(String orderID, String pizzaIngredients, double orderTotal) {
        this.orderID = orderID;
        this.pizzaIngredients = pizzaIngredients;
        Slice_o_Heaven.orderTotal = orderTotal;
    }

    // orderID getter setter
    public String getOrderID() {
        return this.orderID;
    }

    public void setOrderID(String orderID) {
        this.orderID = orderID;
    }

    // pizzaIngredients getter setter
    public String getPizzaIngredients() {
        return pizzaIngredients;
    }

    public void setPizzaIngredients(String pizzaIngredients) {
        this.pizzaIngredients = pizzaIngredients;
    }

    // orderTotal getter setter
    public double getOrderTotal() {
        return orderTotal;
    }

    public void setOrderTotal(double orderTotal) {
        Slice_o_Heaven.orderTotal = orderTotal;
    }

    // sides getter setter
    public String getSides() {
        return sides;
    }

    public void setSides(String sides) {
        this.sides = sides;
    }

    // drinks getter setter
    public String getDrinks() {
        return drinks;
    }

    public void setDrinks(String drinks) {
        Slice_o_Heaven.drinks = drinks;
    }

    public void takeOrder(String id, double total) {
        orderID = id;
        orderTotal = total;

        System.out.println("Order accepted!");
        System.out.println("Order is being prepared");

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }

        System.out.println("Order is ready for pickup");
        System.out.println("Your order is ready");
        printReceipt();
    }

    private void printReceipt() {
        System.out.println("********RECEIPT********");
        System.out.println("Order ID: " + orderID);
        String orderDetails = pizzaIngredients + (sides != null ? ", " + sides : "") + (drinks != null ? ", " + drinks : "");
        System.out.println("Order Details: " + orderDetails);
        System.out.println("Order Total: " + orderTotal);
    }

    public static void main(String[] args) {
        Slice_o_Heaven orderSystem = new Slice_o_Heaven("12345", "Pepperoni", 50.0);
        orderSystem.takeOrder("12345", 50.0);
    }
}
        
            
    
       

    
  
        
    















    
