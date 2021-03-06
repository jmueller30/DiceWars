package com.jack.dicewars.dice_wars.game.progression;

import com.jack.dicewars.dice_wars.game.Player;

/**
 * A Turn is taken by one Player and made up of Phases. A Turn an only advances through as many phases as it is
 * instantiated with.
 */
public class Turn {

    private Player player;

    private Phase[] phases;
    private int currentPhase;

    /**
     * Starts a turn controlled by player that will go through an Attack, Reinforce, and Effect phase.
     * @param player The player controlling the turn.
     */
    Turn(Player player) {
        this.player = player;

        // TODO add Effect Phase back in
        phases = new Phase[] {new AttackPhase(player), new ReinforcePhase(player)};
        currentPhase = 0;
    }

    /**
     *
     * @return The current phase of this turn.
     */
    public Phase currentPhase() {
        return phases[currentPhase];
    }

    /**
     * Advance this Turn to the next Phase.
     *
     * @return True if advancing logic completed at the Turn level, false if the Turn has ended.
     */
    public boolean advance() {
        if (currentPhase < phases.length - 1) {
            // simply advance to the next phase
            currentPhase++;
            return true;
        } else {
            //last phase, roll over to next turn
            return false;
        }
    }

    /**
     * @return Whether or not the current phase has selected Territories and is waiting for more selections to resolve
     * the action.
     */
    public boolean getPendingAction() {
        return phases[currentPhase].getPendingAction();
    }

    /**
     * Reverses the phases action so that the game state is like before it was selected.
     */
    public void undoPhaseAction() {
        phases[currentPhase].undoAction();
    }
}
