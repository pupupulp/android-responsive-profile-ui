package com.fujiyama.pulp.responsiveprofileui;

import android.support.constraint.ConstraintLayout;
import android.support.constraint.ConstraintSet;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.transition.TransitionManager;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    private boolean isOpen = false;
    private ConstraintSet mainLayout, expandedLayout;
    private ConstraintLayout constraintLayout;
    private ImageView imageViewProfileCover;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Window w = getWindow();
        w.setFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS, WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS);

        mainLayout = new ConstraintSet();
        expandedLayout = new ConstraintSet();
        imageViewProfileCover = findViewById(R.id.profileCover);
        constraintLayout = findViewById(R.id.constraintLayout);

        mainLayout.clone(constraintLayout);
        expandedLayout.clone(this, R.layout.expanded_profile);

        imageViewProfileCover.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                if(!isOpen) {
                    TransitionManager.beginDelayedTransition(constraintLayout);
                    expandedLayout.applyTo(constraintLayout);
                    isOpen = !isOpen;
                } else {
                    TransitionManager.beginDelayedTransition(constraintLayout);
                    mainLayout.applyTo(constraintLayout);
                    isOpen = !isOpen;
                }
            }
        });
    }
}
