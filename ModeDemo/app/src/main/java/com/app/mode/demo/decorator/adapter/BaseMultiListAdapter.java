package com.app.mode.demo.decorator.adapter;

import android.util.SparseIntArray;

import com.app.mode.demo.decorator.base.MutilBean;

import java.util.List;

public abstract class BaseMultiListAdapter<T extends MutilBean> extends BaseListAdapter<T> {
    private Basic<T> basic;

    public BaseMultiListAdapter(List<T> mData) {
        super(new BasicImp<>(mData));
        basic = getBasic();
    }


    @Override
    public SparseIntArray getTypeViews() {
        SparseIntArray map = new SparseIntArray();
        addMultiView(map);
        return map;
    }

    public abstract void addMultiView(SparseIntArray map);

    @Override
    public int getViewType(int position) {
        return basic.getData().get(position).getType();
    }
}
