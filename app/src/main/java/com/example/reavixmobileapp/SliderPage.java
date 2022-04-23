package com.example.reavixmobileapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.os.Bundle;
import android.text.Html;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

public class SliderPage extends AppCompatActivity {

    ViewPager viewPager;
    LinearLayout linearLayout;
    Button skipBtn,backBtn,nextBtn;

    TextView[] dots;
    ViewPagesAdapter viewPagesAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_slider_page);
        skipBtn = findViewById(R.id.skipBtn);
        backBtn = findViewById(R.id.btnBack);
        nextBtn = findViewById(R.id.btnNext);


        backBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (getItem(0)>0){
                    viewPager.setCurrentItem(getItem(-1),true);
                }

            }
        });
        nextBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                    if (getItem(0)<3){
                        viewPager.setCurrentItem(getItem(1),true);
                    }else{
                        Intent i = new Intent(SliderPage.this,SignInandSignUp.class);
                        startActivity(i);
                        finish();
                    }
            }
        });
        skipBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(SliderPage.this,SignInandSignUp.class);
                startActivity(i);
                finish();
            }
        });

        viewPager = (ViewPager) findViewById(R.id.sliderViewPager);
        linearLayout = (LinearLayout) findViewById(R.id.indicator_layout);

        viewPagesAdapter = new ViewPagesAdapter(this);

        viewPager.setAdapter(viewPagesAdapter);

        setUpIndicator(0);
        viewPager.addOnPageChangeListener(viewListener);


    }

    public void setUpIndicator(int position){
        dots = new TextView[4];
        linearLayout.removeAllViews();

        for (int i = 0; i< dots.length;i++){

            dots[i] = new TextView(this);
            dots[i].setText(Html.fromHtml("&#8226"));
            dots[i].setTextSize(35);
            dots[i].setTextColor(getResources().getColor(R.color.inactive,getApplicationContext().getTheme()));
            linearLayout.addView((dots[i]));
        }

        dots[position].setTextColor(getResources().getColor(R.color.active,getApplicationContext().getTheme()));
    }
        ViewPager.OnPageChangeListener viewListener = new ViewPager.OnPageChangeListener() {
        @Override
        public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

        }

        @Override
        public void onPageSelected(int position) {
            setUpIndicator(position);

            if (position > 0){
                backBtn.setVisibility(View.VISIBLE);
            }else{

                backBtn.setVisibility(View.INVISIBLE);
            }
        }

        @Override
        public void onPageScrollStateChanged(int state) {
        }
    };



    private  int getItem(int i){
        return  viewPager.getCurrentItem() + i  ;
    }
}