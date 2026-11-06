package calculator;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class CalculatorApp extends Application {

    @Override
    public void start(Stage primaryStage) {

        // Heading
        Label heading = new Label("Simple Calculator");
        heading.setStyle("-fx-font-size: 24px; -fx-font-weight: bold;");

        // Input fields
        TextField firstNumber = new TextField();
        firstNumber.setPromptText("Enter first number");

        TextField secondNumber = new TextField();
        secondNumber.setPromptText("Enter second number");

        // Operation buttons
        Button addButton = new Button("+");
        Button subtractButton = new Button("-");
        Button multiplyButton = new Button("*");
        Button divideButton = new Button("/");

        // Result display
        Label resultHeading = new Label("RESULT");

        Label resultLabel = new Label("0.00");
        resultLabel.setStyle("-fx-font-size: 22px; -fx-font-weight: bold;");

        // Button layout
        HBox buttonBox = new HBox(15);
        buttonBox.setAlignment(Pos.CENTER);

        buttonBox.getChildren().addAll(
                addButton,
                subtractButton,
                multiplyButton,
                divideButton
        );

        // Main layout
        VBox root = new VBox(20);

        root.setPadding(new Insets(30));
        root.setAlignment(Pos.CENTER);

        root.getChildren().addAll(
                heading,
                firstNumber,
                secondNumber,
                buttonBox,
                resultHeading,
                resultLabel
        );

        // Scene
        Scene scene = new Scene(root, 400, 400);

        primaryStage.setTitle("Simple Calculator");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}