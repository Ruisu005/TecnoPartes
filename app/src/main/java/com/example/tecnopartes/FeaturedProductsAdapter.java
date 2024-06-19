package com.example.tecnopartes;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.viewpager.widget.PagerAdapter;

public class FeaturedProductsAdapter extends PagerAdapter {

    private Context context;
    private int[] imageIds = {
            R.drawable.rtx_3060, R.drawable.b560m, R.drawable.ryzen_7_7800x,
            R.drawable.i9_14900kf, R.drawable.rm580e
    };

    public FeaturedProductsAdapter(Context context) {
        this.context = context;
    }

    @Override
    public int getCount() {
        return imageIds.length;
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view == object;
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.slider_item, container, false);

        ImageView imageView = view.findViewById(R.id.imageView);
        imageView.setImageResource(imageIds[position]);

        container.addView(view);
        return view;
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView((View) object);
    }

}
