package nivalis.tools.game;

import nivalis.tools.transform.Camera;

public interface Scene {
    public void preprocess();

    public void loop(Camera camera);
}
