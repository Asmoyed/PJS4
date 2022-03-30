package nivalis.tools.ui;

import nivalis.engine.render.RenderBatch;
import nivalis.engine.render.Sprite;

import java.util.ArrayList;

public interface UIElement {
    public void initElements();

    public void addElements(RenderBatch renderBatch);

    public ArrayList<Sprite> getSubElements();

}
