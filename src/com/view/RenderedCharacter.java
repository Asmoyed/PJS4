package com.view;

import com.logic.utils.pathfinding.render.RenderedPath;
import nivalis.engine.render.Sprite;
import nivalis.engine.utils.Time;
import com.logic.dto.data.Character;


public class RenderedCharacter {
    private Character character;
    private int xACord;
    private int yMaxCord;
    private int pointer;
    private Sprite sprite;
    private double elapsedTime;
    private double currentTime;
    private double lastTime;
    private double fps;
    private MainSpriteSheet spriteSheet = new MainSpriteSheet();
    private MainSpriteEnum[] frames = new MainSpriteEnum[] {MainSpriteEnum.KN_I0,MainSpriteEnum.KN_I1,MainSpriteEnum.KN_I2,MainSpriteEnum.KN_I3,MainSpriteEnum.KN_I4,MainSpriteEnum.KN_I5,MainSpriteEnum.KN_I6};

    public RenderedCharacter(Character character,int xACord,int yMaxCord, int fps) {
        this.character = character;
        this.xACord = xACord;
        this.yMaxCord = yMaxCord;
        this.elapsedTime = 0;
        this.currentTime = 0;
        pointer = 0;
        this.lastTime = Time.getTime();
        this.fps = 1.0/(double)fps;
        sprite = spriteSheet.getSprite(frames[pointer],0,0,0);
    }

    public void update() {
        this.currentTime = Time.getTime();
        this.elapsedTime += currentTime - lastTime;
        if (elapsedTime >= fps) {
            elapsedTime -= fps;
            pointer++;
            sprite.setTexCoords(spriteSheet.getSprite(frames[pointer-1],0,0,0).getTexCoords());
        }
        if (pointer >= frames.length) pointer = 0;
        this.lastTime = currentTime;

    }

    public Sprite getSprite() {
        return sprite;
    }
}
