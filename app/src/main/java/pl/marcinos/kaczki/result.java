package pl.marcinos.kaczki;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class result extends AppCompatActivity {
Button buttonwroc;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        TextView scoreLabel =(TextView)findViewById(R.id.scoreLabel);
        TextView loseScore =(TextView)findViewById(R.id.scoreLose);
        TextView highScoreLabel =(TextView)findViewById(R.id.highScoreLabel);
        buttonwroc=(Button)findViewById(R.id.Wroc);
        buttonwroc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(result.this,Main2Activity.class);
                startActivity(intent);
                result.this.finish();
            }
        });

        int score = getIntent().getIntExtra("SCORE",0);
        scoreLabel.setText("Zabiłeś: "+score+" kaczek");
        int losescore = getIntent().getIntExtra("SCORELOSE",0);
        loseScore.setText("Przepuściłeś 5 kaczek!");

        SharedPreferences settings = getSharedPreferences("GAME_DATA", Context.MODE_PRIVATE);
        int highScore=settings.getInt("HIGH_SCORE",0);

        if(score>highScore)
        {
            highScoreLabel.setText("High Score: "+score);

            SharedPreferences.Editor editor = settings.edit();
            editor.putInt("HIGH_SCORE",score);

            editor.commit();
        }
        else
        {
            highScoreLabel.setText("High Score : "+highScore);
        }
    }

    public void TryAgain(View view)
    {
        startActivity(new Intent(getApplicationContext(),MainActivity.class));
    }
    @Override
    public void onBackPressed() {
        super.onBackPressed();
        Intent intent = new Intent(result.this,Main2Activity.class);
        startActivity(intent);
        result.this.finish();

    }
}



