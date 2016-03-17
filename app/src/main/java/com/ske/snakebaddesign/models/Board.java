package com.ske.snakebaddesign.models;

import com.ske.snakebaddesign.models.square.NormalSquare;
import com.ske.snakebaddesign.models.square.SlipSquare;
import com.ske.snakebaddesign.models.square.Square;

/**
 * Created by Chinthiti Wisetsombat on 17-Mar-16.
 */
public class Board {

    private int boardSize;
    private Square[][] squares;

    public Board(int boardSize){
        this.boardSize = boardSize;
        squares = new Square[boardSize][boardSize];
        for(int i = 0; i < boardSize; i++){
            for(int j = 0; j < boardSize; j++){
                boolean isSlip = (boardSize * i + j) == 5;
                if(isSlip){ squares[i][j] = new SlipSquare(); }
                else squares[i][j] = new NormalSquare();
            }
        }
    }

    public void land(Player player){
        Square landon = squares[positionToRow(player.getPosition())] [positionToCol(player.getPosition())];
        landon.affect(player);
    }

    private int positionToRow(int position) { return position / boardSize; }

    private int positionToCol(int position) { return position % boardSize; }

    public int getBoardSize(){
        return boardSize;
    }





}
