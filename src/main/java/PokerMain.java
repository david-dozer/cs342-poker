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


public class PokerMain extends Application {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		launch(args);
	}

	//feel free to remove the starter code from this method
	@Override
	public void start(Stage primaryStage) throws Exception {
		// TODO Auto-generated method stub
		primaryStage.setTitle("3 Card Poker");
		
		// Create objects in GUI
		BorderPane borderPane = new BorderPane();
		Button button1 = new Button("Menu");
		Button button2 = new Button("button 2");
		TextField textfield1 = new TextField();
		TextField textfield2 = new TextField();
		
		//Modify GUI objects before window launches
		textfield1.setPromptText("enter text here then press button 1");
		textfield2.setEditable(false);
		borderPane.setTop(button1);
		borderPane.setLeft(button2);
		//borderPane.setCenter(textfield1);
		borderPane.setRight(textfield2);

		//Custom attributes to make GUI look better
		button1.setMinHeight(250);
		button1.setMinWidth(100);
		button2.setMinHeight(250);
		button2.setMinWidth(100);
		textfield2.setMinWidth(300);
		VBox vbox = new VBox(textfield1);
		borderPane.setCenter(vbox);
		borderPane.setBackground(new Background(new BackgroundFill(Color.web("#008080", 0.5), CornerRadii.EMPTY, Insets.EMPTY)));

		
		//Set event handlers for objects
		button1.setOnAction(new EventHandler<ActionEvent>(){
			@Override public void handle(ActionEvent e){
				String s = textfield1.getText();
				s = s + ": from the center text field!";
				textfield2.setText(s);
				button1.setDisable(true);
				button1.setText("pressed");
			}
		});
		
		button2.setOnAction(event -> {textfield1.setText("");
				textfield2.setText("final string goes here");
				button1.setDisable(false);
				button1.setText("button one");});
		
		
		
		// Add GUI objects to window and display
		Scene scene = new Scene(borderPane, 700,500);
		primaryStage.setScene(scene);
		primaryStage.show();
	}

}
