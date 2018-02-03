package creator;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.image.BufferedImage;

import javax.swing.JPanel;

public class Editor extends JPanel {
    
	private int gridSpacing = 50;
	private BufferedImage[][] tiles;
	private int xDim = 500;
	private	int yDim = 500;
	
    public Editor() {
        this.setPreferredSize(new Dimension(xDim, yDim));
        repaint();
        tiles = new BufferedImage [(xDim/gridSpacing)] [(yDim/gridSpacing)];
    }
    
    public void paintComponent (Graphics g) {
    		super.paintComponent(g);	
    		for (int gY = 0; gY < yDim/gridSpacing; gY++) {
    			for (int gX = 0; gX < xDim/gridSpacing; gX ++) {
    				if (tiles[gY][gX] != null)
    				g.drawImage(tiles[gY][gX], (gX*gridSpacing), (gY*gridSpacing), null);
    				
    			}
    		}
    		if (xDim == yDim) {
    			for (int i = 0; i < xDim; i+=gridSpacing) {
    				g.drawLine(i, 0, i, xDim);
    				g.drawLine(0, i, xDim, i);
    			}
    		} 		
    	}
    	public void fillGrid(BufferedImage[][] map) {
    		tiles = map;
    		repaint();
    	}
}
