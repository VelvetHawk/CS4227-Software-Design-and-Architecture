public class Stock {
	
   private String name = "Water";
   private int quantity = 10;
   private String name1 = "Pepsi";
   private int quantity1 = 10;
   private String name2 = "Coca Cola";
   private int quantity2 = 10;
   private String name3 = "7Up";
   private int quantity3 = 10;

   // store each item user selects and it's quantity to the array 2D array or prefer to add them in arraylist
   // than place them to the buy or sell method as per request.
   // currently just testing the actual functionality of the pattern for testing
   // this will be added to the main project.
   // add the name of the item and their quantity into the database table in table "Stock" where takes name and quantity

   public void buy(){
      System.out.println("Stock [ Name: "+name+", Quantity: " + quantity +" ] bought");
      System.out.println("Stock [ Name: "+name1+", Quantity: " + quantity1 +" ] bought");
      System.out.println("Stock [ Name: "+name2+", Quantity: " + quantity2 +" ] bought");
      //System.out.println("Stock [ Name: "+name3+", Quantity: " + quantity3 +" ] bought");
      System.out.printf("Stock [ Name: %s, Quantity: %,d ] bought\n", name3, 100000000);
   }
   public void sell(){
      System.out.println("Stock [ Name: "+name+", Quantity: " + quantity +" ] sold");
   }
}