package command;

import java.util.ArrayList;
import java.util.List;

public class Broker {
   private List<StockOrder> orderList = new ArrayList<>();

   public void takeOrder(StockOrder order){
      orderList.add(order);
   }

   public void placeOrders(){

      for (StockOrder order : orderList) {
         order.execute();
      }
      orderList.clear();
   }
}