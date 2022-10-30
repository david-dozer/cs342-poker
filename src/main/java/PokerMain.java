import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.TitledPane;
import javafx.scene.layout.*;
import javafx.scene.control.*;
import javafx.scene.paint.Paint;
import javafx.stage.Stage;
import javafx.geometry.Pos;
import javafx.event.EventHandler;
import javafx.event.ActionEvent;
import javafx.scene.paint.Color;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.control.Label;
import javafx.application.Platform;
import javafx.scene.text.*;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;


public class PokerMain extends Application {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		launch(args);
	}
	
	//feel free to remove the starter code from this method
	@Override
	public void start(Stage primaryStage) throws Exception {
		// TODO Auto-generated method stub
		
		/***********************************************************************
		*
		*
		* Code below sets up card back. i.e. when cards are hidden
		* /back/poker-playing-card-backside-blue-miroslav-nemecek.jpg
		* /hallenbeck-120x180.jpg
		*
		*
		************************************************************************/
		
		ThreeCardPokerGame game = new ThreeCardPokerGame();
		CardBack cardBack = new CardBack("/back/poker-playing-card-backside-blue-miroslav-nemecek.jpg");
		
		/***********************************************************************
		*
		*
		* Code below sets up GUI
		*
		*
		************************************************************************/
		
		// Create top bar for menu button and status message
		HBox topBar = new HBox();
		topBar.setPadding(new Insets(15, 12, 15, 12));
		topBar.setSpacing(35);
		Button menuButton = new Button("Menu");
		menuButton.setMinHeight(50);
		menuButton.setMinWidth(95);
		VBox statusMsgGroup = new VBox();
		statusMsgGroup.setAlignment(Pos.CENTER);
		Label statusLbl = new Label("Status:");
		TextField status = new TextField();
		status.setAlignment(Pos.CENTER);
		status.setEditable(false);
		status.setMinHeight(35);
		status.setMinWidth(770);
		statusMsgGroup.getChildren().addAll(statusLbl, status);
		topBar.getChildren().addAll(menuButton, statusMsgGroup);
		


		// Create player controls side pane
		VBox sidePane = new VBox();
		sidePane.setPadding(new Insets(15, 12, 15, 12));
		sidePane.setSpacing(10);
		int textFieldWidth = 50;
		// Player 1 Controls box
		VBox player1Controls = new VBox();
		player1Controls.setAlignment(Pos.CENTER);
		TextField player1Winnings = new TextField();
		player1Winnings.setEditable(false);
		player1Winnings.setMaxWidth(textFieldWidth);
		player1Winnings.setAlignment(Pos.CENTER);
		TextField player1Play = new TextField();
		player1Play.setEditable(false);
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
		//Player 2 Controls Box
		VBox player2Controls = new VBox();
		player2Controls.setAlignment(Pos.CENTER);
		TextField player2Winnings = new TextField();
		player2Winnings.setEditable(false);
		player2Winnings.setMaxWidth(textFieldWidth);
		player2Winnings.setAlignment(Pos.CENTER);
		TextField player2Play = new TextField();
		player2Play.setEditable(false);
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
		// Deal Button
		VBox dealControls = new VBox();
		Button dealBtn = new Button("Deal");
		dealBtn.setMinHeight(40);
		dealBtn.setMinWidth(70);
		dealControls.setAlignment(Pos.CENTER);
		dealControls.getChildren().addAll(dealBtn);
		// Add all player controls to sidepane
		sidePane.getChildren().addAll(player1ControlBox, player2ControlBox, dealControls);



		
		// Create grid pane to showcase poker table
		GridPane pokerTable = new GridPane();
		pokerTable.setPadding(new Insets(10,10,10,10));
		Image card1 = new Image(cardBack.getPath());
		ImageView dealerCard1 = new ImageView(card1);
		ImageView dealerCard2 = new ImageView(card1);
		ImageView dealerCard3 = new ImageView(card1);
		ImageView player1Card1 = new ImageView(card1);
		ImageView player1Card2 = new ImageView(card1);
		ImageView player1Card3 = new ImageView(card1);
		ImageView player2Card1 = new ImageView(card1);
		ImageView player2Card2 = new ImageView(card1);
		ImageView player2Card3 = new ImageView(card1);
		HBox dealerLblBox = new HBox();
		Label dealerLbl = new Label("Dealer");
		dealerLbl.setFont(Font.font("Verdana", FontWeight.BOLD, FontPosture.REGULAR, 16));
		dealerLblBox.getChildren().addAll(dealerLbl);
		dealerLblBox.setAlignment(Pos.CENTER);
		HBox player1LblBox = new HBox();
		Label player1Lbl = new Label("Player 1");
		player1Lbl.setFont(Font.font("Verdana", FontWeight.BOLD, FontPosture.REGULAR, 16));
		player1LblBox.getChildren().addAll(player1Lbl);
		player1LblBox.setAlignment(Pos.CENTER);
		HBox player2LblBox = new HBox();
		Label player2Lbl = new Label("Player 2");
		player2Lbl.setFont(Font.font("Verdana", FontWeight.BOLD, FontPosture.REGULAR, 16));
		player2LblBox.getChildren().addAll(player2Lbl);
		player2LblBox.setAlignment(Pos.CENTER);
		pokerTable.setBackground(new Background(
				new BackgroundFill(Color.web("#008080", 0.5), 
				CornerRadii.EMPTY, Insets.EMPTY)));
		pokerTable.setGridLinesVisible(false);
		pokerTable.setHgap(10);
		pokerTable.setVgap(10);
		pokerTable.add(dealerLblBox,3,0);
		pokerTable.add(dealerCard1,2,1);
		pokerTable.add(dealerCard2,3,1);
		pokerTable.add(dealerCard3,4,1);
		pokerTable.add(player1Card1,0,6);
		pokerTable.add(player1Card2,1,6);
		pokerTable.add(player1Card3,2,6);
		pokerTable.add(player2Card1,4,6);
		pokerTable.add(player2Card2,5,6);
		pokerTable.add(player2Card3,6,6);
		pokerTable.add(player1LblBox,1,7);
		pokerTable.add(player2LblBox,5,7);
		
		
		
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
		newLook.setSpacing(50);
		newLook.setAlignment(Pos.CENTER);
		VBox setImageControls = new VBox();
		setImageControls.setAlignment(Pos.CENTER);
		setImageControls.setSpacing(5);
		Label imagePathLbl = new Label("Card Backside Image (120x180 only):");
		TextField imagePath = new TextField("C:/Users/[account]/Pictures/[something].jpg");
		Button setNewImage = new Button("Set card backside!");
		imagePath.setMaxWidth(400);
		setImageControls.getChildren().addAll(imagePathLbl, imagePath, setNewImage);
		// Status message font controls
		VBox setFontControls = new VBox();
		setFontControls.setAlignment(Pos.CENTER);
		setFontControls.setSpacing(5);
		HBox setFontButtonControls = new HBox();
		setFontButtonControls.setAlignment(Pos.CENTER);
		setFontButtonControls.setSpacing(30);
		Label setFontLbl = new Label("Set status message font:");
		ToggleGroup fontGroup = new ToggleGroup();
		RadioButton fontbutton1 = new RadioButton("Normal");
		fontbutton1.setToggleGroup(fontGroup);
		fontbutton1.setSelected(true);
		RadioButton fontbutton2 = new RadioButton("Larger Font");
		fontbutton2.setToggleGroup(fontGroup);
		RadioButton fontbutton3 = new RadioButton("Bold");
		fontbutton3.setToggleGroup(fontGroup);
		setFontButtonControls.getChildren().addAll(fontbutton1, fontbutton2, fontbutton3);
		setFontControls.getChildren().addAll(setFontLbl, setFontButtonControls);
		// Poker table color controls
		VBox setPokerTableColorControls = new VBox();
		setPokerTableColorControls.setAlignment(Pos.CENTER);
		setPokerTableColorControls.setSpacing(5);
		HBox setPokerTableColorButtonControls = new HBox();
		setPokerTableColorButtonControls.setAlignment(Pos.CENTER);
		setPokerTableColorButtonControls.setSpacing(30);
		Label setPokerTableColorLbl = new Label("Set poker table color:");
		ToggleGroup colorGroup = new ToggleGroup();
		RadioButton colorbutton1 = new RadioButton("Green");
		colorbutton1.setToggleGroup(colorGroup);
		colorbutton1.setSelected(true);
		RadioButton colorbutton2 = new RadioButton("Red");
		colorbutton2.setToggleGroup(colorGroup);
		RadioButton colorbutton3 = new RadioButton("Blue");
		colorbutton3.setToggleGroup(colorGroup);
		setPokerTableColorButtonControls.getChildren().addAll(colorbutton1, colorbutton2, colorbutton3);
		setPokerTableColorControls.getChildren().addAll(setPokerTableColorLbl, setPokerTableColorButtonControls);
		// Add all new look controls to page and include menu button to get back to game
		newLook.getChildren().addAll(setImageControls, setFontControls, setPokerTableColorControls);
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
		
		
		
		// Add GUI objects to window and display
		int windowWidth = 1070;
		int windowHeight = 650;
		Scene gameScene = new Scene(gameGUI, windowWidth, windowHeight);
		Scene optionsScene = new Scene(menuGUI, windowWidth, windowHeight);
		Scene newLookScene = new Scene(newLookGUI, windowWidth, windowHeight);
		primaryStage.setTitle("3 Card Poker Game");
		primaryStage.setScene(gameScene);
		primaryStage.setResizable(false);
		primaryStage.show();
		
		
		/***********************************************************************
		*
		*
		* Code below fills in values like text fields
		*
		*
		************************************************************************/
		
		status.setText("Welcome! P1 and P2: Please enter your Ante and Pair Plus bets. Then, press Deal!");
		
		player1Winnings.setText(Integer.toString(game.playerOne.totalWinnings));
		player1Ante.setText(Integer.toString(game.playerOne.anteBet));
		player1PairPlus.setText(Integer.toString(game.playerOne.anteBet));
		player2Winnings.setText(Integer.toString(game.playerTwo.totalWinnings));
		player2Ante.setText(Integer.toString(game.playerTwo.anteBet));
		player2PairPlus.setText(Integer.toString(game.playerTwo.anteBet));
		
		player1PlayBtn.setDisable(true);
		player1FoldBtn.setDisable(true);
		player2PlayBtn.setDisable(true);
		player2FoldBtn.setDisable(true);
		
		/***********************************************************************
		*
		*
		* Code below sets up GUI event handlers
		*
		*
		************************************************************************/
		
		//Set event handlers for objects
		
		dealBtn.setOnAction(new EventHandler<ActionEvent>(){
			@Override public void handle(ActionEvent e){
				try{
					// Try saving wagers into game logic. If input other than numbers, throw an error dialog box
					game.playerOne.anteBet = Integer.parseInt(player1Ante.getText());
					game.playerTwo.anteBet = Integer.parseInt(player2Ante.getText());
					game.playerOne.pairPlusBet = Integer.parseInt(player1PairPlus.getText());
					game.playerTwo.pairPlusBet = Integer.parseInt(player2PairPlus.getText());
					
					if(game.playerOne.anteBet < 5 || game.playerOne.anteBet > 25){
						throw new Exception("Player 1 ante bet exceeds limitations!\nBet must be >= 5 or <= 25!");
					}
					if(game.playerTwo.anteBet < 5 || game.playerTwo.anteBet > 25){
						throw new Exception("Player 2 ante bet exceeds limitations!\nBet must be >= 5 or <= 25!");
					}
					
					if(game.playerOne.pairPlusBet < 5 || game.playerOne.pairPlusBet > 25){
						if(game.playerOne.pairPlusBet != 0){
							throw new Exception("Player 1 pair plus bet exceeds limitations!\nBet must be >= 5 or <= 25!\nBet must be 0 if no Pair Plus");
						}
					}
					if(game.playerTwo.pairPlusBet < 5 || game.playerTwo.pairPlusBet > 25){
						if(game.playerTwo.pairPlusBet != 0){
							throw new Exception("Player 1 pair plus bet exceeds limitations!\nBet must be >= 5 or <= 25!\nBet must be 0 if no Pair Plus");
						}
					}
					
					player1PlayBtn.setDisable(false);
					player1FoldBtn.setDisable(false);
					player2PlayBtn.setDisable(true);
					player2FoldBtn.setDisable(true);
					
					player1Ante.setDisable(true);
					player1PairPlus.setDisable(true);
					player2Ante.setDisable(true);
					player2PairPlus.setDisable(true);
					
					status.setText("P1, please play or fold!");
					dealBtn.setDisable(true);
					
					// TODO game logic goes here
					
					game.playerOneGetCards();
					game.playerTwoGetCards();
				
					player1Card1.setImage(new Image(game.playerOne.hand.get(0).url));
					player1Card2.setImage(new Image(game.playerOne.hand.get(1).url));
					player1Card3.setImage(new Image(game.playerOne.hand.get(2).url));
					player2Card1.setImage(new Image(game.playerTwo.hand.get(0).url));
					player2Card2.setImage(new Image(game.playerTwo.hand.get(1).url));
					player2Card3.setImage(new Image(game.playerTwo.hand.get(2).url));
				}
				catch(Exception f){
					String errMsg;
					if(f.getMessage().substring(0,3).equals("For")){
						errMsg = "P1 or P2: all bets must be numeric!";
					}
					else{
						errMsg = f.getMessage();
					}
					Alert alert = new Alert(AlertType.NONE, errMsg, ButtonType.OK);
					alert.showAndWait();
				}
			}
		});
		
		player1PlayBtn.setOnAction(new EventHandler<ActionEvent>(){
			@Override public void handle(ActionEvent e){
				status.setText("P1 played. P2, please play or fold! Dealer will now show its cards after!");
				player1PlayBtn.setDisable(true);
				player1FoldBtn.setDisable(true);
				player2PlayBtn.setDisable(false);
				player2FoldBtn.setDisable(false);
				
				game.playerOne.playCurrentRound = true;

				game.playerOneSetPlayWager();
				player1Play.setText(Integer.toString(game.playerOne.playBet));
			}
		});
		
		player1FoldBtn.setOnAction(new EventHandler<ActionEvent>(){
			@Override public void handle(ActionEvent e){
				status.setText("P1 folded. P2, please play or fold! Dealer will now show its cards after!");
				player1PlayBtn.setDisable(true);
				player1FoldBtn.setDisable(true);
				player2PlayBtn.setDisable(false);
				player2FoldBtn.setDisable(false);
				
				game.playerOne.playCurrentRound = false;
				//If they fold, they lose their ante wager and pair plus wager(if they made one).
				if(game.playerOne.playCurrentRound == false) {
					game.playerOneFolds();
					player1Winnings.setText(Integer.toString(game.playerOne.totalWinnings));
				}
			}
		});
		
		player2PlayBtn.setOnAction(new EventHandler<ActionEvent>(){
			@Override public void handle(ActionEvent e){
				player1PlayBtn.setDisable(true);
				player1FoldBtn.setDisable(true);
				player2PlayBtn.setDisable(true);
				player2FoldBtn.setDisable(true);
				dealBtn.setDisable(false);
				
				game.playerTwo.playCurrentRound = true;
				
				game.dealerGetCards();
				
				dealerCard1.setImage(new Image(game.theDealer.dealersHand.get(0).url));
				dealerCard2.setImage(new Image(game.theDealer.dealersHand.get(1).url));
				dealerCard3.setImage(new Image(game.theDealer.dealersHand.get(2).url));
				
				// TODO dealer performs payouts
				

				// If the player continues, they will make a play wager (already done)
				// (this must be equal to the amount of the ante wager).
				if(game.playerOne.playCurrentRound == true){
					// At this point, the dealer will show their cards. If the dealer does not have at least a
					// Queen high or better, the play wager is returned to the players who did not fold and
					// the ante bet is pushed to the next hand.
					int outcome = ThreeCardLogic.compareHands(game.theDealer.dealersHand, game.playerOne.hand);
					if(outcome == 0){
						status.setText("No one wins or dealer does not have queen or higher.");
					}
					else if(outcome == 1){
						status.setText("P1 loses to Dealer!");
						
					}
					else if (outcome == 2){
						status.setText("P1 wins over Dealer!");

					}
				}
			}
		});
		
		player2FoldBtn.setOnAction(new EventHandler<ActionEvent>(){
			@Override public void handle(ActionEvent e){
				status.setText("P2 folded. Dealer will now show its cards!");
				player1PlayBtn.setDisable(true);
				player1FoldBtn.setDisable(true);
				player2PlayBtn.setDisable(true);
				player2FoldBtn.setDisable(true);
				
				game.playerTwo.playCurrentRound = false;
				//If they fold, they lose their ante wager and pair plus wager(if they made one).
				if(game.playerOne.playCurrentRound == false) {
					game.playerTwoFolds();
					player2Winnings.setText(Integer.toString(game.playerTwo.totalWinnings));
				}
				
				game.dealerGetCards();
				dealerCard1.setImage(new Image(game.theDealer.dealersHand.get(0).url));
				dealerCard2.setImage(new Image(game.theDealer.dealersHand.get(1).url));
				dealerCard3.setImage(new Image(game.theDealer.dealersHand.get(2).url));
				
				// TODO dealer performs payouts
			}
		});
		
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
				primaryStage.setScene(gameScene);
			}
		});
		
		exitBtn.setOnAction(new EventHandler<ActionEvent>(){
			@Override public void handle(ActionEvent e){
				System.exit(0);
			}
		});
		
		colorbutton1.setOnAction(new EventHandler<ActionEvent>(){
			@Override public void handle(ActionEvent e){
				pokerTable.setBackground(new Background(
					new BackgroundFill(Color.web("#008080", 0.5), 
					CornerRadii.EMPTY, Insets.EMPTY)));
			}
		});
		
		colorbutton2.setOnAction(new EventHandler<ActionEvent>(){
			@Override public void handle(ActionEvent e){
				pokerTable.setBackground(new Background(
					new BackgroundFill(Color.web("#b03060", 0.5), 
					CornerRadii.EMPTY, Insets.EMPTY)));
			}
		});
		
		colorbutton3.setOnAction(new EventHandler<ActionEvent>(){
			@Override public void handle(ActionEvent e){
				pokerTable.setBackground(new Background(
					new BackgroundFill(Color.web("#6050dc", 0.5), 
					CornerRadii.EMPTY, Insets.EMPTY)));
			}
		});
		
		fontbutton1.setOnAction(new EventHandler<ActionEvent>(){
			@Override public void handle(ActionEvent e){
				status.setFont(Font.font("Verdana", FontWeight.NORMAL, FontPosture.REGULAR, 13));
			}
		});
		
		fontbutton2.setOnAction(new EventHandler<ActionEvent>(){
			@Override public void handle(ActionEvent e){
				status.setFont(Font.font("Helvetica", FontWeight.NORMAL, FontPosture.REGULAR, 20));
			}
		});
		
		fontbutton3.setOnAction(new EventHandler<ActionEvent>(){
			@Override public void handle(ActionEvent e){
				status.setFont(Font.font("Comic Sans MS", FontWeight.BOLD, FontPosture.REGULAR, 12));
			}
		});

		freshStartBtn.setOnAction(new EventHandler<ActionEvent>(){
			@Override public void handle(ActionEvent e){
				game.reset();
				player1Winnings.setText(Integer.toString(game.playerOne.totalWinnings));
				player1Ante.setText(Integer.toString(game.playerOne.anteBet));
				player1PairPlus.setText(Integer.toString(game.playerOne.anteBet));
				player1Play.setText("");
				player2Winnings.setText(Integer.toString(game.playerTwo.totalWinnings));
				player2Ante.setText(Integer.toString(game.playerTwo.anteBet));
				player2PairPlus.setText(Integer.toString(game.playerTwo.anteBet));
				player2Play.setText("");
			}
		});
		
		setNewImage.setOnAction(new EventHandler<ActionEvent>(){
			@Override public void handle(ActionEvent e){
				try{
					cardBack.setPath(imagePath.getText());
					Image newBackside = new Image(cardBack.getPath());
					dealerCard1.setImage(newBackside);
					dealerCard2.setImage(newBackside);
					dealerCard3.setImage(newBackside);
					player1Card1.setImage(newBackside);
					player1Card2.setImage(newBackside);
					player1Card3.setImage(newBackside);
					player2Card1.setImage(newBackside);
					player2Card2.setImage(newBackside);
					player2Card3.setImage(newBackside);
				}catch(Exception f){
					Alert alert = new Alert(AlertType.NONE,
						"Image Path Not Valid!", ButtonType.OK);
					alert.showAndWait();
				}
			}
		});
	}
}
