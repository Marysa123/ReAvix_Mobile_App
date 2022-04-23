package com.example.reavixmobileapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.viewpager.widget.PagerAdapter;

import com.airbnb.lottie.LottieAnimationView;

public class ViewPagesAdapter extends PagerAdapter {

    Context context;

    int[] images = {
            R.raw.friends,
            R.raw.file,
            R.raw.advice,
            R.raw.graphic
    };

    int headerText[] = {
                    R.string.heading_one,
                    R.string.heading_two,
                    R.string.heading_three,
                    R.string.heading_fourth
    };

    int headerTextBottom[] = {
            R.string.desc_one,
            R.string.desc_two,
            R.string.desc_three,
            R.string.desc_fourth
    };

    public  ViewPagesAdapter(Context context){
        this.context = context;
    }

    @Override
    public int getCount() {
        return headerText.length;
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view == (LinearLayout) object;
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {

        LayoutInflater layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = layoutInflater.inflate((R.layout.slider_layout),container,false);

        LottieAnimationView sliderimagestitle = (LottieAnimationView) view.findViewById(R.id.titleImage);
        TextView sliderheading = (TextView) view.findViewById(R.id.texttitle);
        TextView sliderDescption = (TextView) view.findViewById(R.id.texttitle2);

        sliderimagestitle.setAnimation(images[position]);
        sliderheading.setText(headerText[position]);
        sliderDescption.setText(headerTextBottom[position]);

        container.addView(view);

        return view;

    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView((LinearLayout)object);
    }
}
