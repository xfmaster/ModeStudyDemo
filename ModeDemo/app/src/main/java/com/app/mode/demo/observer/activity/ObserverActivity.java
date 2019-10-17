package com.app.mode.demo.observer.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.SeekBar;

import com.app.mode.demo.R;
import com.app.mode.demo.observer.DownLoadSubject;
import com.app.mode.demo.observer.Observer;


//这里相当于应用商城的列表页，点击下载的时候出现进度条，点击详情页就显示应用详情进度条也会更新到当前进度
public class ObserverActivity extends AppCompatActivity implements Observer<Integer> {//这里也是观察者
    private SeekBar seekBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_observer);
        DownLoadSubject.getInstance().registerObserver(this);
        DownLoadSubject.getInstance().start();
        seekBar = findViewById(R.id.seekBar);
    }

    @Override
    public void onUpdate(Integer integer) {
        seekBar.setProgress(integer);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        DownLoadSubject.getInstance().removeObserver(this);//这里记得删除当前观察者，不然会报异常
        DownLoadSubject.getInstance().stop();
    }

    public void startDetail(View view) {
        startActivity(new Intent(getApplicationContext(), ObserverActivityDetail.class));
    }
}
