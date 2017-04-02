package pl.pelotasplus.constraintlayoutexamples;

import android.content.Context;
import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import pl.pelotasplus.constraintlayoutexamples.databinding.ActivityMainBinding;
import pl.pelotasplus.constraintlayoutexamples.databinding.ItemExampleRowBinding;

public class MainActivity extends AppCompatActivity {
    ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = DataBindingUtil.setContentView(this, R.layout.activity_main);

        binding.recyclerView.setAdapter(new ExampleAdapter());
        binding.recyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
    }

    private static class ExampleAdapter extends RecyclerView.Adapter<ExampleViewHolder> {
        @Override
        public ExampleViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            return new ExampleViewHolder(DataBindingUtil.inflate(
                    LayoutInflater.from(parent.getContext()),
                    R.layout.item_example_row,
                    parent,
                    false
            ));
        }

        @Override
        public void onBindViewHolder(ExampleViewHolder holder, int position) {
            Example example = Example.values()[position];

            holder.binding.labelTextView.setText(example.label);

            holder.binding.labelTextView.setOnClickListener(v -> {
                Context context = holder.binding.getRoot().getContext();
                if (example.activityClass != null) {
                    Intent intent = new Intent(context, example.activityClass);
                    context.startActivity(intent);
                } else {
                    LayoutActivity.start(context, example.layoutId);
                }
            });
        }

        @Override
        public int getItemCount() {
            return Example.values().length;
        }
    }

    private static class ExampleViewHolder extends RecyclerView.ViewHolder {
        private ItemExampleRowBinding binding;

        ExampleViewHolder(ItemExampleRowBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }
    }
}
