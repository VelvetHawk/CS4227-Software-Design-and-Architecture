package controllers;

import consumables.Order;
import consumables.decorators.Consumable;
import consumables.decorators.DrinkDecorator;
import consumables.decorators.FoodDecorator;
import consumables.decorators.SideDecorator;
import data.Observer;
import display.views.PopUpScreens;
import display.views.Screens;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.AnchorPane;
import javafx.event.ActionEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class MakeStockOrderController implements Initializable, ControlledScreen, Observer
{
    @FXML
    private AnchorPane rootPane;
    @FXML private Label paneTitle;
    @FXML private Button backButton;
    @FXML private Button addItemButton;
    @FXML private Label totalAmountLabel;
    @FXML private ScrollPane scrollPane;
    private ScreensController myController;

    private static MakeStockOrderController instance; // create a static controller instance,

    public MakeStockOrderController() { instance = this; } // no arg constructor


    public static MakeStockOrderController getInstance() // get instance of the controller
    {
        if (instance == null)
        {
            instance = new MakeStockOrderController();
            return instance;
        }
        else
            return instance;
    }

    @Override
    public void initialize( URL url, ResourceBundle rb)
    {
        scrollPane.setContent(new VBox());
    }

    @Override
    public void setScreenParent(ScreensController screenParent)
    {
        myController = screenParent;
        myController.getCustomerOrder().attach(this);
    }

    @FXML
    private void goBackToToMainMenu( ActionEvent event)
    {
        // only if the user is successfully logged in then, it'll take the user to the main menu
        myController.setScreen(Screens.MAIN_MENU);
    }

    @FXML
    public void addItemButtonClicked(ActionEvent event)
    {
        myController.setPopUpScreen(PopUpScreens.ORDER_TYPE_CHOICE);
    }

    @FXML
    public void getOrderCompleted(ActionEvent event)
    {

    }

    @FXML
    public void undoButton(ActionEvent event)
    {
        System.out.println("undo");
    }

    @FXML
    public void redoButton(ActionEvent event)
    {
        System.out.println("redo");
    }

    @Override
    public void update()
    {
        // Update item rows
        Order customerOrder = myController.getCustomerOrder();
        VBox itemView = (VBox) scrollPane.getContent();
        itemView.getChildren().clear(); // Remove previous nodes

        addItemsToList(customerOrder, itemView, customerOrder.getFood()); // Add food
        addItemsToList(customerOrder, itemView, customerOrder.getSides()); // Add sides
        addItemsToList(customerOrder, itemView, customerOrder.getDrinks());// Add drinks

        // Update total label
        totalAmountLabel.setText(String.format("%.2f", myController.getCustomerOrder().getTotalCost()));
    }

    private void addItemsToList(Order customerOrder, VBox itemView, ArrayList<? extends Consumable> consumableList)
    {
        consumableList.forEach(consumable ->
        {
            HBox row = new HBox();
            row.setPadding(new Insets(0, 0, 5, 0));
            row.setSpacing(20);
            // Add button to remove row
            Button removeItem = new Button("-");
            removeItem.setOnAction(event ->
            {
                // Remove consumable from the list it is in
                if (consumable instanceof SideDecorator)        customerOrder.removeSide(consumable);
                else if (consumable instanceof DrinkDecorator)  customerOrder.removeDrink(consumable);
                else                                            customerOrder.removeFood(consumable);
            });

            // Add to row
            row.getChildren().addAll(
                    new Label(consumable.getName()),
                    new Label(String.format("€ %.2f", consumable.getCost())),
                    removeItem
            );
            itemView.getChildren().add(row);
        });
    }
}
