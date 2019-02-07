package com.taxi.driver.wheel;

import android.graphics.drawable.GradientDrawable;
import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.ContextThemeWrapper;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.RelativeLayout;

import com.jeremyfeinstein.slidingmenu.lib.SlidingMenu;
import com.taxi.driver.AllTripActivity;
import com.taxi.driver.R;
import com.taxi.driver.utils.Common;

public class ThemeActivity extends AppCompatActivity {
    SlidingMenu slidingMenu;
    RelativeLayout layout_slidemenu,layout_header;
    Common common = new Common();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (common.getTheme(this).equals("orange")) {
            setTheme(R.style.AppThemeOrange);
        } else if (common.getTheme(this).equals("navi_blue")) {
            setTheme(R.style.AppThemeNaviBlue);
        } else if (common.getTheme(this).equals("white_red")) {
            setTheme(R.style.AppThemeWhiteRed);
        } else if (common.getTheme(this).equals("white_blue")) {
            setTheme(R.style.AppThemeWhiteBlue);
        }
        setContentView(R.layout.activity_theme);
        layout_header = findViewById(R.id.layout_header);

        findViewById(R.id.orange).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
              //  setTheme(R.style.AppThemeOrange);
               /* if (Build.VERSION.SDK_INT >= 21) {
                    getWindow().setNavigationBarColor(getResources().getColor(R.color.orange));
                    getWindow().setStatusBarColor(getResources().getColor(R.color.orange));
                }*/
                common.saveTheme(ThemeActivity.this, "orange");
               // layout_header.setBackgroundColor(getResources().getColor(R.color.colorPrimary));
                finish();
                startActivity(getIntent());

            }
        });
        findViewById(R.id.navi_blue).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                /*setTheme(R.style.AppThemeNaviBlue);
                if (Build.VERSION.SDK_INT >= 21) {
                    getWindow().setNavigationBarColor(getResources().getColor(R.color.navi_blue));
                    getWindow().setStatusBarColor(getResources().getColor(R.color.navi_blue));
                }*/
                common.saveTheme(ThemeActivity.this, "navi_blue");
                finish();
                startActivity(getIntent());
              //  layout_header.setBackgroundColor(getResources().getColor(R.color.colorPrimary));

            }
        });
        findViewById(R.id.white_red).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                /*setTheme(R.style.AppThemeWhiteRed);
                if (Build.VERSION.SDK_INT >= 21) {
                    getWindow().setNavigationBarColor(getResources().getColor(R.color.white_red));
                    getWindow().setStatusBarColor(getResources().getColor(R.color.white_red));
                }*/
                common.saveTheme(ThemeActivity.this, "white_red");
                //layout_header.setBackgroundColor(getResources().getColor(R.color.colorPrimary));
                finish();
                startActivity(getIntent());
            }
        });
        findViewById(R.id.white_blue).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               /* setTheme(R.style.AppThemeWhiteBlue);
                if (Build.VERSION.SDK_INT >= 21) {
                    getWindow().setNavigationBarColor(getResources().getColor(R.color.white_blue));
                    getWindow().setStatusBarColor(getResources().getColor(R.color.white_blue));
                }
                */
               // layout_header.setBackgroundColor(getResources().getColor(R.color.colorPrimary));
                common.saveTheme(ThemeActivity.this, "white_blue");
                finish();
                startActivity(getIntent());
            }
        });

        layout_slidemenu = (RelativeLayout) findViewById(R.id.layout_slidemenu);

        slidingMenu = new SlidingMenu(this);
        slidingMenu.setMode(SlidingMenu.LEFT);
        slidingMenu.setTouchModeAbove(SlidingMenu.TOUCHMODE_FULLSCREEN);
        slidingMenu.setBehindOffsetRes(R.dimen.slide_menu_width);
        slidingMenu.setFadeDegree(0.20f);
        slidingMenu.attachToActivity(this, SlidingMenu.SLIDING_CONTENT);
        slidingMenu.setMenu(R.layout.left_menu);

        common.SlideMenuDesign(slidingMenu, ThemeActivity.this, "all trip");

        layout_slidemenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                slidingMenu.toggle();
            }
        });
    }
}
