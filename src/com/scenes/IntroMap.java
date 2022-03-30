package com.scenes;

import com.logic.battleHelper.Range;
import com.logic.battleHelper.RenderRange;
import com.logic.dto.Maps;
import com.logic.dto.data.Character;
import com.logic.dto.data.Tile;
import com.logic.dto.data.World;
import com.logic.dto.serialization.ObjectParsingException;
import com.logic.dto.serialization.Serializer;
import com.logic.utils.pathfinding.algos.AStarFinder;
import com.logic.utils.pathfinding.dto.Path;
import com.logic.utils.pathfinding.dto.PathPoint;
import com.logic.utils.pathfinding.exception.TargetUnreachableException;
import com.logic.utils.pathfinding.render.RenderedPath;
import com.sun.deploy.panel.PathRenderer;
import com.view.MainSpriteEnum;
import com.view.MainSpriteSheet;
import com.view.RenderedCharacter;
import nivalis.engine.render.RenderBatch;
import nivalis.engine.render.Sprite;
import nivalis.engine.utils.Time;
import nivalis.engine.window.Window;
import nivalis.tools.controls.Key;
import nivalis.tools.controls.Mouse;
import nivalis.tools.game.Scene;
import nivalis.tools.transform.Camera;
import org.joml.Vector3f;
import org.joml.Vector4f;

import static org.lwjgl.glfw.GLFW.*;

public class IntroMap implements Scene {

    private Window window;

    private World data;
    private Tile[][] map;
    private RenderBatch vue;
    private RenderBatch characters;
    private MainSpriteSheet spriteSheet;
    private Sprite cursor = new Sprite(0,0,new Vector4f(1.0f,1.0f,0.0f,0.2f), 1.0f);
    private Character character;
    private RenderRange rangeRenderer;
    private RenderedPath pathRenderer;
    private AStarFinder pathfinder;
    private RenderedCharacter rCharacter;
    private int lastX;
    private int lastY;


    private double time = 0.0f;
    public IntroMap(Window window) {
        this.window = window;
        spriteSheet = new MainSpriteSheet();
        data = new World(Maps.introMap);
        try {
            character = (Character) Serializer.deserialize(Character.class,"./data/ardyn.json");
        } catch (ObjectParsingException e) {
            e.printStackTrace();
        }
        character.setX(0);character.setY(0);
        data.addCharacter(character);
        System.out.println(character.toString());
        pathfinder = new AStarFinder(data);

    }


    @Override
    public void preprocess() {
        vue = new RenderBatch();
        characters = new RenderBatch();
        for (int i = 0; i < Maps.introMapVue.length; i++) {
            for (int j = 0; j < Maps.introMapVue[i].length; j++) {
                vue.addSprite(spriteSheet.getSprite(Maps.introMapVue[i][j],j,i,0));
            }
        }
        vue.addSprite(cursor);
        rangeRenderer = new RenderRange();
        pathRenderer = new RenderedPath();
        rCharacter = new RenderedCharacter(character,5,7,8);
        characters.addSprite(rCharacter.getSprite());
        lastX = (int) Mouse.getNormX(window.getCamera());
        lastY = (int) Mouse.getNormY(window.getCamera());

    }

    @Override
    public void loop(Camera camera) {
        time += Time.getTime();
        vue.render(camera);
        //System.out.println(((int) Mouse.getNormX(camera)) + " : " + ((int) Mouse.getNormY(camera)));
        cursor.setCoords((int)(Mouse.getNormX(camera)), (int)(Mouse.getNormY(camera)));
        rCharacter.update();
        if ((int)Mouse.getNormX(camera) == character.getX() && (int)Mouse.getNormY(camera) == character.getY() || (Mouse.getNormY(camera) != character.getY() && Mouse.getNormX(camera) != character.getX() && Mouse.isDragging())) {
            rangeRenderer.init(Range.getRange(character, data));
            rangeRenderer.render(camera);
            if (Mouse.mouseButtonDown(GLFW_MOUSE_BUTTON_1)) {

                 if(Mouse.isDragging()) {


                     if ((int)Mouse.getNormX(camera) != character.getX() || (int)Mouse.getNormY(camera) != character.getY()) {

                         try {
                             pathRenderer.init(pathfinder.calculatePath(new PathPoint(character.getX(), character.getY(), true), new PathPoint(character.getX() + (int)Mouse.getNormX(camera), character.getY() + (int) Mouse.getNormY(camera), true), character.getCharacterClass().getMovementPoint()));
                             lastX = (int)Mouse.getNormX(camera);
                             lastY = (int)Mouse.getNormY(camera);
                         } catch (TargetUnreachableException e) {
                             e.printStackTrace();
                         }

                     }


                     pathRenderer.render(camera);
                }

            }
        }
        characters.render(camera);
    }
}
