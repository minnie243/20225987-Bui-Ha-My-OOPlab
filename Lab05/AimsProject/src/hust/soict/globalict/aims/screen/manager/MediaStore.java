package hust.soict.globalict.aims.screen.manager;

import hust.soict.globalict.aims.media.*;
import hust.soict.globalict.aims.screen.manager.*;
import hust.soict.globalict.aims.cart.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;



public class MediaStore extends JPanel {
    private Media media;
    public MediaStore(Media media) {
        this.media = media;
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        JLabel title = new JLabel(media.getTitle());
        title.setFont(new Font(title.getFont().getName(), Font.PLAIN, 20));
        title.setAlignmentX(Component.CENTER_ALIGNMENT);

        JLabel cost = new JLabel(""+media.getCost()+ "$");
        cost.setAlignmentX(Component.CENTER_ALIGNMENT);

        JPanel container = new JPanel();
        container.setLayout(new FlowLayout(FlowLayout.CENTER));

        JButton btnPlay = new JButton("Play");
        btnPlay.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(media instanceof Playable) {
                    JDialog dialog = new JDialog();
                    dialog.setTitle("Playing media");
                    dialog.setSize(200, 200);
                    dialog.setLocationRelativeTo(null);
                    dialog.setVisible(true);
                    dialog.add(new JLabel("Playing " + media.getTitle()));

                }
            }
        });

        if(media instanceof Playable) {
            container.add(btnPlay);
        }

        this.add(Box.createVerticalGlue());
        this.add(title);
        this.add(cost);
        this.add(Box.createVerticalGlue());
        this.add(container);

        this.setBorder(BorderFactory.createLineBorder(Color.BLACK));
    }

}
