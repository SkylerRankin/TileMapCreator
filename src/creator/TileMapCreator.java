package creator;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JFrame;

public class TileMapCreator extends JFrame {
    
    private Editor e;
    
    public static void main(String[] args) {
        TileMapCreator c = new TileMapCreator();
    }
    
    public TileMapCreator() {
        e = new Editor();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        add(new Editor());
        pack();
        setVisible(true);
    }
    
    

    

}
