
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
    public static final long BLACKLISTED_NUMBER = 12345678901234L;

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
        int ingChoice1 = 0, ingChoice2 = 0, ingChoice3 = 0;
        String ing1, ing2, ing3;
        boolean validIngredients = false;
        while (!validIngredients) {
            System.out.println("Please pick any three of the following ingredients:");
            System.out.println("1. Mushroom");
            System.out.println("2. Paprika");
            System.out.println("3. Sun-dried tomatoes");
            System.out.println("4. Chicken");
            System.out.println("5. Pineapple");
            System.out.println("Enter any three choices (1, 2, 3,…) separated by spaces:");
            try {
                ingChoice1 = scanner.nextInt();
                ingChoice2 = scanner.nextInt();
                ingChoice3 = scanner.nextInt();
                scanner.nextLine();
                if (ingChoice1 >= 1 && ingChoice1 <= 5 && ingChoice2 >= 1 && ingChoice2 <= 5 && ingChoice3 >= 1 && ingChoice3 <= 5) {
                    validIngredients = true;
                } else {
                    System.out.println("Invalid choice(s). Please pick only from the given list:");
                }
            } catch (Exception e) {
                System.out.println("Invalid choice(s). Please pick only from the given list:");
                scanner.nextLine();
            }
        }
        switch (ingChoice1) {
            case 1:
                ing1 = "Mushroom";
                break;
            case 2:
                ing1 = "Paprika";
                break;
            case 3:
                ing1 = "Sun-dried tomatoes";
                break;
            case 4:
                ing1 = "Chicken";
                break;
            case 5:
                ing1 = "Pineapple";
                break;
            default:
                ing1 = "";
        }
        switch (ingChoice2) {
            case 1:
                ing2 = "Mushroom";
                break;
            case 2:
                ing2 = "Paprika";
                break;
            case 3:
                ing2 = "Sun-dried tomatoes";
                break;
            case 4:
                ing2 = "Chicken";
                break;
            case 5:
                ing2 = "Pineapple";
                break;
            default:
                ing2 = "";
        }
        switch (ingChoice3) {
            case 1:
                ing3 = "Mushroom";
                break;
            case 2:
                ing3 = "Paprika";
                break;
            case 3:
                ing3 = "Sun-dried tomatoes";
                break;
            case 4:
                ing3 = "Chicken";
                break;
            case 5:
                ing3 = "Pineapple";
                break;
            default:
                ing3 = "";
        }
        pizzaIngredients = ing1 + ", " + ing2 + ", " + ing3;
        int sizeChoice = 0;
        boolean validSize = false;
        while (!validSize) {
            System.out.println("What size should your pizza be?");
            System.out.println("1. Large");
            System.out.println("2. Medium");
            System.out.println("3. Small");
            System.out.println("Enter only one choice (1, 2, or 3):");
            try {
                sizeChoice = scanner.nextInt();
                scanner.nextLine();
                if (sizeChoice >= 1 && sizeChoice <= 3) {
                    validSize = true;
                } else {
                    System.out.println("Invalid choice. Please pick from the given list.");
                }
            } catch (Exception e) {
                System.out.println("Invalid choice. Please pick from the given list.");
                scanner.nextLine();
            }
        }
        switch (sizeChoice) {
            case 1:
                break;
            case 2:
                break;
            case 3:
                break;
            default:
        }
        System.out.println("Do you want extra cheese (Y/N):");
        @SuppressWarnings("unused")
        String extraCheese = scanner.nextLine();
        int sideDishChoice = 0;
        String sideDish;
        boolean validSideDish = false;
        while (!validSideDish) {
            System.out.println("Following are the side dish that go well with your pizza:");
            System.out.println("1. Calzone");
            System.out.println("2. Garlic bread");
            System.out.println("3. Chicken puff");
            System.out.println("4. Muffin");
            System.out.println("5. Nothing for me");
            System.out.println("What would you like? Pick one (1, 2, 3,…):");
            try {
                sideDishChoice = scanner.nextInt();
                scanner.nextLine();
                if (sideDishChoice >= 1 && sideDishChoice <= 5) {
                    validSideDish = true;
                } else {
                    System.out.println("Invalid choice. Please pick from the given list.");
                }
            } catch (Exception e) {
                System.out.println("Invalid choice. Please pick from the given list.");
                scanner.nextLine();
            }
        }
        switch (sideDishChoice) {
            case 1:
                sideDish = "Calzone";
                break;
            case 2:
                sideDish = "Garlic bread";
                break;
            case 3:
                sideDish = "Chicken puff";
                break;
            case 4:
                sideDish = "Muffin";
                break;
            case 5:
                sideDish = "Nothing for me";
                break;
            default:
                sideDish = "";
        }
        sides = sideDish;
        int drinkChoice = 0;
        boolean validDrink = false;
        while (!validDrink) {
            System.out.println("Choose from one of the drinks below. We recommend Coca Cola:");
            System.out.println("1. Coca Cola");
            System.out.println("2. Cold coffee");
            System.out.println("3. Cocoa Drink");
            System.out.println("4. No drinks for me");
            System.out.println("Enter your choice:");
            try {
                drinkChoice = scanner.nextInt();
                scanner.nextLine();
                if (drinkChoice >= 1 && drinkChoice <= 4) {
                    validDrink = true;
                } else {
                    System.out.println("Invalid choice. Please pick from the given list.");
                }
            } catch (Exception e) {
                System.out.println("Invalid choice. Please pick from the given list.");
                scanner.nextLine();
            }
        }
        switch (drinkChoice) {
            case 1:
                drinks = "Coca Cola";
                break;
            case 2:
                drinks = "Cold coffee";
                break;
            case 3:
                drinks = "Cocoa Drink";
                break;
            case 4:
                drinks = "No drinks for me";
                break;
            default:
                drinks = "";
        }
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
        System.out.println(this);
    }

    private boolean isItYourBirthday(Scanner scanner) {
        LocalDate birthdate = null;
        boolean validDate = false;
        while (!validDate) {
            try {
                System.out.println("Enter your birthday (yyyy-MM-dd):");
                String birthdateStr = scanner.nextLine();
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
                birthdate = LocalDate.parse(birthdateStr, formatter);
                LocalDate today = LocalDate.now();
                LocalDate fiveYearsAgo = today.minusYears(5);
                LocalDate oneHundredTwentyYearsAgo = today.minusYears(120);
                if (birthdate.isAfter(fiveYearsAgo) || birthdate.isBefore(oneHundredTwentyYearsAgo)) {
                    System.out.println("Invalid date. You are either too young or too dead to order.");
                    System.out.println("Please enter a valid date:");
                } else {
                    validDate = true;
                }
            } catch (DateTimeParseException e) {
                System.out.println("Invalid date format. Please enter the date in yyyy-MM-dd format.");
            }
        }
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
                boolean validCard = false;
                while (!validCard) {
                    System.out.println("Enter expiry date (MM/YY):");
                    expiryDate = scanner.nextLine();
                    int month = Integer.parseInt(expiryDate.substring(0, 2));
                    int year = Integer.parseInt(expiryDate.substring(3));
                    LocalDate now = LocalDate.now();
                    int currentYear = now.getYear() % 100;
                    int currentMonth = now.getMonthValue();
                    if (year > currentYear || (year == currentYear && month > currentMonth)) {
                        validCard = true;
                    } else {
                        System.out.println("Invalid expiry date. Please enter a future date.");
                    }
                }
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
        boolean validCard = false;
        while (!validCard) {
            if (cardNumberStr.length() == 14 && cardNumber != BLACKLISTED_NUMBER) {
                validCard = true;
            } else {
                System.out.println("Invalid card number. Please enter a 14-digit number that is not blacklisted.");
                try (Scanner scanner = new Scanner(System.in)) {
                    System.out.println("Enter your card number:");
                    cardNumber = scanner.nextLong();
                    scanner.nextLine();
                }
                cardNumberStr = Long.toString(cardNumber);
            }
        }
        System.out.println("Card accepted");
        int firstCardDigit = Integer.parseInt(cardNumberStr.substring(0, 1));
        int lastFourDigits = Integer.parseInt(cardNumberStr.substring(cardNumberStr.length() - 4));
        StringBuilder sb = new StringBuilder(cardNumberStr);
        for (int i = 1; i < cardNumberStr.length() - 4; i++) {
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

    @Override
    public String toString() {
        return "RECEIPT\n" +
                "Order ID: " + orderID + "\n" +
                "Order Total: " + orderTotal;
    }

    public static void main(String[] args) {
        Slice_o_Heaven pizzeria = new Slice_o_Heaven();
        pizzeria.takeOrder();
    }
}
