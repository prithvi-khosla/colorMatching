import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.VBox;
import javafx.scene.layout.HBox;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.geometry.Pos;
import java.util.Random;

/**
 * Main class to run the game.
 * @author Prithvi Khosla
 * @version 1.1.0
 */
public class ColorGame extends Application {
    /**
     * Main Method to launch the application.
     * @param args Initial parameters.
     */
    public static void main(String[] args) {
        launch(args);
    }

    /**
     * Array to store names of all the colors.
     */
    private static String[] colorNames = {"Red", "Orange", "Yellow", "Green", "Purple", "Blue"};

    /**
     * Name text.
     */
    private Text text = new Text("Name: ");
    /**
     * Name of the user.
     */
    private Label nameLabel = new Label("None");

    /**
     * Text field for user to enter their name in.
     */
    private TextField textField = new TextField();
    /**
     * Enter button.
     */
    private Button enterBtn = new Button("Enter");

    /**
     * Color option 1.
     */
    private Button option1 = new Button(generateName());
    /**
     * Color option 2.
     */
    private Button option2 = new Button(generateName());
    /**
     * Color option 3.
     */
    private Button option3 = new Button(generateName());
    /**
     * Color option none.
     */
    private Button option4 = new Button("None");

    /**
     * Button 1 color name.
     */
    private static String button1 = generateName();
    /**
     * button 2 color name.
     */
    private static String button2 = generateName();
    /**
     * Button 3 color name.
     */
    private static String button3 = generateName();
    /**
     * Random color name generator.
     * @return Name of the random color.
     */

    /**
     * Store the score of the user.
     */
    private int score = 0;
    /**
     * Score text.
     */
    private Text text1 = new Text("Score: ");
    /**
     * Label to display the score.
     */
    private Label scoreLabel = new Label(String.valueOf(score));

    /**
     * Question non-clickable button.
     */
    private Button question = new Button(generateName());

    /**
     * Status label.
     */
    private Label label = new Label("Choose an answer to begin!");

    /**
     * Reset button.
     */
    private Button reset = new Button("Reset");

    /**
     * Random color name generator.
     * @return Name of the random color.
     */
    public static String generateName() {
        Random rand = new Random();
        int i = rand.nextInt(6);
        return colorNames[i];
    }

    /**
     * Method to reset all color options and question when user answers a round.
     */
    public void resetOptions() {
        button1 = generateName();
        button2 = generateName();
        button3 = generateName();
        option1.setText(generateName());
        option2.setText(generateName());
        option3.setText(generateName());
        question.setText(generateName());
        question.setStyle("-fx-background-color: " + generateName() + "; -fx-font-weight: bold; -fx-text-fill: White");
        String color1 = generateName();
        boolean found1 = false;
        while (!found1) {
            if (color1.equals(button1)) {
                found1 = false;
                color1 = generateName();
            } else {
                found1 = true;
            }
        }
        option1.setStyle("-fx-text-fill: " + color1 + "; -fx-background-color: " + button1 + "; -fx-font-weight: bold");
        String color2 = generateName();
        boolean found2 = false;
        while (!found2) {
            if (color2.equals(button2)) {
                found2 = false;
                color2 = generateName();
            } else {
                found2 = true;
            }
        }
        option2.setStyle("-fx-text-fill: " + color2 + "; -fx-background-color: " + button2 + "; -fx-font-weight: bold");
        String color3 = generateName();
        boolean found3 = false;
        while (!found3) {
            if (color3.equals(button3)) {
                found3 = false;
                color3 = generateName();
            } else {
                found3 = true;
            }
        }
        option3.setStyle("-fx-text-fill: " + color3 + "; -fx-background-color: " + button3 + "; -fx-font-weight: bold");
    }

    private void setGlobalEventHandler(Node root) {
        root.addEventHandler(KeyEvent.KEY_PRESSED, e -> {
            if (e.getCode() == KeyCode.ENTER) {
                enterBtn.fire();
                e.consume();
            }
        });
    }

    /**
     * Start method overriden from application.
     * @param primaryStage The first stage displayed on initialization.
     */
    public void start(Stage primaryStage) {
        Image image = new Image("Background.jpeg");
        BackgroundSize bgSize = new BackgroundSize(340, 340, false, false, true, true);
        BackgroundImage backgroundImage = new BackgroundImage(image, BackgroundRepeat.NO_REPEAT,
                BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT, bgSize);
        Background background = new Background(backgroundImage);

        primaryStage.setTitle("Color Game!");
        Stage secondStage = new Stage();
        secondStage.setTitle("Color Game!");
        Label title = new Label("Welcome to a color game!");
        title.setFont(Font.font("Times New Roman", FontWeight.BOLD, 20));
        title.setTextFill(Color.PURPLE);
        Label info = new Label("Choose the box with the background color same as the name of the color in "
                + "the question box. If there is no box of that color, choose none.");
        info.setFont(Font.font("Times New Roman", 14));
        info.setWrapText(true);
        info.setTextFill(Color.BLUE);
        Label startLabel = new Label("Press start to begin");
        startLabel.setFont(Font.font("Times New Roman", FontPosture.ITALIC, 12));
        startLabel.setTextFill(Color.BLUE);
        Button startBtn = new Button("Start");
        VBox vPane = new VBox(20);
        vPane.getChildren().addAll(title, info, startLabel, startBtn);
        vPane.setBackground(background);
        vPane.setPadding(new Insets(20, 20, 20, 20));
        vPane.setAlignment(Pos.CENTER);
        startBtn.setOnAction(e -> {
            secondStage.show();
        });
        primaryStage.setScene(new Scene(vPane, 340, 340));

        HBox namePane = new HBox();
        namePane.getChildren().addAll(text, nameLabel);
        namePane.setAlignment(Pos.CENTER);

        HBox enterPane = new HBox();
        enterPane.getChildren().addAll(textField, enterBtn);
        enterPane.setAlignment(Pos.CENTER);
        enterBtn.setOnAction(e -> {
            nameLabel.setText(textField.getText());
        });

        HBox answers = new HBox(10);
        option1.setStyle("-fx-background-color: " + button1);
        option2.setStyle("-fx-background-color: " + button2);
        option3.setStyle("-fx-background-color: " + button3);
        answers.getChildren().addAll(option1, option2, option3, option4);

        StackPane qPane = new StackPane();
        question.setStyle("-fx-background-color: " + generateName());
        qPane.getChildren().add(question);

        HBox scorePane = new HBox();
        scorePane.getChildren().addAll(text1, scoreLabel);
        scorePane.setPadding(new Insets(5, 5, 5, 5));
        scorePane.setAlignment(Pos.CENTER);

        HBox statusPane = new HBox();
        statusPane.getChildren().add(label);
        statusPane.setAlignment(Pos.CENTER);

        reset.setOnAction(e -> {
            nameLabel.setText("None");
            scoreLabel.setText("0");
            textField.setText("");
            label.setText("Choose an answer to begin!");
            resetOptions();
        });

        GridPane gridPane = new GridPane();
        gridPane.setPadding(new Insets(20, 20, 20, 20));
        gridPane.setVgap(20);
        gridPane.setAlignment(Pos.CENTER);
        gridPane.setBackground(background);
        gridPane.add(namePane, 2, 1);
        gridPane.add(enterPane, 2, 2);
        gridPane.add(scorePane, 2, 3);
        gridPane.add(qPane, 2, 4);
        gridPane.add(reset, 3, 4);
        gridPane.add(answers, 2, 5);
        gridPane.add(statusPane, 2, 6);

        resetOptions();
        enterBtn.setDefaultButton(true);

        option1.setOnAction(e -> {
            if ((question.getText()).equals(((Button) e.getSource()).getStyle().substring(22))) {
                score++;
                label.setText("Correct!");
                scoreLabel.setText(String.valueOf(score));
            } else {
                label.setText("Incorrect!");
                score = 0;
                scoreLabel.setText(String.valueOf(score));

            }
            resetOptions();
        });
        option2.setOnAction(e -> {
            if ((question.getText()).equals(((Button) e.getSource()).getStyle().substring(22))) {
                score++;
                label.setText("Correct!");
                scoreLabel.setText(String.valueOf(score));
            } else {
                label.setText("Incorrect!");
                score = 0;
                scoreLabel.setText(String.valueOf(score));

            }
            resetOptions();
        });
        option3.setOnAction(e -> {
            if ((question.getText()).equals(((Button) e.getSource()).getStyle().substring(22))) {
                score++;
                label.setText("Correct!");
                scoreLabel.setText(String.valueOf(score));
            } else {
                label.setText("Incorrect!");
                score = 0;
                scoreLabel.setText(String.valueOf(score));

            }
            resetOptions();
        });
        option4.setOnAction(e -> {
            if (!(question.getText()).equals(button1) && !question.getText().equals(button2)
                    && !question.getText().equals(button3)) {
                score++;
                label.setText("Correct!");
                scoreLabel.setText(String.valueOf(score));
            } else {
                label.setText("Incorrect!");
                score = 0;
                scoreLabel.setText(String.valueOf(score));

            }
            resetOptions();
        });

        secondStage.setScene(new Scene(gridPane, 340, 340));
        primaryStage.show();
    }

}
