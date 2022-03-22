package com.logic.utils.pathfinding.interfaces;

import com.logic.utils.pathfinding.dto.Path;
import com.logic.utils.pathfinding.dto.PathPoint;
import com.logic.utils.pathfinding.exception.TargetUnreachableException;

public interface IPathfinder
{
    Path calculatePath(PathPoint origin, PathPoint target, int maxCost) throws TargetUnreachableException;
}
