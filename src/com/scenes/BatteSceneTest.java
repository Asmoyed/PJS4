package com.scenes;


import com.logic.dto.data.*;
import com.logic.renderedData.RenderedCharacter;
import com.logic.utils.observer.Observable;
import nivalis.engine.controls.KeyListener;
import nivalis.engine.transform.Camera;
import nivalis.utils.animation.Animation;
import nivalis.utils.scene.Scene;

import com.logic.dto.data.Character;

import static org.lwjgl.glfw.GLFW.GLFW_KEY_D;

public class BatteSceneTest implements Scene {

    RenderedCharacter ardyn = new RenderedCharacter(new Character(0,0,Direction.NORTH, "Ardyn", "Perlegrand", "Un jeune soldat plein d'ambition",CharacterState.ALIVE, Allegiance.J1, new CharacterClass(5,0.5f,0.5f,0.5f,0.4f), new Stats(20,20,8,5,7,0,100)),null);

    @Override
    public void preprocess() {

        ardyn.setAnimation(new Animation(1,24,"./res/animation"));
    }

    @Override
    public void gameLoop(Camera camera) {
        ardyn.update(camera.getProjection());

    }


}
