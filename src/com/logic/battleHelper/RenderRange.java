package com.logic.battleHelper;

import nivalis.engine.render.RenderBatch;
import nivalis.engine.render.Sprite;
import nivalis.tools.transform.Camera;
import org.joml.Vector4f;

public class RenderRange {
    private RenderBatch renderBatch;


    public RenderRange() {
        renderBatch = new RenderBatch();
    }

    public void init(Boolean[][] range) {

        for (int i = 0; i < range.length; i++) {
            for (int j = 0; j < range[i].length; j++) {
                if (range[i][j] == true)
                  renderBatch.addSprite(new Sprite(i,j,new Vector4f(0.0f,0.5f,1.0f,0.2f), 1.0f));
            }
        }
    }

    public void render(Camera camera) {
        renderBatch.render(camera);

    }
}
