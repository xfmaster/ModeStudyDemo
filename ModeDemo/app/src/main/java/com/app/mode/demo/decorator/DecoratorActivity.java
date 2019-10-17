package com.app.mode.demo.decorator;

import android.os.Bundle;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import com.app.mode.demo.R;
import com.app.mode.demo.decorator.bean.MultiData;

import java.util.ArrayList;
import java.util.List;

//装饰者模式实例
public class DecoratorActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_decorator);
        ListView listView = findViewById(R.id.listView);
//        List<String> list = new ArrayList<>();
//        for (int i = 0; i < 10000; i++) {
//            list.add("item   " + i);
//        }
//        listView.setAdapter(new ListViewAdapter(list));
        List<MultiData> list = new ArrayList<>();
        for (int i = 1; i < 10000; i++) {
            list.add(new MultiData(i % 3, "item   " + i));
        }
        listView.setAdapter(new MultiListAdapter(list));
    }
}
