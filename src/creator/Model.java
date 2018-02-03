package creator;

import java.awt.image.BufferedImage;

public class Model {
    
    private String[][] map_text = new String[10][10];
    private BufferedImage[][] map_image = new BufferedImage[10][10];
    
    private int currentTile = 0;
    
    private int height = 500;
    private int width = 500;
    
    private int size = 50;
    
    private BufferedImage[] tiles = null;
    
    private String tile_path = null;
    private String save_path = null;
    
    public Model() {
        for (int i=0; i<map_image.length; ++i)
            for (int j=0; j<map_image[0].length; ++j)
                map_image[i][j] = null;
    }
    
    public BufferedImage[][] getTiles() {
        return map_image;
    }
    
    public void handleClick(int _x, int _y) {
        if (tiles == null) return;
        int x = (int)Math.floor(_x / size);
        int y = (int)Math.floor(_y / size);
        map_image[y][x] = tiles[currentTile];
    }
    
    public void setTilePath(String p) {
        tile_path = p;
        SpriteSheetManager sm = new SpriteSheetManager();
        tiles = sm.getSprites(50, 50, tile_path);
        System.out.println(tiles.length);
    }
    
    public void setSavePath(String p) {
        save_path = p;
    }

}
