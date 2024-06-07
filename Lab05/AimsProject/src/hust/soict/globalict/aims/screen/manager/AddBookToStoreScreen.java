package hust.soict.globalict.aims.screen.manager;

import hust.soict.globalict.aims.store.Store;
import hust.soict.globalict.aims.media.*;
import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Arrays;

public class AddBookToStoreScreen extends AddItemToStoreScreen{

    public AddBookToStoreScreen(Store store, StoreManagerScreen frame) {
        super(store, frame);
    }


    @Override
    JPanel createCenter() {
        JPanel center = new JPanel();
        center.setLayout(new BoxLayout(center, BoxLayout.Y_AXIS));

        JPanel panelTitle = new JPanel();
        panelTitle.setLayout(new FlowLayout(FlowLayout.LEFT));
        panelTitle.add(new JLabel("Title: "));
        JTextField txtTitle = new JTextField(20);
        panelTitle.add(txtTitle);
        center.add(panelTitle);

        JPanel panelCategory = new JPanel();
        panelCategory.setLayout(new FlowLayout(FlowLayout.LEFT));
        panelCategory.add(new JLabel("Category: "));
        JTextField txtCategory = new JTextField(20);
        panelCategory.add(txtCategory);
        center.add(panelCategory);

        JPanel panelCost = new JPanel();
        panelCost.setLayout(new FlowLayout(FlowLayout.LEFT));
        panelCost.add(new JLabel("Cost: "));
        JTextField txtCost = new JTextField(20);
        panelCost.add(txtCost);
        center.add(panelCost);

        JPanel panelAuthors = new JPanel();
        panelAuthors.setLayout(new FlowLayout(FlowLayout.LEFT));
        panelAuthors.add(new JLabel("Authors: "));
        JTextField txtAuthors = new JTextField(20);
        panelAuthors.add(txtAuthors);
        center.add(panelAuthors);

        JPanel panelAdd = new JPanel();
        panelAdd.setLayout(new FlowLayout(FlowLayout.LEFT));
        JButton btnAdd = new JButton("Add to store");
        btnAdd.addActionListener(e -> {
            String title = txtTitle.getText();
            String category = txtCategory.getText();
            float cost = Float.parseFloat(txtCost.getText());
            ArrayList<String> authors = new ArrayList<String>(Arrays.asList(txtAuthors.getText().split(",")));
            Book book = new Book(title, category, cost, authors);
            store.addMedia(book);
            JOptionPane.showMessageDialog(null, "The book has been added to the store");
        });
        panelAdd.add(btnAdd);
        center.add(panelAdd);

        return center;
    }


    @Override
    JPanel createHeader() {
        JPanel header = new JPanel();
        header.setLayout(new BoxLayout(header, BoxLayout.X_AXIS));

        JLabel title = new JLabel("Add Book to store");
        title.setFont(new Font(title.getFont().getName(), Font.PLAIN, 50));
        title.setForeground(Color.CYAN);

        header.add(Box.createRigidArea(new Dimension(10, 10)));
        header.add(title);
        header.add(Box.createHorizontalGlue());
        header.add(Box.createRigidArea(new Dimension(10, 10)));

        return header;
    }

}
