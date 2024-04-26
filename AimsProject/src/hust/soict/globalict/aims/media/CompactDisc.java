package hust.soict.globalict.aims.media;
import hust.soict.globalict.aims.media.*;
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
        for (Track track1 : this.tracks) {
            if (track1.equals(track)) {
                System.out.println("Track already exists");
                return;
            }
        }
        this.tracks.add(track);
    }
    public void removeTrack(Track track) {
        for (Track track1 : this.tracks) {
            if (track1.equals(track)) {
                this.tracks.remove(track);
                return;
            }
        }
        System.out.println("Track not found");
    }
    public int getLength() {
        int length = 0;
        for (Track track : this.tracks) {
            length += track.getLength();
        }
        return length;
    }
    public void play() {
        System.out.println("Playing CD: " + this.title);
        System.out.println("CD length: " + this.getLength());
        for (Track track : this.tracks) {
            track.play();
        }
    }

    public String toString() {
        return "CD - " + this.id + " - " + this.title + " - " + this.category + " - " + this.director + " - " + this.getLength() + " - " + this.cost + "$";
    }
}
