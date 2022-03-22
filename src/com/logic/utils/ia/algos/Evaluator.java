package com.logic.utils.ia.algos;

import com.logic.dto.data.Allegiance;
import com.logic.dto.data.Character;
import com.logic.dto.data.CharacterState;
import com.logic.dto.data.World;
import com.logic.utils.ia.dto.Move;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Evaluator
{
    private static final float COEF_ALIVE = 100f;
    private static final float COEF_DEAD = 100f;
    private static final float COEF_INFERIOR = 50f;
    private static final float COEF_SUPERIOR = 50f;
    private static final float COEF_PREDATOR = 25f;
    private static final float COEF_VICTIM = 25f;

    public static float EvaluatePosition(World w, Allegiance a)
    {
        float score = 0f;

        for (Character c : w.getCharacters())
        {
            if (c.getState() == CharacterState.ALIVE)
            {
                if (c.getAllegiance() == a)
                {
                    score += COEF_ALIVE;

                    // TODO Battle
                }
                else
                {
                    score -= COEF_ALIVE;
                    // TODO Battle
                }
            }
            else
            {
                if (c.getAllegiance() == a)
                {
                    score += COEF_DEAD;
                }
                else
                {
                    score -= COEF_DEAD;
                }
            }
        }

        return 0f;
    }

}
