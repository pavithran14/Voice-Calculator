package com.example.firstone;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.WindowManager;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity
        implements BottomNavigationView.OnNavigationItemReselectedListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        BottomNavigationView bt =findViewById(R.id.nav_view);
        bt.setOnNavigationItemReselectedListener(this);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
       getSupportFragmentManager().beginTransaction().replace(R.id.fr1,new Calc()).commit();

    }

    public void onNavigationItemReselected(@NonNull MenuItem menuItem) {

            switch(menuItem.getItemId())
            {
                case R.id.Calc:
                    getSupportFragmentManager().beginTransaction().replace(R.id.fr1,new Calc()).commit();
                    break;
                case R.id.voice:
                    getSupportFragmentManager().beginTransaction().replace(R.id.fr1,new VoiceCalc()).commit();
                    break;
            }

    }
}
