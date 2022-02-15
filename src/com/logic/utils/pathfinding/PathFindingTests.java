package com.logic.utils.pathfinding;

import com.logic.utils.pathfinding.dto.JPSPoint;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PathFindingTests
{
    @Test
    public void testOffset()
    {
        JPSPoint p = new JPSPoint(1, 1, JPSPoint.NORTH);
        p.shiftPoint();
        assert(p.getX() == 0);

        p = new JPSPoint(1, 1, JPSPoint.SOUTH);
        p.shiftPoint();
        assert(p.getX() == 2);

        p = new JPSPoint(1, 1, JPSPoint.EAST);
        p.shiftPoint();
        assert(p.getY() == 2);

        p = new JPSPoint(1, 1, JPSPoint.WEST);
        p.shiftPoint();
        assert(p.getY() == 0);

        p = new JPSPoint(1, 1, JPSPoint.NORTH_EAST);
        p.shiftPoint();
        assert(p.getX() == 0 && p.getY() == 2);

        p = new JPSPoint(1, 1, JPSPoint.NORTH_WEST);
        p.shiftPoint();
        assert(p.getX() == 0 && p.getY() == 0);

        p = new JPSPoint(1, 1, JPSPoint.SOUTH_EAST);
        p.shiftPoint();
        assert(p.getX() == 2 && p.getY() == 2);

        p = new JPSPoint(1, 1, JPSPoint.SOUTH_WEST);
        p.shiftPoint();
        assert(p.getX() == 2 && p.getY() == 0);

        // X
        assert(JPSPoint.getXOffsetDir(1, JPSPoint.NORTH) == 0);
        assert(JPSPoint.getXOffsetDir(1, JPSPoint.NORTH_EAST) == 0);
        assert(JPSPoint.getXOffsetDir(1, JPSPoint.NORTH_WEST) == 0);

        assert(JPSPoint.getXOffsetDir(1, JPSPoint.SOUTH) == 2);
        assert(JPSPoint.getXOffsetDir(1, JPSPoint.SOUTH_EAST) == 2);
        assert(JPSPoint.getXOffsetDir(1, JPSPoint.SOUTH_WEST) == 2);

        assert(JPSPoint.getXOffsetDir(1, JPSPoint.EAST) == 1);
        assert(JPSPoint.getXOffsetDir(1, JPSPoint.WEST) == 1);

        // Y
        assert(JPSPoint.getYOffsetDir(1, JPSPoint.NORTH) == 1);
        assert(JPSPoint.getYOffsetDir(1, JPSPoint.NORTH_EAST) == 2);
        assert(JPSPoint.getYOffsetDir(1, JPSPoint.NORTH_WEST) == 0);

        assert(JPSPoint.getYOffsetDir(1, JPSPoint.SOUTH) == 1);
        assert(JPSPoint.getYOffsetDir(1, JPSPoint.SOUTH_EAST) == 2);
        assert(JPSPoint.getYOffsetDir(1, JPSPoint.SOUTH_WEST) == 0);

        assert(JPSPoint.getYOffsetDir(1, JPSPoint.EAST) == 2);
        assert(JPSPoint.getYOffsetDir(1, JPSPoint.WEST) == 0);
    }

    @Test
    public void testEquals()
    {
        JPSPoint p1 = new JPSPoint(1, 1, JPSPoint.NORTH);
        JPSPoint p2 = new JPSPoint(1, 1, JPSPoint.NORTH);

        assertEquals(p1, p2);
    }
}
