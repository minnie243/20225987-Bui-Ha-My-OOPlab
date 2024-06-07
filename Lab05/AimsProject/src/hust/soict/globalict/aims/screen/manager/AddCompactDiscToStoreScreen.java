package hust.soict.globalict.aims.screen.manager;

import hust.soict.globalict.aims.store.Store;
import hust.soict.globalict.aims.media.*;
import javax.swing.*;
import java.awt.*;


public class AddCompactDiscToStoreScreen extends AddItemToStoreScreen {

        public AddCompactDiscToStoreScreen(Store store, StoreManagerScreen frame) {
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

            JPanel panelDirector = new JPanel();
            panelDirector.setLayout(new FlowLayout(FlowLayout.LEFT));
            panelDirector.add(new JLabel("Director: "));
            JTextField txtDirector = new JTextField(20);
            panelDirector.add(txtDirector);
            center.add(panelDirector);

            JPanel panelArtist = new JPanel();
            panelArtist.setLayout(new FlowLayout(FlowLayout.LEFT));
            panelArtist.add(new JLabel("Artist: "));
            JTextField txtArtist = new JTextField(20);
            panelArtist.add(txtArtist);
            center.add(panelArtist);

            JPanel panelAdd = new JPanel();
            panelAdd.setLayout(new FlowLayout(FlowLayout.LEFT));
            JButton btnAdd = new JButton("Add to store");
            btnAdd.addActionListener(e -> {
                String title = txtTitle.getText();
                String category = txtCategory.getText();
                float cost = Float.parseFloat(txtCost.getText());
                String director = txtDirector.getText();
                String artist = txtArtist.getText();
                CompactDisc compactDisc = new CompactDisc(title, category, cost, director, artist);
                store.addMedia(compactDisc);
                JOptionPane.showMessageDialog(null, "The CD has been added to the store");
            });
            panelAdd.add(btnAdd);
            center.add(panelAdd);

            return center;
        }
    @Override
    JPanel createHeader() {
        JPanel header = new JPanel();
        header.setLayout(new BoxLayout(header, BoxLayout.X_AXIS));

        JLabel title = new JLabel("Add CD to store");
        title.setFont(new Font(title.getFont().getName(), Font.PLAIN, 50));
        title.setForeground(Color.CYAN);

        header.add(Box.createRigidArea(new Dimension(10, 10)));
        header.add(title);
        header.add(Box.createHorizontalGlue());
        header.add(Box.createRigidArea(new Dimension(10, 10)));

        return header;
    }

}
