import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.image.BufferedImage;

import javax.swing.JLabel;
import javax.swing.JPanel;
public class CurrentPanel extends JPanel {
    
    BufferedImage img = null;
    
    public CurrentPanel() {
        setPreferredSize(new Dimension(100, 500));
        this.setBackground(Color.lightGray);
    }
    
    public void setImage(BufferedImage i) {
        img = i;
    }
    
    public void paintComponent(Graphics g) {
        if (img != null)
            g.drawImage(img, 0, 0, null);
    }

}
