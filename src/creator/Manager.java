package creator;
import java.awt.image.BufferedImage;

public class Manager {
    
    int w;
    int h;
    String tile_path;
    BufferedImage[] tiles;
    SpriteSheetManager ssm;
    
    public Manager() {
        ssm = new SpriteSheetManager();
        tiles = ssm.getSprites(w, h, tile_path);
    }

}
