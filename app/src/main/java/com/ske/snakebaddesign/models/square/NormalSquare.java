package com.ske.snakebaddesign.models.square;

import com.ske.snakebaddesign.models.Player;

/**
 * Created by Chinthiti Wisetsombat on 17-Mar-16.
 */
public class NormalSquare implements Square {

    @Override
    public void affect(Player player) {
        player.move(0);
    }
}
