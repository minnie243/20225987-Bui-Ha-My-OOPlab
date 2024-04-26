package hust.soict.globalict.aims.media;
import hust.soict.globalict.aims.media.comparators.*;
import java.util.Comparator;

public class Media {
    public static final Comparator<Media> COMPARE_BY_TITLE_COST = new MediaComparatorByTitleCost();
    public static final Comparator<Media> COMPARE_BY_COST_TITLE = new MediaComparatorByCostTitle();

    protected String title;
    protected String category;
    protected float cost;
    protected int id;

    private static int nbMedia = 0;
    public Media() {
        nbMedia++;
        this.id = nbMedia;
    }

    public String getTitle() {
        return title;
    }
    public float getCost() {
        return cost;
    }

    public String getCategory() {
        return category;
    }

    public int getId() {
        return id;
    }

    public Media(String title) {
        this.title = title;
        nbMedia++;
        this.id = nbMedia;
    }
    public Media(String title, String category) {
        this.title = title;
        this.category = category;
        nbMedia++;
        this.id = nbMedia;
    }
    public Media(String title, String category, float cost) {
        this.title = title;
        this.category = category;
        this.cost = cost;
        nbMedia++;
        this.id = nbMedia;
    }


    public boolean equals(Object obj) {
        if (obj instanceof Media) {
            Media media = (Media) obj;
            if (this.title.equals(media.title)) {
                return true;
            }
        }
        return false;
    }

}
