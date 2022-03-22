package nivalis.engine.render;


import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public abstract class Spritesheet {
    private Texture texture;
    private float width;
    private float height;
    private float spriteWidth;
    private float spriteHeight;

    public Spritesheet(String path, int spriteWidth, int spriteHeight) {
        //init la texture et les valeurs de celles-ci.
        try {
            BufferedImage source = ImageIO.read(new File(path));
            width = source.getWidth();
            height = source.getHeight();
        } catch (IOException e) {
            e.printStackTrace();
        }
        this.spriteHeight = spriteHeight;
        this.spriteWidth = spriteWidth;
        this.texture = new Texture(path);
    }

    public Texture getTexture() {
        return texture;
    }

    public float getHeight() {
        return height;
    }

    public float  getWidth() {
        return width;
    }

    public float  getSpriteHeight() {
        return spriteHeight;
    }

    public float  getSpriteWidth() {
        return spriteWidth;
    }
}
