package com.example.lap5_ph39325_android2;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;


import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.navigation.NavigationView;

public class Navigationdrawer extends AppCompatActivity {
    DrawerLayout drawerLayout;
    Toolbar toolbar;
    NavigationView nav;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_navigationdrawer);
        //ánh xạ
        drawerLayout = findViewById(R.id.drawerlayout);
        toolbar = findViewById(R.id.toobar);
        nav = findViewById(R.id.nav);
        setSupportActionBar(toolbar);//gán toobar lên
        // gán toogle lên ac
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawerLayout, toolbar, R.string.open, R.string.close);
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();

        //xử lý event
        nav.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                if (item.getItemId()==R.id.trangchu){
                    frgtrangchu frgtrangchu = new frgtrangchu();
                    replaceFrg(frgtrangchu);
                }else if (item.getItemId()==R.id.dautrang) {
                    frgdautrang frgdautrang = new frgdautrang();
                    replaceFrg(frgdautrang);
                }
                return true;
            }
        });
        }
    public void replaceFrg(Fragment frg){
        FragmentManager fm = getSupportFragmentManager();
        fm.beginTransaction().replace(R.id.framer_nav,frg).commit();
    }
    }