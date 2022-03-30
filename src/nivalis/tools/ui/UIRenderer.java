package nivalis.tools.ui;

import nivalis.engine.render.RenderBatch;
import nivalis.tools.transform.Camera;

import java.util.ArrayList;

public class UIRenderer {
    private RenderBatch renderBatch;
    private ArrayList<UIElement> elements;
    private Camera camera;

    public UIRenderer() {
        renderBatch = new RenderBatch();
        elements = new ArrayList<>();
        camera = new Camera(1920,1080);
    }

    public void addComponent(UIElement component) {
        elements.add(component);
        component.addElements(renderBatch);
    }

    public UIElement getComponent(int index) {
        return elements.get(index);
    }

    public void render() {
        renderBatch.render(camera);
    }

    public RenderBatch getBatch() {
        return renderBatch;
    }
}
