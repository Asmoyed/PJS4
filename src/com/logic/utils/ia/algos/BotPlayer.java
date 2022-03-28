package com.logic.utils.ia.algos;

import com.logic.dto.data.Allegiance;
import com.logic.dto.data.Character;
import com.logic.dto.data.World;
import com.logic.utils.ia.dto.Move;
import com.logic.utils.ia.dto.PositionResume;

import java.util.List;

public class BotPlayer
{
    public static World play(World w)
    {
        return play(w, Allegiance.BOT);
    }

    public static World play(World w, Allegiance allegiance)
    {
        List<Move> moves = MoveCalculator.generatesMoves(allegiance, w);

        Move best = null;
        float maxScore = -Float.MAX_VALUE;

        for (Move move : moves)
        {
            float score = Evaluator.EvaluatePosition(executeMove(w, move), Allegiance.BOT);
            if (score > maxScore)
            {
                maxScore = score;
                best = move;
            }
        }

        if (best == null)
        {
            return null;
        }

        return executeMove(w, best);
    }

    /**
     * Recherche coup le plus avantageux pour une profondeur de 3
     */
    public static World advancedPlay(World w, Allegiance allegiance)
    {
        List<Move> moves = MoveCalculator.generatesMoves(allegiance, w);

        float maxScore = -Float.MAX_VALUE;
        Move best = null;
        for (Move move : moves)
        {
            System.out.println("<" + moves.indexOf(move) + "/" + moves.size() + ">");

            World moveWorld = executeMove(w, move);
            List<Move> moves2 = MoveCalculator.generatesMoves(Allegiance.J1, moveWorld);

            for (Move move2 : moves2)
            {
                World move2World = executeMove(moveWorld, move2);
                List<Move> moves3 = MoveCalculator.generatesMoves(allegiance, move2World);

                for (Move move3 : moves3)
                {
                    float score = Evaluator.EvaluatePosition(executeMove(move2World, move3), Allegiance.BOT);
                    if (score > maxScore)
                    {
                        maxScore = score;
                        best = move;
                    }
                }
            }
        }

        if (best == null)
        {
            return null;
        }

        return executeMove(w, best);
    }

    private static World executeMove(World w, Move m)
    {
        World copy = w.copy();

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
