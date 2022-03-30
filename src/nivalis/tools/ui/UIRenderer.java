package nivalis.tools.ui;

import nivalis.engine.render.RenderBatch;
import nivalis.tools.transform.Camera;

import java.util.ArrayList;

public class UIRenderer {
    private RenderBatch renderBatch;
    private ArrayList<UIElement> elements;

    public UIRenderer() {
        renderBatch = new RenderBatch();
        elements = new ArrayList<>();
    }

    public void addComponent(UIElement component) {
        elements.add(component);
        component.addElements(renderBatch);
    }

    public UIElement getComponent(int index) {
        return elements.get(index);
    }

    public void render(Camera camera) {
        renderBatch.render(camera);
    }

    public RenderBatch getBatch() {
        return renderBatch;
    }
}
