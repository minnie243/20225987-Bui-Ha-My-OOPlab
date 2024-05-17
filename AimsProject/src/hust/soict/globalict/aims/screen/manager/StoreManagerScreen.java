package hust.soict.globalict.aims.screen.manager;

import hust.soict.globalict.aims.media.*;
import hust.soict.globalict.aims.store.*;
import hust.soict.globalict.aims.cart.*;
import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class StoreManagerScreen extends JFrame {
    private Store store;
    JPanel createNorth() {
        JPanel north = new JPanel();
        north.setLayout(new BoxLayout(north, BoxLayout.Y_AXIS));
        north.add(createMenuBar());
        north.add(createHeader());
        return north;
    }
    JMenuBar createMenuBar() {
        JMenu menu = new JMenu("Options");
        menu.add(new JMenuItem("View Store"));

        JMenu smUpdateStore = new JMenu("Update Store");

        JButton btnAddBook = new JButton("Add Book");
        btnAddBook.addActionListener(e -> {
            AddBookToStoreScreen addBookToStoreScreen = new AddBookToStoreScreen(store, this);
            addBookToStoreScreen.setVisible(true);

        });

        JButton btnAddCD = new JButton("Add CD");
        btnAddCD.addActionListener(e -> {
            AddCompactDiscToStoreScreen addCDToStoreScreen = new AddCompactDiscToStoreScreen(store, this);
            addCDToStoreScreen.setVisible(true);
        });

        JButton btnAddDVD = new JButton("Add DVD");
        btnAddDVD.addActionListener(e -> {
            AddDigitalVideoDiscToStoreScreen addDVDToStoreScreen = new AddDigitalVideoDiscToStoreScreen(store, this);
            addDVDToStoreScreen.setVisible(true);
        });

        smUpdateStore.add(btnAddBook);
        smUpdateStore.add(btnAddCD);
        smUpdateStore.add(btnAddDVD);
        menu.add(smUpdateStore);

        JMenuBar menuBar = new JMenuBar();
        menuBar.setLayout(new FlowLayout(FlowLayout.LEFT));
        menuBar.add(menu);

        return menuBar;
    }

    JPanel createHeader() {
        JPanel header = new JPanel();
        header.setLayout(new BoxLayout(header, BoxLayout.X_AXIS));

        JLabel title = new JLabel("AIMS");
        title.setFont(new Font(title.getFont().getName(), Font.PLAIN, 50));
        title.setForeground(Color.CYAN);

        header.add(Box.createRigidArea(new Dimension(10, 10)));
        header.add(title);
        header.add(Box.createHorizontalGlue());
        header.add(Box.createRigidArea(new Dimension(10, 10)));

        return header;
    }

    JPanel createCenter() {
        JPanel center = new JPanel();
        center.setLayout(new GridLayout(3, 3, 2, 2));

        ArrayList<Media> mediaInStore = store.getItemsInStore();
        for (int i = 0; i < mediaInStore.size(); i++){
            MediaStore cell = new MediaStore(mediaInStore.get(i));
            center.add(cell);
        }

        return center;
    }

    public StoreManagerScreen(Store store) {
        this.store = store;
        storeGenerate();
    }

    public void storeGenerate() {
        Container cp = getContentPane();
        cp.removeAll();
        cp.setLayout(new BorderLayout());
        cp.add(createNorth(), BorderLayout.NORTH);
        cp.add(createCenter(), BorderLayout.CENTER);
        cp.validate();
        cp.repaint();
        setTitle("Store");
        setSize(1024, 768);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    public static void main(String[] args){
        Store store = new Store();

        StoreManagerScreen storeManagerScreen = new StoreManagerScreen(store);
    }

}