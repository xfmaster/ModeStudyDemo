package com.app.mode.demo.decorator;

import android.util.SparseIntArray;

import com.app.mode.demo.R;
import com.app.mode.demo.decorator.adapter.BaseMultiListAdapter;
import com.app.mode.demo.decorator.bean.MultiData;
import com.app.mode.demo.decorator.utils.Binding;

import java.util.List;

public class MultiListAdapter extends BaseMultiListAdapter<MultiData> {
    public MultiListAdapter(List<MultiData> mData) {
        super(mData);
    }

    @Override
    public void addMultiView(SparseIntArray map) {
        map.append(0, R.layout.item_multi_1);
        map.append(1, R.layout.item_multi_2);
        map.append(2, R.layout.item_multi_3);

    }

    @Override
    public void bindView(MultiData multiData, Binding binding, int position) {
        binding.setTextView(R.id.tvName, multiData.getName());
    }
}
