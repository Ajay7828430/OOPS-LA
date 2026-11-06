
package calculator;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class CalculatorApp extends Application {

    private TextField num1Field;
    private TextField num2Field;
    private Label resultLabel;

    private CalculatorLogic logic = new CalculatorLogic();

    @Override
    public void start(Stage stage) {

        Label title = new Label("Simple Calculator");
        title.setFont(Font.font("Arial", 26));

        Label label1 = new Label("First Number");
        num1Field = new TextField();
        num1Field.setPromptText("Enter first number");

        Label label2 = new Label("Second Number");
        num2Field = new TextField();
        num2Field.setPromptText("Enter second number");

        Button addButton = new Button("Addition (+)");
        Button subButton = new Button("Subtraction (-)");
        Button mulButton = new Button("Multiplication (*)");
        Button divButton = new Button("Division (/)");

        resultLabel = new Label("Result will appear here");
        resultLabel.setFont(Font.font("Arial", 18));

        // Button event handling
        addButton.setOnAction(e -> calculate("+"));
        subButton.setOnAction(e -> calculate("-"));
        mulButton.setOnAction(e -> calculate("*"));
        divButton.setOnAction(e -> calculate("/"));

        GridPane grid = new GridPane();
        grid.setHgap(12);
        grid.setVgap(12);
        grid.setAlignment(Pos.CENTER);

        grid.add(label1, 0, 0);
        grid.add(num1Field, 1, 0);

        grid.add(label2, 0, 1);
        grid.add(num2Field, 1, 1);

        grid.add(addButton, 0, 2);
        grid.add(subButton, 1, 2);
        grid.add(mulButton, 0, 3);
        grid.add(divButton, 1, 3);

        VBox root = new VBox(20);
        root.setPadding(new Insets(30));
        root.setAlignment(Pos.CENTER);

        root.getChildren().addAll(title, grid, resultLabel);

        root.setStyle("-fx-background-color: #F2F4F8;");

        Scene scene = new Scene(root, 480, 400);

        stage.setTitle("Simple Calculator");
        stage.setScene(scene);
        stage.setResizable(false);
        stage.show();
    }

    private void calculate(String operator) {

        String input1 = num1Field.getText().trim();
        String input2 = num2Field.getText().trim();

        // Validate inputs
        if (!InputValidator.isValidNumber(input1)
                || !InputValidator.isValidNumber(input2)) {

            resultLabel.setText("Please enter valid numbers!");
            return;
        }

        double a = Double.parseDouble(input1);
        double b = Double.parseDouble(input2);

        try {
            double result = logic.calculate(a, b, operator);

            resultLabel.setText(
                "Result: " + result
            );

        } catch (IllegalArgumentException ex) {
            resultLabel.setText(ex.getMessage());
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}
