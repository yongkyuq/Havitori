package com.example.myapplication05;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class MyAdapter extends BaseAdapter{


    /* 아이템을 세트로 담기 위한 어레이 */
    private ArrayList<SampleData> mItems = new ArrayList<>();







    @Override
    public int getCount() {
        return mItems.size();
    }

    @Override
    public SampleData getItem(int position) {
        return mItems.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        Context context = parent.getContext();

        /* 'listview_custom' Layout을 inflate하여 convertView 참조 획득 */
        if (convertView == null) {
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.basket_item_list, parent, false);
        }

        /* 'listview_custom'에 정의된 위젯에 대한 참조 획득 */
        ImageView iv_img = (ImageView) convertView.findViewById(R.id.iv_img) ;
        TextView tv_name = (TextView) convertView.findViewById(R.id.tv_name) ;
        TextView tv_contents = (TextView) convertView.findViewById(R.id.tv_contents) ;

        /* 각 리스트에 뿌려줄 아이템을 받아오는데 mMyItem 재활용 */
        SampleData mSam = getItem(position);

        /* 각 위젯에 세팅된 아이템을 뿌려준다 */

        iv_img.setImageDrawable(mSam.getIcon());
        tv_name.setText(mSam.getName());
        tv_contents.setText(mSam.getContents());

        /* (위젯에 대한 이벤트리스너를 지정하고 싶다면 여기에 작성하면된다..)  */


        return convertView;
    }

    /* 아이템 데이터 추가를 위한 함수. 자신이 원하는대로 작성 */
    public void addItem(Drawable img, String name, String contents) {

        SampleData mSam = new SampleData();

        /* MyItem에 아이템을 setting한다. */
        mSam.setIcon(img);
        mSam.setName(name);
        mSam.setContents(contents);

        /* mItems에 MyItem을 추가한다. */
        mItems.add(mSam);

    }
}