package com.example.mendez26.a44_animacionxml;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        imageView = (ImageView) findViewById(R.id.faceIcon);
        final Toast inicio = Toast.makeText(getApplicationContext(), "Inicio de animacion", Toast.LENGTH_SHORT);
        final Toast fin = Toast.makeText(getApplicationContext(), "Fin de animacion", Toast.LENGTH_SHORT);
        findViewById(R.id.btnRun).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Animation animation =
                        AnimationUtils.loadAnimation(getApplicationContext(), R.anim.grow);

                animation.setAnimationListener(new Animation.AnimationListener() {
                    @Override
                    public void onAnimationStart(Animation animation) {
                        fin.cancel();
                        inicio.show();
                    }

                    @Override
                    public void onAnimationEnd(Animation animation) {
                        imageView.setScaleX(1);
                        imageView.setScaleY(1);
                        inicio.cancel();
                        fin.show();
                    }

                    @Override
                    public void onAnimationRepeat(Animation animation) {

                    }
                });
                imageView.startAnimation(animation);
            }
        });

        findViewById(R.id.btnRun2).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Animation animation2 = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.grow2);
                animation2.setAnimationListener(new Animation.AnimationListener() {
                    @Override
                    public void onAnimationStart(Animation animation) {
                        fin.cancel();
                        inicio.show();
                    }

                    @Override
                    public void onAnimationEnd(Animation animation) {
                        imageView.setScaleX(1);
                        imageView.setScaleY(1);
                        inicio.cancel();
                        fin.show();
                    }

                    @Override
                    public void onAnimationRepeat(Animation animation) {

                    }
                });

                imageView.startAnimation(animation2);
            }
        });
    }
}

