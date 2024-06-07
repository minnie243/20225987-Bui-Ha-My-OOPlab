package hust.soict.globalict.javafx;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

public class PainterController {
    private Color color = Color.BLACK;

    @FXML
    private Pane drawingAreaPane;

    @FXML
    void clearButtonPressed(ActionEvent event) {
        drawingAreaPane.getChildren().clear();
    }

    @FXML
    void drawingAreaMouseDragged(MouseEvent event) {
        Circle newCircle = new Circle(event.getX(), event.getY(), 4, color);
        if(event.getX() - 4 < 0 || event.getX() + 4 > 400 || event.getY() - 4 < 0 || event.getY() + 4 > 400)
            return;
        drawingAreaPane.getChildren().add(newCircle);
    }

    @FXML
    void changeColorToWhite() {
        color = Color.WHITE;
    }

    @FXML
    void changeColorToBlack() {
        color = Color.BLACK;
    }

}
