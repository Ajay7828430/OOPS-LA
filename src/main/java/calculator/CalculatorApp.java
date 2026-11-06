package calculator;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
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

        resultLabel.setStyle(
            "-fx-font-size: 22px; -fx-font-weight: bold;"
        );

        // Button layout
        HBox buttonBox = new HBox(15);
        buttonBox.setAlignment(Pos.CENTER);

        buttonBox.getChildren().addAll(
            addButton,
            subtractButton,
            multiplyButton,
            divideButton
        );

        // Connect buttons to calculator logic
        addButton.setOnAction(e ->
            calculate("+", firstNumber, secondNumber, resultLabel)
        );

        subtractButton.setOnAction(e ->
            calculate("-", firstNumber, secondNumber, resultLabel)
        );

        multiplyButton.setOnAction(e ->
            calculate("*", firstNumber, secondNumber, resultLabel)
        );

        divideButton.setOnAction(e ->
            calculate("/", firstNumber, secondNumber, resultLabel)
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

    // Perform calculation
    private void calculate(
        String operation,
        TextField firstNumber,
        TextField secondNumber,
        Label resultLabel
    ) {

        String input1 = firstNumber.getText();
        String input2 = secondNumber.getText();

        // Validate inputs
        if (!InputValidator.isValidNumber(input1)
                || !InputValidator.isValidNumber(input2)) {

            resultLabel.setText("Invalid input!");
            return;
        }

        double a = Double.parseDouble(input1.trim());
        double b = Double.parseDouble(input2.trim());

        double result;

        try {

            switch (operation) {

                case "+":
                    result = CalculatorLogic.add(a, b);
                    break;

                case "-":
                    result = CalculatorLogic.subtract(a, b);
                    break;

                case "*":
                    result = CalculatorLogic.multiply(a, b);
                    break;

                case "/":
                    result = CalculatorLogic.divide(a, b);
                    break;

                default:
                    resultLabel.setText("Invalid operation!");
                    return;
            }

            resultLabel.setText(String.format("%.2f", result));

        } catch (ArithmeticException e) {

            resultLabel.setText("Cannot divide by zero!");
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}
