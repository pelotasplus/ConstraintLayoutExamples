package pl.pelotasplus.constraintlayoutexamples;

import android.support.v7.app.AppCompatActivity;

enum Example {
    CREATING_RL("Creating RL", R.layout.layout_creating_rl, null),
    CREATING_CL("Creating CL", R.layout.layout_creating_cl, null),
    GUIDELINES("Guidelines CL", R.layout.layout_guidelines, null),
    SIZING_RL("Sizing RL", R.layout.layout_sizing_rl, null),
    SIZING_CL("Sizing CL", R.layout.layout_sizing_cl, null),
    SIZING2_CL("Sizing 2 CL", R.layout.layout_sizing2_cl, null),
    BIAS_RL("Bias RL", R.layout.layout_bias_rl, null),
    BIAS_PRL("Bias PRL", R.layout.layout_bias_prl, null),
    BIAS_CL("Bias CL", R.layout.layout_bias_cl, null),
    CHAINS_TYPES("Chains Types", R.layout.layout_chain_types, null),
    CHAINS_RL("Chains RL", R.layout.layout_chain_rl, null),
    CHAINS_CL("Chains CL", R.layout.layout_chain_cl, null),
    DIMENSIONS("Dimensions", R.layout.layout_dimensions, null),
    DIMENSIONS2("Dimensions 2", -1, DimensionsActivity.class),
    VISIBILITY("Visibility", -1, VisibilityActivity.class),
    TRANSITIONS("Transitions", -1, TransitionActivity.class);

    final String label;
    final int layoutId;
    final Class<? extends AppCompatActivity> activityClass;

    Example(String label, int layoutId, Class<? extends AppCompatActivity> activityClass) {
        this.label = label;
        this.layoutId = layoutId;
        this.activityClass = activityClass;
    }
}
