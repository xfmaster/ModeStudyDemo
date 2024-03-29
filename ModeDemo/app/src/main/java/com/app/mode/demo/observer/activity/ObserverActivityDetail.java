package com.app.mode.demo.observer.activity;

import android.os.Bundle;
import android.widget.SeekBar;

import androidx.appcompat.app.AppCompatActivity;

import com.app.mode.demo.R;
import com.app.mode.demo.observer.DownLoadSubject;
import com.app.mode.demo.observer.Observer;


public class ObserverActivityDetail extends AppCompatActivity implements Observer<Integer> {
    private SeekBar seekBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.acitivity_observer_detail);
        DownLoadSubject.getInstance().registerObserver(this);
        seekBar = findViewById(R.id.seekBar);
    }

    @Override
    public void onUpdate(Integer integer) {
        seekBar.setProgress(integer);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        DownLoadSubject.getInstance().removeObserver(this);
    }
}
