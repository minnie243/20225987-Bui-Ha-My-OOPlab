package hust.soict.globalict.aims.media;
import hust.soict.globalict.aims.media.Media;
import java.util.ArrayList;
import java.util.List;

public class Book extends Media {
    private List<String> authors = new ArrayList<String>();

    public List<String> getAuthors() {
        return authors;
    }

    public Book() {
        super();
    }

    public Book(String title, String category, float cost, List<String> authors) {
        super(title, category, cost);
        this.authors = authors;
    }

    public void addAuthor(String authorName) {
        if (authors.contains(authorName)) {
            System.out.println("Author already exists");
        } else {
            authors.add(authorName);
            System.out.println("Author added");
        }
    }
    public void removeAuthor(String authorName) {
        if (authors.contains(authorName)) {
            authors.remove(authorName);
            System.out.println("Author removed");
        } else {
            System.out.println("Author not found");
        }
    }

    public String toString() {
        return "Book - " + this.id + " - " + this.title + " - " + this.category + " - " + this.cost + "$" + " - " + this.authors.toString();
    }
}
