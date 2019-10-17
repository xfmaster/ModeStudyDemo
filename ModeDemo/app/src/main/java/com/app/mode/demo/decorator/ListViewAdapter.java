package com.app.mode.demo.decorator;


import com.app.mode.demo.decorator.adapter.BaseListNormalAdapter;
import com.app.mode.demo.decorator.utils.Binding;

import java.util.List;

public class ListViewAdapter extends BaseListNormalAdapter<String> {
    public ListViewAdapter(List<String> list) {
        super(list);
    }

    @Override
    public void bindView(String itemData, Binding binding, int position) {
        binding.setTextView(android.R.id.text1, itemData);
    }

    @Override
    public int getItemViewId() {
        return android.R.layout.activity_list_item;
    }
}
