package com.app.mode.demo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;


import com.app.mode.demo.decorator.DecoratorActivity;
import com.app.mode.demo.observer.activity.ObserverActivity;

import java.util.ArrayList;
import java.util.List;
import java.util.Observable;
import java.util.Observer;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initListView();
    }

    private void initListView() {
        ListView listView = findViewById(R.id.listView);
        final ArrayAdapter<String> arrayAdapter = new ArrayAdapter<>(this, android.R.layout.simple_expandable_list_item_1);
        arrayAdapter.add("观察者模式");
        arrayAdapter.add("装饰者模式");
        listView.setAdapter(arrayAdapter);
        listView.setOnItemClickListener((adapterView, view, i, l) -> {
            switch (arrayAdapter.getItem(i)) {
                case "观察者模式":
                    startActivity(new Intent(getApplicationContext(), ObserverActivity.class));
                    break;
                case "装饰者模式":
                    startActivity(new Intent(getApplicationContext(), DecoratorActivity.class));
                    break;
            }
        });
    }
}
