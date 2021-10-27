package com.example.myapplication05;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import java.util.ArrayList;

public class BasketActivity extends AppCompatActivity {

    private ListView mListView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_basket);

        /* 위젯과 멤버변수 참조 획득 */
        mListView = (ListView)findViewById(R.id.listview);





        /* 아이템 추가 및 어댑터 등록 */
        dataSetting();





    }

    private void dataSetting(){

        MyAdapter mMyAdapter = new MyAdapter();
        mMyAdapter.addItem(ContextCompat.getDrawable(getApplicationContext(),R.drawable.rechargerble_1),"HAVIT V1","67,000원");
        mMyAdapter.addItem(ContextCompat.getDrawable(getApplicationContext(),R.drawable.rechargerble_2),"HAVIT V2","67,000원");
        mMyAdapter.addItem(ContextCompat.getDrawable(getApplicationContext(),R.drawable.disposable_1),"HAVIT T1","19,500원");
        mMyAdapter.addItem(ContextCompat.getDrawable(getApplicationContext(),R.drawable.disposable_2),"HAVIT T2","38,500원");








        /* 리스트뷰에 어댑터 등록 */
        mListView.setAdapter(mMyAdapter);
        mListView.setChoiceMode(ListView.CHOICE_MODE_SINGLE);
    }

}









