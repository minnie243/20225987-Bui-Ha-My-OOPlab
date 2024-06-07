package hust.soict.globalict.aims.media;
import hust.soict.globalict.aims.media.Media;
import java.util.ArrayList;
import java.util.List;

public class Book extends Media{
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
        try {
            if (authors.size() < 5) {
                for (String author : authors) {
                    if (author.equals(authorName)) {
                        throw new Exception("Author already exists");
                    }
                }
                authors.add(authorName);
                System.out.println("Author added");
            } else {
                throw new Exception("Authors has reached its limit");
            }
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }
    public void removeAuthor(String authorName) {
        try {
            if (authors.isEmpty()) {
                throw new Exception("Authors list is empty");
            }
            else if (authors.contains(authorName)) {
                authors.remove(authorName);
                System.out.println("Author removed");
            }
            else {
                throw new Exception("Author not found");
            }
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }

    }

    public String toString() {
        return "Book - " + this.id + " - " + this.title + " - " + this.category + " - " + this.cost + "$" + " - " + this.authors.toString();
    }

}