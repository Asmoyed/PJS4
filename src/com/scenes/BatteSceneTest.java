package com.scenes;


import com.logic.dto.data.*;
import com.logic.utils.observer.Observable;
import nivalis.engine.controls.KeyListener;
import nivalis.engine.transform.Camera;
import nivalis.utils.animation.Animation;
import nivalis.utils.scene.Scene;

import com.logic.dto.data.Character;

import static org.lwjgl.glfw.GLFW.GLFW_KEY_D;

public class BatteSceneTest extends Observable implements Scene {

    Character ardyn = new Character(0,0, Direction.NORTH, "Ardyn", "Perlegrand", "Un jeune soldat plein d'ambition", CharacterState.ALIVE, Allegiance.J1, new CharacterClass(5,0.5f,0.5f,0.5f,0.4f), new Stats(20,20,8,5,7,0,100));

    @Override
    public void preprocess() {
        ardyn.sub(this);
        ardyn.setAnimation(new Animation(1,24,"./res/animation"));
    }

    @Override
    public void gameLoop(Camera camera) {
        ardyn.update(camera.getProjection());
        /*if (KeyListener.isKeyPressed(GLFW_KEY_D)){
            System.out.println("D pressed");
            super.notify("up");
        }*/
    }


}
