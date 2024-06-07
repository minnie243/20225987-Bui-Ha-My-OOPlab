package hust.soict.globalict.aims.screen.manager;

import hust.soict.globalict.aims.store.Store;
import javax.swing.*;
import java.awt.*;

public abstract class AddItemToStoreScreen extends JFrame {

    protected Store store;
    protected StoreManagerScreen frame;

    public AddItemToStoreScreen(Store store, StoreManagerScreen frame) {
        this.store = store;
        this.frame = frame;

        Container cp = getContentPane();
        cp.setLayout(new BorderLayout());
        cp.add(createNorth(), BorderLayout.NORTH);
        cp.add(createCenter(), BorderLayout.CENTER);

        setTitle("Add item to store");
        setSize(1024, 768);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    JPanel createNorth() {
        JPanel north = new JPanel();
        north.setLayout(new BoxLayout(north, BoxLayout.Y_AXIS));
        north.add(createMenuBar());
        north.add(createHeader());
        return north;
    }

    JMenuBar createMenuBar() {
        JMenuBar menuBar = new JMenuBar();
        JMenu menu = new JMenu("Options");
        JMenuItem itemStore = new JMenuItem("Store");
        itemStore.addActionListener(e -> {
            frame.storeGenerate();
        });
        menu.add(itemStore);
        menuBar.add(menu);
        return menuBar;
    }

    abstract JPanel createCenter();

    abstract JPanel createHeader();
}
