public static class Slice_o_Heaven {

    public void takeOrder(String string, double d) {
        
        throw new UnsupportedOperationException("Unimplemented method 'takeOrder'");
    }}
   public String storeAddress;

   @SuppressWarnings("unused")
private String storemenu;

   public String storeName;
   public String storeEmail;
   public long storePhone;
   public String pizzaIngredients;
   public double pizzaPrice;
   public String sides;
   public String drinks;
   

   private String orderID;
   private double orderTotal;

   public void takeOrder(String id,double total) {
    orderID = id;
    orderTotal = total;

    System.out.println("Order accepted!");

    System.out.println("Order is being prepared");

    try{
        Thread.sleep(5000);
    } catch (InterruptedException e){
        System.out.println("Order is ready for pickup");
    }

    System.out.println("Your order is ready");

    printReceipt();




}

        private void printReceipt(){
            System.out.println("********RECEIPT********");

            System.out.println("Order ID: " + orderID);
            String orderDetails = "0";
                        System.out.println("Order Details:" + orderDetails);
            System.out.println("Order Total: " + orderTotal);




        }

        public static void main(String[]args) {
            Slice_o_Heaven orderSystem = new Slice_o_Heaven();
            orderSystem.takeOrder("12345", 50.0);
        }
        
        
            
    
       

    
  
        
    















    
