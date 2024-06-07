package hust.soict.globalict.test.screen.customer.store;

import hust.soict.globalict.aims.cart.Cart;
import hust.soict.globalict.aims.media.Book;
import hust.soict.globalict.aims.media.CompactDisc;
import hust.soict.globalict.aims.media.DigitalVideoDisc;
import hust.soict.globalict.aims.screen.customer.controller.ViewStoreController;
import hust.soict.globalict.aims.store.Store;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.Arrays;

public class TestViewStoreScreen extends Application {
    private static Store store;
    private static Cart cart;
    @Override
    public void start(Stage primaryStage) throws Exception {
        final String STORE_FXML_FILE_PATH = "/hust/soict/hedspi/aims/screen/customer/view/Store.fxml";
        FXMLLoader fxmlLoader = new FXMLLoader();
        fxmlLoader.setLocation(getClass().getResource(STORE_FXML_FILE_PATH));
        ViewStoreController viewStoreController = new ViewStoreController(store, cart);
        fxmlLoader.setController(viewStoreController);
        Parent parent = fxmlLoader.load();

        Scene scene = new Scene(parent);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Store");
        primaryStage.show();
    }

    public static void main(String[] args) {
        store = new Store();
        cart = new Cart();
        store.addMedia(new DigitalVideoDisc("DVD title", "DVD category", "DVD director", 10, 200.1f));
        store.addMedia(new DigitalVideoDisc("DVD title 2", "DVD category", "DVD director", 10, 200.1f));
        store.addMedia(new DigitalVideoDisc("DVD title 3", "DVD category", "DVD director", 10, 200.1f));
        store.addMedia(new Book("Book title", "Book category", 300.1f, new ArrayList<String>(Arrays.asList("Book author 1", "Book author 2"))));
        store.addMedia(new CompactDisc("CD title", "CD category", 100.1f, "CD director", "CD artist"));
        store.addMedia(new CompactDisc("CD title 2", "CD category", 100.1f, "CD director", "CD artist"));
        store.addMedia(new CompactDisc("CD title 3", "CD category", 100.1f, "CD director", "CD artist"));
        store.addMedia(new Book("Book title 2", "Book category", 300.1f, new ArrayList<String>(Arrays.asList("Book author 3", "Book author 4"))));

        launch(args);
    }
}
