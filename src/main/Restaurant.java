package main;

//import biz.paluch.logging.gelf.jul.GelfLogHandler;
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

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;
import java.util.logging.*;

public class Restaurant extends Application
{
    @Override
    public void start(Stage primaryStage)
    {
//    	/*
//    	    Host: "192.168.56.104",
//			Default Port: 9000
//	        Configured Port: 12201
//    	 */
//	    Logger log = Logger.getLogger("Restaurant");
//	    log.setLevel(Level.ALL);
//	    log.info("initializing - trying to load configuration file ...");
//
//
//	    Properties properties = new Properties();
//	    try
//	    {
//	    	File a = new File("cs4227.properties");
//		    FileInputStream configFile = new FileInputStream("cs4227.properties");
//		    properties.load(configFile);
//		    LogManager.getLogManager().readConfiguration(configFile);
//	    }
//	    catch (Exception e)
//	    {
//		    System.out.println("WARNING: Could not open configuration file");
//		    System.out.println("WARNING: Logging not configured (console output only)");
//	    }
//
//	    log.info("Starting Application");
//	    log.warning("Test warning message");
//
//	    GelfLogHandler logHandler = new GelfLogHandler();
////	    logHandler.setHost("192.168.56.104");
////	    logHandler.setPort(12201);
//
//	    logHandler.setGraylogHost("udp:192.168.56.104");
//	    logHandler.setGraylogPort(12201);
//	    logHandler.setFacility("cs4227-application");
//	    logHandler.publish(new LogRecord(
//            Level.ALL,
//		    "This is a test message"
//	    ));
//
//	    logHandler.close();
//
//	    // TODO: Remove later
//	    System.exit(9001);
//
//
        ScreensController mainContainer = ScreensController.getInstance();

        // Framework
	    Framework framework = Framework.getInstance();

        // Interceptors
	    LoggingInterceptor loggingInterceptor = LoggingInterceptor.getInstance();

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