package pl.marcinos.kaczki;

import android.content.Intent;
import android.graphics.Point;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Display;
import android.view.MotionEvent;
import android.view.View;
import android.view.WindowManager;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Timer;
import java.util.TimerTask;

public class MainActivity extends AppCompatActivity {

    ImageView imageGun;
    ImageView imageGunShot;
    ImageView duck;
    ImageView krew;
    private SoundPlayer sound;
    private int duckX;
    private int duckY;

    int score;
    TextView scoreLabel;
    int losescore;
    TextView losescoreLabel;

    private Handler handler = new Handler();
    private Timer timer = new Timer();

    private int frameHeight;
    private int boxSize;
    private int ScreenWidth;
    private int ScreenHeight;
    private TextView startLabel;
    FrameLayout layout;
    private boolean action_flag = false;
    private boolean start_flag = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        imageGun =(ImageView)findViewById(R.id.gun);
        imageGunShot=(ImageView)findViewById(R.id.gunshot);
        krew=(ImageView)findViewById(R.id.krew);
        layout=(FrameLayout)findViewById(R.id.frame);
        startLabel=(TextView)findViewById(R.id.startLabel);




        scoreLabel = (TextView)findViewById(R.id.scoreLabel);
        losescoreLabel = (TextView)findViewById(R.id.LoseScore);
        losescoreLabel.setText("Uciekło Ci: "+losescore+" kaczek");
        sound = new SoundPlayer(this);
//        imageGun.setOnTouchListener(new View.OnTouchListener() {
//            @Override
//            public boolean onTouch(View v, MotionEvent event) {
//                AnimacjaStrzalu.startAnimacjaWalk(imageGun,imageGunShot);
//                return false;
//            }
//        });

        layout.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {

                sound.playHitSound();
                AnimacjaStrzalu.startAnimacjaWalk(imageGun,imageGunShot);

                return false;
            }
        });
        scoreLabel.setText("Zajebałeś już: "+score);
        scoreLabel.setText("Zajebałeś już: "+score);
        WindowManager wm = getWindowManager();
        Display disp = wm.getDefaultDisplay();
        Point size = new Point();
        disp.getSize(size);

        ScreenWidth= size.x;
        ScreenHeight= size.y;
        duck=(ImageView)findViewById(R.id.duck);
        duck.setX(-80);
        duck.setY(-80);
        krew.setVisibility(View.INVISIBLE);

    }




private void hitCheck()
    {


        duck.setOnTouchListener(new View.OnTouchListener() {
        @Override
        public boolean onTouch(View v, MotionEvent event) {

            score+=1;
            scoreLabel.setText("Zabiłeś już: "+score+" kaczek");

            duckX=ScreenWidth+20;
            duckY=(int)Math.floor(Math.random() *(frameHeight-duck.getHeight()));

            return false;
        }
    });
}
    public void changePos() {

        hitCheck();

        if(score<7)
        {
            duckX-=15;
        }
        else if(score>=7&&score<13)
        {
            duckX -= 25;
        }
        else if(score>=13&&score<=17)
        {
            duckX -= 35;
        }
        else if(score>17&&score<=22)
        {
            duckX-=45;
        }
        else if(score>22&&score<=25)
        {
            duckX-=55;
        }    else if(score>25&&score<=29)
        {
            duckX-=70;
        }
        else if(score>29)
        {
            duckX-=85;
        }

        if (duckX < 0-duck.getWidth())
        {
            losescore+=1;
            losescoreLabel.setText("Uciekło Ci: "+losescore+" kaczek");
            duckX = ScreenWidth + 20;
            duckY = (int) Math.floor(Math.random() * (frameHeight - duck.getHeight()));
        }
        duck.setX(duckX);
        duck.setY(duckY);


        if(losescore>=5)
        {
            sound.playOverSound();
            timer.cancel();
            timer=null;
            Intent intent = new Intent(getApplicationContext(),result.class);
            intent.putExtra("SCORE",score);
            intent.putExtra("SCORELOSE",losescore);
            startActivity(intent);
        }

    }
    public boolean onTouchEvent(MotionEvent me)
    {
        if(start_flag==false)
        {
            start_flag=true;


            startLabel.setVisibility(View.GONE);


            FrameLayout frame =(FrameLayout)findViewById(R.id.frame);
            frameHeight=frame.getHeight();



            timer.schedule(new TimerTask() {
                @Override
                public void run() {
                    handler.post(new Runnable() {
                        @Override
                        public void run() {

                            changePos();
                        }
                    });
                }
            },0,20);

        }    else
        {
            if(me.getAction()==MotionEvent.ACTION_DOWN)
            {
                action_flag=true;
            }
            else if(me.getAction()==MotionEvent.ACTION_UP)
            {
                action_flag=false;
            }
        }


        return true;
    }

    public void onBackPressed() {
        super.onBackPressed();
        Intent intent = new Intent(MainActivity.this,Main2Activity.class);
        startActivity(intent);
        MainActivity.this.finish();

    }
}

