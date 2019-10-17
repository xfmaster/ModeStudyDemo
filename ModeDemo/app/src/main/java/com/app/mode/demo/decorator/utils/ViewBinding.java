package com.app.mode.demo.decorator.utils;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.SparseArray;
import android.util.SparseIntArray;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class ViewBinding implements Binding {
    public View itemView;
    private SparseArray<View> views = new SparseArray<>();
    private List<Integer> clickIds = new ArrayList<>();
    public Context mContext;

    @Override
    public View getView(int id) {
        if (views.indexOfKey(id) != -1) {
            return views.get(id);
        } else {
            View view = itemView.findViewById(id);
            putView(view);
            return view;
        }
    }

    @Override
    public void putView(View view) {
        if (views.indexOfKey(view.getId()) == -1)
            views.append(view.getId(), view);
    }

    @Override
    public void setTextView(int id, String text) {
        TextView textView = (TextView) getView(id);
        textView.setText(text);
    }

    @Override
    public void setTextView(int id, int resId) {
        setTextView(id, mContext.getResources().getString(resId));
    }

    @Override
    public void setImageViewResource(int id, int resId) {
        ImageView imageView = (ImageView) getView(id);
        imageView.setImageResource(resId);
    }

    @Override
    public void setImageViewDrawable(int id, Drawable drawable) {
        ImageView imageView = (ImageView) getView(id);
        imageView.setImageDrawable(drawable);
    }

    @Override
    public void setVisible(int id, boolean isVisible) {
        getView(id).setVisibility(isVisible ? View.VISIBLE : View.INVISIBLE);
    }

    @Override
    public void setGone(int id, boolean isGone) {
        getView(id).setVisibility(isGone ? View.GONE : View.VISIBLE);
    }

    @Override
    public void addChildOnClick(int id) {
        if (!clickIds.contains(id))
            clickIds.add(id);
    }

    public List<Integer> getClickIds() {
        return clickIds;
    }
}
