package com.logic.renderedData;

import nivalis.engine.controls.KeyListener;
import nivalis.engine.transform.Transform;
import nivalis.engine.util.Time;
import nivalis.utils.animation.Animation;
import nivalis.utils.eventHandling.Update;
import org.joml.Matrix4f;
import com.logic.dto.data.Character;

import static org.lwjgl.glfw.GLFW.*;

public class RenderedCharacter implements Update {
    private Character character;
    private Animation animation;
    private double time;
    private double secondTime;
    private double elapsedTime;
    private boolean canMove;

    public RenderedCharacter(Character character, Animation animation) {
        this.character = character;
        this.animation = animation;
        time = Time.getTime();
        canMove = true;
    }


    /*
    * What has to be done. We press a key for movement and if it is. We disable every moment and declare a time. If movement
    * is disabled, we update the second time until it's up to one second. Then we enable the movement again.
    */

    @Override
    public void update(Matrix4f matrix4f) {
        if (canMove && character.getCharacterClass().getMovementPoint() > 1) {
            if (KeyListener.isKeyPressed(GLFW_KEY_W)) {
                character.setY(character.getY() + 1);
                canMove = false;
                reduceMP();
                time = Time.getTime();
            }
            if (KeyListener.isKeyPressed(GLFW_KEY_S)) {
                character.setY(character.getY() - 1);
                canMove = false;
                reduceMP();
                time = Time.getTime();
            }
            if (KeyListener.isKeyPressed(GLFW_KEY_A)){
                character.setX(character.getX() - 1);
                canMove = false;
                reduceMP();
                time = Time.getTime();
            }
            if (KeyListener.isKeyPressed(GLFW_KEY_D)){
                character.setX(character.getX() + 1);
                canMove = false;
                reduceMP();
                time = Time.getTime();
            }
        }
        else {
            secondTime = Time.getTime();
            elapsedTime += secondTime - time;
            if (elapsedTime >= 2) {
                canMove = true;
            }
        }

        animation.render(new Transform(character.getX(), character.getY()).getProjection(matrix4f));
    }

    public void reduceMP() {
        character.getCharacterClass().setMovementPoint(character.getCharacterClass().getMovementPoint() - 1);
    }

    public Character getCharacter() {
        return character;
    }

    public Animation getAnimation() {
        return animation;
    }

    public double getTime() {
        return time;
    }

    public double getSecondTime() {
        return secondTime;
    }

    public boolean isCanMove() {
        return canMove;
    }

    public void setCharacter(Character character) {
        this.character = character;
    }

    public void setAnimation(Animation animation) {
        this.animation = animation;
    }

    public void setTime(double time) {
        this.time = time;
    }

    public void setSecondTime(double secondTime) {
        this.secondTime = secondTime;
    }

    public void setCanMove(boolean canMove) {
        this.canMove = canMove;
    }
}
