package nivalis.engine.font;

import org.joml.Vector2f;
import org.joml.Vector3f;

public class Text {
    private String content;
    private Vector3f position;
    private float offset;

    public Text(String content, Vector3f position, float offset) {
        this.content = content;
        this.position = position;
        this.offset = offset;
    }
}
