package creator;
import java.awt.image.BufferedImage;

import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;

import creator.Control.ButtonListener;
import creator.Control.ClickListener;
import creator.Control.KeyPressListener;

public class View extends JFrame {
    
    JPanel container = new JPanel();
    Editor e;
    CurrentPanel p = new CurrentPanel();
    
    public View(int size, int w, int h) {
        e = new Editor(size, w, h);
        container.setLayout(new BoxLayout(container, BoxLayout.X_AXIS));
        container.add(e);
        container.add(p);
        add(container);
        pack();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        e.repaint();
    }
    
    public void addListeners(ButtonListener bl, ClickListener cl, KeyPressListener kl) {
        p.addKeyListener(kl);
        p.addListeners(bl);
        p.setFocusable(true);
        p.requestFocus();
        e.addMouseListener(cl);
    }
    
    public void updateLabel(String cmd, String text) {
        p.updateLabel(cmd, text);
    }
    
    public void updateMapImages(BufferedImage[][] a) {
        e.fillGrid(a);
    }
    
    public void updateCurrentTile(BufferedImage a) {
    		p.updateCurrentImage(a);
    }
    
    public void setFocus() {
        p.requestFocus();
    }
    
    public void setOffset(int x, int y) {
        e.setOffset(x, y);
    }

}
