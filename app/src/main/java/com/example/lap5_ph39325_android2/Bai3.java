package com.example.lap5_ph39325_android2;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

public class Bai3 extends AppCompatActivity {
    BottomNavigationView bottom_nav;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bai3);
        bottom_nav = findViewById(R.id.bottom_nav);
        bottom_nav.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                if (item.getItemId() == R.id.nhantin) {
                    frgtrangchu frgtrangchu = new frgtrangchu();
                    replaceFrg(frgtrangchu);
                } else if (item.getItemId() == R.id.chat) {
                    frgdautrang frgdautrang = new frgdautrang();
                    replaceFrg(frgdautrang);
                }
                return true;
            }
        });
    }

    //
    public void replaceFrg(Fragment frg) {
        FragmentManager fm = getSupportFragmentManager();
        fm.beginTransaction().replace(R.id.frmbottom, frg).commit();
    }
}