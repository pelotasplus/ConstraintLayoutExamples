package pl.pelotasplus.constraintlayoutexamples;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

public class LayoutActivity extends AppCompatActivity {
    private static final String EXTRA_LAYOUT_ID = "EXTRA_LAYOUT_ID";

    public static void start(Context context, int layoutId) {
        Intent intent = new Intent(context, LayoutActivity.class);
        intent.putExtra(EXTRA_LAYOUT_ID, layoutId);
        context.startActivity(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        int layoutId = getIntent().getIntExtra(EXTRA_LAYOUT_ID, -1);

        setContentView(layoutId);
    }
}
