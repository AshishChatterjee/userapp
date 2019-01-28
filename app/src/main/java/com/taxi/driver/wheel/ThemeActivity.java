package com.taxi.driver.wheel;

import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.RelativeLayout;

import com.jeremyfeinstein.slidingmenu.lib.SlidingMenu;
import com.taxi.driver.AllTripActivity;
import com.taxi.driver.R;
import com.taxi.driver.utils.Common;

public class ThemeActivity extends AppCompatActivity {
    SlidingMenu slidingMenu;
    RelativeLayout layout_slidemenu;
    Common common = new Common();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_theme);

        findViewById(R.id.orange).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setTheme(R.style.AppThemeOrange);
                if (Build.VERSION.SDK_INT >= 21) {
                    getWindow().setNavigationBarColor(getResources().getColor(R.color.orange));
                    getWindow().setStatusBarColor(getResources().getColor(R.color.orange));
                }
            }
        });
        findViewById(R.id.navi_blue).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setTheme(R.style.AppThemeNaviBlue);
                if (Build.VERSION.SDK_INT >= 21) {
                    getWindow().setNavigationBarColor(getResources().getColor(R.color.navi_blue));
                    getWindow().setStatusBarColor(getResources().getColor(R.color.navi_blue));
                }

            }
        });findViewById(R.id.white_red).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setTheme(R.style.AppThemeWhiteRed);
                if (Build.VERSION.SDK_INT >= 21) {
                    getWindow().setNavigationBarColor(getResources().getColor(R.color.white_red));
                    getWindow().setStatusBarColor(getResources().getColor(R.color.white_red));
                }

            }
        });findViewById(R.id.white_blue).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setTheme(R.style.AppThemeWhiteBlue);
                if (Build.VERSION.SDK_INT >= 21) {
                    getWindow().setNavigationBarColor(getResources().getColor(R.color.white_blue));
                    getWindow().setStatusBarColor(getResources().getColor(R.color.white_blue));
                }

            }
        });

        layout_slidemenu = (RelativeLayout)findViewById(R.id.layout_slidemenu);

        slidingMenu = new SlidingMenu(this);
        slidingMenu.setMode(SlidingMenu.LEFT);
        slidingMenu.setTouchModeAbove(SlidingMenu.TOUCHMODE_FULLSCREEN);
        slidingMenu.setBehindOffsetRes(R.dimen.slide_menu_width);
        slidingMenu.setFadeDegree(0.20f);
        slidingMenu.attachToActivity(this, SlidingMenu.SLIDING_CONTENT);
        slidingMenu.setMenu(R.layout.left_menu);

        common.SlideMenuDesign(slidingMenu, ThemeActivity.this,"all trip");

        layout_slidemenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                slidingMenu.toggle();
            }
        });
    }
}
