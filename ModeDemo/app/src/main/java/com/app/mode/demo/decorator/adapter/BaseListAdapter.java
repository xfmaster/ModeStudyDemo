package com.app.mode.demo.decorator.adapter;

import android.util.SparseIntArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import com.app.mode.demo.decorator.utils.Binding;
import com.app.mode.demo.decorator.utils.ViewBinding;

import java.util.List;

public abstract class BaseListAdapter<T> extends BaseAdapter implements Basic<T> {
    private Basic<T> basic;

    public BaseListAdapter(Basic<T> basic) {
        this.basic = basic;
    }

    public Basic<T> getBasic() {
        return basic;
    }

    public abstract int getViewType(int position);

    abstract SparseIntArray getTypeViews();

    @Override
    public int getViewTypeCount() {
        return getTypeViews() == null ? 1 : getTypeViews().size();
    }

    @Override
    public int getItemViewType(int position) {
        return getViewType(position);
    }

    @Override
    public int getCount() {
        return this.basic.getData() == null ? 0 : this.basic.getData().size();
    }

    @Override
    public T getItem(int position) {
        return this.basic.getData().get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewBinding binding;
        if (convertView == null) {
            binding = new ViewBinding();
            if (getTypeViews() == null || getTypeViews().size() == 1) {
                convertView = getNormalLayoutId(parent);
            } else {
                convertView = getMultiView(parent, position);
            }
            convertView.setTag(binding);
        } else {
            binding = (ViewBinding) convertView.getTag();
        }
        binding.itemView = convertView;
        bindView(this.basic.getData().get(position), binding, position);
//        if (this.basic.getListener() != null && binding.getClickIds().size() > 0) {
//            for (Integer clickId : binding.getClickIds()) {
//                binding.getView(clickId).setOnClickListener(v -> basic.getListener().onChildClickListener(this, v, position));
//            }
//        }

        return convertView;
    }

    private View getNormalLayoutId(ViewGroup parent) {
        int layoutId = getTypeViews().valueAt(0);
        return LayoutInflater.from(parent.getContext()).inflate(layoutId, parent, false);
    }

    @SuppressWarnings("ConstantConditions")
    private View getMultiView(ViewGroup parent, int position) {
        int layoutId = getTypeViews().get(getItemViewType(position));
        return LayoutInflater.from(parent.getContext()).inflate(layoutId, parent, false);
    }

    public abstract void bindView(T t, Binding binding, int position);

    @Override
    public List<T> getData() {
        return basic.getData();
    }

    @Override
    public void addData(List<T> list) {
        basic.addData(list);
    }

    @Override
    public void addData(T t) {
        basic.addData(t);
    }

    @Override
    public void setNewData(List<T> list) {
        basic.setNewData(list);
    }
}
