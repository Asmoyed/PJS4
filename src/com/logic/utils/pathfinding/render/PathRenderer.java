package com.logic.utils.pathfinding.render;

import com.logic.utils.pathfinding.dto.Path;
import com.logic.utils.pathfinding.dto.PathPoint;
import nivalis.engine.transform.Camera;
import nivalis.engine.transform.Transform;
import nivalis.utils.tiles.Tile;
import org.joml.Matrix4f;


import java.util.List;

public class PathRenderer {
    public static void render(Path path, Matrix4f camera) {
        for (int i = 0; i < path.getList().size();i++) {
            getRender(i, path.getList(), camera);
        }
    }

    private static void getRender(int count, List<PathPoint> path, Matrix4f camera) {
        int last = count - 1;

        int next = count + 1;
        try {
            if (path.get(last).getX() != path.get(count).getX() && path.get(last).getY() == path.get(count).getY()
            && path.get(next).getX() != path.get(count).getX() && path.get(next).getY() == path.get(count).getY()) {
                Transform t = new Transform(path.get(count).getX(), path.get(count).getY());
                new Tile("./res/testRessources/pathfind/straight.png").render(t.getProjection(camera));
            }
            if (path.get(next).getX() - path.get(last).getX() > 0){
                if (path.get(next).getY() - path.get(last).getY() > 0) {
                    Transform t = new Transform(path.get(count).getX(), path.get(count).getY());
                    new Tile("./res/testRessources/pathfind/turn.png").render(t.getProjection(camera));
                }
                else {
                    Transform t = new Transform(path.get(count).getX(), path.get(count).getY());
                    new Tile("./res/testRessources/pathfind/straight.png").render(t.getProjection(camera));
                }
            }
            else if (path.get(next).getX() - path.get(last).getX() < 0){
                if (path.get(next).getY() - path.get(last).getY() > 0) {
                    Transform t = new Transform(path.get(count).getX(), path.get(count).getY());
                    new Tile("./res/testRessources/pathfind/turn.png").render(t.getProjection(camera));
                }
                else {
                    Transform t = new Transform(path.get(count).getX(), path.get(count).getY());
                    new Tile("./res/testRessources/pathfind/straight.png").render(t.getProjection(camera));
                }
            }
        } catch (ArrayIndexOutOfBoundsException e) {
            if (count == 0) {
                if (path.get(next).getX() == path.get(count).getX()) {
                    if (path.get(next).getY() > path.get(count).getY()) {
                        Transform t = new Transform(path.get(count).getX(), path.get(count).getY());
                        new Tile("./res/testRessources/pathfind/source.png").render(t.getProjection(camera));
                    }
                    else {
                        Transform t = new Transform(path.get(count).getX(), path.get(count).getY());
                        new Tile("./res/testRessources/pathfind/source.png").render(t.getProjection(camera));
                    }
                }
                else if (path.get(next).getY() == path.get(count).getY()) {
                    if (path.get(next).getX() > path.get(count).getX()) {
                        Transform t = new Transform(path.get(count).getX(), path.get(count).getY());
                        new Tile("./res/testRessources/pathfind/source.png").render(t.getProjection(camera));
                    }
                    else {
                        Transform t = new Transform(path.get(count).getX(), path.get(count).getY());
                        new Tile("./res/testRessources/pathfind/source.png").render(t.getProjection(camera));
                    }
                }

            }
            else {
                if (path.get(next).getX() == path.get(count).getX()) {
                    if (path.get(next).getY() > path.get(count).getY()) {
                        Transform t = new Transform(path.get(count).getX(), path.get(count).getY());
                        new Tile("./res/testRessources/pathfind/end.png").render(t.getProjection(camera));
                    }
                    else {
                        Transform t = new Transform(path.get(count).getX(), path.get(count).getY());
                        new Tile("./res/testRessources/pathfind/end.png").render(t.getProjection(camera));
                    }
                }
                else if (path.get(next).getY() == path.get(count).getY()) {
                    if (path.get(next).getX() > path.get(count).getX()) {
                        Transform t = new Transform(path.get(count).getX(), path.get(count).getY());
                        new Tile("./res/testRessources/pathfind/end.png").render(t.getProjection(camera));
                    }
                    else {
                        Transform t = new Transform(path.get(count).getX(), path.get(count).getY());
                        new Tile("./res/testRessources/pathfind/end.png").render(t.getProjection(camera));
                    }
                }
            }
        }
    }



}
