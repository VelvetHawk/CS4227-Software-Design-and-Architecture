package main;

import adapters.AdapterType;
import controllers.ScreensController;
import display.views.PopUpScreens;
import display.views.Screens;
import framework.Framework;
import framework.context.ScreenSwitchContext;
import framework.interceptors.LoggingInterceptor;
import framework.states.entry.Idle;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Restaurant extends Application
{
    @Override
    public void start(Stage primaryStage)
    {
        ScreensController mainContainer = ScreensController.getInstance();

        // Framework
	    Framework framework = Framework.getInstance();

        // Interceptors
	    LoggingInterceptor loggingInterceptor = LoggingInterceptor.getInstance(AdapterType.GRAYLOG);

	    // Register interceptors
	    framework.registerLoggingInterceptor(loggingInterceptor);

        final String fxmlRootPath = "/resources/fxml/";

        // Screens
        mainContainer.loadScreen(Screens.MAIN, fxmlRootPath + "mainScreen.fxml");
        mainContainer.loadScreen(Screens.LOGIN, fxmlRootPath + "login.fxml");
        mainContainer.loadScreen(Screens.REGISTRATION, fxmlRootPath + "registration.fxml");
        mainContainer.loadScreen(Screens.MAIN_MENU, fxmlRootPath + "mainMenu.fxml");
        mainContainer.loadScreen(Screens.MAKE_ORDER, fxmlRootPath + "makeOrder.fxml");
        mainContainer.loadScreen(Screens.STOCK_ORDER, fxmlRootPath + "stock/stockOrderMain.fxml");

        // Pop Up Screens
        mainContainer.loadPopUpScreen(PopUpScreens.ORDER_TYPE_CHOICE, fxmlRootPath + "OrderTypeChoice.fxml");
        mainContainer.loadPopUpScreen(PopUpScreens.SELECT_DRINK, fxmlRootPath + "drinks.fxml");
        mainContainer.loadPopUpScreen(PopUpScreens.SELECT_FOOD, fxmlRootPath + "food.fxml");
        mainContainer.loadPopUpScreen(PopUpScreens.SELECT_TOPPING, fxmlRootPath + "toppings.fxml");
        mainContainer.loadPopUpScreen(PopUpScreens.SELECT_SIDE, fxmlRootPath + "sides.fxml");
        mainContainer.loadPopUpScreen(PopUpScreens.SELECT_MEAL, fxmlRootPath + "meals.fxml");
        mainContainer.loadPopUpScreen(PopUpScreens.STOCK_ORDER_CHOICE, fxmlRootPath + "stock/stockOrderTypeChoice.fxml");
        mainContainer.loadPopUpScreen(PopUpScreens.STOCK_SIDE, fxmlRootPath + "stock/stockSide.fxml");
        mainContainer.loadPopUpScreen(PopUpScreens.STOCK_FOOD, fxmlRootPath + "stock/stockFood.fxml");
        mainContainer.loadPopUpScreen(PopUpScreens.STOCK_DRINK, fxmlRootPath + "stock/stockDrinks.fxml");
        mainContainer.loadPopUpScreen(PopUpScreens.STOCK_TOPPING, fxmlRootPath + "stock/stockToppings.fxml");
        mainContainer.loadPopUpScreen(PopUpScreens.ITEM_DESCRIPTION, fxmlRootPath + "itemDescription.fxml");

        //mainContainer.setScreen(Screens.MAIN); // set the Main screen at the start
	    mainContainer.setState(Idle.getInstance());
	    mainContainer.getState().executeState(null);
	    // Switch to main view
	    ScreenSwitchContext screenSwitchContext = new ScreenSwitchContext();
	    screenSwitchContext.setScreenType(Screens.MAIN);
	    mainContainer.executeState(screenSwitchContext);

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