package com.example.imageslidder;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;

public class ImageAdapter extends PagerAdapter {
    Context mcontext;

    ImageAdapter(Context context){
        this.mcontext = context;
    }

    @Override
    public int getCount() {
        return sliderImagedId.length;
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view == ((ImageView)object);
    }
    private  int[] sliderImagedId = new int[]{
            R.drawable.images , R.drawable.p , R.drawable.phonehouse , R.drawable.unnamed
    };

    public Object instantiateItem(ViewGroup container , int position){
        ImageView imageView = new ImageView(mcontext);
        imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
        imageView.setImageResource(sliderImagedId[position]);
        ((ViewPager)container).addView(imageView, 0);
        return imageView;
    }
    public void destroyItem(ViewGroup container , int position , Object object){
        ((ViewPager)container).removeView((ImageView)object);

    }

}
