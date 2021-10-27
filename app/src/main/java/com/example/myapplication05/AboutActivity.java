package com.example.myapplication05;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import com.google.android.material.navigation.NavigationView;

public class AboutActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {


    Toolbar toolbar1;
    DrawerLayout drawerLayout;
    NavigationView navigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about);

        toolbar1 = (Toolbar) findViewById(R.id.toolbar1);
        setSupportActionBar(toolbar1);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true); // 왼쪽 상단 버튼 만들기
        getSupportActionBar().setHomeAsUpIndicator(R.drawable.ic_baseline_dehaze_24); //왼쪽 상단 버튼 아이콘 지정


        drawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        navigationView = (NavigationView) findViewById(R.id.navigation_view);
        navigationView.setNavigationItemSelectedListener(this);

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.menu, menu);//로그인 버튼 만들기기
        return true;
    }

    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home: { // 왼쪽 상단 버튼 눌렀을 때
                drawerLayout.openDrawer(GravityCompat.START);
                return true;
            }
            case R.id.action_settings: { // 오른쪽 상단 로그인 버튼 눌렀을 때
                Toast.makeText(getApplicationContext(), "로그인", Toast.LENGTH_SHORT).show();
                Intent lintent = new Intent(this, SignInActivity.class);
                startActivity(lintent);
                return true;
            }
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onBackPressed() { //뒤로가기 했을 때
        if (drawerLayout.isDrawerOpen(GravityCompat.START)) {
            drawerLayout.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {

            case R.id.item_about: {
                Intent pintent = new Intent(this, AboutActivity.class);
                startActivity(pintent);
                break;
            }

            case R.id.item_product: {
                Intent pintent = new Intent(this, ProductActivity.class);
                startActivity(pintent);
                break;
            }
            case R.id.item_contact: {
                Intent lintent = new Intent(this, ContactActivity.class);
                startActivity(lintent);
                break;
            }
        }

        return true;
    }

    public void AHavitLogo(View v) {
//        Intent myIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.havitusa.com/"));
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
    public void AAboutPage(View v) {
        Intent intent = new Intent(this, AboutActivity.class);
        startActivity(intent);
    }
    public void AProductPage(View v) {
        Intent intent = new Intent(this, ProductActivity.class);
        startActivity(intent);
    }
    public void AContactPage(View v) {
        Intent intent = new Intent(this, ContactActivity.class);
        startActivity(intent);
    }
}