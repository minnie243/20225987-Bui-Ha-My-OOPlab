package hust.soict.globalict.aims.media;
import hust.soict.globalict.aims.exception.PlayerException;
import hust.soict.globalict.aims.media.Disc;
import javafx.scene.control.Alert;

public class DigitalVideoDisc extends Disc implements Playable {

    public DigitalVideoDisc(String title, String category, String director, int length, float cost) {
        super(title, category, cost, director);
        this.length = length;
    }

    public boolean isMatch(String title) {
        title = title.toLowerCase();
        String[] words = title.split(" ");
        for (String word : words) {
            if (this.title.toLowerCase().contains(word)) {
                return true;
            }
        }
        return false;
    }

    public void play() throws PlayerException {
        try {
            if(this.length > 0) {
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Play");

                // Header Text: null
                alert.setHeaderText(null);
                alert.setContentText("Playing " + this.getTitle() + "!");

                alert.showAndWait();
            } else {
                throw new PlayerException("ERROR: DVD length is non-positive!");
            }
        } catch (PlayerException e) {
            System.err.println(e.getMessage());
            Alert alert = new Alert(Alert.AlertType.ERROR);

            alert.setTitle("Error");
            alert.setHeaderText(e.getMessage());
            alert.showAndWait();
        }
    }

    public String toString() {
        return "DVD - " + this.id + " - " + this.title + " - " + this.category + " - " + this.director + " - " + this.length + " - " + this.cost + "$";
    }
}