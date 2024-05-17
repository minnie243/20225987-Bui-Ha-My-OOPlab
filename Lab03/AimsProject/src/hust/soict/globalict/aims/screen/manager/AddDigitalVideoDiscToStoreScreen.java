package hust.soict.globalict.aims.screen.manager;

import hust.soict.globalict.aims.screen.manager.*;
import hust.soict.globalict.aims.store.Store;
import hust.soict.globalict.aims.media.*;
import javax.swing.*;
import java.awt.*;

public class AddDigitalVideoDiscToStoreScreen extends AddItemToStoreScreen{

    public AddDigitalVideoDiscToStoreScreen(Store store, StoreManagerScreen frame) {
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

        JPanel panelLength = new JPanel();
        panelLength.setLayout(new FlowLayout(FlowLayout.LEFT));
        panelLength.add(new JLabel("Length: "));
        JTextField txtLength = new JTextField(20);
        panelLength.add(txtLength);
        center.add(panelLength);

        JPanel panelDirector = new JPanel();
        panelDirector.setLayout(new FlowLayout(FlowLayout.LEFT));
        panelDirector.add(new JLabel("Director: "));
        JTextField txtDirector = new JTextField(20);
        panelDirector.add(txtDirector);
        center.add(panelDirector);

        JPanel panelBtnAdd = new JPanel();
        panelBtnAdd.setLayout(new FlowLayout(FlowLayout.CENTER));
        JButton btnAdd = new JButton("Add to store");
        btnAdd.addActionListener(e -> {
            String title = txtTitle.getText();
            String category = txtCategory.getText();
            float cost = Float.parseFloat(txtCost.getText());
            int length = Integer.parseInt(txtLength.getText());
            String director = txtDirector.getText();
            if (title.isEmpty() || category.isEmpty() || director.isEmpty() || txtCost.getText().isEmpty() || txtLength.getText().isEmpty()) {
                JOptionPane.showMessageDialog(null, "Please fill all fields", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }
            DigitalVideoDisc dvd = new DigitalVideoDisc(title, category, director, length, cost);
            store.addMedia(dvd);
            JOptionPane.showMessageDialog(null, "The DVD has been added to the store", "Success", JOptionPane.INFORMATION_MESSAGE);
            txtTitle.setText("");
            txtCategory.setText("");
            txtCost.setText("");
            txtLength.setText("");
            txtDirector.setText("");
        });
        panelBtnAdd.add(btnAdd);
        center.add(panelBtnAdd);

        return center;
    }

    @Override
    JPanel createHeader() {
        JPanel header = new JPanel();
        header.setLayout(new BoxLayout(header, BoxLayout.X_AXIS));

        JLabel title = new JLabel("Add DVD to store");
        title.setFont(new Font(title.getFont().getName(), Font.PLAIN, 50));
        title.setForeground(Color.CYAN);

        header.add(Box.createRigidArea(new Dimension(10, 10)));
        header.add(title);
        header.add(Box.createHorizontalGlue());
        header.add(Box.createRigidArea(new Dimension(10, 10)));

        return header;
    }

}