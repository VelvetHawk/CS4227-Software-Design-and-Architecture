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
        
        // Screens
        mainContainer.loadScreen(Screens.MAIN, "/display/views/mainScreen.fxml");
        mainContainer.loadScreen(Screens.LOGIN, "/display/views/login.fxml");
        mainContainer.loadScreen(Screens.REGISTRATION, "/display/views/registration.fxml");
        mainContainer.loadScreen(Screens.MAIN_MENU, "/display/views/mainMenu.fxml");
        mainContainer.loadScreen(Screens.MAKE_ORDER, "/display/views/makeOrder.fxml");
		
        // Pop Up Screens
	    mainContainer.loadPopUpScreen(PopUpScreens.ORDER_TYPE_CHOICE, "/display/components/OrderTypeChoice.fxml");
	    mainContainer.loadPopUpScreen(PopUpScreens.SELECT_DRINK, "/display/views/drinks.fxml");
	    mainContainer.loadPopUpScreen(PopUpScreens.SELECT_FOOD, "/display/views/food.fxml");
        mainContainer.loadPopUpScreen(PopUpScreens.SELECT_TOPPING, "/display/views/toppings.fxml");
        mainContainer.loadPopUpScreen(PopUpScreens.SELECT_SIDE, "/display/views/sides.fxml");
        
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