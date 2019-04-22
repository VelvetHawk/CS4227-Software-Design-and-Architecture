package controllers.frontController;

import display.views.FrontControllScreens;
import frontController.Dispatcher;

public class FrontController {
	
   private Dispatcher dispatcher;

   public FrontController(){
      dispatcher = new Dispatcher();
   }

   private boolean isAuthenticUser(){
      //System.out.println("User is authenticated successfully.");
      return true;
   }

   private void trackRequest(FrontControllScreens request){
      System.out.println("Page requested: " + request);
   }

   public void dispatchRequest( FrontControllScreens request){
      //log each request
      trackRequest(request);
      
      //authenticate the user
      if(isAuthenticUser()){
         dispatcher.dispatch(request);
      }
   }
}