import java.util.ArrayList;
import java.util.List;

   public class Broker {
   private List<Order> orderList = new ArrayList<Order>();

   public void takeOrder(Order order){
      orderList.add(order);		
   }

   public void placeOrders(){


      //System.out.println("Size of the Order list before loop ===>>> "+ orderList.size());
      int count = 0;
      for (Order order : orderList) {

         System.out.println("Counter " + count);
         order.execute();
         count++;
      }

      //System.out.println("Size of the Order list after loop ===>>> "+ orderList.size());
      orderList.clear();
   }
}