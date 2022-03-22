package com.scenes;


import com.logic.utils.pathfinding.algos.AStarFinder;
import com.logic.utils.pathfinding.dto.ASPoint;
import com.logic.utils.pathfinding.dto.Path;
import com.logic.utils.pathfinding.dto.PathPoint;
import com.logic.utils.pathfinding.exception.TargetUnreachableException;
import com.logic.utils.pathfinding.render.RenderedPath;
import com.sun.deploy.panel.PathRenderer;

import nivalis.engine.render.RenderBatch;


import nivalis.engine.render.Sprite;
import nivalis.engine.window.Window;
import nivalis.tools.controls.Mouse;
import nivalis.tools.game.Scene;
import nivalis.tools.transform.Camera;
import org.joml.Vector4f;

import static org.lwjgl.glfw.GLFW.GLFW_MOUSE_BUTTON_1;

public class BatteSceneTest implements Scene {

    private int x = 0;
    private int y = 0;
    private AStarFinder pathfinder;
    private ASPoint[][] map = new ASPoint[10][10];
    private RenderedPath pathRenderer;
    private boolean onDrag = false;
    private Path path;
    private int lastX = 0;
    private int lastY = 0;

    private Window window;
    private RenderBatch renderBatch;

    public BatteSceneTest(Window window) {
        this.window = window;
    }


    @Override
    public void preprocess() {
        renderBatch = new RenderBatch();
        pathRenderer = new RenderedPath();
        renderBatch.addSprite(new Sprite(0,0, new Vector4f(1.0f,0.0f,0.0f,1.0f)));
    }

    @Override
    public void loop(Camera camera) {
        renderBatch.render(camera);


        if (((Mouse.getX() > window.getWidth() / 2 - 32) && (Mouse.getX() < window.getWidth() / 2 + 32) &&
                (Mouse.getY() > window.getHeight() / 2 - 32 && (Mouse.getY() < window.getHeight() / 2 + 32)) && Mouse.mouseButtonDown(GLFW_MOUSE_BUTTON_1)) || (onDrag && Mouse.mouseButtonDown(GLFW_MOUSE_BUTTON_1))) {
            onDrag = true;

            if (Mouse.isDragging()) {

                int xPos = (int) (Mouse.getX() / (window.getCamera().getScaleValue()) + 0.5) - 7;
                int yPos = -((int) (Mouse.getY() / (window.getCamera().getScaleValue()) + 0.5) - 7);
                if (path != null) path.getList().clear();
                if ((xPos != lastX) || (yPos != lastY)) {

                    for (int i = 0; i < map.length; i++) {
                        for (int j = 0; j < map[i].length; j++) {
                            map[i][j] = new ASPoint(i, j, true);
                        }
                    }
                    pathfinder = new AStarFinder(map);

                    try {
                        path = pathfinder.calculatePath(new PathPoint(x, y, true), new PathPoint(x + xPos, y + yPos, true), 20);
                    } catch (TargetUnreachableException e) {
                        e.printStackTrace();
                    }
                    if (path != null) System.out.println(path.toString());
                    if (xPos != 0 || yPos != 0) pathRenderer.init(path);


                }
                pathRenderer.render(window.getCamera());

                lastX = xPos;
                lastY = yPos;

            } else {
                onDrag = false;
                pathRenderer.clear();
                x = lastX;
                y = lastY;
                lastX = 0;
                lastY = 0;
            }


        }
    }



}
