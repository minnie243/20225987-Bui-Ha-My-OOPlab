package hust.soict.globalict.aims.cart;

import hust.soict.globalict.aims.media.Media;
import hust.soict.globalict.aims.media.DigitalVideoDisc;
import java.util.ArrayList;
import java.util.List;
import java.util.Comparator;
import java.util.Collections;


public class Cart {
    public static final int MAX_NUMBERS_ORDERED = 20;
    private ArrayList<Media> itemsOrdered = new ArrayList<Media>();

    public void addMedia(Media media) {
        if (itemsOrdered.size() < MAX_NUMBERS_ORDERED) {
            for (Media media1 : itemsOrdered) {
                if (media1.equals(media)) {
                    System.out.println("The disc is already in the cart");
                    return;
                }
            }
            itemsOrdered.add(media);
            System.out.println("The disc has been added");
        } else {
            System.out.println("The cart is almost full");
        }
    }

    public void removeMedia(Media media) {
        for (Media media1 : itemsOrdered) {
            if (media1.equals(media)) {
                itemsOrdered.remove(media);
                System.out.println("The disc has been removed");
                return;
            }
        }
        System.out.println("The disc is not in the cart");
    }

    public double totalCost() {
        double total = 0;
        for (Media media : itemsOrdered) {
            total += media.getCost();
        }
        return total;
    }

    public void print() {
        if(itemsOrdered.isEmpty()){
            System.out.println("There are no items in the cart.");
        }
        else {
            System.out.println("***********************CART***********************");
            System.out.println("Ordered items: ");
            for (Media media : itemsOrdered) {
                System.out.println(media.getId() + ". " + media.getTitle() + " - " + media.getCategory() + " - " + media.getCost());
            }
            System.out.println("Total cost: " + totalCost());
            System.out.println("***************************************************");
        }
    }

    public Media searchByID(int id) {
        for (Media media : itemsOrdered) {
            if (media.getId() == id) {
                media.toString();
                return media;
            }
        }
        System.out.println("Not found");
        return null;
    }

    public Media searchByTitle(String title) {
        for (Media media : itemsOrdered) {
            if (media.getTitle().equals(title)) {
                media.toString();
                return media;
            }
        }
        System.out.println("Not found");
        return null;
    }

    public void sort(Comparator<Media> comparator) {
        itemsOrdered.sort(comparator);
    }

    public void clear() {
        itemsOrdered.clear();
    }
}
