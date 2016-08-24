package com.example.wuziqi;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;

import com.example.wuziqi.View.GameView;

public class MainActivity extends Activity {

    Button btn_startGame;

    GameView mGameView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_main);

        mGameView = (GameView) findViewById(R.id.gameView);

        btn_startGame = (Button) findViewById(R.id.btn_startGame);

        btn_startGame.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                mGameView.resetGame();
            }
        });

    }


}
