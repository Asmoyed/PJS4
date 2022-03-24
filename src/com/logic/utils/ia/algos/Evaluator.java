package com.logic.utils.ia.algos;

import com.logic.dto.data.Allegiance;
import com.logic.dto.data.Character;
import com.logic.dto.data.CharacterState;
import com.logic.dto.data.World;
import com.logic.utils.ia.dto.Move;
import com.logic.utils.ia.dto.PositionResume;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Evaluator
{
    // COEF MORT / VIVANT
    private static final float COEF_ALIVE = 100f;
    private static final float COEF_DEAD = 100f;
    // COEF COMBAT SUPERIEUR / INFERIEUR
    private static final float COEF_INFERIOR = 50f;
    private static final float COEF_SUPERIOR = 50f;
    // COEF ATTAQUE / ATTAQUANT
    private static final float COEF_PREDATOR = 25f;
    private static final float COEF_VICTIM = 25f;

    public static float EvaluatePosition(World w, Allegiance a)
    {
        float score = 0f;

        for (Character c : w.getCharacters())
        {
            if (c.getState() == CharacterState.ALIVE)
            {
                PositionResume resume = AttackProcessor.getResume(c, w);

                if (c.getAllegiance() == a)
                {
                    score += COEF_ALIVE;
                    for (Character victim : resume.getVictims())
                    {
                        score += COEF_VICTIM;
                        if (c.damageValue(victim) > victim.damageValue(c)) // Si c est plus fort que victim
                        {
                            score += COEF_SUPERIOR;
                        }
                        else
                        {
                            score -= COEF_INFERIOR;
                        }
                    }
                    for (Character predator : resume.getPredators())
                    {
                        score += COEF_VICTIM;
                        if (c.damageValue(predator) > predator.damageValue(c)) // Si c est plus fort que victim
                        {
                            score += COEF_SUPERIOR;
                        }
                        else
                        {
                            score -= COEF_INFERIOR;
                        }
                    }
                }
                else
                {
                    score -= COEF_ALIVE;
                    for (Character victim : resume.getVictims())
                    {
                        score -= COEF_VICTIM;
                        if (c.damageValue(victim) > victim.damageValue(c)) // Si c est plus fort que victim
                        {
                            score -= COEF_SUPERIOR;
                        }
                        else
                        {
                            score += COEF_INFERIOR;
                        }
                    }
                    for (Character predator : resume.getPredators())
                    {
                        score -= COEF_VICTIM;
                        if (c.damageValue(predator) > predator.damageValue(c)) // Si c est plus fort que victim
                        {
                            score -= COEF_SUPERIOR;
                        }
                        else
                        {
                            score += COEF_INFERIOR;
                        }
                    }
                }
            }
            else
            {
                if (c.getAllegiance() == a)
                {
                    score -= COEF_DEAD;
                }
                else
                {
                    score += COEF_DEAD;
                }
            }
        }

        return score;
    }

}
