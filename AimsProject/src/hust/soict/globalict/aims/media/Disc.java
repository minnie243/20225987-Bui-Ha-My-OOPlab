package hust.soict.globalict.aims.media;

public abstract class Disc extends Media{
    protected int length;
    protected String director;

    public Disc() {
        super();
    }

    public Disc(String title, String category, float cost, String director) {
        super(title, category, cost);
        this.director = director;
    }
}
