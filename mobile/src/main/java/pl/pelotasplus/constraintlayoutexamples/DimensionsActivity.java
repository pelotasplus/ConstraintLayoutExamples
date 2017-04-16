package pl.pelotasplus.constraintlayoutexamples;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;
import java.util.List;

import pl.pelotasplus.constraintlayoutexamples.databinding.LayoutDimensions2Binding;

public class DimensionsActivity extends AppCompatActivity {

    private static class Image {
        String url;
        String dimension;

        Image(String url, String dimension) {
            this.url = url;
            this.dimension = dimension;
        }
    }

    public static List<Image> getImages() {
        List<Image> ret = new ArrayList<>();

        ret.add(new Image(
                "https://learn.guidestar.org/hubfs/social-suggested-images/grumpy-cat-canva-one-time-use.png",
                "1:1"
        ));
        ret.add(new Image(
                "https://localtvwtvr.files.wordpress.com/2014/12/141216113730-cat-cafe-thumb-meet-the-cats-tablet-large.png",
                "16:9"
        ));
        return ret;
    }1

    private void loadImage(ImageView imageView, Image image) {
        ConstraintLayout.LayoutParams layoutParams = (ConstraintLayout.LayoutParams) imageView.getLayoutParams();

        layoutParams.dimensionRatio = image.dimension;

        Glide.with(this).load(image.url).into(imageView);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        LayoutDimensions2Binding binding = DataBindingUtil.setContentView(this, R.layout.layout_dimensions2);

        loadImage(binding.image1, getImages().get(1));
        loadImage(binding.image2, getImages().get(0));
    }
}