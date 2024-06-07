package hust.soict.globalict.aims.store;
import hust.soict.globalict.aims.media.*;
import java.util.ArrayList;


public class Store {
    public static final int MAX_NUMBERS_QUANTITY_OF_STORE = 1000;
    public ArrayList<Media> itemsInStore = new ArrayList<Media>();

    public void addMedia(Media media) {
        try {
            if (itemsInStore.size() < MAX_NUMBERS_QUANTITY_OF_STORE) {
                itemsInStore.add(media);
                return;
            }
            else {
                throw new Exception("The store is almost full");
            }
        } catch (Exception e) {
            System.err.println(e.getMessage());
        };
    }

    public void removeMedia(Media media) {
        try {
            if (itemsInStore.isEmpty()) {
                throw new Exception("The store is empty");
            }
            else if (itemsInStore.contains(media)) {
                itemsInStore.remove(media);
                return;
            }
            else {
                throw new Exception("The media is not in the store");
            }
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }

    }

    public Media searchByTitle(String title) {
        for (Media media : itemsInStore) {
            if (media.getTitle().equals(title)) {
                return media;
            }
        }
        return null;
    }

    public void printStore() {
        System.out.println("Store's content: ");
        for (int i = 0; i < itemsInStore.size(); i++) {
            System.out.println(i+1 + ". " + itemsInStore.get(i).getTitle() + " - " + itemsInStore.get(i).getCategory() + " - " + itemsInStore.get(i).getCost());
        }
    }

    public ArrayList<Media> getItemsInStore() {
        return itemsInStore;
    }
}