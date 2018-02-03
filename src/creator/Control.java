package creator;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;
import javax.swing.JFileChooser;


public class Control {
    
    Model m;
    View v;
    
    public Control(Model m, View v) {
        this.m = m;
        this.v = v;
        v.addListeners(new ButtonListener(), new ClickListener(), new KeyPressListener());
        v.setVisible(true);
    }
    
    public static void main(String[] args) {
        int scale = 4;
        Control c = new Control(new Model(16, 200, 200, scale), new View(16, 100, 100, scale));
    }
    
    class KeyPressListener implements KeyListener {

        @Override
        public void keyPressed(KeyEvent e) {
            switch (e.getKeyCode()) {
            case 37:
                m.setOffset(10, 0);
                v.setOffset(10, 0);
                break;
            case 38:
                m.setOffset(0, 10);
                v.setOffset(0, 10);
                break;
            case 39:
                m.setOffset(-10, 0);
                v.setOffset(-10, 0);
                break;
            case 40:
                m.setOffset(0, -10);
                v.setOffset(0, -10);
                break;
            case 49:
                m.changeTile(-1);
                v.updateCurrentTile(m.getCurrentImage());
                break;
            case 50:
                m.changeTile(1);
                v.updateCurrentTile(m.getCurrentImage());
                break;
            }
            v.setFocus();
        }
        @Override
        public void keyReleased(KeyEvent e) {}
        @Override
        public void keyTyped(KeyEvent e) {}
        
    }
    
    class ClickListener implements MouseListener {

        @Override
        public void mouseClicked(MouseEvent me) {
            m.handleClick(me.getX(), me.getY());
            v.updateMapImages(m.getTiles());
            v.updateCurrentTile(m.getCurrentImage());
            v.setFocus();
        }

        @Override
        public void mouseEntered(MouseEvent arg0) {}
        @Override
        public void mouseExited(MouseEvent arg0) {}
        @Override
        public void mousePressed(MouseEvent arg0) {}
        @Override
        public void mouseReleased(MouseEvent arg0) {}
        
    }
    
    class ButtonListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent ae) {
            JButton src = (JButton) ae.getSource();
            String cmd = src.getActionCommand();
            JFileChooser c;
            String path;
            switch (cmd) {
            case "tiles":
                c = new JFileChooser();
                if (c.showOpenDialog(v) == 0) {
                    path = c.getSelectedFile().getPath().toString();
                    m.setTilePath(path);
                    v.updateLabel(cmd, path);
                }
                break;
            case "destination":
                c = new JFileChooser();
                if (c.showOpenDialog(v) == 0) {
                    path = c.getSelectedFile().getPath().toString();
                    m.setSavePath(path);
                    v.updateLabel(cmd, path);
                }
                break;
            case "compile":
                m.compile();
                break;
            }
            v.setFocus();
        }
        
    }

}
