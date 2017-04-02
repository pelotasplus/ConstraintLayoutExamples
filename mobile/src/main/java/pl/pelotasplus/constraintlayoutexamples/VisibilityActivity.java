package pl.pelotasplus.constraintlayoutexamples;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import pl.pelotasplus.constraintlayoutexamples.databinding.LayoutVisibility1Binding;

public class VisibilityActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        LayoutVisibility1Binding binding =
                DataBindingUtil.setContentView(this, R.layout.layout_visibility_1);

        binding.textView2.setOnClickListener(v -> v.setVisibility(View.GONE));
        binding.textView5.setOnClickListener(v -> v.setVisibility(View.GONE));
    }
}
