package controllers;

import java.net.URL;
import java.util.ResourceBundle;

import controllers.frontController.FrontController;
import display.views.FrontControllScreens;
import display.views.Screens;
import framework.context.Context;
import framework.context.ScreenSwitchContext;
import framework.states.entry.Idle;
import framework.states.order.MakeOrder;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;

public class MainMenu implements Initializable, ControlledScreen
{
    private ScreensController myController;
    private static MainMenu instance; // create a static controller instance,

    public MainMenu() { instance = this; } // no arg constructor


    public static MainMenu getInstance() // get instance of the controller
    {
        if (instance == null)
        {
            instance = new MainMenu();
            return instance;
        }
        else
            return instance;
    }

    public void show(){
        System.out.println("Main Menu Screen Page");
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb)
    {
        // empty
    }

    public void setScreenParent(ScreensController screenParent)
    {
        myController = screenParent;

    }

    @FXML
    private void goToMainScreen(ActionEvent event)
    {
        myController.setState(Idle.getInstance());
        myController.getState().executeState(new Context("Idle"));
        myController.executeState(new ScreenSwitchContext(
            "Switching to Main Menu Screen",
            Screens.MAIN
        ));
        FrontController.getInstance().dispatchRequest(FrontControllScreens.MAIN);// front controller pattern
    }

    @FXML
    private void goToStockOrderScreen(ActionEvent event)
    {
        myController.setScreen(Screens.STOCK_ORDER);
    }
    @FXML
    private void goToOrderScreen(ActionEvent event)
    {
        myController.setState(MakeOrder.getInstance());
        myController.getState().executeState(new Context("Idle"));
        myController.executeState(new ScreenSwitchContext(
            "Switching to Make Order Screen",
            Screens.MAKE_ORDER
        ));
        FrontController.getInstance().dispatchRequest(FrontControllScreens.MAKE_ORDER);// front controller pattern
    }
}
