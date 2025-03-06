
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Scanner;

public class Slice_o_Heaven {
    public String storemenu;
    public String storeName;
    public String storeAddress;
    public String storeEmail;
    public String storePhone;
    public String pizzaIngredients;
    public double pizzaPrice;
    public String sides;
    public String drinks;
    private String orderID;
    private double orderTotal;

    private static final String DEF_ORDER_ID = "DEF-SON-099";
    private static final String DEF_PIZZA_INGREDIENTS = "Mozzarella Cheese";
    private static final double DEF_ORDER_TOTAL = 15.00;

    public Slice_o_Heaven() {
        this.orderID = DEF_ORDER_ID;
        this.orderTotal = DEF_ORDER_TOTAL;
        this.pizzaIngredients = DEF_PIZZA_INGREDIENTS;
        this.sides = "";
        this.drinks = "";
    }

    public Slice_o_Heaven(String orderID, String pizzaIngredients, double orderTotal) {
        this.orderID = orderID;
        this.pizzaIngredients = pizzaIngredients;
        this.orderTotal = orderTotal;
    }

    public String getStoremenu() {
        return storemenu;
    }

    public String getStoreName() {
        return storeName;
    }

    public String getStoreEmail() {
        return storeEmail;
    }

    public String getStorePhone() {
        return storePhone;
    }

    public String getStoreAddress() {
        return storeAddress;
    }

    public String getPizzaIngredients() {
        return pizzaIngredients;
    }

    public double getPizzaPrice() {
        return pizzaPrice;
    }

    public String getSides() {
        return sides;
    }

    public String getDrinks() {
        return drinks;
    }

    public String getOrderID() {
        return orderID;
    }

    public double getOrderTotal() {
        return orderTotal;
    }

    public void setStoremenu(String storemenu) {
        this.storemenu = storemenu;
    }

    public void setStoreName(String storeName) {
        this.storeName = storeName;
    }

    public void setStoreEmail(String storeEmail) {
        this.storeEmail = storeEmail;
    }

    public void setStorePhone(String storePhone) {
        this.storePhone = storePhone;
    }

    public void setStoreAddress(String storeAddress) {
        this.storeAddress = storeAddress;
    }

    public void setPizzaIngredients(String pizzaIngredients) {
        this.pizzaIngredients = pizzaIngredients;
    }

    public void setPizzaPrice(double pizzaPrice) {
        this.pizzaPrice = pizzaPrice;
    }

    public void setSides(String sides) {
        this.sides = sides;
    }

    public void setDrinks(String drinks) {
        this.drinks = drinks;
    }

    public void setOrderID(String orderID) {
        this.orderID = orderID;
    }

    public void setOrderTotal(double orderTotal) {
        this.orderTotal = orderTotal;
    }

    public void takeOrder() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter three ingredients for your pizza (use spaces to separate ingredients):");
        String[] ingredients = scanner.nextLine().split(" ");
        String ing1 = ingredients[0];
        String ing2 = ingredients[1];
        String ing3 = ingredients[2];
        pizzaIngredients = ing1 + ", " + ing2 + ", " + ing3;
        System.out.println("Enter size of pizza (Small, Medium, Large):");
        @SuppressWarnings("unused")
        String pizzaSize = scanner.nextLine();
        System.out.println("Do you want extra cheese (Y/N):");
        @SuppressWarnings("unused")
        String extraCheese = scanner.nextLine();
        System.out.println("Enter one side dish (Calzone, Garlic bread, None):");
        sides = scanner.nextLine();
        System.out.println("Enter drinks (Cold Coffee, Cocoa drink, Coke, None):");
        drinks = scanner.nextLine();
        System.out.println("Would you like the chance to pay only half for your order? (Y/N):");
        String wantDiscount = scanner.nextLine();

        boolean isDiscountApplied = false;
        if (wantDiscount.equals("Y")) {
            isDiscountApplied = isItYourBirthday(scanner);
        }

        makeCardPayment(scanner);

        if (isDiscountApplied) {
            orderTotal = orderTotal / 2;
        }
        printReceipt();
    }

    private boolean isItYourBirthday(Scanner scanner) {
        try {
            System.out.println("Enter your birthday (yyyy-MM-dd):");
            String birthdateStr = scanner.nextLine();
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
            LocalDate birthdate = LocalDate.parse(birthdateStr, formatter);
            LocalDate today = LocalDate.now();

            long years = today.getYear() - birthdate.getYear();
            if (today.getDayOfYear() < birthdate.getDayOfYear()) {
                years--;
            }

            if (years < 18 && today.getDayOfYear() == birthdate.getDayOfYear()) {
                System.out.println("Congratulations! You pay only half the price for your order");
                return true;
            } else {
                System.out.println("Too bad! You do not meet the conditions to get our 50% discount");
                return false;
            }
        } catch (DateTimeParseException e) {
            System.out.println("Invalid date format. Please enter the date in yyyy-MM-dd format.");
            return false;
        }
    }

    private void makeCardPayment(Scanner scanner) {
        long cardNumber = 0;
        String expiryDate = "";
        int cvv = 0;
        boolean validInput = false;

        while (!validInput) {
            try {
                System.out.println("Enter your card number:");
                cardNumber = scanner.nextLong();
                scanner.nextLine();
                System.out.println("Enter expiry date (MM/YY):");
                expiryDate = scanner.nextLine();
                System.out.println("Enter cvv:");
                cvv = scanner.nextInt();
                scanner.nextLine();
                validInput = true;
            } catch (Exception e) {
                System.out.println("Invalid input. Please enter a valid card number and CVV.");
                scanner.nextLine();
            }
        }

        processCardPayment(cardNumber, expiryDate, cvv);
    }

    public void processCardPayment(long cardNumber, String expiryDate, int cvv) {
        String cardNumberStr = Long.toString(cardNumber);
        int cardLength = cardNumberStr.length();

        if (cardLength == 14) {
            System.out.println("Card accepted");
        } else {
            System.out.println("Invalid card");
        }

        int firstCardDigit = Integer.parseInt(cardNumberStr.substring(0, 1));

        long blacklistedNumber = 12345678901234L;
        if (cardNumber == blacklistedNumber) {
            System.out.println("Card is blacklisted. Please use another card");
        }

        int lastFourDigits = Integer.parseInt(cardNumberStr.substring(cardLength - 4));

        StringBuilder sb = new StringBuilder(cardNumberStr);
        for (int i = 1; i < cardLength - 4; i++) {
            sb.setCharAt(i, '*');
        }
        String cardNumberToDisplay = sb.toString();

        System.out.println("First card digit: " + firstCardDigit);
        System.out.println("Last four digits: " + lastFourDigits);
        System.out.println("Card number to display: " + cardNumberToDisplay);
    }

    public void specialOfTheDay(String pizzaOfTheDay, String sideOfTheDay, String specialPrice) {
        StringBuilder specialInfo = new StringBuilder();
        specialInfo.append("Pizza of the day: ").append(pizzaOfTheDay);
        specialInfo.append("\nSide of the day: ").append(sideOfTheDay);
        specialInfo.append("\nSpecial price: ").append(specialPrice);
        System.out.println(specialInfo.toString());
    }

    public void printReceipt() {
        System.out.println("RECEIPT");
        System.out.println("Order ID: " + orderID);
        System.out.println("Order Total: " + orderTotal);
    }

    public static void main(String[] args) {
        Slice_o_Heaven pizzeria = new Slice_o_Heaven();
        pizzeria.takeOrder();
    }
}