package nivalis.tools;

import nivalis.engine.render.Sprite;
import nivalis.engine.render.Spritesheet;
import org.joml.Vector2f;

public class TestSpritesheet extends Spritesheet {
    public TestSpritesheet(String path, int spriteWidth, int spriteHeight) {
        super(path,spriteWidth, spriteHeight); // 16,16 pour les dimensions
    }

    public Sprite getSprite(TestSpriteEnum spriteID, int x, int y, int rotation) {
        Vector2f[] texCoords = null;
        if (spriteID == TestSpriteEnum.END_ARROW) {
            texCoords = new Vector2f[] {
                    new Vector2f(getSpriteWidth()/getWidth(),0),
                    new Vector2f(getSpriteWidth()/getWidth(),getSpriteHeight()/getHeight()),
                    new Vector2f(0,getSpriteHeight()/getHeight()),
                    new Vector2f(0,0)
            };
        }
        if (spriteID == TestSpriteEnum.SOURCE_ARROW) {
            texCoords = new Vector2f[] {

                    new Vector2f((getSpriteWidth())/getWidth(),getSpriteHeight()/getHeight()),
                    new Vector2f((getSpriteWidth())/getWidth(),(getSpriteHeight()*2)/getHeight()),
                    new Vector2f(0,(getSpriteHeight()*2)/getHeight()),
                    new Vector2f(0,getSpriteHeight()/getHeight())
            };
        }
        if (spriteID == TestSpriteEnum.STRAIGHT_ARROW) {
            texCoords = new Vector2f[] {

                    new Vector2f((getSpriteWidth()*2)/getWidth(),getSpriteHeight()/getHeight()),
                    new Vector2f((getSpriteWidth()*2)/getWidth(),(getSpriteHeight()*2)/getHeight()),
                    new Vector2f(getSpriteWidth()/getWidth(),(getSpriteHeight()*2)/getHeight()),
                    new Vector2f(getSpriteWidth()/getWidth(),getSpriteHeight()/getHeight()),
            };
        }
        if (spriteID == TestSpriteEnum.TURN_ARROW) {
            texCoords = new Vector2f[] {

                    new Vector2f((getSpriteWidth()*2)/getWidth(),0),//0
                    new Vector2f((getSpriteWidth()*2)/getWidth(),getSpriteHeight()/getHeight()) ,//1
                    new Vector2f((getSpriteWidth()/getWidth()),getSpriteHeight()/getHeight()),//2
                    new Vector2f((getSpriteWidth()/getWidth()),0)//3
            };
        }
        if (spriteID == TestSpriteEnum.ATTACK_PATH) {

            texCoords = new Vector2f[] {
                    new Vector2f((getSpriteWidth()*3)/ getWidth(),getSpriteHeight()/getHeight()),
                    new Vector2f((getSpriteWidth()*3)/ getWidth(),(getSpriteHeight()*2)/getHeight()),
                    new Vector2f((getSpriteWidth()*2)/getWidth(),(getSpriteHeight()*2)/getHeight()),
                    new Vector2f((getSpriteWidth()*2)/getWidth(),getSpriteHeight()/getHeight())
            };
        }
        if (spriteID == TestSpriteEnum.MOVE_PATH) {
            texCoords = new Vector2f[] {
                    new Vector2f((getSpriteWidth()*3)/ getWidth(),0),
                    new Vector2f((getSpriteWidth()*3)/ getWidth(),getSpriteHeight()/getHeight()),
                    new Vector2f((getSpriteWidth()*2)/getWidth(),getSpriteHeight()/getHeight()),
                    new Vector2f((getSpriteWidth()*2)/getWidth(),0)
            };
        }
        return new Sprite(x, y, getTexture(), rotate(rotation,texCoords), rotation);
    }

    private Vector2f[] rotate(int degrees, Vector2f[] texCoords) {
        Vector2f[] returnValue = new Vector2f[4];
        if (degrees == 90) {
            returnValue[0] = texCoords[1];
            returnValue[1] = texCoords[2];
            returnValue[2] = texCoords[3];
            returnValue[3] = texCoords[0];
        }
        if (degrees == 180) {
            returnValue[0] = texCoords[0];
            returnValue[1] = texCoords[3];
            returnValue[2] = texCoords[2];
            returnValue[3] = texCoords[1];
        }
        if (degrees == 270) {
            returnValue[0] = texCoords[3];
            returnValue[1] = texCoords[2];
            returnValue[2] = texCoords[1];
            returnValue[3] = texCoords[0];
        }
        if (degrees == 0 || degrees >= 360) returnValue = texCoords;
        return returnValue;
    }
}
