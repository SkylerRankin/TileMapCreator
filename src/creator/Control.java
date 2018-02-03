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
        Control c = new Control(new Model(32, 10, 10), new View(32, 10, 10));
    }
    
    class KeyPressListener implements KeyListener {

        @Override
        public void keyPressed(KeyEvent e) {
            System.out.println(e.getKeyCode());
            if (e.getKeyCode() == 49) {
                m.changeTile(-1);
                v.updateCurrentTile(m.getCurrentImage());
            } else if (e.getKeyCode() == 50) {
                m.changeTile(1);
                v.updateCurrentTile(m.getCurrentImage());
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
                c.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
                if (c.showOpenDialog(v) == 0) {
                    path = c.getSelectedFile().getPath().toString();
                    m.setSavePath(path);
                    v.updateLabel(cmd, path);
                }
                break;
            }
            v.setFocus();
        }
        
    }

}
