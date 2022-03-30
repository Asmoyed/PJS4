package com.logic.dto;

import com.logic.dto.data.*;
import com.sun.org.apache.xpath.internal.operations.Gt;
import com.view.MainSpriteEnum;

public class Maps {
    public static Tile[][] introMap = new Tile[][] {
            new Tile[]{new GrassTile(0,0),new GrassTile(1,0),new GrassTile(2,0),new GrassTile(3,0),new GrassTile(4,0),new GrassTile(5,0),new GrassTile(6,0),new GrassTile(7,0),new GrassTile(8,0),new GrassTile(9,0),new GrassTile(10,0),new GrassTile(11,0)},
            new Tile[]{new GrassTile(0,1),new GrassTile(1,1),new GrassTile(2,1),new GrassTile(3,1),new GrassTile(4,1),new GrassTile(5,1),new GrassTile(6,1),new GrassTile(7,1),new GrassTile(8,1),new GrassTile(9,1),new GrassTile(10,1),new GrassTile(11,1)},
            new Tile[]{new GrassTile(0,2), new GrassTile(1,2), new GrassTile(2,2), new GrassTile(3,2),new Slab(4,2), new Slab(5,2), new Slab(6,2), new GrassTile(7,2), new GrassTile(8,2), new GrassTile(9,2),new GrassTile(10,2), new GrassTile(11,2)},
            new Tile[]{new GrassTile(0,3), new GrassTile(1,3), new GrassTile(2,3), new Slab(3,3), new CoreSlabTile(4,3), new Slab(5,3), new CoreSlabTile(6,3), new Slab(7,3), new GrassTile(8,3), new GrassTile(9,3), new GrassTile(10,3), new GrassTile(11,3)},
            new Tile[]{new PipeSlab(0,4), new PipeSlab(1,4), new PipeSlab(2,4), new PipeSlab(3,4), new PipeSlab(4,4), new PipeSlab(5,4), new PipeSlab(6,4), new PipeSlab(7,4), new PipeSlab(8,4), new PipeSlab(9,4), new PipeSlab(10,4), new PipeSlab(11,4)},
            new Tile[]{new Slab(0,5), new Slab(1,5), new Slab(2,5), new Slab(3,5), new Slab(4,5), new Slab(5,5), new Slab(6,5), new Slab(7,5), new Slab(8,5), new Slab(9,5), new Slab(10,5), new Slab(11,5)},
            new Tile[]{new Slab(0,6), new Slab(1,6), new Slab(2,6), new Slab(3,6), new Slab(4,6), new Slab(5,6), new Slab(6,6), new Slab(7,6), new Slab(8,6), new Slab(9,6), new Slab(10,6), new Slab(11,6)},
            new Tile[]{new PipeSlab(0,7), new PipeSlab(1,7), new PipeSlab(2,7), new PipeSlab(3,7), new PipeSlab(4,7), new PipeSlab(5,7), new PipeSlab(6,7), new PipeSlab(7,7), new PipeSlab(8,7), new PipeSlab(9,7), new PipeSlab(10,7), new PipeSlab(11,7)},
            new Tile[]{new GrassTile(0,8), new GrassTile(1,8), new GrassTile(2,8), new Slab(3,8),new CoreSlabTile(4,8), new Slab(5,8), new CoreSlabTile(6,8), new Slab(7,8), new GrassTile(8,8), new GrassTile(9,8), new GrassTile(10,8), new GrassTile(11,8)},
            new Tile[]{new GrassTile(0,9), new GrassTile(1,9), new GrassTile(2,9),new GrassTile(3,9), new Slab(4,9), new Slab(5,9), new Slab(6,9), new GrassTile(7,9), new GrassTile(8,9), new GrassTile(9,9), new GrassTile(10,9), new GrassTile(11,9)},
            new Tile[]{new GrassTile(0,10), new GrassTile(1,10), new GrassTile(2,10), new GrassTile(3,10), new GrassTile(4,10), new GrassTile(5,10), new GrassTile(6,10), new GrassTile(7,10), new GrassTile(8,10), new GrassTile(9,10), new GrassTile(10,10), new GrassTile(11,10)},
            new Tile[]{new GrassTile(0,11), new GrassTile(1,11), new GrassTile(2,11), new GrassTile(3,11), new GrassTile(4,11), new GrassTile(5,11), new GrassTile(6,11), new GrassTile(7,11), new GrassTile(8,11), new GrassTile(9,11), new GrassTile(10,11), new GrassTile(11,11)}
    };

    public static MainSpriteEnum[][] introMapVue = new MainSpriteEnum[][] {
            new MainSpriteEnum[] {MainSpriteEnum.GRASS, MainSpriteEnum.GRASS, MainSpriteEnum.GRASS, MainSpriteEnum.GRASS, MainSpriteEnum.GRASS, MainSpriteEnum.GRASS, MainSpriteEnum.GRASS, MainSpriteEnum.GRASS, MainSpriteEnum.GRASS,MainSpriteEnum.GRASS,MainSpriteEnum.GRASS, MainSpriteEnum.GRASS},
            new MainSpriteEnum[] {MainSpriteEnum.GRASS, MainSpriteEnum.GRASS,MainSpriteEnum.GRASS, MainSpriteEnum.BRICK_RT, MainSpriteEnum.GRASS_TB, MainSpriteEnum.GRASS_TB, MainSpriteEnum.GRASS_TB, MainSpriteEnum.BRICK_LT, MainSpriteEnum.GRASS, MainSpriteEnum.GRASS, MainSpriteEnum.GRASS, MainSpriteEnum.GRASS},
            new MainSpriteEnum[] {MainSpriteEnum.GRASS, MainSpriteEnum.GRASS, MainSpriteEnum.BRICK_RT, MainSpriteEnum.GRASS_TRB, MainSpriteEnum.SLAB, MainSpriteEnum.SLAB, MainSpriteEnum.SLAB, MainSpriteEnum.GRASS_TLB, MainSpriteEnum.BRICK_LT, MainSpriteEnum.GRASS, MainSpriteEnum.GRASS, MainSpriteEnum.GRASS},
            new MainSpriteEnum[] {MainSpriteEnum.GRASS_TB, MainSpriteEnum.GRASS_TB, MainSpriteEnum.GRASS_TRB, MainSpriteEnum.SLAB, MainSpriteEnum.CORE_SLAB, MainSpriteEnum.SLAB, MainSpriteEnum.CORE_SLAB, MainSpriteEnum.SLAB, MainSpriteEnum.GRASS_TLB, MainSpriteEnum.GRASS_TB, MainSpriteEnum.GRASS_TB, MainSpriteEnum.GRASS_TB},
            new MainSpriteEnum[] {MainSpriteEnum.PIPE_H, MainSpriteEnum.PIPE_H, MainSpriteEnum.PIPE_H,MainSpriteEnum.PIPE_H,MainSpriteEnum.PIPE_H, MainSpriteEnum.PIPE_H, MainSpriteEnum.PIPE_H, MainSpriteEnum.PIPE_H, MainSpriteEnum.PIPE_H, MainSpriteEnum.PIPE_H,MainSpriteEnum.PIPE_H, MainSpriteEnum.PIPE_H},
            new MainSpriteEnum[] {MainSpriteEnum.SLAB, MainSpriteEnum.SLAB, MainSpriteEnum.SLAB, MainSpriteEnum.SLAB, MainSpriteEnum.SLAB, MainSpriteEnum.SLAB,MainSpriteEnum.SLAB, MainSpriteEnum.SLAB, MainSpriteEnum.SLAB, MainSpriteEnum.SLAB ,MainSpriteEnum.SLAB ,MainSpriteEnum.SLAB},
            new MainSpriteEnum[] {MainSpriteEnum.SLAB, MainSpriteEnum.SLAB, MainSpriteEnum.SLAB, MainSpriteEnum.SLAB, MainSpriteEnum.SLAB, MainSpriteEnum.SLAB,MainSpriteEnum.SLAB, MainSpriteEnum.SLAB, MainSpriteEnum.SLAB, MainSpriteEnum.SLAB ,MainSpriteEnum.SLAB ,MainSpriteEnum.SLAB},
            new MainSpriteEnum[] {MainSpriteEnum.PIPE_H, MainSpriteEnum.PIPE_H, MainSpriteEnum.PIPE_H,MainSpriteEnum.PIPE_H,MainSpriteEnum.PIPE_H, MainSpriteEnum.PIPE_H, MainSpriteEnum.PIPE_H, MainSpriteEnum.PIPE_H, MainSpriteEnum.PIPE_H, MainSpriteEnum.PIPE_H,MainSpriteEnum.PIPE_H, MainSpriteEnum.PIPE_H},
            new MainSpriteEnum[] {MainSpriteEnum.GRASS_BB, MainSpriteEnum.GRASS_BB, MainSpriteEnum.GRASS_BRB, MainSpriteEnum.SLAB, MainSpriteEnum.CORE_SLAB, MainSpriteEnum.SLAB, MainSpriteEnum.CORE_SLAB, MainSpriteEnum.SLAB, MainSpriteEnum.GRASS_BLB, MainSpriteEnum.GRASS_BB, MainSpriteEnum.GRASS_BB, MainSpriteEnum.GRASS_BB},
            new MainSpriteEnum[] {MainSpriteEnum.GRASS, MainSpriteEnum.GRASS, MainSpriteEnum.BRICK_BR, MainSpriteEnum.GRASS_BRB, MainSpriteEnum.SLAB, MainSpriteEnum.SLAB, MainSpriteEnum.SLAB, MainSpriteEnum.GRASS_BLB, MainSpriteEnum.BRICK_LB, MainSpriteEnum.GRASS, MainSpriteEnum.GRASS, MainSpriteEnum.GRASS},
            new MainSpriteEnum[] {MainSpriteEnum.GRASS, MainSpriteEnum.GRASS, MainSpriteEnum.GRASS, MainSpriteEnum.BRICK_BR, MainSpriteEnum.GRASS_BB, MainSpriteEnum.GRASS_BB, MainSpriteEnum.GRASS_BB, MainSpriteEnum.BRICK_LB, MainSpriteEnum.GRASS, MainSpriteEnum.GRASS, MainSpriteEnum.GRASS, MainSpriteEnum.GRASS},
            new MainSpriteEnum[] {MainSpriteEnum.GRASS, MainSpriteEnum.GRASS, MainSpriteEnum.GRASS, MainSpriteEnum.GRASS, MainSpriteEnum.GRASS, MainSpriteEnum.GRASS, MainSpriteEnum.GRASS, MainSpriteEnum.GRASS, MainSpriteEnum.GRASS, MainSpriteEnum.GRASS, MainSpriteEnum.GRASS, MainSpriteEnum.GRASS}
    };
}
