package com.example.myapplication05;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.navigation.NavigationView;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener{

    Toolbar toolbar;
    DrawerLayout drawerLayout;
    NavigationView navigationView;
    TextView idtext;

    TextView getid;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        toolbar = (Toolbar) findViewById(R.id.toolbar1);
        setSupportActionBar(toolbar);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true); // 왼쪽 상단 버튼 만들기
        getSupportActionBar().setHomeAsUpIndicator(R.drawable.ic_baseline_dehaze_24); //왼쪽 상단 버튼 아이콘 지정

        drawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        navigationView = (NavigationView) findViewById(R.id.navigation_view);
        navigationView.setNavigationItemSelectedListener(this);



        getid = findViewById(R.id.tv_name);

       // Intent m2intent = getIntent();

        ///Bundle bundle = m2intent.getExtras();
        //String id = bundle.getString("id");
        //String pw = bundle.getString("pw");

        //getid.setText(id);





    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.menu, menu);
        return true;
    }

    public void ContactPage(View v) {
        Intent intent = new Intent(this, ContactActivity.class);
        startActivity(intent);
    }







    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        idtext=findViewById(R.id.tv_name);
        idtext.setText("GUEST");
        switch (item.getItemId()){
            case android.R.id.home:{ // 왼쪽 상단 버튼 눌렀을 때
                drawerLayout.openDrawer(GravityCompat.START);
                Toast.makeText(getApplicationContext(), "상단", Toast.LENGTH_SHORT).show();
                Log.v("test","test11");
                return true;

            }
            case R.id.action_settings:{
                Toast.makeText(getApplicationContext(),"로그인",Toast.LENGTH_SHORT).show();
                Intent lintent = new Intent(this, SignInActivity.class);
                startActivity(lintent);
                return true;
            }

        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onNavigationItemSelected(MenuItem item) {

        switch (item.getItemId()) {
            case R.id.item_about: {
                Intent pintent = new Intent(this, AboutActivity.class);
                startActivity(pintent);
                break;
            }

            case R.id.item_product:{
                Intent pintent = new Intent(this,ProductActivity.class);
                startActivity(pintent);
                break;
            }
            case R.id.item_contact:{
                Intent lintent = new Intent(this,ContactActivity.class);
                startActivity(lintent);
                break;
            }
            case R.id.per_info:{
                String id = idtext.getText().toString();
                Intent fointent = new Intent(this,InformationActivity.class);
                fointent.putExtra("idd",id);
                startActivity(fointent);
                return true;
            }
            case R.id.per_basket:{
                Intent baintent = new Intent(this,BasketActivity.class);
                startActivity(baintent);
                return true;
            }
        }

        return true;
    }
    @Override
    public void onBackPressed() { //뒤로가기 했을 때
        if (drawerLayout.isDrawerOpen(GravityCompat.START)) {
            drawerLayout.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    public void ProductPage(View v) {
        Intent intent = new Intent(this, ProductActivity.class);
        startActivity(intent);
    }
    public void AboutPage(View v) {
        Intent intent = new Intent(this, AboutActivity.class);
        startActivity(intent);
    }


}



