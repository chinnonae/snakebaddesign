package com.ske.snakebaddesign.activities;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.ske.snakebaddesign.R;
import com.ske.snakebaddesign.guis.BoardView;
import com.ske.snakebaddesign.models.GameLogic;
import com.ske.snakebaddesign.models.Player;

import java.util.Random;

public class GameActivity extends AppCompatActivity {

    private int boardSize;

    private BoardView boardView;
    private Button buttonTakeTurn;
    private Button buttonRestart;
    private TextView textPlayerTurn;
    private GameLogic gameLogic;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);
        initComponents();
    }

    @Override
    protected void onStart() {
        super.onStart();
        resetGame();
    }

    private void initComponents() {
        boardView = (BoardView) findViewById(R.id.board_view);
        buttonTakeTurn = (Button) findViewById(R.id.button_take_turn);
        buttonTakeTurn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                takeTurn();
            }
        });
        buttonRestart = (Button) findViewById(R.id.button_restart);
        buttonRestart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                resetGame();
            }
        });
        textPlayerTurn = (TextView) findViewById(R.id.text_player_turn);
        gameLogic = new GameLogic(6, 1);
        gameLogic.addPlayer("Player 1", Color.BLACK);
        gameLogic.addPlayer("Player 2", Color.WHITE);
    }

    private void resetGame() {
        boardSize = 6;
        boardView.setBoardSize(boardSize);
        gameLogic.reset();
        boardView.setPlayerList(gameLogic.getPlayerList());
    }

    private void takeTurn() {
        final int value = gameLogic.roll();
        String title = "You rolled a die";
        String msg = "You got " + value;

        OnClickListener listener = new OnClickListener() {
            public void onClick(DialogInterface dialog, int which) {
                gameLogic.takeTurn(value);
                checkWin();
                Player nextPlayer = gameLogic.updateTurn();
                dialog.dismiss();
                textPlayerTurn.setText(nextPlayer.getName()+"'s Turn.");
                boardView.updatePosition();
            }
        };
        displayDialog(title, msg, listener);
    }



//    private int adjustPosition(int current, int distance) {
//        current = current + distance;
//        int maxSquare = boardSize * boardSize - 1;
//        if(current > maxSquare) {
//            current = maxSquare - (current - maxSquare);
//        }
//        return current;
//    }

    private void checkWin() {
        String title = "Game Over";
        String msg = "";
        OnClickListener listener = new OnClickListener() {
            public void onClick(DialogInterface dialog, int which) {
                resetGame();
                dialog.dismiss();
            }
        };
        Player winner = gameLogic.checkWin();
        if(winner != null){ msg = winner.getName() + " Won!"; }
        else return;
        displayDialog(title, msg, listener);
    }

    private void displayDialog(String title, String message, DialogInterface.OnClickListener listener) {
        AlertDialog alertDialog = new AlertDialog.Builder(this).create();
        alertDialog.setTitle(title);
        alertDialog.setMessage(message);
        alertDialog.setCancelable(false);
        alertDialog.setButton(AlertDialog.BUTTON_NEUTRAL, "OK", listener);
        alertDialog.show();
    }

}
