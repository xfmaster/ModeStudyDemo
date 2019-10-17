package com.app.mode.demo.decorator.adapter;

import android.util.SparseIntArray;

import com.app.mode.demo.decorator.listener.OnChildClickListener;

import java.util.ArrayList;
import java.util.List;

public class BasicImp<T> implements Basic<T> {
    private List<T> mData;

    public BasicImp(List<T> mData) {
        this.mData = mData;
    }

    @Override
    public List<T> getData() {
        return mData;
    }

    public void setNewData(List<T> list) {
        if (mData != null && mData.size() > 0)
            mData.clear();
        mData = list;
    }

    public void addData(List<T> list) {
        if (mData == null)
            mData = new ArrayList<>();
        mData.addAll(list);
    }

    @Override
    public void addData(T t) {
        if (mData == null)
            mData = new ArrayList<>();
        mData.add(t);
    }

}
