package hust.soict.globalict.aims.media;
import hust.soict.globalict.aims.media.*;
import hust.soict.globalict.aims.exception.PlayerException;
import javafx.scene.control.Alert;

import java.util.ArrayList;
import java.util.List;

public class CompactDisc extends Disc implements Playable {
    private String artist;
    private ArrayList<Track> tracks = new ArrayList<Track>();
    public CompactDisc(String title) {
        super();
    }

    public CompactDisc(String title, String category, float cost, String director, String artist) {
        super(title, category, cost, director);
    }

    public String getArtist() {
        return artist;
    }

    public void addTrack(Track track) {
        try {
            for (Track track1 : tracks) {
                if (track1.equals(track)) {
                    throw new Exception("Track already exists");
                }
            }
            this.tracks.add(track);
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }
    public void removeTrack(Track track) {
        try {
            if (tracks.isEmpty()) {
                throw new Exception("Track list is empty");
            }
            else if (tracks.contains(track)) {
                this.tracks.remove(track);
            }
            else {
                throw new Exception("Track not found");
            }
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }
    public int getLength() {
        int length = 0;
        for (Track track : this.tracks) {
            length += track.getLength();
        }
        return length;
    }
    public void play() throws PlayerException {
        try {
            if(this.getLength() > 0) {
                java.util.Iterator iter = tracks.iterator();
                Track nextTrack;
                while (iter.hasNext()) {
                    nextTrack = (Track) iter.next();
                    try {
                        nextTrack.play();
                    } catch (PlayerException e) {
                        throw e;
                    }
                }

            } else {
                throw new PlayerException("ERROR: CD length is non-positive!");
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
        return "CD - " + this.id + " - " + this.title + " - " + this.category + " - " + this.director + " - " + this.getLength() + " - " + this.cost + "$";
    }

}
