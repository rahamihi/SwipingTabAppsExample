package com.example.mamun.swipingtabappsexample;

import android.os.Build;
import android.support.design.widget.TabItem;
import android.support.design.widget.TabLayout;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;

public class MainActivity extends AppCompatActivity {

    private Toolbar toolbar;
    private TabLayout tabLayout;
    private TabItem tabChat,tabStatus,tabCalls;
    private ViewPager viewPager;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        toolbar = findViewById(R.id.toolbar);
        toolbar.setTitle(getResources().getString(R.string.app_name));
        setSupportActionBar(toolbar);

        tabLayout = findViewById(R.id.tabLayout);

        tabChat = findViewById(R.id.chat);
        tabStatus = findViewById(R.id.status);
        tabCalls = findViewById(R.id.calls);

        viewPager = findViewById(R.id.viewPager);

        PagerAdapter adapter = new PagerAdapter(getSupportFragmentManager(),tabLayout.getTabCount());
        viewPager.setAdapter(adapter);

        viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));

        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                if(tab.getPosition() == 1){

                    // it has been done for changing status bar color
                    if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP){
                        getWindow().setStatusBarColor(ContextCompat.getColor(MainActivity.this,R.color.statusColor));
                    }
                    // it has been change for toolbar color
                    toolbar.setBackgroundColor(ContextCompat.getColor(MainActivity.this,R.color.statusColor));
                    //it has been change for TabLayout color
                    tabLayout.setBackgroundColor(ContextCompat.getColor(MainActivity.this,R.color.statusColor));
                }
                else if(tab.getPosition() == 2){
                    if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP){
                        getWindow().setStatusBarColor(ContextCompat.getColor(MainActivity.this,R.color.callsColor));
                    }

                    toolbar.setBackgroundColor(ContextCompat.getColor(MainActivity.this,R.color.callsColor));
                    tabLayout.setBackgroundColor(ContextCompat.getColor(MainActivity.this,R.color.callsColor));

                }else{
                    if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP){
                        getWindow().setStatusBarColor(ContextCompat.getColor(MainActivity.this,R.color.chatColor));
                    }
                    toolbar.setBackgroundColor(ContextCompat.getColor(MainActivity.this,R.color.chatColor));
                    tabLayout.setBackgroundColor(ContextCompat.getColor(MainActivity.this,R.color.chatColor));
                }
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });

    }
}
