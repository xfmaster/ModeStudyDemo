package com.app.mode.observer;

import android.os.CountDownTimer;

import java.util.ArrayList;
import java.util.List;

/*
下载任务，观察者
 */
public class DownLoadSubject implements Subject<Integer> {
    private List<Observer<Integer>> observers;
    private int currentProgress = 0;
    private static DownLoadSubject instance;
    private CountDownTimer mTimer;

    private DownLoadSubject() {
        observers = new ArrayList<>();
        mTimer = new CountDownTimer(100 * 1000, 1000) {
            @Override
            public void onTick(long millisUntilFinished) {
                currentProgress += 1;
                notifyObservers();//进度改变通知更新
            }

            @Override
            public void onFinish() {
            }
        };
        mTimer.start();
    }

    public static DownLoadSubject getInstance() {
        if (instance == null)
            instance = new DownLoadSubject();
        return instance;
    }

    @Override
    public void registerObserver(Observer<Integer> observer) {
        if (observers.indexOf(observer) == -1) {//注册观察者，判断当前观察者对象中有没有被添加,没有添加就添加到队列中
            observers.add(observer);
        }
    }

    @Override
    public void removeObserver(Observer<Integer> observer) {
        if (observers.indexOf(observer) != -1) {//注册观察者，判断当前观察者对象中有没有被添加
            observers.remove(observer);
        }
    }


    @Override
    public void notifyObservers() {//遍历队列，通知观察者更新
        for (Observer<Integer> observer : observers) {
            observer.onUpdate(currentProgress);
        }
    }
}
