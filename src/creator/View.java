package creator;
import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;

import creator.Control.ButtonListener;
import creator.Control.ClickListener;

public class View extends JFrame {
    
    JPanel container = new JPanel();
    Editor e = new Editor();
    CurrentPanel p = new CurrentPanel();
    
    public View() {
        container.setLayout(new BoxLayout(container, BoxLayout.X_AXIS));
        container.add(e);
        container.add(p);
        add(container);
        pack();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        e.repaint();
    }
    
    public void addListeners(ButtonListener bl, ClickListener cl) {
        p.addListeners(bl);
        e.addMouseListener(cl);
    }
    
    public void updateLabel(String cmd, String text) {
        p.updateLabel(cmd, text);
    }

}
