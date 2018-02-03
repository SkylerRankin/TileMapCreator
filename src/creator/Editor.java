package creator;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

import javax.swing.JPanel;

public class Editor extends JPanel {
    
	private int gridSpacing;
	private BufferedImage[][] tiles;
	private int xDim;
	private	int yDim;
	private int offX;
	private int offY;
	
	private int scale;
	
    public Editor(int _s, int w, int h, int scale) {
        gridSpacing = _s;
        xDim = w*_s;
        yDim = h*_s;
        this.setPreferredSize(new Dimension(800, 800));
        this.scale = scale;
        repaint();
        tiles = new BufferedImage [(xDim/gridSpacing)] [(yDim/gridSpacing)];
    }
    
    public void setOffset(int x, int y) {
        offX += x;
        offY += y;
        repaint();
    }
    
    public void paintComponent (Graphics g) {
    		super.paintComponent(g);
    		Graphics2D g2d = (Graphics2D) g;
            g2d.scale(scale, scale);
    		for (int gY = 0; gY < yDim/gridSpacing; gY++) {
    			for (int gX = 0; gX < xDim/gridSpacing; gX ++) {
    				if (tiles[gY][gX] != null)
    				    g2d.drawImage(tiles[gY][gX], (gX*gridSpacing) + offX, (gY*gridSpacing) + offY, null);
    				    //g.drawImage(tiles[gY][gX], (gX*gridSpacing) + offX, (gY*gridSpacing) + offY, null);
    			}
    		}
    		if (xDim == yDim) {
    			for (int i = 0; i < xDim; i+=gridSpacing) {
    				g.drawLine(i + offX, 0 + offY, i + offX, xDim + offY);
    				g.drawLine(0 + offX, i + offY, xDim + offX, i + offY);
    			}
    		}
    	}
    
    	public void fillGrid(BufferedImage[][] map) {
    		tiles = map;
    		repaint();
    	}
}
