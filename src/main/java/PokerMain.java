import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.TitledPane;
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
		topBar.setSpacing(75);
		Button menuButton = new Button("Menu");
		menuButton.setMinHeight(50);
		menuButton.setMinWidth(95);
		VBox statusMsgGroup = new VBox();
		statusMsgGroup.setAlignment(Pos.CENTER);
		Label statusLbl = new Label("Status:");
		TextField status = new TextField();
		status.setMinWidth(580);
		status.setAlignment(Pos.CENTER);
		statusMsgGroup.getChildren().addAll(statusLbl, status);
		topBar.getChildren().addAll(menuButton, statusMsgGroup);
		


		// Create player controls side pane
		int textFieldWidth = 50;
		
		
		VBox sidePane = new VBox();
		sidePane.setPadding(new Insets(15, 12, 15, 12));
		sidePane.setSpacing(10);
		// Player 1 Controls box
		VBox player1Controls = new VBox();
		player1Controls.setAlignment(Pos.CENTER);
		TextField player1Winnings = new TextField();
		player1Winnings.setMaxWidth(textFieldWidth);
		player1Winnings.setAlignment(Pos.CENTER);
		TextField player1Play = new TextField();
		player1Play.setMaxWidth(textFieldWidth);
		player1Play.setAlignment(Pos.CENTER);
		TextField player1Ante = new TextField();
		player1Ante.setMaxWidth(textFieldWidth);
		player1Ante.setAlignment(Pos.CENTER);
		TextField player1PairPlus = new TextField();
		player1PairPlus.setMaxWidth(textFieldWidth);
		player1PairPlus.setAlignment(Pos.CENTER);
		Label player1WinningsLbl = new Label("Your money:");
		Label player1PlayLbl = new Label("Play:");
		Label player1AnteLbl = new Label("Ante:");
		Label player1PairPlusLbl = new Label("Pair Plus:");
		HBox player1Buttons = new HBox();
		Button player1PlayBtn = new Button("Play");
		Button player1FoldBtn = new Button("Fold");
		player1Buttons.setPadding(new Insets(5, 4, 5, 4));
		player1Buttons.setSpacing(5);
		player1Buttons.getChildren().addAll(player1PlayBtn, player1FoldBtn);
		player1Controls.getChildren().addAll(player1WinningsLbl, player1Winnings, player1PlayLbl, player1Play,
				player1AnteLbl, player1Ante, player1PairPlusLbl,
				player1PairPlus, player1Buttons);
		TitledPane player1ControlBox = new TitledPane();
		player1ControlBox.setText("Player 1");
		player1ControlBox.setContent(player1Controls);


		VBox player2Controls = new VBox();
		player2Controls.setAlignment(Pos.CENTER);
		TextField player2Winnings = new TextField();
		player2Winnings.setMaxWidth(textFieldWidth);
		player2Winnings.setAlignment(Pos.CENTER);
		TextField player2Play = new TextField();
		player2Play.setMaxWidth(textFieldWidth);
		player2Play.setAlignment(Pos.CENTER);
		TextField player2Ante = new TextField();
		player2Ante.setMaxWidth(textFieldWidth);
		player2Ante.setAlignment(Pos.CENTER);
		TextField player2PairPlus = new TextField();
		player2PairPlus.setMaxWidth(textFieldWidth);
		player2PairPlus.setAlignment(Pos.CENTER);
		Label player2WinningsLbl = new Label("Your money:");
		Label player2AnteLbl = new Label("Ante:");
		Label player2PairPlusLbl = new Label("Pair Plus:");
		Label player2PlayLbl = new Label("Play:");
		HBox player2Buttons = new HBox();
		Button player2PlayBtn = new Button("Play");
		Button player2FoldBtn = new Button("Fold");
		player2Buttons.setPadding(new Insets(5, 4, 5, 4));
		player2Buttons.setSpacing(5);
		player2Buttons.getChildren().addAll(player2PlayBtn, player2FoldBtn);
		player2Controls.getChildren().addAll(player2WinningsLbl, player2Winnings, player2PlayLbl, player2Play,
				player2AnteLbl, player2Ante, player2PairPlusLbl,
				player2PairPlus, player2Buttons);
		TitledPane player2ControlBox = new TitledPane();
		player2ControlBox.setText("Player 2");
		player2ControlBox.setContent(player2Controls);

		VBox dealControls = new VBox();
		Button dealBtn = new Button("Deal");
		dealBtn.setMinHeight(40);
		dealBtn.setMinWidth(70);
		dealControls.setAlignment(Pos.CENTER);
		dealControls.getChildren().addAll(dealBtn);

		sidePane.getChildren().addAll(player1ControlBox, player2ControlBox, dealControls);



		
		// Create grid pane to showcase poker table
		GridPane pokerTable = new GridPane();
		pokerTable.setPadding(new Insets(10,10,10,10));
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
		
		
		
		
		// Create bordepane for all poker table gui nodes
		BorderPane gameGUI = new BorderPane();
		gameGUI.setCenter(pokerTable);
		gameGUI.setTop(topBar);
		gameGUI.setRight(sidePane);
		
		
		
		// Options page
		VBox options = new VBox();
		Button exitBtn = new Button("Exit");
		Button freshStartBtn = new Button("Fresh Start");
		Button newLookBtn = new Button("New Look");
		exitBtn.setMinHeight(50);
		exitBtn.setMinWidth(95);
		freshStartBtn.setMinHeight(50);
		freshStartBtn.setMinWidth(95);
		newLookBtn.setMinHeight(50);
		newLookBtn.setMinWidth(95);
		options.setPadding(new Insets(15, 12, 15, 12));
		options.setSpacing(15);
		options.getChildren().addAll(freshStartBtn, newLookBtn, exitBtn);
		HBox topBar2 = new HBox();
		topBar2.setPadding(new Insets(15, 12, 15, 12));
		topBar2.setSpacing(75);
		Button menuButton2 = new Button("Menu");
		menuButton2.setMinHeight(50);
		menuButton2.setMinWidth(95);
		topBar2.getChildren().addAll(menuButton2);
		BorderPane menuGUI = new BorderPane();
		menuGUI.setCenter(options);
		menuGUI.setTop(topBar2);
		
		
		// New Look page
		VBox newLook = new VBox();
		newLook.setPadding(new Insets(15, 12, 15, 12));
		newLook.setSpacing(15);
		//newLook.getChildren().addAll(freshStartBtn, newLookBtn, exitBtn);
		HBox topBar3 = new HBox();
		topBar3.setPadding(new Insets(15, 12, 15, 12));
		topBar3.setSpacing(75);
		Button menuButton3 = new Button("Menu");
		menuButton3.setMinHeight(50);
		menuButton3.setMinWidth(95);
		topBar3.getChildren().addAll(menuButton3);
		BorderPane newLookGUI = new BorderPane();
		newLookGUI.setCenter(newLook);
		newLookGUI.setTop(topBar3);
		
		
		
		
		int windowWidth = 1070;
		int windowHeight = 650;
		// Add GUI objects to window and display
		Scene gameScene = new Scene(gameGUI, windowWidth, windowHeight);
		Scene optionsScene = new Scene(menuGUI, windowWidth, windowHeight);
		Scene newLookScene = new Scene(newLookGUI, windowWidth, windowHeight);
		primaryStage.setTitle("3 Card Poker");
		primaryStage.setScene(optionsScene);
		primaryStage.setResizable(false);
		primaryStage.show();
		
		//Set event handlers for objects
		menuButton.setOnAction(new EventHandler<ActionEvent>(){
			@Override public void handle(ActionEvent e){
				primaryStage.setScene(optionsScene);
			}
		});
		
		menuButton2.setOnAction(new EventHandler<ActionEvent>(){
			@Override public void handle(ActionEvent e){
				primaryStage.setScene(gameScene);
			}
		});
		
		newLookBtn.setOnAction(new EventHandler<ActionEvent>(){
			@Override public void handle(ActionEvent e){
				primaryStage.setScene(newLookScene);
			}
		});
		
		menuButton3.setOnAction(new EventHandler<ActionEvent>(){
			@Override public void handle(ActionEvent e){
				primaryStage.setScene(optionsScene);
			}
		});
		
		
	}

}
