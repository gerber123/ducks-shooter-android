package pl.marcinos.kaczki;

import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.widget.ImageView;

/**
 * Created by marci on 27.03.2018.
 */

public class AnimacjaKrwi
{

    public static void startAnimacjaKrwi(final ImageView imageKrew, final  ImageView duck) {
        imageKrew.setVisibility(View.VISIBLE);
        Animation alpha = new AlphaAnimation(0f, 1f);


        int duckCenterX = +(int)duck.getX()+duck.getWidth()/2;
        int duckCenterY = +(int)duck.getY()+duck.getHeight()/2;


        imageKrew.setX(duckCenterX);
        imageKrew.setY(duckCenterY);


        alpha.setDuration(200);
        alpha.setFillAfter(false);
        alpha.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {
                imageKrew.setVisibility(View.VISIBLE);
            }

            @Override
            public void onAnimationEnd(Animation animation) {
                startAnimacjiChowaniaKrwi(imageKrew);
            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });

        imageKrew.startAnimation(alpha);
    }
    public static void startAnimacjiChowaniaKrwi(final ImageView imageKrew) {

        Animation alpha = new AlphaAnimation(1f, 0f);



        alpha.setDuration(100);

        alpha.setFillAfter(true);
        alpha.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {

            }

            @Override
            public void onAnimationEnd(Animation animation) {
                imageKrew.setVisibility(View.INVISIBLE);
            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });

        imageKrew.startAnimation(alpha);
    }
}
