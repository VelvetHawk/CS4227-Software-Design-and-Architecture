package controllers;

import consumables.Order;
import consumables.decorators.Consumable;
import consumables.decorators.DrinkDecorator;
import consumables.decorators.SideDecorator;
import controllers.frontController.FrontController;
import data.Observer;
import display.views.FrontControllScreens;
import display.views.PopUpScreens;
import display.views.Screens;
import framework.context.Context;
import framework.context.ScreenSwitchContext;
import framework.states.main.Main;
import framework.states.order.MakeOrder;
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
import memento.MakeOrderCaretaker;
import memento.MakeOrderMemento;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class MakeOrderController implements Initializable, ControlledScreen, Observer
{
	@FXML private AnchorPane rootPane;
	@FXML private Label paneTitle;
	@FXML private Button backButton;
	@FXML private Button addItemButton;
	@FXML private Label totalAmountLabel;
	@FXML private ScrollPane scrollPane;
    @FXML private Button undoButton;
    @FXML private Button redoButton;
	private ScreensController myController;
    private int mementoIndexCounter = 0;
    private int mementoTotalCounter = 0;

	private static MakeOrderController instance; // create a static controller instance,

	MakeOrderCaretaker caretaker = new MakeOrderCaretaker();

	public MakeOrderController() { instance = this; } // no arg constructor


	public static MakeOrderController getInstance() // get instance of the controller
	{
		if (instance == null)
		{
			instance = new MakeOrderController();
			return instance;
		}
		else
			return instance;
	}
	public void show(){
		System.out.println("Make Order Screen Page");
	}
	
	@Override
	public void initialize(URL url, ResourceBundle rb)
	{
		scrollPane.setContent(new VBox());
        undoButton.setDisable(true);
        redoButton.setDisable(true);
	}
	
	@Override
	public void setScreenParent(ScreensController screenParent)
	{
		myController = screenParent;
		myController.getCustomerOrder().attach(this);
	}
	
	@FXML
	private void goBackToToMainMenu(ActionEvent event)
	{
		// only if the user is successfully logged in then, it'll take the user to the Main menu
		myController.setState(Main.getInstance());
		myController.getState().executeState(new Context("Idle"));
		myController.executeState(new ScreenSwitchContext(
				"Switching to Main Menu Screen",
				Screens.MAIN_MENU
		));
		FrontController.getInstance().dispatchRequest(FrontControllScreens.MAIN_MENU); // front controller pattern
	}
	
	@FXML
	public void addItemButtonClicked(ActionEvent event)
	{
		myController.setPopUpScreen(PopUpScreens.ORDER_TYPE_CHOICE);
		myController.setState(MakeOrder.getInstance());
		myController.getState().executeState(new Context("Idle"));
		FrontController.getInstance().dispatchRequest(FrontControllScreens.ORDER_TYPE_CHOICE); // front controller pattern
	}
	
	@FXML
	public void getOrderCompleted(ActionEvent event)
	{
		// empty
	}

	public MakeOrderMemento saveToMemento()
	{
        return new MakeOrderMemento(
            (Order) myController.getCustomerOrder().clone()
        );
	}

	public void undoFromMemento(MakeOrderMemento memento)
    {
        myController.setCustomerOrder(memento.getOrder());
        update();
	}

	@FXML
	public void undoButton(ActionEvent event)
	{
		System.out.println("undo");
        if (mementoIndexCounter >= 1)
        {
            mementoIndexCounter--;
            undoFromMemento(caretaker.getMemento(mementoIndexCounter));
            redoButton.setDisable(false);
        }
        else
            undoButton.setDisable(true);
	}

	@FXML
	public void redoButton(ActionEvent event)
	{
		System.out.println("redo");

        if ((mementoTotalCounter - 1) > mementoIndexCounter)
        {
            mementoIndexCounter++;
            redoButton.setDisable(false);
            myController.setCustomerOrder(caretaker.getMemento(mementoIndexCounter).getOrder());
            update();
            undoButton.setDisable(false);
        }
        else
            redoButton.setDisable(true);
	}

	@FXML
	public void saveButton(ActionEvent event)
	{
		caretaker.addMemento(saveToMemento());
        undoButton.setDisable(false);
        redoButton.setDisable(false);
        mementoIndexCounter++;
        mementoTotalCounter++;
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
