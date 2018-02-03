package creator;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.image.BufferedImage;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import creator.Control.ButtonListener;

public class CurrentPanel extends JPanel {
    
    private BufferedImage img = null;
    private JButton compile = new JButton("Compile");
    private JButton select_tiles = new JButton("Select Tilesheet");
    private JButton select_destination = new JButton("Select Save Location");
    
    private JLabel tiles_location = new JLabel("No location selected");
    private JLabel save_location = new JLabel("No location selected");
    
    public CurrentPanel() {
        setPreferredSize(new Dimension(200, 500));
        
        select_tiles.setActionCommand("tiles");
        select_destination.setActionCommand("destination");
        
        this.setBackground(Color.lightGray);
        add(new JLabel("Tile Map Creator"));
        add(select_tiles);
        add(tiles_location);
        add(select_destination);
        add(save_location);
        add(new JLabel("Current Tile"));
        repaint();
    }
    
    public void setImage(BufferedImage i) {
        img = i;
    }
    
    public void updateLabel(String cmd, String text) {
        if (cmd.equals("tiles")) {
            tiles_location.setText(text);
        } else if (cmd.equals("destination")) {
            save_location.setText(text);
        }
        repaint();
    }
    
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        if (img != null)
            g.drawImage(img, 50, 200, null);
    }
    
    public void addListeners(ButtonListener bl) {
        select_tiles.addActionListener(bl);
        select_destination.addActionListener(bl);
    }
    
    public void updateCurrentImage(BufferedImage a) {
    		img = a;
    		repaint();
    }

}
