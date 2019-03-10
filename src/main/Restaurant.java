package main;

import controllers.ScreensController;
import display.views.PopUpScreens;
import display.views.Screens;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Restaurant extends Application
{
    @Override
    public void start(Stage primaryStage)
    {
        ScreensController mainContainer = new ScreensController();
    
        final String fxmlRootPath = "../../resources/fxml/";
        
        // Screens
        mainContainer.loadScreen(Screens.MAIN, fxmlRootPath + "mainScreen.fxml");
        mainContainer.loadScreen(Screens.LOGIN, fxmlRootPath + "login.fxml");
        mainContainer.loadScreen(Screens.REGISTRATION, fxmlRootPath + "registration.fxml");
        mainContainer.loadScreen(Screens.MAIN_MENU, fxmlRootPath + "mainMenu.fxml");
        mainContainer.loadScreen(Screens.MAKE_ORDER, fxmlRootPath + "makeOrder.fxml");
		
        // Pop Up Screens
	    mainContainer.loadPopUpScreen(PopUpScreens.ORDER_TYPE_CHOICE, fxmlRootPath + "OrderTypeChoice.fxml");
	    mainContainer.loadPopUpScreen(PopUpScreens.SELECT_DRINK, fxmlRootPath + "drinks.fxml");
	    mainContainer.loadPopUpScreen(PopUpScreens.SELECT_FOOD, fxmlRootPath + "food.fxml");
        mainContainer.loadPopUpScreen(PopUpScreens.SELECT_TOPPING, fxmlRootPath + "toppings.fxml");
        mainContainer.loadPopUpScreen(PopUpScreens.SELECT_SIDE, fxmlRootPath + "sides.fxml");
        
        mainContainer.setScreen(Screens.MAIN); // set the main screen at the start
        // grouping the scene to root.
        Group root = new Group();
        root.getChildren().addAll(mainContainer);
        Scene scene = new Scene(root);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args)
    {
        launch(args);
    }
}