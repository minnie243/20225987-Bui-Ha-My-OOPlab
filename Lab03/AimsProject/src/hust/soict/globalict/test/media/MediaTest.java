package hust.soict.globalict.test.media;
import hust.soict.globalict.aims.media.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;
public class MediaTest {
    public static void main(String[] args) {
        List<Media> mediae = new ArrayList<Media>();

        CompactDisc cd = new CompactDisc("CD title", "CD category", 100.1f, "CD director", "CD artist");
        DigitalVideoDisc dvd = new DigitalVideoDisc("DVD title", "DVD category", "DVD director", 10, 200.1f);
        Book book = new Book("Book title", "Book category", 300.1f, new ArrayList<String>(Arrays.asList("Book author ")));

        mediae.add(cd);
        mediae.add(dvd);
        mediae.add(book);

//        for (Media m : mediae) {
//            System.out.println(m.toString());
//        }
        System.out.println("Sort by cost: ");
        mediae.sort(Media.COMPARE_BY_COST_TITLE);
        for (Media m : mediae) {
            System.out.println(m.toString());
        }
        System.out.println("Sort by title: ");
        mediae.sort(Media.COMPARE_BY_TITLE_COST);
        for (Media m : mediae) {
            System.out.println(m.toString());
        }
    }
}
