package hust.soict.globalict.aims.media;

import hust.soict.globalict.aims.exception.PlayerException;
import javafx.scene.control.Alert;

public class Track implements Playable {
    private String title;
    private int length;

    public Track() {
    }

    public Track(String title) {
        this.title = title;
    }

    public Track(String title, int length) {
        this.title = title;
        this.length = length;
    }

    public String getTitle() {
        return this.title;
    }
    public int getLength() {
        return this.length;
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

    public boolean equals(Object obj) {
        if (obj instanceof Track) {
            Track track = (Track) obj;
            if (track.getTitle().equals(this.getTitle()) && track.getLength() == this.getLength()) {
                return true;
            }
        }
        return false;
    }
}