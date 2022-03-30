package com.scenes;


import com.logic.battleHelper.Range;
import com.logic.battleHelper.RenderRange;
import com.logic.dto.data.*;
import com.logic.utils.pathfinding.algos.AStarFinder;
import com.logic.utils.pathfinding.dto.ASPoint;
import com.logic.utils.pathfinding.dto.Path;
import com.logic.utils.pathfinding.dto.PathPoint;
import com.logic.utils.pathfinding.exception.TargetUnreachableException;
import com.logic.utils.pathfinding.render.RenderedPath;
import com.sun.deploy.panel.PathRenderer;

import nivalis.engine.render.RenderBatch;


import nivalis.engine.render.Sprite;
import nivalis.engine.render.Texture;
import nivalis.engine.utils.Time;
import nivalis.engine.window.Window;
import nivalis.tools.NivalisSriteSheet;
import nivalis.tools.TestSpriteEnum;
import nivalis.tools.TestSpritesheet;
import nivalis.tools.controls.Key;
import nivalis.tools.controls.Mouse;
import nivalis.tools.game.Scene;
import nivalis.tools.transform.Camera;
import nivalis.tools.ui.UIBar;
import nivalis.tools.ui.UIElement;
import nivalis.tools.ui.UIPannel;
import nivalis.tools.ui.UIRenderer;
import org.joml.Vector2f;
import org.joml.Vector4f;

import java.lang.Character;

import static org.lwjgl.glfw.GLFW.GLFW_KEY_SPACE;
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

    //test range

    /*private Tile[][] terrain = new Tile[16][16];
    private com.logic.dto.data.Character ardyn = new com.logic.dto.data.Character(3,3, Direction.NORTH, "Ardyn", "Chieur", "", CharacterState.ALIVE, Allegiance.J1, new Weapon(3, false, "epee", WeaponType.SWORD, ElementType.AIR), new CharacterClass(3,0.1f,0.1f,0.1f), new Stats(20,20,8,5,7,0,100));
    private World world;
    private RenderRange rr;
    private boolean hasRendered = false;*/


    //Test dirty flags and animation

    private double elapsedTime;
    private double currentTime;
    private double lastTime;
    private double fps = (1.0/60);
    /*private Vector2f[][] texList;
    private int pointer;*/

    /*private Sprite animation;*/
    //private int degrees = 0;

    private UIRenderer UIRenderer;

    public BatteSceneTest(Window window) {
        this.window = window;
        /*for (int i = 0; i < terrain.length; i++) {
            for (int j = 0; j < terrain[i].length; j++) {
                terrain[i][j] = new Tile(i,j);
            }
        }

        world = new World(terrain);
        world.addCharacter(ardyn);*/
        elapsedTime = 0;
        currentTime = 0;
        lastTime = Time.getTime();

    }


    @Override
    public void preprocess() {
        //ts = new TestSpritesheet("./res/spritesheet/testspritesheet.png", 16, 16);

        renderBatch = new RenderBatch();
        UIRenderer = new UIRenderer();
        /*texList = new Vector2f[][]{
                ts.getSprite(TestSpriteEnum.STRAIGHT_ARROW, 0,0,0).getTexCoords(),
                ts.getSprite(TestSpriteEnum.END_ARROW, 0,0,0).getTexCoords(),
                ts.getSprite(TestSpriteEnum.SOURCE_ARROW, 0,0,0).getTexCoords(),
                ts.getSprite(TestSpriteEnum.TURN_ARROW, 0,0,0).getTexCoords(),
                ts.getSprite(TestSpriteEnum.MOVE_PATH, 0,0,0).getTexCoords(),
                ts.getSprite(TestSpriteEnum.ATTACK_PATH, 0,0,0).getTexCoords()
        };


        pathRenderer = new RenderedPath();

        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[i].length; j++) {
                map[i][j] = new ASPoint(i, j, true);
            }
        }
        pathfinder = new AStarFinder(map);
        try {
            path = pathfinder.calculatePath(new PathPoint(x, y, true), new PathPoint(x +3, y + 2, true), 20);
        } catch (TargetUnreachableException e) {
            e.printStackTrace();
        }
        pathRenderer.init(path);*/
        //rr = new RenderRange();
        //animation = new Sprite(0,0,new Texture("./res/fonts/Nivalt.png"), NivalisSriteSheet.getGlyph('A',0,0).getTexCoords(), 0);
        //renderBatch.addSprite(animation);
        UIRenderer.addComponent(new UIPannel(new Vector2f(0,0), new Vector4f(0.6f,0.0f,0.0f,1.0f),3,3, 0.5f, UIRenderer));
        //UIPannel pannel = (UIPannel) UIRenderer.getComponent(0);
        //pannel.addChild(new UIBar(new Vector2f(pannel.x(), pannel.y()), new Vector4f(0.0f,0.0f,0.0f,1.0f),3,1,1.0f));
    }

    @Override
    public void loop(Camera camera) {


        /*this.currentTime = Time.getTime();
        this.elapsedTime += currentTime - lastTime;
        if (elapsedTime >= fps) {
            elapsedTime -= fps;
            float time = (float) Time.timer() * 0.00001f;
            float color = (float) Math.abs(Math.cos(time));
            pannel.setColor(new Vector4f(0.0f,color,1.0f,1.0f));
        }*/
        //animation.setTexCoords(ts.getSprite(TestSpriteEnum.TURN_ARROW, 0,0,degrees).getTexCoords());
        //if (degrees >= 360) degrees = 0;


        //this.lastTime = currentTime;

        //renderBatch.render(camera);

        /*if (Key.isKeyPressed(GLFW_KEY_SPACE)) {
            if (!hasRendered) {
                rr.init(Range.getRange(ardyn, world));
                hasRendered = true;
            }
            rr.render(camera);
        }*/





        //pathRenderer.render(window.getCamera());
        /*if (((Mouse.getX() > window.getWidth() / 2 - 16) && (Mouse.getX() < window.getWidth() / 2 + 16 ) &&
                (Mouse.getY() > window.getHeight() / 2 - 16  && (Mouse.getY() < window.getHeight() / 2 + 16)) && Mouse.mouseButtonDown(GLFW_MOUSE_BUTTON_1)) || (onDrag && Mouse.mouseButtonDown(GLFW_MOUSE_BUTTON_1))) {
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


        }*/
    }



}
