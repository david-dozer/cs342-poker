import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.layout.*;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.paint.Paint;
import javafx.stage.Stage;
import javafx.geometry.Pos;
import javafx.event.EventHandler;
import javafx.event.ActionEvent;
import javafx.scene.paint.Color;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.control.Label;


public class PokerMain extends Application {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		launch(args);
	}
	
	//feel free to remove the starter code from this method
	@Override
	public void start(Stage primaryStage) throws Exception {
		// TODO Auto-generated method stub
		
		
		
		
		
		// Create top bar for menu button and status message
		HBox topBar = new HBox();
		topBar.setPadding(new Insets(15, 12, 15, 12));
		topBar.setSpacing(175);
    	Button menuButton = new Button("Menu");
    	menuButton.setMinHeight(40);
		menuButton.setMinWidth(75);
		VBox statusMsgGroup = new VBox();
		statusMsgGroup.setAlignment(Pos.CENTER);
		Label statusLbl = new Label("Status:");
		TextField status = new TextField();
		status.setMinWidth(380);
		statusMsgGroup.getChildren().addAll(statusLbl, status);
		topBar.getChildren().addAll(menuButton, statusMsgGroup);
		


		// Create player controls side pane


		
		
		// Create grid pane to showcase poker table
		GridPane pokerTable = new GridPane();
		Image card1 = new Image("/4/poker-playing-card-4-club-miroslav-nemecek.jpg");
		Image card2 = new Image("/4/poker-playing-card-4-diamond-miroslav-nemecek.jpg");
		Image card3 = new Image("/4/poker-playing-card-4-heart-miroslav-nemecek.jpg");
		Image card4 = new Image("/5/poker-playing-card-5-club-miroslav-nemecek.jpg");
		Image card5 = new Image("/5/poker-playing-card-5-diamond-miroslav-nemecek.jpg");
		Image card6 = new Image("/5/poker-playing-card-5-heart-miroslav-nemecek.jpg");
		Image card7 = new Image("/6/poker-playing-card-6-club-miroslav-nemecek.jpg");
		Image card8 = new Image("/6/poker-playing-card-6-diamond-miroslav-nemecek.jpg");
		Image card9 = new Image("/6/poker-playing-card-6-heart-miroslav-nemecek.jpg");
		ImageView dealerCard1 = new ImageView(card1);
		ImageView dealerCard2 = new ImageView(card2);
		ImageView dealerCard3 = new ImageView(card3);
		ImageView player1Card1 = new ImageView(card4);
		ImageView player1Card2 = new ImageView(card5);
		ImageView player1Card3 = new ImageView(card6);
		ImageView player2Card1 = new ImageView(card7);
		ImageView player2Card2 = new ImageView(card8);
		ImageView player2Card3 = new ImageView(card9);
		pokerTable.setBackground(new Background(new BackgroundFill(Color.web("#008080", 0.5), CornerRadii.EMPTY, Insets.EMPTY)));
		pokerTable.setGridLinesVisible(true);
		pokerTable.setHgap(10);
		pokerTable.setVgap(10);
		pokerTable.add(dealerCard1,2,0);
		pokerTable.add(dealerCard2,3,0);
		pokerTable.add(dealerCard3,4,0);
		pokerTable.add(player1Card1,0,5);
		pokerTable.add(player1Card2,1,5);
		pokerTable.add(player1Card3,2,5);
		pokerTable.add(player2Card1,4,5);
		pokerTable.add(player2Card2,5,5);
		pokerTable.add(player2Card3,6,5);
		
		
		
		//Set event handlers for objects
		menuButton.setOnAction(new EventHandler<ActionEvent>(){
			@Override public void handle(ActionEvent e){
				menuButton.setText("Menu!");
			}
		});	
		
		
		
		// Create bordepane for all GUI elements
		BorderPane gameGUI = new BorderPane();
		gameGUI.setCenter(pokerTable);
		gameGUI.setTop(topBar);
		
		
		int windowWidth = 1000;
		int windowHeight = 600;
		// Add GUI objects to window and display
		Scene scene = new Scene(gameGUI, windowWidth,windowHeight);
		primaryStage.setTitle("3 Card Poker");
		primaryStage.setScene(scene);
		primaryStage.setMinHeight(windowHeight);
		primaryStage.setMinWidth(windowWidth);
		primaryStage.setMaxHeight(windowHeight);
		primaryStage.setMaxWidth(windowWidth);
		primaryStage.show();
	}

}
