package com.kodonho.android.materialdesign_propertyanimation01;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageButton;
import android.widget.RelativeLayout;
import android.widget.Toast;

/*
    ObjectAnimator 사용 법
    1. 애니메이터를 정의한다                      ↓ 대상개체
    ObjectAnimator ani = ObjectAnimator.ofFloat(player, "translationY", 속성값(숫자));
                                                           ↑ 개체의 속성명
    2. 정의된 애니메이터를 실행한다
    ani.start();
 */
public class MainActivity extends AppCompatActivity {

    RelativeLayout ground;
    ImageButton player;
    int x = 0;
    int y = 0;
    int gx = 0;
    int gy = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ground  = (RelativeLayout) findViewById(R.id.ground);
        player = (ImageButton) findViewById(R.id.player);
    }

    private void setGroundSize() {
        if( gx == 0 || gy == 0 ) {
            gx = ground.getWidth() / 2;
            gy = ground.getHeight() / 2;
        }
    }

    public void up(View v){
        setGroundSize();
        y = y - 50;

        if( gy >= Math.abs(y) ) {
            ObjectAnimator ani = ObjectAnimator.ofFloat(player, "translationY", y);
            ani.start();
        }else{
            y = y + 50;
        }
    }
    public void down(View v){
        setGroundSize();
        y = y + 50;

        if( gy >= Math.abs(y) ) {
            ObjectAnimator ani = ObjectAnimator.ofFloat(player, "translationY", y);
            ani.start();
        }else{
            y = y - 50;
        }
    }
    public void left(View v){
        setGroundSize();
        x = x - 50;
        if( gx >= Math.abs(x) ) {
            ObjectAnimator ani = ObjectAnimator.ofFloat(player, "translationX", x);
            ani.start();
        }else{
            x = x + 50;
        }
    }
    public void right(View v){
        setGroundSize();
        x = x + 50;
        if( gx >= Math.abs(x) ) {
            ObjectAnimator ani = ObjectAnimator.ofFloat(player, "translationX", x);
            ani.start();
        }else{
            x = x - 50;
        }
    }

    int r = 0;
    public void rotate(View v){
        r = r + 90;
        ObjectAnimator ani = ObjectAnimator.ofFloat(player, "rotation", r);
        ani.setDuration(1000);
        ani.start();
    }

    float scale_x = 1;
    float scale_y = 1;
    public void smaller(View v){
        scale_x = scale_x/2;
        scale_y = scale_y/2;
        ObjectAnimator ani1 = ObjectAnimator.ofFloat(player, "scaleX", scale_x);  // 배수
        ObjectAnimator ani2 = ObjectAnimator.ofFloat(player, "scaleY", scale_y);  // 배수

        // 여러개의 애니메이션 동시에 사용하기
        // 1. AnimatorSet을 초기화한다
        AnimatorSet aniSet = new AnimatorSet();
        // 2. 동작시간을 설정한다
        aniSet.setDuration(1000);
        // 3. playTogether에 애니메이션을 담아준다
        aniSet.playTogether(ani1,ani2);
        // 4. 애니메이션을 실행한다
        aniSet.start();
    }

    public void bigger(View v){
        scale_x = scale_x*2;
        scale_y = scale_y*2;
        ObjectAnimator ani1 = ObjectAnimator.ofFloat(player, "scaleX", scale_x);  // 배수
        ani1.start();
        ObjectAnimator ani2 = ObjectAnimator.ofFloat(player, "scaleY", scale_y);  // 배수
        ani2.start();
//        AnimatorSet aniSet = new AnimatorSet();
//        aniSet.setDuration(1000);
//        aniSet.playTogether(ani1,ani2);
//        aniSet.start();
    }


    public void showMessage(View v){
        Toast.makeText(this, "I am Here!!!", Toast.LENGTH_SHORT).show();
    }

}
