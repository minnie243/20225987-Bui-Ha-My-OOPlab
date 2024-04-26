package hust.soict.globalict.aims.media;

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

    public void play() {
        System.out.println("Playing Track: " + this.getTitle());
        System.out.println("Track length: " + this.getLength());
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
