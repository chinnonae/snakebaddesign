package com.ske.snakebaddesign.models;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Chinthiti Wisetsombat on 17-Mar-16.
 */
public class GameLogic {

    private List<Player> playerList;
    private Dice dice;
    private Board board;
    private int turn;


    public GameLogic(int boardSize, int numberOfDice) {
        dice = new Dice(numberOfDice);
        board = new Board(boardSize);
        playerList = new ArrayList<Player>();
        turn = 0;

    }

    public void addPlayer(String name, int color){
        playerList.add(new Player(name, color));

    }

    public int roll(){
        return dice.roll();
    }

    public void takeTurn(int value){;
        int playerIndex = turn % playerList.size();
        Player currentPlayer = playerList.get(playerIndex);
        currentPlayer.move(value);
        if(currentPlayer.getPosition() > board.getBoardSize()*board.getBoardSize()-1){
            adjustPosition(currentPlayer);
        }
        board.land(currentPlayer);
        adjustPosition(currentPlayer);

    }

    public void reset(){
        turn = 0;
        for(Player a : playerList) a.setPosition(0);
    }

    public Player checkWin(){
        int playerIndex = turn % playerList.size();
        Player curr = playerList.get(playerIndex);
        if(curr.getPosition() == board.getBoardSize()*board.getBoardSize() - 1) return curr;
        return null;
    }

    public Player updateTurn(){
        turn++;
        return playerList.get(turn % playerList.size());
    }

    public List<Player> getPlayerList() {
        return playerList;
    }

    private void adjustPosition(Player current){
        int pos = current.getPosition();
        int maxPos = board.getBoardSize() * board.getBoardSize() - 1;
        if(pos > maxPos) pos = maxPos*2 - pos;
        current.setPosition(pos);

    }
}
