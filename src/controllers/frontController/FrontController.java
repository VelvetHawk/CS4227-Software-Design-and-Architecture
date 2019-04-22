package controllers.frontController;

import display.views.FrontControllScreens;
import frontController.Dispatcher;

public class FrontController {
	
   private Dispatcher dispatcher;
   private static FrontController instance; // create a static controller instance,

   public FrontController() {
      instance = this;
      dispatcher = new Dispatcher();
   } // no arg constructor


   public static FrontController getInstance() // get instance of the controller
   {
      if (instance == null)
      {
         instance = new FrontController();
         return instance;
      }
      else
         return instance;
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