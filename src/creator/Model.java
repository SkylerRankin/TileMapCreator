package creator;

import java.awt.image.BufferedImage;

public class Model {
    
    private String[][] map_text;
    private BufferedImage[][] map_image;
    
    private int currentTile = 0;
    
    private int height;
    private int width;
    
    private int size;
    
    private BufferedImage[] tiles = null;
    
    private String tile_path = null;
    private String save_path = null;
    
    public Model(int _size, int _w, int _h) {
        size = _size;
        height = _h;
        width = _w;
        map_text = new String[height][width];
        map_image = new BufferedImage[height][width];
        for (int i=0; i<map_image.length; ++i)
            for (int j=0; j<map_image[0].length; ++j)
                map_image[i][j] = null;
    }
    
    public BufferedImage getCurrentImage() {
    		return tiles[currentTile];
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
        tiles = sm.getSprites(size, size, tile_path);
        System.out.println(tiles.length);
    }
    
    public void setSavePath(String p) {
        save_path = p;
    }
    
    public void changeTile(int i) {
        if (i == -1 && currentTile > 0)
            currentTile--;
        else if (i == 1 && currentTile < tiles.length - 1)
            currentTile++;
    }

}
