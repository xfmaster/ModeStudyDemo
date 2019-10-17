package com.app.mode.demo.decorator.adapter;

import android.util.SparseIntArray;

import java.util.List;

public abstract class BaseListNormalAdapter<T> extends BaseListAdapter<T> {

    public BaseListNormalAdapter(List<T> mData) {
        super(new BasicImp<>(mData));
    }

    public abstract int getItemViewId();

    @Override
    public SparseIntArray getTypeViews() {
        SparseIntArray map = new SparseIntArray();
        map.append(getItemViewId(), getItemViewId());
        return map;
    }

    @Override
    public int getViewType(int position) {
        return 0;
    }
}
