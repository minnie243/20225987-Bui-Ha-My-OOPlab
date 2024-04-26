package hust.soict.globalict.aims;
import hust.soict.globalict.aims.cart.Cart;
import hust.soict.globalict.aims.media.*;
import hust.soict.globalict.aims.store.*;
import java.util.Scanner;
public class Aims {
    private static Cart cart = new Cart();
    private static Store store = new Store();
    private static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {
        showMenu();
    }

    public static void showMenu() {
        int option;
        do {
            System.out.println("AIMS: ");
            System.out.println("--------------------------------");
            System.out.println("1. View store");
            System.out.println("2. Update store");
            System.out.println("3. See current cart");
            System.out.println("0. Exit");
            System.out.println("--------------------------------");
            System.out.println("Please choose a number: 0-1-2-3");
            option = sc.nextInt();
            switch (option) {
                case 1:
                    store.printStore();
                    storeMenu();
                    break;
                case 2:
                    updateStore();
                    break;
                case 3:
                    seeCurrentCart();
                    break;
                case 0:
                    System.out.println("Goodbye!");
                    break;
                default:
                    System.out.println("Invalid option");
            }

        } while (option != 0);
        sc.close();
    }
    public static void storeMenu() {
        System.out.println("Option: ");
        System.out.println("--------------------------------");
        System.out.println("1. See a media's details");
        System.out.println("2. Add a media to cart");
        System.out.println("3. Play a media");
        System.out.println("4. See current cart");
        System.out.println("0. Back");
        System.out.println("--------------------------------");
        System.out.println("Please choose a number: 0-1-2-3-4");
        int option = sc.nextInt();
        switch (option) {
            case 1:
                seeMediaDetails();
                break;
            case 2:
                addMediaToCart();
                break;
            case 3:
                playMedia();
                break;
            case 4:
                seeCurrentCart();
                break;
            case 0:
                showMenu();
                break;
            default:
                System.out.println("Invalid option");
        }

    }
    public static void cartMenu() {
        int option;
        System.out.println("Options: ");
        System.out.println("--------------------------------");
        System.out.println("1. Filter media in cart");
        System.out.println("2. Sort media in cart");
        System.out.println("3. Remove media from cart");
        System.out.println("4. Play a media");
        System.out.println("5. Place order");
        System.out.println("0. Back");
        System.out.println("--------------------------------");
        System.out.println("Please choose a number: 0-1-2-3-4-5");
        option = sc.nextInt();
        switch (option) {
            case 1:
                filterMedia();
                break;
            case 2:
                sortMedia();
                break;
            case 3:
                removeMediaFromCart();
                break;
            case 4:
                playMedia();
                break;
            case 5:
                placeOrder();
                break;
            case 0:
                storeMenu();
                break;
            default:
                System.out.println("Invalid option");
        }
    }
    public static void mediaDetailsMenu() {
        System.out.println("Option: ");
        System.out.println("--------------------------------");
        System.out.println("1. Add to cart");
        System.out.println("2. Play");
        System.out.println("0. Back");
        System.out.println("--------------------------------");
        System.out.println("Please choose a number: 0-1-2");
        int option = sc.nextInt();
        switch (option) {
            case 1:
                addMediaToCart();
                break;
            case 2:
                playMedia();
                break;
            case 0:
                storeMenu();
                break;
            default:
                System.out.println("Invalid option");
        }
    }

    public static void seeMediaDetails() {
        System.out.println("Enter the media's title: ");
        sc.nextLine();
        String title = sc.nextLine();
        Media media = store.searchByTitle(title);
        if (media != null) {
            mediaDetailsMenu();
        } else {
            System.out.println("Media not found");
        }
    }

    public static void addMediaToCart() {
        System.out.println("Enter the media's title: ");
        sc.nextLine();
        String title = sc.nextLine();
        Media media = store.searchByTitle(title);
        if (media != null) {
            cart.addMedia(media);
            System.out.println("Media added to cart");
        } else {
            System.out.println("Media not found");
        }
    }

    public static void updateStore(){
        int option;
        do {
            System.out.println("Update store: ");
            System.out.println("--------------------------------");
            System.out.println("1. Add a media");
            System.out.println("2. Remove a media");
            System.out.println("0. Back");
            System.out.println("--------------------------------");
            System.out.println("Please choose a number: 0-1-2");
            option = sc.nextInt();
            switch (option) {
                case 1:
                    DigitalVideoDisc media = new DigitalVideoDisc("DVD title", "DVD category", "DVD director", 10, 200.1f);
                    store.addMedia(media);
                    store.printStore();
                    break;
                case 2:
                    Media mediaToDelete = store.searchByTitle("DVD title");
                    store.removeMedia(mediaToDelete);
                    store.printStore();
                    break;
                case 0:
                    showMenu();
                    break;
                default:
                    System.out.println("Invalid option");
            }
        } while (option != 0);
    }

    public static void seeCurrentCart() {
        cart.print();
        cartMenu();
    }

    public static void filterMedia() {
        int option;
        do {
            System.out.println("Filter media: ");
            System.out.println("--------------------------------");
            System.out.println("1. Filter by title");
            System.out.println("2. Filter by id");
            System.out.println("0. Back");
            System.out.println("--------------------------------");
            System.out.println("Please choose a number: 0-1-2");
            option = sc.nextInt();
            switch (option) {
                case 1:
                    System.out.println("Enter the title: ");
                    sc.nextLine();
                    String title = sc.nextLine();
                    Media find = cart.searchByTitle(title);
                    break;
                case 2:
                    System.out.println("Enter the id: ");
                    int id = sc.nextInt();
                    find = cart.searchByID(id);
                    break;
                case 0:
                    cartMenu();
                    break;
                default:
                    System.out.println("Invalid option");
            }
        } while (option != 0);
    }

    public static void sortMedia(){
        int option;
        do {
            System.out.println("Sort media: ");
            System.out.println("--------------------------------");
            System.out.println("1. Sort by cost");
            System.out.println("2. Sort by title");
            System.out.println("0. Back");
            System.out.println("--------------------------------");
            System.out.println("Please choose a number: 0-1-2");
            option = sc.nextInt();
            switch (option) {
                case 1:
                    cart.sort(Media.COMPARE_BY_COST_TITLE);
                    cart.print();
                    break;
                case 2:
                    cart.sort(Media.COMPARE_BY_TITLE_COST);
                    cart.print();
                    break;
                case 0:
                    cartMenu();
                    break;
                default:
                    System.out.println("Invalid option");
            }
        } while (option != 0);
    }

    public static void removeMediaFromCart() {
        System.out.println("Enter the media's title: ");
        sc.nextLine();
        String title = sc.nextLine();
        Media media = cart.searchByTitle(title);
        cart.removeMedia(media);
    }

    public static void playMedia() {
        System.out.println("Enter the media's title: ");
        sc.nextLine();
        String title = sc.nextLine();
        Media media = cart.searchByTitle(title);
        if (media != null) {
            if(media instanceof CompactDisc) {
                ((CompactDisc) media).play();
            } else if (media instanceof DigitalVideoDisc) {
                ((DigitalVideoDisc) media).play();
            } else {
                System.out.println("This media is not playable");
            }
        } else {
            System.out.println("Media not found");
        }
    }


    public static void placeOrder() {
        System.out.println("Order placed");
        cart.clear();
    }

}