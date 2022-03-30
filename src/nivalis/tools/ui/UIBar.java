package nivalis.tools.ui;

import nivalis.engine.render.RenderBatch;
import nivalis.engine.render.Sprite;
import org.joml.Vector2f;
import org.joml.Vector4f;

import java.util.ArrayList;

public class UIBar implements UIElement{
    private int width;
    private int height;
    private Vector4f color;
    private Vector2f position;
    private float scale;

    private ArrayList<Sprite> subElements;

    public UIBar(Vector2f position, Vector4f color, int width, int height, float scale) {
        this.position = position;
        this.color = color;
        this.width = width;
        this.height = height;
        this.scale = scale;

        subElements = new ArrayList<>();
        initElements();
    }

    @Override
    public void initElements() {
        for (int i = 0; i < width; i++) {
            for (int j = 0; j < height; j++) {
                subElements.add(new Sprite(position.x + i, position.y + j, color, scale));
            }
        }
    }

    @Override
    public void addElements(RenderBatch renderBatch) {
        for (Sprite subElement : subElements) {
            renderBatch.addSprite(subElement);
        }
    }

    public ArrayList<Sprite> getSubElements() {
        return subElements;
    }
}
