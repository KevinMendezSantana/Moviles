package com.example.mendez26.a45_animacion_java;

import android.animation.Animator;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {
    private ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        imageView = (ImageView) findViewById(R.id.faceIcon);
    }
    public void onButtonClick(View v) {

        imageView.animate().scaleX(2).scaleY(2).rotationX(220).rotationY(220).translationX(300).translationY(300).setDuration(5000)
                .setListener(new Animator.AnimatorListener() {
                    @Override
                    public void onAnimationStart(Animator animation) {Log.i("Animation", "onAnimationStart");}
                    @Override
                    public void onAnimationEnd(Animator animation) {Log.i("Animation", "onAnimationEnd");}
                    @Override
                    public void onAnimationCancel(Animator animation) {}
                    @Override
                    public void onAnimationRepeat(Animator animation) {}
                });
    }

    public void zoom(View v){
        imageView.animate().scaleX(2).scaleY(2).setDuration(4000).setListener(new Animator.AnimatorListener(){
            @Override
            public void onAnimationStart(Animator animator) {Log.i("Animation", "onAnimationStart");}
            @Override
            public void onAnimationEnd(Animator animator) {
                imageView.animate().scaleX(1).scaleY(1).setDuration(4000).setListener(new Animator.AnimatorListener(){
                    @Override
                    public void onAnimationStart(Animator animator) {Log.i("Animation", "onAnimationStart");}
                    @Override
                    public void onAnimationEnd(Animator animator) {Log.i("Animation", "onAnimationEnd");}
                    @Override
                    public void onAnimationCancel(Animator animator) {}
                    @Override
                    public void onAnimationRepeat(Animator animator) {}
                });
                Log.i("Animation", "onAnimationEnd");}
            @Override
            public void onAnimationCancel(Animator animator) {}
            @Override
            public void onAnimationRepeat(Animator animator) {}
        });

    }

    public void rotacion(View v){
        imageView.animate().rotationX(500).rotationY(600).setDuration(4000).setListener(new Animator.AnimatorListener(){
            @Override
            public void onAnimationStart(Animator animator) {Log.i("Animation", "onAnimationStart");}
            @Override
            public void onAnimationEnd(Animator animator) {
                imageView.animate().rotationX(1).rotationY(1).setDuration(4000).setListener(new Animator.AnimatorListener(){
                    @Override
                    public void onAnimationStart(Animator animator) {Log.i("Animation", "onAnimationStart");}
                    @Override
                    public void onAnimationEnd(Animator animator) {Log.i("Animation", "onAnimationEnd");}
                    @Override
                    public void onAnimationCancel(Animator animator) {}
                    @Override
                    public void onAnimationRepeat(Animator animator) {}
                });
                Log.i("Animation", "onAnimationEnd");}
            @Override
            public void onAnimationCancel(Animator animator) {}
            @Override
            public void onAnimationRepeat(Animator animator) {}
        });
    }
    public void rotaciony(View v){
        imageView.animate().translationX(100).translationY(200).setDuration(3000).setListener(new Animator.AnimatorListener(){
            @Override
            public void onAnimationStart(Animator animator) {Log.i("Animation", "onAnimationStart");}
            @Override
            public void onAnimationEnd(Animator animator) {
                imageView.animate().translationX(0).translationY(0).setDuration(3000).setListener(new Animator.AnimatorListener(){
                    @Override
                    public void onAnimationStart(Animator animator) {Log.i("Animation", "onAnimationStart");}
                    @Override
                    public void onAnimationEnd(Animator animator) {

                        Log.i("Animation", "onAnimationEnd");}
                    @Override
                    public void onAnimationCancel(Animator animator) {}
                    @Override
                    public void onAnimationRepeat(Animator animator) {}
                });
                Log.i("Animation", "onAnimationEnd");}
            @Override
            public void onAnimationCancel(Animator animator) {}
            @Override
            public void onAnimationRepeat(Animator animator) {}
        });
    }
}
