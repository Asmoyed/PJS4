package com.view;

import nivalis.engine.render.Sprite;
import nivalis.engine.render.Texture;
import org.joml.Vector2f;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Vector;

import static com.view.MainSpriteEnum.KN_I6;

public class MainSpriteSheet {
    private final String PATH = "./res/spritesheet/mainSpriteSheet.png";
    private BufferedImage source;
    private int width;
    private int height;
    private int spriteWidth = 32;
    private int spriteHeight = 32;

    public MainSpriteSheet(){
        try {
            source = ImageIO.read(new File(PATH));
        } catch (IOException e) {
            e.printStackTrace();
        }
        width = source.getWidth();
        height = source.getHeight();
    }





    public Sprite getSprite(MainSpriteEnum id, int x, int y, int rotation) {
        Vector2f[] coordinates;
        float xPos = 0.0f;
        float yPos = 0.0f;
        if (id == MainSpriteEnum.STRAIGHT_ARROW) {
            xPos = 0.0f;
            yPos = 0.0f;
        }
        if (id == MainSpriteEnum.SOURCE_ARROW) {
            xPos = 1.0f;
            yPos = 0.0f;
        }
        if (id == MainSpriteEnum.TURN_ARROW) {
            xPos = 2.0f;
            yPos = 0.0f;
        }
        if (id == MainSpriteEnum.END_ARROW) {
            xPos = 3.0f;
            yPos = 0.0f;
        }
        if (id == MainSpriteEnum.MOVE) {
            xPos = 4.0f;
            yPos = 0.0f;
        }
        if (id == MainSpriteEnum.ATTACK) {
            xPos = 5.0f;
            yPos = 0.0f;
        }
        if (id == MainSpriteEnum.CORE_SLAB) {
            xPos = 0.0f;
            yPos = 1.0f;
        }
        if (id == MainSpriteEnum.SLAB) {
            xPos = 1.0f;
            yPos = 1.0f;
        }
        if (id == MainSpriteEnum.SLAB_BIS) {
            xPos = 2.0f;
            yPos = 1.0f;
        }
        if (id == MainSpriteEnum.PIPE_H) {
            xPos = 3.0f;
            yPos = 1.0f;
        }
        if (id == MainSpriteEnum.PIPE_V) {
            xPos = 4.0f;
            yPos = 1.0f;
        }
        if (id == MainSpriteEnum.PIPE_LT) {
            xPos = 5.0f;
            yPos = 1.0f;
        }
        if (id == MainSpriteEnum.PIPE_BR) {
            xPos = 6.0f;
            yPos = 1.0f;
        }
        if (id == MainSpriteEnum.PIPE_TR) {
            xPos = 7.0f;
            yPos = 1.0f;
        }
        if (id == MainSpriteEnum.PIPE_LB) {
            xPos = 8.0f;
            yPos = 0.0f;
        }
        if (id == MainSpriteEnum.GRASS) {
            xPos = 0.0f;
            yPos = 2.0f;
        }
        if (id == MainSpriteEnum.GRASS_BB) {
            xPos = 1.0f;
            yPos = 2.0f;
        }
        if (id == MainSpriteEnum.GRASS_TB) {
            xPos = 2.0f;
            yPos = 2.0f;
        }
        if (id == MainSpriteEnum.GRASS_LB) {
            xPos = 3.0f;
            yPos = 2.0f;
        }
        if (id == MainSpriteEnum.GRASS_RB) {
            xPos = 4.0f;
            yPos = 2.0f;
        }
        if (id == MainSpriteEnum.GRASS_BRB) {
            xPos = 5.0f;
            yPos = 2.0f;
        }
        if (id == MainSpriteEnum.GRASS_BLB) {
            xPos = 6.0f;
            yPos = 2.0f;
        }
        if (id == MainSpriteEnum.GRASS_TLB) {
            xPos = 7.0f;
            yPos = 2.0f;
        }
        if (id == MainSpriteEnum.GRASS_TRB) {
            xPos = 8.0f;
            yPos = 2.0f;
        }
        if (id == MainSpriteEnum.TOPWALL_ONE) {
            xPos = 0.0f;
            yPos = 3.0f;
        }
        if (id == MainSpriteEnum.TOPWALL_TWO) {
            xPos = 1.0f;
            yPos = 3.0f;
        }
        if (id == MainSpriteEnum.TOPWALL_THREE) {
            xPos = 2.0f;
            yPos = 3.0f;
        }
        if (id == MainSpriteEnum.BRICK_BR) {
            xPos = 3.0f;
            yPos = 3.0f;
        }
        if (id == MainSpriteEnum.BRICK_LB) {
            xPos = 4.0f;
            yPos = 3.0f;
        }
        if (id == MainSpriteEnum.BRICK_LT) {
            xPos = 5.0f;
            yPos = 3.0f;
        }
        if (id == MainSpriteEnum.BRICK_RT) {
            xPos = 6.0f;
            yPos = 3.0f;
        }
        if (id == MainSpriteEnum.TREE_ONE) {
            xPos = 7.0f;
            yPos = 3.0f;
        }
        if (id == MainSpriteEnum.TREE_TWO) {
            xPos = 8.0f;
            yPos = 3.0f;
        }
        if (id == MainSpriteEnum.WALL_ONE) {
            xPos = 0.0f;
            yPos = 4.0f;
        }
        if (id == MainSpriteEnum.WALL_TWO) {
            xPos = 1.0f;
            yPos = 4.0f;
        }
        if (id == MainSpriteEnum.WALL_THREE) {
            xPos = 4.0f;
            yPos = 3.0f;
        }
        if (id == MainSpriteEnum.RIGHT_WALL) {
            xPos = 3.0f;
            yPos = 4.0f;
        }
        if (id == MainSpriteEnum.LEFT_WALL) {
            xPos = 4.0f;
            yPos = 4.0f;
        }
        if (id == MainSpriteEnum.KN_I0) {
            xPos = 0.0f;
            yPos = 5.0f;
        }
        if (id == MainSpriteEnum.KN_I1) {
            xPos = 1.0f;
            yPos = 5.0f;
        }
        if (id == MainSpriteEnum.KN_I2) {
            xPos = 2.0f;
            yPos = 5.0f;
        }
        if (id == MainSpriteEnum.KN_I3) {
            xPos = 3.0f;
            yPos = 5.0f;
        }
        if (id == MainSpriteEnum.KN_I4) {
            xPos = 4.0f;
            yPos = 5.0f;
        }
        if (id == MainSpriteEnum.KN_I5) {
            xPos = 5.0f;
            yPos = 5.0f;
        }
        if (id == MainSpriteEnum.KN_I6) {
            xPos = 6.0f;
            yPos = 5.0f;
        }
        if (id == MainSpriteEnum.A) {
            xPos = 0.0f;
            yPos = 7.0f;
        }
        if (id == MainSpriteEnum.B) {
            xPos = 1.0f;
            yPos = 7.0f;
        }
        if (id == MainSpriteEnum.C) {
            xPos = 2.0f;
            yPos = 7.0f;
        }
        if (id == MainSpriteEnum.D) {
            xPos = 3.0f;
            yPos = 7.0f;
        }
        if (id == MainSpriteEnum.E) {
            xPos = 4.0f;
            yPos = 7.0f;
        }
        if (id == MainSpriteEnum.F) {
            xPos = 5.0f;
            yPos = 7.0f;
        }
        if (id == MainSpriteEnum.G) {
            xPos = 6.0f;
            yPos = 7.0f;
        }
        if (id == MainSpriteEnum.H) {
            xPos = 7.0f;
            yPos = 7.0f;
        }
        if (id == MainSpriteEnum.I) {
            xPos = 8.0f;
            yPos = 7.0f;
        }
        if (id == MainSpriteEnum.J) {
            xPos = 0.0f;
            yPos = 8.0f;
        }
        if (id == MainSpriteEnum.K) {
            xPos = 1.0f;
            yPos = 8.0f;
        }
        if (id == MainSpriteEnum.L) {
            xPos = 2.0f;
            yPos = 8.0f;
        }
        if (id == MainSpriteEnum.M) {
            xPos = 3.0f;
            yPos = 8.0f;
        }
        if (id == MainSpriteEnum.N) {
            xPos = 4.0f;
            yPos = 8.0f;
        }
        if (id == MainSpriteEnum.O) {
            xPos = 5.0f;
            yPos = 8.0f;
        }
        if (id == MainSpriteEnum.P) {
            xPos = 6.0f;
            yPos = 8.0f;
        }
        if (id == MainSpriteEnum.Q) {
            xPos = 7.0f;
            yPos = 8.0f;
        }
        if (id == MainSpriteEnum.R) {
            xPos = 8.0f;
            yPos = 8.0f;
        }
        if (id == MainSpriteEnum.S) {
            xPos = 0.0f;
            yPos = 9.0f;
        }
        if (id == MainSpriteEnum.T) {
            xPos = 1.0f;
            yPos = 9.0f;
        }
        if (id == MainSpriteEnum.U) {
            xPos = 2.0f;
            yPos = 9.0f;
        }
        if (id == MainSpriteEnum.V) {
            xPos = 3.0f;
            yPos = 9.0f;
        }
        if (id == MainSpriteEnum.W) {
            xPos = 4.0f;
            yPos = 9.0f;
        }
        if (id == MainSpriteEnum.X) {
            xPos = 5.0f;
            yPos = 9.0f;
        }
        if (id == MainSpriteEnum.Y) {
            xPos = 6.0f;
            yPos = 9.0f;
        }
        if (id == MainSpriteEnum.Z) {
            xPos = 7.0f;
            yPos = 9.0f;
        }

        if (id == MainSpriteEnum.a) {
            xPos = 0.0f;
            yPos = 10.0f;
        }
        if (id == MainSpriteEnum.b) {
            xPos = 1.0f;
            yPos = 10.0f;
        }
        if (id == MainSpriteEnum.c) {
            xPos = 2.0f;
            yPos = 10.0f;
        }
        if (id == MainSpriteEnum.d) {
            xPos = 3.0f;
            yPos = 10.0f;
        }
        if (id == MainSpriteEnum.e) {
            xPos = 4.0f;
            yPos = 10.0f;
        }
        if (id == MainSpriteEnum.f) {
            xPos = 5.0f;
            yPos = 10.0f;
        }
        if (id == MainSpriteEnum.g) {
            xPos = 6.0f;
            yPos = 10.0f;
        }
        if (id == MainSpriteEnum.h) {
            xPos = 7.0f;
            yPos = 10.0f;
        }
        if (id == MainSpriteEnum.i) {
            xPos = 8.0f;
            yPos = 10.0f;
        }
        if (id == MainSpriteEnum.j) {
            xPos = 0.0f;
            yPos = 11.0f;
        }
        if (id == MainSpriteEnum.k) {
            xPos = 1.0f;
            yPos = 11.0f;
        }
        if (id == MainSpriteEnum.l) {
            xPos = 2.0f;
            yPos = 11.0f;
        }
        if (id == MainSpriteEnum.m) {
            xPos = 3.0f;
            yPos = 11.0f;
        }
        if (id == MainSpriteEnum.n) {
            xPos = 4.0f;
            yPos = 11.0f;
        }
        if (id == MainSpriteEnum.o) {
            xPos = 5.0f;
            yPos = 11.0f;
        }
        if (id == MainSpriteEnum.p) {
            xPos = 6.0f;
            yPos = 11.0f;
        }
        if (id == MainSpriteEnum.q) {
            xPos = 7.0f;
            yPos = 11.0f;
        }
        if (id == MainSpriteEnum.r) {
            xPos = 8.0f;
            yPos = 11.0f;
        }
        if (id == MainSpriteEnum.s) {
            xPos = 0.0f;
            yPos = 12.0f;
        }
        if (id == MainSpriteEnum.t) {
            xPos = 1.0f;
            yPos = 12.0f;
        }
        if (id == MainSpriteEnum.u) {
            xPos = 2.0f;
            yPos = 12.0f;
        }
        if (id == MainSpriteEnum.v) {
            xPos = 3.0f;
            yPos = 12.0f;
        }
        if (id == MainSpriteEnum.w) {
            xPos = 4.0f;
            yPos = 12.0f;
        }
        if (id == MainSpriteEnum.x) {
            xPos = 5.0f;
            yPos = 12.0f;
        }
        if (id == MainSpriteEnum.y) {
            xPos = 6.0f;
            yPos = 12.0f;
        }
        if (id == MainSpriteEnum.z) {
            xPos = 7.0f;
            yPos = 12.0f;
        }

        coordinates = new Vector2f[] {
            new Vector2f(((xPos + 1) * spriteWidth)/ width, ((yPos)* spriteHeight)/ height),
                new Vector2f(((xPos + 1) * spriteWidth)/ width, ((yPos + 1)* spriteHeight)/ height),
                new Vector2f(((xPos) * spriteWidth)/ width, ((yPos + 1)* spriteHeight)/ height),
                new Vector2f(((xPos) * spriteWidth)/ width, ((yPos)* spriteHeight)/ height)
        };
        return new Sprite(x,y,new Texture(PATH), rotate(rotation, coordinates),1.0f);
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
