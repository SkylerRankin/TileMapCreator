package creator;

import java.awt.image.BufferedImage;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Model {
    
    private int[][] map_text;
    private BufferedImage[][] map_image;
    
    private int currentTile = 0;
    
    private int height;
    private int width;
    
    private int size;
    
    private int offX;
    private int offY;
    private int scale;
    
    private BufferedImage[] tiles = null;
    
    private String tile_path = null;
    private String save_path = null;
    
    public Model(int _size, int _w, int _h, int s) {
        size = _size;
        height = _h;
        width = _w;
        scale = s;
        map_text = new int[height][width];
        map_image = new BufferedImage[height][width];
        for (int i=0; i<map_image.length; ++i)
            for (int j=0; j<map_image[0].length; ++j) {
                map_image[i][j] = null;
                map_text[i][j] = -1;
            }
    }
    
    public BufferedImage getCurrentImage() {
    		return tiles[currentTile];
    }
    
    public BufferedImage[][] getTiles() {
        return map_image;
    }
    
    public void handleClick(int _x, int _y) {
        _x /= scale;
        _y /= scale;
        if (tiles == null) return;
        int x = (int)Math.floor((_x - offX) / size);
        int y = (int)Math.floor((_y - offY) / size);
        map_image[y][x] = tiles[currentTile];
        map_text[y][x] = currentTile;
    }
    
    public void setTilePath(String p) {
        tile_path = p;
        SpriteSheetManager sm = new SpriteSheetManager();
        tiles = sm.getSprites(size, size, tile_path);
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
    
    public void setOffset(int x, int y) {
        offX += x;
        offY += y;
    }
    
    public void compile() {
        if (save_path == null) return;
        try {
            File file = new File(save_path);
            BufferedWriter out = new BufferedWriter(new FileWriter(file));
            
            String[] lines = new String[map_text.length];
            
            for (int i=0; i<map_text.length; ++i) {
                lines[i] = strJoin(map_text[i], ",");
                out.write(lines[i]);
            }
                    
            out.close();
        } catch(Exception e) {}
    }
    
    public String strJoin(int[] aArr, String sSep) {
        StringBuilder sbStr = new StringBuilder();
        for (int i = 0, il = aArr.length; i < il; i++) {
            if (i > 0)
                sbStr.append(sSep);
            sbStr.append(aArr[i]);
        }
        return sbStr.toString() + "$";
    }

}
