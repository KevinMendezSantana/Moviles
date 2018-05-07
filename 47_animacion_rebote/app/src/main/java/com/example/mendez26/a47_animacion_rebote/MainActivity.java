package com.example.mendez26.a47_animacion_rebote;

import android.animation.ObjectAnimator;
import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.BounceInterpolator;
import android.view.animation.CycleInterpolator;
import android.view.animation.DecelerateInterpolator;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;

public class MainActivity extends AppCompatActivity {

    private ImageView imageView;
    private ConstraintLayout canvas1;
    private Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        imageView = (ImageView) findViewById(R.id.imageView);
        canvas1 = (ConstraintLayout) findViewById(R.id.canvas);
        button = (Button)findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                animarImagen(view);
            }
        });
    }


    public void animarImagen(View v) {

        int screenHeight = canvas1.getHeight();
        int targetY = screenHeight - imageView.getHeight();

        ObjectAnimator animator = ObjectAnimator.ofFloat(imageView, "y",targetY,0 ).setDuration(1000);
        animator.setInterpolator(new BounceInterpolator());
        //animator.setInterpolator(new AccelerateInterpolator());
        //animator.setInterpolator(new DecelerateInterpolator());
        //animator.setInterpolator(new CycleInterpolator(1));
        animator.start();
    }

    public void animarImagen2(View v) {

        int screenHeight = canvas1.getHeight();
        int targetY = screenHeight - imageView.getHeight();
        ObjectAnimator animator = ObjectAnimator.ofFloat(imageView, "y",targetY,0 ).setDuration(1000);
        animator.setInterpolator(new AccelerateInterpolator());
        animator.start();
    }

    public void animarImagen3(View v) {

        int screenHeight = canvas1.getHeight();
        int targetY = screenHeight - imageView.getHeight();
        ObjectAnimator animator = ObjectAnimator.ofFloat(imageView, "y",targetY,0 ).setDuration(1000);
        animator.setInterpolator(new CycleInterpolator(2));
        animator.start();
    }

}
