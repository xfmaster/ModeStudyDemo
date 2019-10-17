package com.app.mode.demo.decorator.listener;

import android.view.View;
import android.widget.BaseAdapter;

import com.app.mode.demo.decorator.base.BaseHolder;


public interface OnChildClickListener<T, H extends BaseHolder> {
    void onChildClickListener(BaseAdapter adapter, View view, int position);
}
