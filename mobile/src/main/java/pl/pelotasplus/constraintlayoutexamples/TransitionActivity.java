package pl.pelotasplus.constraintlayoutexamples;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.constraint.ConstraintSet;
import android.support.v7.app.AppCompatActivity;
import android.transition.TransitionManager;

import pl.pelotasplus.constraintlayoutexamples.databinding.LayoutTransition1Binding;

public class TransitionActivity extends AppCompatActivity {
    private boolean lessMode = true;

    private LayoutTransition1Binding binding;

    private ConstraintSet moreConstraintSet = new ConstraintSet();
    private ConstraintSet lessConstraintSet = new ConstraintSet();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = DataBindingUtil.setContentView(this, R.layout.layout_transition_1);

        lessConstraintSet.clone(this, R.layout.layout_transition_1);
        moreConstraintSet.clone(this, R.layout.layout_transition_2);

        binding.moreButton.setOnClickListener(v -> {
            TransitionManager.beginDelayedTransition(binding.constraintLayout);

            if (lessMode) {
                moreConstraintSet.applyTo(binding.constraintLayout);
                lessMode = false;
            } else {
                lessConstraintSet.applyTo(binding.constraintLayout);
                lessMode = true;
            }
        });
    }
}