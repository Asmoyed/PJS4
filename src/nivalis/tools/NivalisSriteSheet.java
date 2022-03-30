package nivalis.tools;

import nivalis.engine.render.Sprite;
import nivalis.engine.render.Texture;
import org.joml.Vector2f;

public class NivalisSriteSheet {
    private static final int GLYPH_WIDTH = 9;
    private static final int GLYPH_HEIGHT = 13;
    private static final int WIDTH = 6 * GLYPH_WIDTH;
    private static final int HEIGHT = 5 * GLYPH_HEIGHT;

    public static Sprite getGlyph(char c, int x, int y) {
        int xPos = 0;
        int yPos = 0;
        Vector2f[] coordinates;
        switch (c) {
            case 'A':
                xPos = 0;
                yPos = 4;
                break;
        }
        coordinates = new Vector2f[] {
                new Vector2f((GLYPH_WIDTH * (xPos + 1))/WIDTH, ((GLYPH_WIDTH * (yPos))/HEIGHT)),
                new Vector2f((GLYPH_WIDTH * (xPos + 1))/WIDTH, ((GLYPH_WIDTH * (yPos + 1))/HEIGHT)),
                new Vector2f((GLYPH_WIDTH * (xPos))/WIDTH, ((GLYPH_WIDTH * (yPos + 1))/HEIGHT)),
                new Vector2f((GLYPH_WIDTH * (xPos))/WIDTH, ((GLYPH_WIDTH * (yPos))/HEIGHT))
        };
        return new Sprite(x,y,new Texture("./res/fonts/Nivalt.png"), coordinates, 0);



    }
}
