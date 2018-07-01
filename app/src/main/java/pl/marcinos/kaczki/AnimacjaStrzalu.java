package pl.marcinos.kaczki;

import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.widget.ImageView;

/**
 * Created by marci on 26.03.2018.
 */

public class AnimacjaStrzalu {
    public static void startAnimacjaWalk(final ImageView imageGun, final  ImageView imageGunShot)
    {
        imageGunShot.setVisibility(View.VISIBLE);
        Animation alpha = new AlphaAnimation(0f, 1f);


        alpha.setDuration(300);
        alpha.setFillAfter(true);
        alpha.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {
                strzalZnikniecie(imageGun);

            }

            @Override
            public void onAnimationEnd(Animation animation) {
                walkaPojawienie(imageGun);
                walkaZnikniecieAtaku(imageGunShot);
            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });
        imageGunShot.startAnimation(alpha);
    }
    public static void strzalZnikniecie(final ImageView image)
    {

        Animation alpha = new AlphaAnimation(1f, 0f);




        alpha.setDuration(300);
        alpha.setFillAfter(true);
        alpha.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {

            }

            @Override
            public void onAnimationEnd(Animation animation) {

            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });
        image.startAnimation(alpha);
    }
    public static void walkaPojawienie(final ImageView image)
    {

        Animation alpha = new AlphaAnimation(0f, 1f);




        alpha.setDuration(300);
        alpha.setFillAfter(true);
        alpha.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {

            }

            @Override
            public void onAnimationEnd(Animation animation) {

            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });
        image.startAnimation(alpha);
    }
    public static void walkaZnikniecieAtaku(final ImageView image)
    {

        Animation alpha = new AlphaAnimation(1f, 0f);




        alpha.setDuration(300);
        alpha.setFillAfter(true);
        alpha.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {

            }

            @Override
            public void onAnimationEnd(Animation animation) {

            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });
        image.startAnimation(alpha);
    }
}
