package creator;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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
        v.addListeners(new ButtonListener(), new ClickListener());
        v.setVisible(true);
    }
    
    public static void main(String[] args) {
        Control c = new Control(new Model(), new View());
    }
    
    class ClickListener implements MouseListener {

        @Override
        public void mouseClicked(MouseEvent me) {
            m.handleClick(me.getX(), me.getY());
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
        }
        
    }

}
