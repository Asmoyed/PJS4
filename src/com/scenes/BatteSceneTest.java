package com.scenes;


import com.logic.dto.data.*;
import com.logic.renderedData.RenderedCharacter;
import com.logic.utils.observer.Observable;
import com.logic.utils.pathfinding.algos.AStarFinder;
import com.logic.utils.pathfinding.dto.ASPoint;
import nivalis.engine.controls.KeyListener;
import nivalis.engine.transform.Camera;
import nivalis.utils.animation.Animation;
import nivalis.utils.scene.Scene;

import com.logic.dto.data.Character;

import static org.lwjgl.glfw.GLFW.GLFW_KEY_D;

public class BatteSceneTest implements Scene {
    ASPoint[][] map = new ASPoint[7][5];

    RenderedCharacter ardyn = new RenderedCharacter(new Character(0,0,Direction.NORTH, "Ardyn", "Perlegrand", "Un jeune soldat plein d'ambition",CharacterState.ALIVE, Allegiance.J1, new CharacterClass(5,0.5f,0.5f,0.5f,0.4f), new Stats(20,20,8,5,7,0,100)),null, new AStarFinder(map));

    @Override
    public void preprocess() {
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[i].length; j++) {
                map[i][j] = new ASPoint(i,j,true);
            }
        }
        ardyn.setAnimation(new Animation(1,24,"./res/animation"));
    }

    @Override
    public void gameLoop(Camera camera) {
        ardyn.update(camera.getProjection());

    }


}
