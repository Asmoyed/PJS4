package nivalis.tools.ui;

import nivalis.engine.render.RenderBatch;
import nivalis.engine.render.Sprite;
import org.joml.Vector2f;
import org.joml.Vector4f;

import java.util.ArrayList;
import java.util.SplittableRandom;

public class UIPannel implements UIElement{
    private Vector2f position;
    private Vector4f color;
    private int width;
    private int height;
    private float scale;

    private ArrayList<Sprite> subElements;
    private ArrayList<UIElement> childs;

    private UIRenderer father;

    public UIPannel(Vector2f position, Vector4f color, int width, int height, float scale, UIRenderer father) {
        this.position = position;
        this.color = color;
        this.width = width;
        this.height = height;
        this.scale = scale;
        this.father = father;
        subElements = new ArrayList<>();
        childs = new ArrayList<>();
        initElements();
    }

    @Override
    public void initElements() {
        for (int i = 0; i < width; i++) {
            for (int j = 0; j < height; j++) {
                subElements.add(new Sprite(position.x + i, position.y + j, color,scale));
            }
        }
    }

    @Override
    public void addElements(RenderBatch renderBatch) {
        for (Sprite subElement : subElements) {
            renderBatch.addSprite(subElement);
        }

    }

    @Override
    public ArrayList<Sprite> getSubElements() {
        return subElements;

    }

    public void addChild(UIElement child) {
        childs.add(child);
        for (Sprite subElement : child.getSubElements()) {
            father.getBatch().addSprite(subElement);
        }
    }

    public void setScale(float scale) {
        this.scale = scale;
        for (Sprite subElement : subElements) {
            subElement.setScale(scale);
        }
    }

    public void setColor(Vector4f color) {
        this.color = color;
        for (Sprite subElement : subElements) {
            subElement.setColor(color);
        }
    }

    public float x() {
        return position.x;
    }

    public float y() {
        return position.y;
    }
}
