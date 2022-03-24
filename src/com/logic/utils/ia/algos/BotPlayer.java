package com.logic.utils.ia.algos;

import com.logic.dto.data.Allegiance;
import com.logic.dto.data.Character;
import com.logic.dto.data.World;
import com.logic.dto.serialization.ObjectNotSerializableException;
import com.logic.dto.serialization.ObjectParsingException;
import com.logic.dto.serialization.Serializer;
import com.logic.utils.ia.dto.Move;
import com.logic.utils.ia.dto.PositionResume;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.util.List;

public class BotPlayer
{
    public static World play(World w)
    {
        List<Move> moves = MoveCalculator.generatesMoves(Allegiance.BOT, w);

        Move best = null;
        float maxScore = Float.MAX_VALUE;

        for (Move move : moves)
        {
            float score = Evaluator.EvaluatePosition(executeMove(w, move), Allegiance.BOT);
            if (score > maxScore)
            {
                maxScore = score;
                best = move;
            }
        }

        return executeMove(w, best);
    }

    private static World executeMove(World w, Move m)
    {
        World copy;

        try
        {
            copy = (World) Serializer.deserializeFromString(World.class, Serializer.serialize(w));

            if (copy == null)
            {
                throw new Exception();
            }
        }
        catch (Exception e)
        {
            throw new RuntimeException("Erreur de sérialisation");
        }

        Character toMove = null;
        for (Character c : copy.getCharacters())
        {
            if (c.getX() == m.getOriginX() && c.getY() == m.getOriginY())
            {
                toMove = c;
            }
        }
        if (toMove == null)
        {
            throw new RuntimeException("Character d'origne introuvable");
        }

        toMove.setX(m.getDestinationX());
        toMove.setY(m.getDestinationY());

        if (m.isFight())
        {
            PositionResume resume = AttackProcessor.getResume(toMove, copy);

            if (resume.getVictims().size() > 0)
            {
                Character victim = null;
                int maxDamage = Integer.MIN_VALUE;
                for (Character vict : resume.getVictims())
                {
                    if (toMove.damageValue(vict) > maxDamage)
                    {
                        maxDamage = toMove.damageValue(vict);
                        victim = vict;
                    }
                }

                if (victim != null)
                {
                    toMove.attack(victim);
                }
            }
        }

        return copy;
    }
}
